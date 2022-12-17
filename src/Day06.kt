fun main() {

    fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)

    fun main(input: String, part: Int): Int {
        var index = 13
        if(part == 1) {
            index = 3
        }

        var charList = ""
        for(i in input.indices) {
            charList = charList.plus(input[i])
            if(i >= index) {
                if (charList.allUnique()) {
                    return i+1
                }
                charList = charList.drop(1)
            }
        }
        return 0
    }

    val input = readInput("Day06")
    val part1Answer = main(input[0], 1)
    val part2Answer = main(input[0], 2)
    println("Answer for part 1: $part1Answer")
    println("Answer for part 2: $part2Answer")
}
