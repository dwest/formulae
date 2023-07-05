(ns formulae.main
  (:require [formulae.route :as route]
            [ring.adapter.jetty :as jetty])
  (:gen-class))

(defn -main []
  (jetty/run-jetty route/app {:port 3000, :join? true}))
