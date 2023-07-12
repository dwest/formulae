(ns formulae.page
  (:require [hiccup.core :as h]
            [hiccup.page :as page]))

(defn index [& args]
  (h/html
   [:head
    [:meta {:charset "UTF-8"}]
    [:title "Fancy Landing Page"]
    [:link {:rel "stylesheet" :href "/public/css/test.css"}]]
   [:body
    [:div {:id "connect-status"}]
    [:p "shaking the rust off"]

    [:footer
     (page/include-js "/cljs-out/dev-main.js")]]))
