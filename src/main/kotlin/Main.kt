
fun parseInput(input : String): List<String> {
    val reg = Regex("(?=[*+-])")
    val parsedInput: List<String> = input.split(reg)
    val newList: MutableList<String> = parsedInput.toMutableList()
    if (newList[0] == "") {
        newList.removeAt(0)
    }

    return newList
}

fun multivision(list : List<String>): List<String> {
    var result : Double = 0.0

    println(list)
    val newList : MutableList<String> = list.toMutableList()

    var i = 0
    println(newList.size)
    while (i < newList.size-1) {
        println("index at: $i")
        if (newList[i + 1][0] == '*') {
            newList[i] = newList[i].replace("*", "")
            newList[i + 1] = newList[i + 1].replace("*", "")
            println(newList)
            result += newList[i].toDouble() * newList[i + 1].toDouble() - result

            newList.set(i, "0")
            newList.set(i + 1, "0")
            println("Step 1: $newList")

            newList.add(i + 2, result.toString())
            println("Step 2: $newList")
            i += 2
        } else {
            i += 1
        }
    }

    println("Finished $newList")
    return newList

}

fun main(input: String): Double {
    val userInput: String = input
    var parsedInput = parseInput(userInput)
    var result : Double = 0.0

    parsedInput = multivision(parsedInput)

    parsedInput.forEachIndexed { i, token ->
        result += parsedInput[i].toDouble()
    }

    println("AND THE RESULT ISSS: $result")
    return result

}
