(ns knjname.my-number.core)

(defn validate-my-number
  "Validates a my-number. Returns a falsy value if invalid."
  [^String  mynumber]
  (and
   mynumber
   (re-matches #"^\d{12}$" mynumber)
   (let [digits (map int mynumber)
         [xs [check_digit]] (split-at 11 digits)
         each_digit_fn (fn [num idx] (* num (if (<= idx 6) (+ idx 1) (- idx 5))))
         calculated_digit (as-> xs <>
                            (reverse <>)
                            (map each_digit_fn <> (iterate inc 1))
                            (reduce + <>)
                            (mod <> 11)
                            (if (<= <> 1) 0 (- 11 <>)))]
     (= check_digit calculated_digit))))
