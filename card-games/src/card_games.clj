(ns card-games)

(defn rounds
  "Takes the current round number and returns 
   a `list` with that round and the _next two_."
  [n]
  (list n (+ 1 n) (+ 2 n)))
  

(defn concat-rounds 
  "Takes two lists and returns a single `list` 
   consisting of all the rounds in the first `list`, 
   followed by all the rounds in the second `list`"
  [l1 l2]
  (concat l1 l2))
  

(defn contains-round? 
  "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
  [l n]
  (boolean (some #(= n %) l)))
  

(defn card-average
  "Returns the average value of a hand"
  [hand]
  (double (/ (reduce + hand) (count hand))))
  

(defn approx-average?
  "Returns `true` if average is equal to either one of:
  - Take the average of the _first_ and _last_ number in the hand.
  - Using the median (middle card) of the hand."
  [hand]
  (let [first-and-last-average (double (/ (+ (first hand) (last hand)) 2))
        middle-card-value (double (nth hand (/ (count hand) 2)))
        avg-hand (card-average hand)]
    (or (= first-and-last-average avg-hand) (= middle-card-value avg-hand))))

(defn average-even-odd?
  "Returns true if the average of the cards at even indexes 
   is the same as the average of the cards at odd indexes."
  [hand]
  (let [even-indexed-cards (map #(nth hand %) (range 0 (count hand) 2))
        odd-indexed-cards (map #(nth hand %) (range 1 (count hand) 2))]
    (cond (= (card-average even-indexed-cards) (card-average odd-indexed-cards)) true
          :else false))
  )

(defn maybe-double-last
  "If the last card is a Jack (11), doubles its value
   before returning the hand."
  [hand]
  (if (= 11 (last hand))
    (concat (butlast hand) '(22))
    hand
    )
  )
