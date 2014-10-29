(ns sudoku
  (:require [clojure.set :as set]))

(def board identity)

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
  nil)

(defn filled? [board]
  nil)

(defn rows [board]
  nil)

(defn valid-rows? [board]
  nil)

(defn cols [board]
  nil)

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
