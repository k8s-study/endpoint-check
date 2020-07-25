(ns endpoint-check.routes.services
  (:require
   [reitit.swagger :as swagger]
   [reitit.swagger-ui :as swagger-ui]
   [reitit.ring.coercion :as coercion]
   [reitit.coercion.spec :as spec-coercion]
   [reitit.ring.middleware.muuntaja :as muuntaja]
   [reitit.ring.middleware.multipart :as multipart]
   [reitit.ring.middleware.parameters :as parameters]
   [endpoint-check.middleware.formats :as formats]
   [endpoint-check.middleware.exception :as exception]
   [ring.util.http-response :refer :all]
   [org.httpkit.client :as http]
   [clojure.java.io :as io]))


(defn testPrint []
  (println "Hello World")
  )

(defn service-routes []
  ["/api"
   {:coercion spec-coercion/coercion
    :muuntaja formats/instance
    :swagger {:id ::api}
    :middleware [;; query-params & form-params
                 parameters/parameters-middleware
                 ;; content-negotiation
                 muuntaja/format-negotiate-middleware
                 ;; encoding response body
                 muuntaja/format-response-middleware
                 ;; exception handling
                 exception/exception-middleware
                 ;; decoding request body
                 muuntaja/format-request-middleware
                 ;; coercing response bodys
                 coercion/coerce-response-middleware
                 ;; coercing request parameters
                 coercion/coerce-request-middleware
                 ;; multipart
                 multipart/multipart-middleware]}

   ;; swagger documentation
   ["" {:no-doc true
        :swagger {:info {:title "my-api"
                         :description "https://cljdoc.org/d/metosin/reitit"}}}

    ["/swagger.json"
     {:get (swagger/create-swagger-handler)}]

    ["/api-docs/*"
     {:get (swagger-ui/create-swagger-ui-handler
            {:url "/api/swagger.json"
             :config {:validator-url nil}})}]]

   
   ["/ping"     
    {:post {:parameters {:body {:urls [string?]}}
            :handler (fn [{{{:keys [urls]} :body} :parameters}] (ok (let [url urls  futures (doall (map http/get url))]
                                                                     (def responseStatus (atom []))
                                                                     (doseq [resp futures]
                                                                       (swap! responseStatus conj {:url (-> @resp :opts :url) :status (:status @resp)})
                                                                       (println (-> @resp :opts :url) " status: " (:status @resp))) @responseStatus)))}}]
   ])
