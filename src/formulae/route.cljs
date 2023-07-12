(ns formulae.route)

(defn lookup-route [path req routes & opts]
  (prn path routes)
  (loop [[route, f] (peek routes)
         rest (pop routes)]
    (if (re-matches route path)
      (f req)
      (recur (peek rest)
             (pop rest)))))
