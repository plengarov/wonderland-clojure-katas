(ns card-game-war.game)

;; feel free to use these cards or use your own data structure
(def suits [:spade :club :diamond :heart])
(def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
(def cards
  (for [suit suits
        rank ranks]
    [suit rank]))

(defn position [pred coll]
  (keep-indexed (fn [idx item]
                  (when (pred item)
                    idx))
                coll))

(defn compare-ranks [card1 card2]
  (let [[rank1] (position #{(card1 1)} ranks)
        [rank2] (position #{(card2 1)} ranks)]
    (- rank1 rank2)))

(defn compare-suits [card1 card2]
  (let [[suit1] (position #{(card1 0)} suits)
        [suit2] (position #{(card2 0)} suits)]
    (- suit1 suit2)))

(defn compare-cards [card1 card2]
  (let [rank-res (compare-ranks card1 card2)
        suit-res (compare-suits card1 card2)]
    (or (> rank-res 0)
        (and (= rank-res 0)
             (> suit-res 0)))))

(defn play-round [card1 card2]
  (compare-cards card1 card2))

(defn play-game [deck1 deck2]
  (cond
    (empty? deck1) "Player2 wins."
    (empty? deck2) "Player1 wins."
    :else (let [[card1 & rest-deck1] deck1
                [card2 & rest-deck2] deck2]
            (if (play-round card1 card2)
              (recur (into rest-deck1 [card1 card2]) rest-deck2)
              (recur rest-deck1 (into rest-deck2 [card1 card2]))))))
