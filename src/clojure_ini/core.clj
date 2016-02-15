(ns clojure-ini.core
  (:require [clojure.string :refer [join]]))

(defn format-key-value
  "Formats a key value pair preceded by an optional 1 line comment
  the input should be a vector of the form [key value comment]"
  [[key value comment]]
  (let [key-value-str (str key "=" value)]
    (if (some? comment)
      (str (str "# " comment "\n" key-value-str))
      key-value-str)))

(defn format-section-heading
  "Formats the heading of an ini section. The heading should be a string"
  [title]
  (str "[" title "]"))

(defn format-section
  "A section is a vector of key-values and an optional heading.
  It should have the form [key-values heading]
  Example usage: (format-section [[[key1 value1 comment1] [key2 value2]] Heading])"
  [[key-values title]]
  (let [key-value-strs (clojure.string/join "\n" (map format-key-value key-values))]
    (if (some? title)
      (str (format-section-heading title) "\n\n" key-value-strs)
      key-value-strs)))

(defn format-ini-file
  [sections]
  (join "\n\n\n" (map format-section sections)))
