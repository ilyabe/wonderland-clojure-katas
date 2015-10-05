(ns alphabet-cipher.coder)

;; vector holding the alphabet
;; fn to get the index of a letter
;; fn to rotate alphabet letter's index times
;; fn to get the encoded letter

(def ^:private alphabet
  ["a" "b" "c" "d" "e" "f"])

(defn indx
  "Function that returns the index of a letter `l` in `alphabet`."
  [l]
  (.indexOf alphabet l))

(defn rotate
  "Function to get the letter `l` row in the substitution chart."
  [l])

(defn encode
  [keyword message]
  "encodeme")

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

