(ns bird-watcher)

(def last-week 
  (vector 0 2 5 3 7 8 4))


(defn today [birds] (peek birds)
  )

(defn inc-bird [birds] (assoc birds (- (count birds) 1) (+ (peek birds) 1))
  )

(defn day-without-birds? [birds] (boolean (some #{0} birds))
  )

(defn n-days-count [birds n] (reduce + (subvec birds 0 n))
  )

(defn busy-days [birds]  (->> birds 
                          (map-indexed vector)
                          (filter (fn [x] (>= (second x) 5)))
                          (count))
  )


(defn odd-week? [brids]
  (let [pat [1 0 1 0 1 0 1]]
    (defn dg [b p] 
      (cond 
        (empty? p) true
        (empty? b) false
        (== (first b) (first p) ) (dg (rest b) (rest p))
        :else false
        ))
    (dg brids pat)))
