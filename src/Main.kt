fun main() {
    while (true) {
        printMenu()
        try {
            when (readln().toInt()) {
                1 -> sum()
                2 -> multiplyByConstant()
                3 -> multiplyByMatrix()
                4 -> transpose()
                5 -> determinant()
                6 -> inverseMatrix()
                0 -> break
            }
        } catch (_: Exception) {
            println()
        }
    }
}