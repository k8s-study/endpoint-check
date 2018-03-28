(ns ping-check-clj.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [ping-check-clj.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[ping-check-clj started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[ping-check-clj has shut down successfully]=-"))
   :middleware wrap-dev})
