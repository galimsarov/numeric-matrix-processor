fun inverseMatrix() {
    val matrix = getMatrix()
    val determinant = getDeterminant(matrix)
    if (determinant == 0.0) {
        println("This matrix doesn't have an inverse.\n")
    } else {
        val transposedMatrix = getTransposedMatrix(matrix)
        val result = mutableListOf<List<Double>>()
        for (i in transposedMatrix.indices) {
            val row = mutableListOf<Double>()
            for (j in transposedMatrix[i].indices) {
                var sign = 1
                if (i % 2 != 0) {
                    sign *= -1
                }
                if (j % 2 != 0) {
                    sign *= -1
                }
                row.add(sign * getDeterminant(getSubMatrix(transposedMatrix, i, j)) / determinant)
            }
            result.add(row)
        }
        kotlin.io.print(result)
    }
}