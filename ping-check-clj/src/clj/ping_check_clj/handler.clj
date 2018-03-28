(ns ping-check-clj.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [ping-check-clj.routes.services :refer [service-routes]]
            [compojure.route :as route]
            [ping-check-clj.env :refer [defaults]]
            [mount.core :as mount]
            [ping-check-clj.middleware :as middleware]))

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
