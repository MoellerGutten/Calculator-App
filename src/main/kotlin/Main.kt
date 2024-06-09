fun parseInput(input : String): List<String> {
    val reg = Regex("(?=[/*+-])")
    val parsedInput: List<String> = input.split(reg)
    val newList: MutableList<String> = parsedInput.toMutableList()
    if (newList[0] == "") {
        newList.removeAt(0)
    }
    return newList
}

fun mutlivision(list : List<String>): List<String> {
    var result : Double = 0.0
    val newList : MutableList<String> = list.toMutableList()
    if ("*" in newList || "/" in newList) {
        newList.forEachIndexed() {i, num ->
            if (num == "*" || num == "/") {
                if (newList[i-1][0] == '-') {
                    newList[i-1] = newList[i-1].replace("-", "")
                }
                else {
                    newList[i-1] = "-" + newList[i-1]
                }
                newList[i + 1] = newList[i + 1].replace("-", "")
                newList[i+1] = newList[i] + newList[i+1]
                newList.removeAt(i)
            }

        }
    }

    var i = 0
    while (i < newList.size-1) {
        if (newList[i + 1][0] == '*' || newList[i+1][0] == '/') {
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
            newList.add(i + 2, result.toString())
            i += 2
        } else {
            i += 1
        }
    }
    return newList
}

fun main(input: String): Double {
    val userInput: String = input
    var parsedInput = parseInput(userInput)
    var result : Double = 0.0

    parsedInput = mutlivision(parsedInput)
    parsedInput.forEachIndexed { i, token ->
        result += parsedInput[i].toDouble()
    }
    //Rounds up, so maybe should be changed or increase the digits
    result = String.format("%.3f", result).toDouble()
    println("AND THE RESULT ISSS: $result")
    return result

}