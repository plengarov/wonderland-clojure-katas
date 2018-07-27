(ns card-game-war.game-test
  (:require [clojure.test :refer :all]
            [card-game-war.game :refer :all]))


;; fill in  tests for your game
(deftest test-play-round
  (testing "the highest rank wins the cards in the round"
    (is (= true
           (play-round [:spade 6] [:spade 2]))))
  (testing "queens are higher rank than jacks"
    (is (= true
           (play-round [:club :queen] [:heart :jack]))))
  (testing "kings are higher rank than queens"
    (is (= false
           (play-round [:heart :queen][:spade :king]))))
  (testing "aces are higher rank than kings"
    (is (= true
           (play-round [:club :ace] [:spade :king]))))
  (testing "if the ranks are equal, clubs beat spades"
    (is (= false
           (play-round [:spade :ace] [:club :ace]))))
  (testing "if the ranks are equal, diamonds beat clubs"
    (is (= true
           (play-round [:diamond :king] [:club :king]))))
  (testing "if the ranks are equal, hearts beat diamonds"
    (is (= false
           (play-round [:diamond 6] [:heart 6])))))

(deftest test-play-game
  (testing "the player loses when they run out of cards"
    (is (= "Player1 wins."
           (play-game [[:club 6] [:spade 10]] [[:heart 2] [:diamond 5]]))))
  (testing ""
    (is (= "Player2 wins."
           (play-game [[:spade 10] [:spade :jack]] [[:heart :jack] [:heart :ace]])))))
