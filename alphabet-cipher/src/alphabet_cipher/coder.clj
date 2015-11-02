(ns alphabet-cipher.coder)

(def ^:private alphabet
  "Just the plain old English alphabet for the substitution chart."
  ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m"
   "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"])

(defn slot
  "Function that returns the index of a letter `l` in `alphabet`.
  Returns -1 if `l` doesn't exist."
  [l]
  (.indexOf alphabet l))

(defn row
  "Function to get the letter `l` row in the substitution chart."
  [l]
  (let [i (mod (slot l) (count alphabet))]
    (into [] (concat (drop i alphabet) (take i alphabet)))))

(defn encl
  "Encodes a letter `l` by finding the letter at the intersection
  of the column indexed by the letter `s` from the secret and the
  row indexed by the letter `l`. Anything other than a one character
  string for each argument returns `nil`."
  [l s]
  (if (and (string? l) (string? s) (= (count l) 1) (= (count s) 1))
    ((row l) (slot s))))

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

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")
