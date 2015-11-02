(ns alphabet-cipher.coder
  (:require [clojure.math.numeric-tower :refer [abs]]))

(def ^:private alphabet
  "Just the plain old English alphabet for the substitution chart."
  ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m"
   "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"])

(defn slot
  "Function that returns the index of a letter `l` in `alphabet`.
  Returns -1 if `l` doesn't exist."
  [l & abc]
  (.indexOf (or (first abc) alphabet) l))

(defn row
  "Function to get the `x`th row in the substitution chart, where `x`
  can be an integer index or a string character."
  [x]
  (let [cnt (count alphabet)
        i (if (integer? x) (mod x cnt) (mod (slot x) cnt))]
    (into [] (concat (drop i alphabet) (take i alphabet)))))

(defn encl
  "Encodes a letter `l` by finding the letter at the intersection
  of the column indexed by the letter `s` from the secret and the
  row indexed by the letter `l`. Anything other than a one character
  string for each argument returns `nil`."
  [l s]
  (if (and (string? l) (string? s) (= (count l) 1) (= (count s) 1))
    ((row l) (slot s))))

(defn find-it
  "Function that goes through the substitution chart looking for
  letter `a` at position `p` (also a letter). Returns the letter of
  that row."
  [a p & r]
  (let [abc (row (or (first r) 0))]
    (if (= a (abc (slot p alphabet)))
      (first abc)
      (find-it a p (+ 1 (or (first r) 0))))))

(defn decl
  "Given the letter from the secret `sec` and the encoded letter `enc`,
  returns the decoded letter."
  [sec enc]
  (if (and (string? a) (string? b) (= (count a) 1) (= (count b) 1))
    (find-it enc sec)))

(defn encode
  "Given a secret keyword `sec`, encodes the msg."
  [sec msg]
  (let [mask (apply str (take (/ (count msg) (count sec)) (repeat sec)))]
    (apply str
      ((fn enc [s mk]
        (if (= 1 (count s))
          (encl (apply str s) (str (first mk)))
          (cons
            (encl (str (first s)) (str (first mk))) (enc (rest s) (rest mk))))) msg mask))))

(defn decode
  "Given the secret keyword `sec`, decodes the msg."
  [sec msg]
  )

(defn decipher [cipher message]
  "decypherme")
