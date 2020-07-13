(ns endpoint-check.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [endpoint-check.routes.services :refer [service-routes]]
            [compojure.route :as route]
            [endpoint-check.env :refer [defaults]]
            [mount.core :as mount]
            [endpoint-check.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
          #'service-routes
      (route/not-found
        "page not found"))))
