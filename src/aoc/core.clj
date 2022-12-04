(ns aoc.core
  (:require [clojure.java.io :as io]
            [aoc.day01 :as day01]))

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
    (println "Solution not found")))