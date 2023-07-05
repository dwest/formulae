(ns formulae.page
  (:require [hiccup.core :as h]
            [hiccup.page :as page]))

(defn index [& args]
  (h/html
   [:head
    [:title "Fancy Landing Page"]
    (page/include-js "/cljs-out/dev-main.js")]
   [:body
    [:p "shaking the rust off"]]))
