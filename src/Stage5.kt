fun determinant() {
    val matrix = getMatrix()
    val result = getDeterminant(matrix)
    val tmp = result.toInt()
    println("The result is:")
    println(
        "${
            if (tmp.toDouble() == result) {
                tmp.toString()
            } else {
                result.toString()
            }
        }\n"
    )
}

fun getDeterminant(matrix: List<List<Double>>): Double {
    return if (matrix.size == 2) {
        matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]
    } else {
        var result = 0.0
        for (j in matrix[0].indices) {
            if (j % 2 == 0) {
                result += matrix[0][j] * getDeterminant(getSubMatrix(matrix, 0, j))
            } else {
                result -= matrix[0][j] * getDeterminant(getSubMatrix(matrix, 0, j))
            }
        }
        result
    }
}

fun getSubMatrix(matrix: List<List<Double>>, unusedI: Int, unusedJ: Int): List<List<Double>> {
    val result = mutableListOf<List<Double>>()
    for (i in matrix.indices) {
        if (i != unusedI) {
            val row = mutableListOf<Double>()
            for (j in matrix[i].indices) {
                if (j != unusedJ) {
                    row.add(matrix[i][j])
                }
            }
            result.add(row)
        }
    }
    return result
}