fun parseInput(input : String): List<String> {
    // Pattern for separating list around operators
    val reg = Regex("(?=[/*+-])")
    val parsedInput: List<String> = input.split(reg)
    val newList: MutableList<String> = parsedInput.toMutableList()

    // For removing any empty elements if input starts with a signed number
    if (newList[0] == "") {
        newList.removeAt(0)
    }
    return newList
}

fun mutlivision(list : List<String>): List<String> {
    var result = 0.0
    val newList : MutableList<String> = list.toMutableList()

    // Logic for fixing signed multiplication or division
    if ("*" in newList || "/" in newList) {
        newList.forEachIndexed() {i, num ->
            if (num == "*" || num == "/") {
                // If both nums are signed the result is going to be positive
                if (newList[i-1][0] == '-') {
                    newList[i-1] = newList[i-1].replace("-", "")
                }

                // Otherwise ensure the number is still signed since it changes below
                else {
                    newList[i-1] = "-" + newList[i-1]
                }
                // Formats like this: ['*', '-5'] -> ['*5'] and removes extra list element containing operator
                newList[i + 1] = newList[i + 1].replace("-", "")
                newList[i+1] = newList[i] + newList[i+1]
                newList.removeAt(i)
            }

        }
    }
    // Uses while loop because we are changing newList length with 0's
    var i = 0
    while (i < newList.size-1) {
        if (newList[i + 1][0] == '*' || newList[i+1][0] == '/') {
            // If its '*' make sure the operator is removed
            if (newList[i + 1][0] == '*') {
                newList[i + 1] = newList[i + 1].replace("*", "")
                result += newList[i].toDouble() * newList[i + 1].toDouble() - result
            }
            // Likewise
            if (newList[i + 1][0] == '/') {
                newList[i + 1] = newList[i + 1].replace("/", "")
                result += newList[i].toDouble() / newList[i + 1].toDouble() - result
            }
            // Remove the multiplied/divided numbers for summing in main fun and add the result afterward
            newList.set(i, "0")
            newList.set(i + 1, "0")
            newList.add(i + 2, result.toString())

            // Change the index to match the added element
            i += 2
        // If there is no '*' or '/' just skip the element
        } else {
            i += 1
        }
    }
    return newList
}
// main arg is just for test cases
fun main(input: String): Double {
    val userInput: String = input
    var parsedInput = parseInput(userInput)
    var result = 0.0


    // for handling * and /
    parsedInput = mutlivision(parsedInput)

    // Sums the finished list regardless of sign
    parsedInput.forEachIndexed { i, token ->
        result += parsedInput[i].toDouble()
    }
    //Rounds up, so maybe should be changed or increase the digits
    result = String.format("%.3f", result).toDouble()
    println("AND THE RESULT ISSS: $result")
    return result

}