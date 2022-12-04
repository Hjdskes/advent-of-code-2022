(ns aoc.day02
  (:require [clojure.string :as string]))

(def lookup-table-a {:AX 4, :AY 8, :AZ 3, :BX 1, :BY 5, :BZ 9, :CX 7, :CY 2, :CZ 6})

(def lookup-table-b {:AX 3, :AY 4, :AZ 8, :BX 1, :BY 5, :BZ 9, :CX 2, :CY 6, :CZ 7})

(defn parse [input]
  (->> input
       (map #(string/replace % " " ""))
       (map keyword)))

(defn a [input]
  (->> input
       parse
       (map #(get lookup-table-a %))
       (apply +)))

(defn b [input]
  (->> input
       parse
       (map #(get lookup-table-b %))
       (apply +)))
