(ns formulae.route
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [formulae.page :as page]))

(defroutes app
  (GET "/" [] page/index)
;  (route/resources "/")
  (route/not-found "<h1>Page not found</h1>"))
