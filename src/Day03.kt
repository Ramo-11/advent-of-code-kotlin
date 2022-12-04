fun main() {

    fun mainLogicPart1(first: String, second: String): Int {
        val matchingLetters: MutableList<Char> = ArrayList()

        for (letter in first) {
            if (letter in second && letter !in matchingLetters) {
                matchingLetters.add(letter)
                if (letter.isUpperCase()) {
                    return letter.lowercaseChar().code - 70
                }
                return letter.code - 96
            }
        }
        return 0
    }

    fun part1(input: List<String>): Int {
        var middle = 0
        var firstString = ""
        var secondString = ""
        var value = 0

        for (i in input.indices) {
            middle = input[i].length / 2
            firstString = input[i].substring(0, middle)
            secondString = input[i].substring(middle)
            value += mainLogicPart1(firstString, secondString)
        }

        return value
    }

    fun mainLogicPart2(input: List<String>): Int {
        for (letter in input[0]) {
            if (letter in input[1] && letter in input[2]) {
                if (letter.isUpperCase()) {
                    return letter.lowercaseChar().code - 70
                }
                return letter.code - 96
            }
        }
        return 0
    }

    fun part2(input: List<String>): Int {
        var value = 0
        var allInput = ""
        var chunkedList: List<List<String>>?
        for (i in 0..input.size) {
            if (i >= 3 && i % 3 == 0) {
                allInput = allInput.dropLast(1)
                chunkedList = allInput.split(" ").chunked(3)
                value += mainLogicPart2(chunkedList[0])
                allInput = ""
            }
            if (i == input.size) {
                break
            }
            allInput += input[i]
            allInput += " "
        }
        return value
    }

    val input = readInput("Day03")
    val part1Answer = part1(input)
    val part2Answer = part2(input)

    println("Answer for part 1: $part1Answer")
    println("Answer for part 2: $part2Answer")
}
