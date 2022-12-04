fun main() {

    // Part 1
    // A and X are rock
    // B and Y are paper
    // C and Z are scissors

    // Part 2
    // Y also means draw
    // X also means lose
    // Z also means win

    val opponentChoices: MutableList<String> = ArrayList()
    val myChoices: MutableList<String> = ArrayList()

    fun constructChoices(input: List<String>) {
        for (i in input.indices) {
            opponentChoices.add(input[i].split(" ")[0])
            myChoices.add(input[i].split(" ")[1])
        }
    }

    fun getChoiceScore(input: String): Int {
        val scoreMap = mapOf("Y" to 2, "X" to 1, "Z" to 3)
        return scoreMap[input]!!
    }

    fun getRoundScore(myChoice: String, opponentChoice: String): Int {
        if ((myChoice == "X" && opponentChoice == "C") || (myChoice == "Y" && opponentChoice == "A") || (myChoice == "Z" && opponentChoice == "B")) {
            return 6
        } else if ((myChoice == "X" && opponentChoice == "A") || (myChoice == "Y" && opponentChoice == "B") || (myChoice == "Z" && opponentChoice == "C")) {
            return 3
        } else {
            return 0
        }
    }

    fun part1(): Int {
        var choiceScore = 0
        var roundScore = 0

        for (i in myChoices.indices) {
            choiceScore += getChoiceScore(myChoices[i])
            roundScore += getRoundScore(myChoices[i], opponentChoices[i])
        }
        return choiceScore + roundScore
    }

    fun calculateTotalScoreForPart2(myChoice: String, opponentChoice: String): Int {
        val losingMap = mapOf("A" to "Z", "B" to "X", "C" to "Y")
        val winningMap = mapOf("A" to "Y", "B" to "Z", "C" to "X")
        val drawMap = mapOf("A" to "X", "B" to "Y", "C" to "Z")

        if (myChoice == "X") { // Lose
            return getRoundScore(losingMap[opponentChoice]!!, opponentChoice) + getChoiceScore(losingMap[opponentChoice]!!)
        } else if (myChoice == "Y") { // Draw
            return getRoundScore(drawMap[opponentChoice]!!, opponentChoice) + getChoiceScore(drawMap[opponentChoice]!!)
        } else { // Win
            return getRoundScore(winningMap[opponentChoice]!!, opponentChoice) + getChoiceScore(winningMap[opponentChoice]!!)
        }
    }

    fun part2(): Int {
        var totalScore = 0

        for (i in myChoices.indices) {
            totalScore += calculateTotalScoreForPart2(myChoices[i], opponentChoices[i])
        }
        return totalScore
    }

    val input = readInput("Day02")
    constructChoices(input)

    val part1Answer = part1()
    val part2Answer = part2()

    println("Answer for part 1: $part1Answer")
    println("Answer for part 2: $part2Answer")
}
