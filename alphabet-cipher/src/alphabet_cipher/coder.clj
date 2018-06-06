(ns alphabet-cipher.coder)

(def alphabet (seq "abcdefghijklmnopqrstuvwxyz"))

(defn char2index
  [c]
  (- (int c) (int \a)))

(defn coder
  [keyword message f]
  (let [key (take (count message) (cycle keyword))
        msg (seq message)]
    (apply str (map #(nth alphabet
                          (mod (f (char2index %1)
                                  (char2index %2))
                               (count alphabet)))
                    msg key))))


(defn encode [keyword message]
  (coder keyword message +))

(defn decode [keyword message]
  (coder keyword message -))

(defn decipher [cipher message]
  (coder message cipher -))
