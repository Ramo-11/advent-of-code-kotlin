fun main() {

    fun part1(input: List<String>): Int {
        var pair1 = ""
        var pair2 = ""
        var total = 0

        for (i in input.indices) {
            pair1 = input[i].split(",")[0]
            pair2 = input[i].split(",")[1]

            if ((pair1.split("-")[0].toInt() >= pair2.split("-")[0].toInt() && pair1.split("-")[1].toInt() <= pair2.split("-")[1].toInt()) ||
                (pair2.split("-")[0].toInt() >= pair1.split("-")[0].toInt() && pair2.split("-")[1].toInt() <= pair1.split("-")[1].toInt())) {
                total++
            }
        }
        return total
    }

    fun part2(input: List<String>): Int {
        var pair1 = ""
        var pair2 = ""
        var pair1set: Set<Int> = setOf()
        var pair2set: Set<Int> = setOf()
        var total = 0

        for (i in input.indices) {
            pair1 = input[i].split(",")[0]
            pair2 = input[i].split(",")[1]

            pair1set = IntRange(pair1.split("-")[0].toInt(), pair1.split("-")[1].toInt()).toSet()
            pair2set = IntRange(pair2.split("-")[0].toInt(), pair2.split("-")[1].toInt()).toSet()

            if (pair1set.any(pair2set::contains) || pair2set.any(pair1set::contains)) {
                total++
            }
        }
        return total
    }

    val input = readInput("Day04")
    val part1Answer = part1(input)
    val part2Answer = part2(input)

    println("Answer for part 1: $part1Answer")
    println("Answer for part 2: $part2Answer")
}
