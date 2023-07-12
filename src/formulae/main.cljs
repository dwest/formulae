(ns formulae.main
  (:require [formulae.util :as util]
            [formulae.route :as r]
            [formulae.page :as page]))

(defn main [event]
  (prn "Hello from main: ")
  (js/console.log event)

  (let [uri  (util/uri->map (str js/document.location))
        path (get uri :path)]
    (js/console.log "uri is: " (clj->js uri) "path is: " (clj->js path))
    (r/lookup-route path uri ; todo should also handle post vars probably?
     [[#"^/$", page/index]
      [#"^/builder$", page/nop]])))

(.addEventListener js/window "DOMContentLoaded" main)
