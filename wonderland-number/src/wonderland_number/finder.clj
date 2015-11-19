(ns wonderland-number.finder)

(defn brute []
  "Brute force solution to produce a sequence of six-digit numbers
  whose products of 2, 3, 4, 5, and 6 all contain the same digits
  as the number itself."
  (for [n (range 100000 1000000)
        :let [n2 (set (str (* n 2)))
              n3 (set (str (* n 3)))
              n4 (set (str (* n 4)))
              n5 (set (str (* n 5)))
              n6 (set (str (* n 6)))]
        :when (= (set (str n)) n2 n3 n4 n5 n6)]
    n))

(defn wonderland-number []
  (first (brute)))
