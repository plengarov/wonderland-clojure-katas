(ns alphabet-cipher.coder)

(defn gen-alphabet []
  (vec (map char (range 97 123))))

(defn rotate-seq [n coll]
  (take (count coll)
        (drop (mod n (count coll))
              (cycle coll))))

(defn div-idxs [idx1 idx2]
  (Math/abs (- (int idx1) (int idx2))))



(defn encode [keyword message]
  "encodeme")

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")
