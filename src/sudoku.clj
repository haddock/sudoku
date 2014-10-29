(ns sudoku
  (:require [clojure.set :as set]))

(def board identity)

(def all-values #{1 2 3 4 5 6 7 8 9})

(defn value-at [board coord]
  (get-in board coord))

(defn has-value? [board coord]
  (not (zero? (value-at board coord))))

(defn row-values [board [row _]]
  (into #{} (get board row)))

(defn col-values [board [row col]]
  (into #{} (for [row board] (get row col))))

(defn coord-pairs [coords]
  (vec
   (for [coord-outer coords coord-inner coords]
     (vector coord-outer coord-inner))))

(defn- block-range [[x y]]
  (let [top-left-x (* (quot x 3) 3)
        top-left-y (* (quot y 3) 3)
        bottom-right-x (+ top-left-x 3)
        bottom-right-y (+ top-left-y 3)]
    [top-left-x top-left-y bottom-right-x bottom-right-y]))

(defn block-values [board coord]
  (let [[top-left-x top-left-y bottom-right-x bottom-right-y] (block-range coord)]
    (into #{} (for [x (range top-left-x bottom-right-x) y (range top-left-y bottom-right-y)]
                (value-at board [x y])))))

(defn valid-values-for [board coord]
  (if (has-value? board coord)
    #{}
    (set/difference all-values (block-values board coord) (row-values board coord) (col-values board coord))))

(defn filled? [board]
  (let [values (into #{} (for [row board value row] value))]
    (not (contains? values 0))))

(defn rows [board]
  (map set board))

(defn valid-rows? [board]
  nil)

(defn cols [board]
  (map set (apply map list board)))

(defn valid-cols? [board]
  nil)

(defn blocks [board]
  nil)

(defn valid-blocks? [board]
  nil)

(defn valid-solution? [board]
  nil)

(defn set-value-at [board coord new-value]
  nil)

(defn find-empty-point [board]
  nil)

(defn solve [board]
  nil)
