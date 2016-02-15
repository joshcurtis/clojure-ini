(ns clojure-ini.core-test
  (:require [clojure.test :refer :all]
            [clojure-ini.core :refer :all]))

(deftest clojure-ini-test
  (testing "format-key-value"
    (is (= "; c\na=b" (format-key-value ["a" "b" "c"])))
    (is (= "a=b" (format-key-value ["a" "b"])))))
