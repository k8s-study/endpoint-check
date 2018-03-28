(ns user
  (:require 
            [mount.core :as mount]
            [endpoint-check.core :refer [start-app]]))

(defn start []
  (mount/start-without #'endpoint-check.core/repl-server))

(defn stop []
  (mount/stop-except #'endpoint-check.core/repl-server))

(defn restart []
  (stop)
  (start))


