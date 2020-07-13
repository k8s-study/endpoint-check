(ns endpoint-check.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [endpoint-check.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[endpoint-check started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[endpoint-check has shut down successfully]=-"))
   :middleware wrap-dev})
