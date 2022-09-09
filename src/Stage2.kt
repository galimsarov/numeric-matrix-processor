fun getConstant(): Double {
    print("Enter constant: ")
    return try {
        readln().toDouble()
    } catch (_: Exception) {
        0.0
    }
}

fun multiplyByConstant() {
    val matrix = getMatrix()
    val constant = getConstant()
    val result = mutableListOf<List<Double>>()
    for (row in matrix) {
        result.add(row.map { it * constant })
    }
    kotlin.io.print(result)
}