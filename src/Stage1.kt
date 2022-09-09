import kotlin.math.roundToInt

fun getMatrix(number: String = ""): List<List<Double>> {
    if (number.isBlank()) {
        print("Enter size of matrix: ")
    } else {
        print("Enter size of $number matrix: ")
    }
    val dimensions =
        try {
            readln().split(" ").map { it.toInt() }
        } catch (_: Exception) {
            listOf(0, 0)
        }
    if (number.isBlank()) {
        println("Enter matrix:")
    } else {
        println("Enter $number matrix:")
    }
    return try {
        val result = mutableListOf<List<Double>>()
        repeat(dimensions[0]) {
            val numbers = readln().split(" ").map { it.toDouble() }.toMutableList()
            if (numbers.size != dimensions[1]) {
                return mutableListOf(mutableListOf())
            } else {
                result.add(numbers)
            }
        }
        result
    } catch (_: Exception) {
        mutableListOf(mutableListOf())
    }
}

fun sum() {
    val firstMatrix = getMatrix("first")
    val secondMatrix = getMatrix("second")
    if (firstMatrix.size != secondMatrix.size) {
        println("The operation cannot be performed.\n")
    } else {
        val result = mutableListOf<List<Double>>()
        for (i in firstMatrix.indices) {
            if (firstMatrix[i].size != secondMatrix[i].size) {
                println("The operation cannot be performed.\n")
            }
            val row = mutableListOf<Double>()
            for (j in firstMatrix[i].indices) {
                row.add(firstMatrix[i][j] + secondMatrix[i][j])
            }
            result.add(row)
        }
        print(result)
    }
}

fun print(matrix: List<List<Double>>) {
    if (matrix.isEmpty()) {
        println("ERROR\n")
    } else {
        println("The result is:")
        matrix.forEach { row ->
            println(
                row.joinToString(" ") {
                    val tmp = it.toInt()
                    if (tmp.toDouble() == it) {
                        tmp.toString()
                    } else {
                        ((it * 100).roundToInt() / 100.0).toString()
                    }
                }
            )
        }
        println()
    }
}