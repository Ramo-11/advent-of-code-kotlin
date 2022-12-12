import sun.security.ec.point.ProjectivePoint.Mutable
import java.util.*
import kotlin.collections.ArrayList

fun main() {

    fun popBottom(stack: Stack<Char>): Char {
        val top = stack.pop();
        if (stack.isEmpty()) {
            return top;
        } else {
            val bottom = popBottom(stack);
            stack.push(top);
            return bottom;
        }
    }

    fun reverseStack(stack: Stack<Char>) {
        if (stack.isEmpty()) {
            return;
        }

        val bottom = popBottom(stack);
        reverseStack(stack);
        stack.push(bottom);
    }

    fun part1(input: MutableList<String>): String {
        val stack1 = Stack<Char>()
        val stack2 = Stack<Char>()
        val stack3 = Stack<Char>()
        val stack4 = Stack<Char>()
        val stack5 = Stack<Char>()
        val stack6 = Stack<Char>()
        val stack7 = Stack<Char>()
        val stack8 = Stack<Char>()
        val stack9 = Stack<Char>()
        val stacks = MutableList(0) { stack4 }

        for (i in 0..8) {
            if (input[i].length >= 3)
                if (input[i].substring(0, 3).contains("["))
                    stack1.push(input[i].substring(0, 3).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 7)
                if (input[i].substring(4, 7).contains("["))
                    stack2.push(input[i].substring(4, 7).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 11)
                if (input[i].substring(8, 11).contains("["))
                    stack3.push(input[i].substring(8, 11).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 15)
                if (input[i].substring(12, 15).contains("["))
                    stack4.push(input[i].substring(12, 15).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 19)
                if (input[i].substring(16, 19).contains("["))
                    stack5.push(input[i].substring(16, 19).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 23)
                if (input[i].substring(20, 23).contains("["))
                    stack6.push(input[i].substring(20, 23).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 27)
                if (input[i].substring(24, 27).contains("["))
                    stack7.push(input[i].substring(24, 27).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 31)
                if (input[i].substring(28, 31).contains("["))
                    stack8.push(input[i].substring(28, 31).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 35)
                if (input[i].substring(32, 35).contains("["))
                    stack9.push(input[i].substring(32, 35).replace("[", "").replace("]", "").replace(" ", "")[0])
        }

        reverseStack(stack1)
        reverseStack(stack2)
        reverseStack(stack3)
        reverseStack(stack4)
        reverseStack(stack5)
        reverseStack(stack6)
        reverseStack(stack7)
        reverseStack(stack8)
        reverseStack(stack9)


        stacks.add(stack1)
        stacks.add(stack2)
        stacks.add(stack3)
        stacks.add(stack4)
        stacks.add(stack5)
        stacks.add(stack6)
        stacks.add(stack7)
        stacks.add(stack8)
        stacks.add(stack9)

        var numberOFElementsToMove = 0
        var moveFrom = 0
        var moveTo = 0

        for (i in 0..9) {
            input.remove(input[0])
        }

        for (i in input.indices) {
            numberOFElementsToMove = input[i].split(" ")[1].toInt()
            moveFrom = input[i].split(" ")[3].toInt()
            moveTo = input[i].split(" ")[5].toInt()

            for (j in 0 until numberOFElementsToMove) {
                stacks[moveTo-1].push(stacks[moveFrom-1].pop())
            }
        }

        return stacks[0].peek().toString() + stacks[1].peek().toString() + stacks[2].peek().toString() + stacks[3].peek().toString() + stacks[4].peek().toString() + stacks[5].peek().toString() + stacks[6].peek().toString() + stacks[7].peek().toString() + stacks[8].peek().toString()
    }

    fun part2(input: MutableList<String>): String {
        val stack1 = Stack<Char>()
        val stack2 = Stack<Char>()
        val stack3 = Stack<Char>()
        val stack4 = Stack<Char>()
        val stack5 = Stack<Char>()
        val stack6 = Stack<Char>()
        val stack7 = Stack<Char>()
        val stack8 = Stack<Char>()
        val stack9 = Stack<Char>()
        val stacks = MutableList(0) { stack4 }

        for (i in 0..8) {
            if (input[i].length >= 3)
                if (input[i].substring(0, 3).contains("["))
                    stack1.push(input[i].substring(0, 3).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 7)
                if (input[i].substring(4, 7).contains("["))
                    stack2.push(input[i].substring(4, 7).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 11)
                if (input[i].substring(8, 11).contains("["))
                    stack3.push(input[i].substring(8, 11).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 15)
                if (input[i].substring(12, 15).contains("["))
                    stack4.push(input[i].substring(12, 15).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 19)
                if (input[i].substring(16, 19).contains("["))
                    stack5.push(input[i].substring(16, 19).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 23)
                if (input[i].substring(20, 23).contains("["))
                    stack6.push(input[i].substring(20, 23).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 27)
                if (input[i].substring(24, 27).contains("["))
                    stack7.push(input[i].substring(24, 27).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 31)
                if (input[i].substring(28, 31).contains("["))
                    stack8.push(input[i].substring(28, 31).replace("[", "").replace("]", "").replace(" ", "")[0])
            if (input[i].length >= 35)
                if (input[i].substring(32, 35).contains("["))
                    stack9.push(input[i].substring(32, 35).replace("[", "").replace("]", "").replace(" ", "")[0])
        }

        reverseStack(stack1)
        reverseStack(stack2)
        reverseStack(stack3)
        reverseStack(stack4)
        reverseStack(stack5)
        reverseStack(stack6)
        reverseStack(stack7)
        reverseStack(stack8)
        reverseStack(stack9)


        stacks.add(stack1)
        stacks.add(stack2)
        stacks.add(stack3)
        stacks.add(stack4)
        stacks.add(stack5)
        stacks.add(stack6)
        stacks.add(stack7)
        stacks.add(stack8)
        stacks.add(stack9)

        var numberOFElementsToMove = 0
        var moveFrom = 0
        var moveTo = 0
        val newStack = Stack<Char>()

        for (i in 0..9) {
            input.remove(input[0])
        }

        for (i in input.indices) {
            numberOFElementsToMove = input[i].split(" ")[1].toInt()
            moveFrom = input[i].split(" ")[3].toInt()
            moveTo = input[i].split(" ")[5].toInt()

            for (j in 0 until numberOFElementsToMove) {
                newStack.push(stacks[moveFrom-1].pop())
            }
            while(!newStack.isEmpty()) {
                stacks[moveTo-1].push(newStack.pop())
            }
        }

        return stacks[0].peek().toString() + stacks[1].peek().toString() + stacks[2].peek().toString() + stacks[3].peek().toString() + stacks[4].peek().toString() + stacks[5].peek().toString() + stacks[6].peek().toString() + stacks[7].peek().toString() + stacks[8].peek().toString()
    }

    val input = readInput("Day05")

    val part1Answer = part1(input.toMutableList())
    val part2Answer = part2(input.toMutableList())

    println("Answer for part 1: $part1Answer")
    println("Answer for part 2: $part2Answer")
}
