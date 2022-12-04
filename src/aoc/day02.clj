(ns aoc.day02)

(def lookup-table-a {"A X" 4, "A Y" 8, "A Z" 3, "B X" 1, "B Y" 5, "B Z" 9, "C X" 7, "C Y" 2, "C Z" 6})

(def lookup-table-b {"A X" 3, "A Y" 4, "A Z" 8, "B X" 1, "B Y" 5, "B Z" 9, "C X" 2, "C Y" 6, "C Z" 7})

(defn a [input]
  (->> input
       (map lookup-table-a)
       (apply +)))

(defn b [input]
  (->> input
       (map lookup-table-b)
       (apply +)))
