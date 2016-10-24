(ns knjname.my-number.core-test
  (:require [clojure.test :refer :all]
            [knjname.my-number.core :refer :all]))

(deftest validate-my-number-valids
  (is true (validate-my-number "023456789013"))
  (is true (validate-my-number "123456789018")))

(deftest validate-my-number-invalids
  (is (not (validate-my-number nil)))
  (is (not (validate-my-number "")))
  (is (not (validate-my-number "1")))
  (is (not (validate-my-number "1234567890123"))))
