(ns twenty48.core
  (:gen-class))

(def not-zero? (comp not zero?))
(def list-without-zero (partial filter not-zero?))
(def transpose (partial apply mapv vector))
(def add-zero-to-list (comp (partial take 4) (partial flatten) (partial conj (repeat 4 0))))
(def move (comp
           (partial add-zero-to-list)
           (partial map (partial apply +))
           (partial partition-by identity)
           (partial list-without-zero)))

(def move-grid-left "Moves an entire grid to the left" (partial map move))

(def move-grid-right "Moves an entire grid to the right" (comp (partial map reverse) (partial move-grid-left) (partial map reverse)))

(def move-grid-down "Moves an entire grid down" (comp (partial transpose) (partial move-grid-right) (partial transpose)))

(def move-grid-up "Moves an entire grid up" (comp (partial transpose) (partial move-grid-left) (partial transpose)))
