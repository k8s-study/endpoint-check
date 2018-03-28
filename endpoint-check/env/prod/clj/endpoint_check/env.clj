(ns endpoint-check.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[endpoint-check started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[endpoint-check has shut down successfully]=-"))
   :middleware identity})
