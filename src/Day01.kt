fun main() {
    fun part1(input: List<String>): Int {
        var dial = 50
        var zeroCount = 0
        input.forEach { rotation ->
            val direction = rotation.take(1)
            var distance = rotation.drop(1).toInt()
            while (distance > 0) {
                if (dial == 0 && direction == "L") {
                    dial = 99
                    distance--
                    continue
                }
                if (dial == 99 && direction == "R") {
                    dial = 0
                    distance--
                    continue
                }
                if (direction == "R") {
                    dial += 1
                } else {
                    dial -= 1
                }
                distance--
            }
            if (dial == 0) zeroCount++
        }
        return zeroCount
    }

    fun part2(input: List<String>): Int {
        var dial = 50
        var zeroCount = 0
        input.forEach { rotation ->
            val direction = rotation.take(1)
            var distance = rotation.drop(1).toInt()
            while (distance > 0) {
                if (dial == 0) zeroCount++
                if (dial == 0 && direction == "L") {
                    dial = 99
                    distance--
                    continue
                }
                if (dial == 99 && direction == "R") {
                    dial = 0
                    distance--
                    continue
                }
                if (direction == "R") {
                    dial += 1
                } else {
                    dial -= 1
                }
                distance--
            }
        }
        return zeroCount
    }

    // Test if implementation meets criteria from the description, like:
    val testInput = listOf("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82")
    check(part1(testInput) == 3)
    check(part2(testInput) == 6)

    // Or read a large test input from the `src/Day01.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 3)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
