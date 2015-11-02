(ns alphabet-cipher.coder-test
  (:require [clojure.test :refer :all]
            [alphabet-cipher.coder :refer :all]))

(deftest test-encode
  (testing "can encode given a secret keyword"
    (is (= "hmkbxebpxpmyllyrxiiqtoltfgzzv"
           (encode "vigilance" "meetmeontuesdayeveningatseven")))
    (is (= "egsgqwtahuiljgs"
           (encode "scones" "meetmebythetree")))))

;;(deftest test-decode
;;  (testing "can decode an cyrpted message given a secret keyword"
;;    (is (= "meetmeontuesdayeveningatseven"
;;           (decode "vigilance" "hmkbxebpxpmyllyrxiiqtoltfgzzv")))
;;    (is (= "meetmebythetree"
;;           (decode "scones" "egsgqwtahuiljgs")))))
;;
;;(deftest test-decipher
;;  (testing "can extract the secret keyword given an encrypted message and the original message"
;;    (is (= "vigilance"
;;           (decipher "opkyfipmfmwcvqoklyhxywgeecpvhelzg" "thequickbrownfoxjumpsoveralazydog")))
;;    (is (= "scones"
;;           (decipher "hcqxqqtqljmlzhwiivgbsapaiwcenmyu" "packmyboxwithfivedozenliquorjugs")))))

(deftest row-test
  (testing "can get a row in the substitution chart"
    (is (= (map #(str %) (apply list "abcdefghijklmnopqrstuvwxyz"))
           (row "a")))
    (is (= (map #(str %) (apply list "mnopqrstuvwxyzabcdefghijkl"))
           (row "m")))))

(deftest encl-test
  (testing "can encode a letter"
    (are [l s ans] (= ans (encl l s))
      nil nil nil
      nil "a" nil
      "a" nil nil
      "abc" "" nil
      1 "b" nil
      [:not :a "letter"] "z" nil
      "i" "d" "l"
      "z" "o" "n")))
