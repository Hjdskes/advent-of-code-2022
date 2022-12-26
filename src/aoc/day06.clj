(ns aoc.day06)

(defn parse [input]
  (str input))

(defn find-first-index [predicate coll]
  (->> coll
       (keep-indexed (fn [i x] (when (predicate x) i)))
       (first)))

(defn find-x [n datastream]
  (->> datastream
       (partition n 1)
       (drop 2)
       (find-first-index #(= n (count (set %))))
       (+ n)))

(defn find-marker [datastream]
  (find-x 4 datastream))

(defn find-message [datastream]
  (find-x 14 datastream))

(defn a [input]
  (->> input
       parse
       find-marker))

(defn b [input]
  (->> input
       parse
       find-message))