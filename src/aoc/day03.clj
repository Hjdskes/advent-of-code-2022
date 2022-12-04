(ns aoc.day03
  (:require [clojure.set :as set]))

(defn split-middle "Split a string down the middle, returning two sets" [str]
  (map set (split-at (/ (count str) 2) str)))

(defn priority "Translates a character to its priority using its ASCII value" [char]
  (if (Character/isUpperCase char)
    (- (int char) 38)
    (- (int char) 96)))

(defn find-priority-in-rucksack [rucksack]
  (->> rucksack
       split-middle
       (reduce set/intersection)
       first
       priority))

(defn find-priority-in-group [rucksacks]
  (->> rucksacks
       (reduce set/intersection)
       first
       priority))

(defn a [input]
  (->> input
       (map find-priority-in-rucksack)
       (apply +)))

(defn b [input]
  (->> input
       (map set)
       (partition 3)
       (map find-priority-in-group)
       (apply +)))