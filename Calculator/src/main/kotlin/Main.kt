package org.example

fun main(args: Array<String>) {

    while (start() == "Y") {

        println("연산할 첫번째 숫자를 입력해주세요")
        val firstNumber = readLine()!!.toLong()
        println("연산할 두번째 숫자를 입력해주세요")
        val secondNumber = readLine()!!.toLong()

        printCalculationGuideMessage()
        val selectCalculationMethod = readLine()!!
        when (selectCalculationMethod) {
            "1" -> AddCalculator(firstNumber, secondNumber).Operation(firstNumber, secondNumber)
            "2" -> SubstractCalculator(firstNumber, secondNumber).Operation(firstNumber, secondNumber)
            "3" -> MultiplyCalculator(firstNumber, secondNumber).Operation(firstNumber, secondNumber)
            "4" -> DivideCalculator(firstNumber, secondNumber).Operation(firstNumber, secondNumber)
            "5" -> RemainderCalculator(firstNumber, secondNumber).Operation(firstNumber, secondNumber)
            else -> reInputRequest()

        }

    }
}


fun start(): String {
    println("-----------------------------------")
    println("-------------계산 방법---------------")
    println("연산할 숫자를 안내에 따라 하나씩 입력해주세요")
    println("숫자 입력 후 연산 방법을 결정 할 수 있습니다.")
    println("-----------------------------------")
    println("메뉴를 골라주세요")
    println("계속 계산을 원하시면 숫자 1")
    println("계산 종료를 원하시면 아무거나 입력해주세요")
    val getStartRequest = readLine()!!
    when (getStartRequest) {
        "1" -> return "Y"
        else -> return "N"
    }
}

fun printCalculationGuideMessage() {
    println("연산 방법을 골라주세요")
    println("1. 더하기")
    println("2. 빼기")
    println("3. 곱하기")
    println("4. 나누기(몫 구하기)")
    println("5. 나누기(나머지 구하기)")
    println("잘못 입력하시면 처음으로 넘어갑니다.")
}

fun reInputRequest() {
    println("처음으로 돌아갑니다")
}

abstract class AbstractOperation(num1: Long, num2: Long) {
    abstract fun Operation(num1: Long, num2: Long)
}


class AddCalculator(num1: Long, num2: Long) : AbstractOperation(num1, num2) {
    override fun Operation(num1: Long, num2: Long) {
        println(num1 + num2)
    }
}

class SubstractCalculator(num1: Long, num2: Long) : AbstractOperation(num1, num2) {
    override fun Operation(num1: Long, num2: Long) {
        println(num1 - num2)
    }
}
class MultiplyCalculator(num1: Long, num2: Long) : AbstractOperation(num1, num2) {
    override fun Operation(num1: Long, num2: Long) {
        println(num1 * num2)
    }
}

class DivideCalculator(num1: Long, num2: Long) : AbstractOperation(num1, num2) {
    override fun Operation(num1:Long,num2: Long) {
        println(num1 / num2)
    }
}

class RemainderCalculator(num1: Long, num2: Long) : AbstractOperation(num1, num2) {
    override fun Operation(num1:Long,num2:Long) {
        println(num1 % num2)
    }
}
