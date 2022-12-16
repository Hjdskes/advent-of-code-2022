(ns aoc.day04
  (:require [clojure.string :as string]))

(defn expand-range [str]
  (map #(Integer/parseInt %) (string/split str #"-")))

(defn overlap [[[x1, x2] [y1, y2]]]
  (<= (max x1 y1) (min x2 y2)))

(defn contained-within [[[x1, x2] [y1, y2]]]
  (or
   (and (<= x1 y1) (<= y2 x2))
   (and (<= y1 x1) (<= x2 y2))))

(defn parse [input]
  (map #(map expand-range (string/split % #",")) input))

(defn a [input]
  (->> input
       parse
       (filter contained-within)
       count))

(defn b [input]
  (->> input
       parse
       (filter overlap)
       count))