(ns clojure-ini.core-test
  (:require [clojure.test :refer :all]
            [clojure-ini.core :refer :all]))

(deftest clojure-ini-test
  (testing "Formatting"
    (is (= "# c\na=b" (format-key-value ["a" "b" "c"])))
    (is (= "a=b" (format-key-value ["a" "b"])))
    (is (= "[Section Title]" (format-section-heading "Section Title")))
    (is (= "[Heading]\n\nk=v\n# a comment\nb=v"
           (format-section [[["k" "v"] ["b" "v" "a comment"]] "Heading"])))
    (is (= "k=v\n# a comment\nb=v"
           (format-section [[["k" "v"] ["b" "v" "a comment"]]])))
    (is (= "k1=v1\nc1=v1"
           (format-ini-file [[[["k1" "v1"] ["c1" "v1"]]]])))
    (is (= "k1=v1\nc1=v1\n\n\nk2=v2\nc2=v2"
           (format-ini-file [[[["k1" "v1"] ["c1" "v1"]]]
                             [[["k2" "v2"] ["c2" "v2"]]]])))
    (is (= "[Heading]\n\nk2=v2\nc2=v2\n\n\nk1=v1\nc1=v1"
           (format-ini-file [[[["k2" "v2"] ["c2" "v2"]] "Heading"]
                             [[["k1" "v1"] ["c1" "v1"]]]])))
    ))
