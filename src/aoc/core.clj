(ns aoc.core
  (:require [clojure.java.io :as io]
            [aoc.day01 :as day01]
            [aoc.day02 :as day02]
            [aoc.day03 :as day03]
            [aoc.day04 :as day04]
            [aoc.day05 :as day05]
            [aoc.day06 :as day06]))

(defn read-input
  "Read the given day's newline separated puzzle input a lazy sequence of strings"
  [day]
  (->> day
       io/resource
       io/reader
       line-seq))

(defn -main "Run solutions from the command line, e.g. lein run 01a" [part]
  (case part
    "01a" (println (day01/a (read-input "day01.txt")))
    "01b" (println (day01/b (read-input "day01.txt")))
    "02a" (println (day02/a (read-input "day02.txt")))
    "02b" (println (day02/b (read-input "day02.txt")))
    "03a" (println (day03/a (read-input "day03.txt")))
    "03b" (println (day03/b (read-input "day03.txt")))
    "04a" (println (day04/a (read-input "day04.txt")))
    "04b" (println (day04/b (read-input "day04.txt")))
    "05a" (println (day05/a (read-input "day05.txt")))
    "05b" (println (day05/b (read-input "day05.txt")))
    "06a" (println (day06/a (read-input "day06.txt")))
    "06b" (println (day06/b (read-input "day06.txt")))
    (println "Solution not found")))