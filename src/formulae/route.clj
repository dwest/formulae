(ns formulae.route
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.resource :as res]
            [formulae.page :as page]))

(defroutes app
  (GET "/" [] page/index)
  (res/wrap-resource (route/resources "/") "/")
  (route/not-found "<h1>Page not found</h1>"))
