(ns formulae.util
  (:require [clojure.string :as s]))

; The following recognizes but does not validate uris.  To ensure that
; characters are valid in the component that they're used in you
; should perform additional testing.
(def uri-regex #"^(([^:/?#]+):)?(//(([^:]*)(:[^@]*)?@)?([^/:?#]*)(:([0-9]{1,5}))?)?([^?#]*)(\?([^#]*))?(#(.*))?")

(defn uri->map [uri & opts]
  "Break URI according to [RFC 3986](https://datatracker.ietf.org/doc/html/rfc3986#appendix-B)
   with some tweaks, and assign matched components to map keys.  Note:
   not using named capture groups here because they aren't available in
   the javascript regex implementation."
  (->> (str uri)
       (re-matches uri-regex)
       (zipmap [:full-uri, :_, :protocol, :_, :_, :username, :password, :hostname, :_, :port, :path, :_, :query, :_, :fragment])
       (#(dissoc % :_))))

(defn path->vec [path & opts]
  "Split a path based on the path seperator and return a vector of
  path components."
  (-> path
      (s/split (re-pattern (get opts :sep "/")))
      (#(remove empty? %))
      vec))
