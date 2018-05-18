(ns alphabet-cipher.coder)

(defn gen-alphabet []
  (map char (range 97 123)))

(defn rotate-seq [n coll]
  (take (count coll)
        (drop (mod n (count coll))
              (cycle coll))))

(defn div-idxs [idx1 idx2]
  (Math/abs (- (int idx1) (int idx2))))

(defn gen-sypher-table []
  (let [a []]
    (for [i (range 26)]
      (conj a (vec (rotate-seq i (gen-alphabet)))))))


(defn encode [keyword message]
  "encodeme")

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")
