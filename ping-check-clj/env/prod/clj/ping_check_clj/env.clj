(ns ping-check-clj.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[ping-check-clj started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[ping-check-clj has shut down successfully]=-"))
   :middleware identity})
