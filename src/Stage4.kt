fun transpose() {
    println("\n1. Main diagonal")
    println("2. Side diagonal")
    println("3. Vertical line")
    println("4. Horizontal line")
    print("Your choice: ")
    try {
        when (readln().toInt()) {
            1 -> mainDiagonal()
            2 -> sideDiagonal()
            3 -> verticalLine()
            4 -> horizontalLine()
        }
    } catch (_: Exception) {
    }
}

private fun mainDiagonal() {
    val matrix = getMatrix()
    val result = getTransposedMatrix(matrix)
    kotlin.io.print(result)
}

fun getTransposedMatrix(matrix: List<List<Double>>): List<List<Double>> {
    val result = mutableListOf<List<Double>>()
    for (i in matrix.indices) {
        result.add(getColumn(matrix, i))
    }
    return result
}

private fun sideDiagonal() {
    val matrix = getMatrix()
    val result = mutableListOf<List<Double>>()
    for (i in matrix.lastIndex downTo 0) {
        result.add(getColumn(matrix, i).reversed())
    }
    kotlin.io.print(result)
}

private fun verticalLine() {
    val matrix = getMatrix()
    val result = mutableListOf<List<Double>>()
    for (i in matrix.indices) {
        result.add(matrix[i].reversed())
    }
    kotlin.io.print(result)
}

private fun horizontalLine() {
    val matrix = getMatrix()
    val result = mutableListOf<List<Double>>()
    for (i in matrix.lastIndex downTo 0) {
        result.add(matrix[i])
    }
    kotlin.io.print(result)
}