
fun parseInput(input : String): List<String> {
    val reg = Regex("(?=[/*+-])")
    val parsedInput: List<String> = input.split(reg)
    val newList: MutableList<String> = parsedInput.toMutableList()
    if (newList[0] == "") {
        newList.removeAt(0)
    }

    return newList
}

fun multiplication(list : List<String>): List<String> {
    var result : Double = 0.0
    val newList : MutableList<String> = list.toMutableList()

    var i = 0
    while (i < newList.size-1) {
        if (newList[i + 1][0] == '*' || newList[i+1][0] == '/') {

            println(newList)
            if (newList[i + 1][0] == '*') {
                newList[i + 1] = newList[i + 1].replace("${newList[i + 1][0]}", "")
                result += newList[i].toDouble() * newList[i + 1].toDouble() - result
            }

            if (newList[i + 1][0] == '/') {
                newList[i + 1] = newList[i + 1].replace("${newList[i + 1][0]}", "")
                result += newList[i].toDouble() / newList[i + 1].toDouble() - result
            }

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

    parsedInput = multiplication(parsedInput)
    parsedInput.forEachIndexed { i, token ->
        result += parsedInput[i].toDouble()
    }
    //Rounds up, so maybe should be changed or increase the digits
    result = String.format("%.3f", result).toDouble()
    println("AND THE RESULT ISSS: $result")
    return result

}
