(ns interest-is-interesting)

(defn interest-rate
  "Returns the interest rate based on the specified balance."
  [balance]
  (cond (neg? balance) -3.213
        (< balance 1000M) 0.5
        (< balance 5000M) 1.621
        :else 2.475
    )
  )

(defn annual-balance-update
  "Returns the annual balance update, taking into account the interest rate."
  [balance]
  ;; (let [rate (/ (interest-rate balance) 100)
  ;;       updated-balance (* (+ 1 (bigdec rate)) balance)]
  ;;   (bigdec updated-balance)
  ;;   )

  (let [rate (bigdec (Math/abs (/ (interest-rate balance) 100)))]
       (* (+ 1M rate) balance)
    )
  )

(defn amount-to-donate
  "Returns how much money to donate based on the balance and the tax-free percentage."
  [balance tax-free-percentage]
  (cond (>= balance 0) (let [rate (/ tax-free-percentage 100)]
                         (int (* balance rate 2))
                       )
        :else 0
    )
  )