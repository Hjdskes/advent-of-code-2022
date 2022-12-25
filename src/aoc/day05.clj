(ns aoc.day05
  (:require [clojure.string :as string]))

(defn parse-stack-line [line]
  (->> line
       (partition 3 4)
       (map second)))

(defn transpose [v]
  (apply mapv #(identity %&) v))

(defn parse-stacks [input]
  (->> input
       (map parse-stack-line)
       transpose
       (mapv #(remove #{\space \1 \2 \3 \4 \5 \6 \7 \8 \9} %))))

(defn parse-instruction [input]
  (let [[quantity from to] (re-seq #"\d+" input)]
    {:quantity (Integer/parseInt quantity)
     :from (dec (Integer/parseInt from))
     :to (dec (Integer/parseInt to))}))

(defn partition-by-blank-line
  "Partition the newline separated puzzle input by blank lines"
  [input]
  (->> input
       (partition-by string/blank?)
       (remove #(every? string/blank? %))))

(defn parse [input]
  (let [[stacks instructions] (partition-by-blank-line input)]
    {:stacks (parse-stacks stacks)
     :instructions (map parse-instruction instructions)}))

(defn move [f stacks {:keys [quantity from to] :as _instruction}]
  (let [moving (take quantity (nth stacks from))]
    (-> stacks
        (update from #(drop quantity %))
        (update to #(concat (f moving) %)))))

(defn cratemover-9000 [stacks instructions]
  (move reverse stacks instructions))

(defn cratemover-9001 [stacks instructions]
  (move identity stacks instructions))

(defn a [input]
  (->> input
       parse
       (#(reduce cratemover-9000 (:stacks %) (:instructions %)))
       (reduce #(str %1 (first %2)) "")))

(defn b [input]
  (->> input
       parse
       (#(reduce cratemover-9001 (:stacks %) (:instructions %)))
       (reduce #(str %1 (first %2)) "")))