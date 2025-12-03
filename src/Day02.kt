fun main() {
    fun part1(input: List<String>): Long {
        val ranges = input.first().split(",")
        val invalidIDs = mutableListOf<Long>()
        ranges.forEach {
            val (firstID, lastID) = it.split("-").map { it.toLong() }
            for (i in firstID..lastID) {
                val id = i.toString()
                if (id.substring(0, id.length / 2) == id.substring(id.length / 2, id.length)) invalidIDs.add(i.toLong())
            }
        }
        return invalidIDs.sum()
    }

    fun part2(input: List<String>): Long {
        val ranges = input.first().split(",")
        val invalidIDs = mutableSetOf<Long>()
        ranges.forEach {
            val (firstID, lastID) = it.split("-").map { it.toLong() }
            for (i in firstID..lastID) {
                val id = i.toString()
                val maxWindowSize = id.length / 2
                maxWindowSize.downTo(1).forEach { windowSize ->
                    val windows = id.windowed(windowSize, windowSize, true).distinct()
                    if (windows.size == 1) {
                        invalidIDs.add(i.toLong())
                    }
                }
            }
        }
        return invalidIDs.sum()
    }

    val testInput =
        listOf("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124")
    check(part1(testInput) == 1227775554.toLong())
    check(part2(testInput) == 4174379265.toLong())


    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
