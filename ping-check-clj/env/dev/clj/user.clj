(ns user
  (:require 
            [mount.core :as mount]
            [ping-check-clj.core :refer [start-app]]))

(defn start []
  (mount/start-without #'ping-check-clj.core/repl-server))

(defn stop []
  (mount/stop-except #'ping-check-clj.core/repl-server))

(defn restart []
  (stop)
  (start))


