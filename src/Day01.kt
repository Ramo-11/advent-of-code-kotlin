fun main() {
    fun helper(input: List<String>): MutableList<Int> {
        val list: MutableList<Int> = ArrayList()
        var counter = 0

        for (i in input.indices) {
            if (input[i].isBlank()) {
                list.add(counter)
                counter = 0
                continue
            }
            counter += input[i].toInt()
        }
        return list
    }

    fun part1(input: List<String>): Int {
        val list = helper(input)
        return list.max()
    }

    fun part2(input: MutableList<Int>): Int {
        var totalMax = 0
        for (i in 0..2) {
            totalMax += input.max()
            input.remove(input.max())
        }

        return totalMax
    }

    val input = readInput("Day01")
    val part1Answer = part1(input)
    val part2Answer = part2(helper(input))
    println("Answer for part 1: $part1Answer")
    println("Answer for part 2: $part2Answer")
}
