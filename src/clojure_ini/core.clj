(ns clojure-ini.core)

(defn format-key-value
  "Formats a key value pair preceded by an optional 1 line comment"
  [[k v c]]
  (let [key-value-str (str k "=" v)]
    (if (some? c)
      (str (str "; " c "\n" key-value-str))
      key-value-str)))
