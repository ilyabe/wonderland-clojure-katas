(ns fox-goose-bag-of-corn.puzzle)

(def start-pos [[:fox :goose :corn :you] [:boat] []])

(defn river-crossing-plan []
  "Fox can't be left with goose.
  Goose can't be left with corn."
  ; start
  [start-pos
  ; plan
  [[:fox :corn] [:boat :goose :you] []]
  [[:fox :corn] [:boat] [:you :goose]]
  [[:fox :corn] [:boat :you] [:goose]]
  [[:fox :corn :you] [:boat] [:goose]]
  [[:fox] [:boat :you :corn] [:goose]]
  [[:fox] [:boat] [:you :corn :goose]]
  [[:fox] [:boat :you :goose] [:corn]]
  [[:fox :you :goose] [:boat] [:corn]]
  [[:goose] [:boat :you :fox] [:corn]]
  [[:goose] [:boat] [:fox :you :corn]]
  [[:goose] [:boat :you] [:fox :corn]]
  [[:goose :you] [:boat] [:fox :corn]]
  [[] [:boat :you :goose] [:fox :corn]]
  ;end
  [[] [:boat] [:fox :goose :corn :you]]])
