(ns aoc.day01
  (:require [clojure.string :as string]))

(defn group-by-elf [[calories calories-per-elf] line]
  (if (string/blank? line)
    [0 (conj calories-per-elf calories)]
    [(+ calories (Integer/parseInt line)) calories-per-elf]))

(defn parse [input]
  (->> input
       (reduce group-by-elf [0 []])
       second))

(defn a [input]
  (->> input
       parse
       (apply max)))

(defn b [input]
  (->> input
       parse
       sort
       (take-last 3)
       (apply +)))