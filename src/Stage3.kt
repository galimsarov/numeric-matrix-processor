fun printMenu() {
    println("1. Add matrices")
    println("2. Multiply matrix by a constant")
    println("3. Multiply matrices")
    println("4. Transpose matrix")
    println("5. Calculate a determinant")
    println("6. Inverse matrix")
    println("0. Exit")
    print("Your choice: ")
}

fun multiplyByMatrix() {
    val firstMatrix = getMatrix("first")
    val secondMatrix = getMatrix("second")
    val result = mutableListOf<List<Double>>()
    var isError = false
    for (i in firstMatrix.indices) {
        val row = mutableListOf<Double>()
        for (j in secondMatrix[i].indices) {
            val column = getColumn(secondMatrix, j)
            if (firstMatrix[i].size != column.size) {
                isError = true
                break
            } else {
                var value = 0.0
                for (k in firstMatrix[i].indices) {
                    value += firstMatrix[i][k] * column[k]
                }
                row.add(value)
            }
        }
        result.add(row)
    }
    if (isError) {
        println("The operation cannot be performed.\n")
    } else {
        kotlin.io.print(result)
    }
}

fun getColumn(matrix: List<List<Double>>, columnIndex: Int): List<Double> {
    val result = mutableListOf<Double>()
    for (i in matrix.indices) {
        result.add(matrix[i][columnIndex])
    }
    return result
}