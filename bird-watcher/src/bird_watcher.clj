(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4]
  )

(defn today [birds]
  (last birds)
  )

(defn inc-bird [birds]
  (let [todayIndex (dec (count birds))]
    (update birds todayIndex inc))
  )

(defn day-without-birds? [birds]
  (not (every? pos? birds))
  )

(defn n-days-count [birds n]
  (reduce + (take n birds))
  )

(defn busy-days [birds]
  (count (filter (fn [x] (>= x 5)) birds)
    )
  )

(defn odd-week? [birds]
  (= [1 0 1 0 1 0 1] birds)
  )
