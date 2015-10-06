(ns alphabet-cipher.coder)

;; vector holding the alphabet
;; [x] fn to get the index of a letter
;; [x] fn to rotate alphabet letter's index times
;; [] fn to get the encoded letter (intersection)

(def ^:private alphabet
  ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m"
   "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"])

(defn indx
  "Function that returns the index of a letter `l` in `alphabet`.
  Returns -1 if `l` doesn't exist."
  [l]
  (.indexOf alphabet l))

(defn row
  "Function to get the letter `l` row in the substitution chart."
  [l]
  (let [i (mod (indx l) (count alphabet))]
    (concat (drop i alphabet) (take i alphabet))))

(defn encode
  [keyword message]
  "encodeme")

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

