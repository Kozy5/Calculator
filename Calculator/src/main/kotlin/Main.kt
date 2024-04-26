package org.example

fun main(args: Array<String>) {
    /*
    1. 계산기 시작 화면
    계산 방법을 안내합니다.
    사용자의 진행여부에 따라 계산 시작 or 종료 가능합니다.

    2. 숫자 입력 화면
    연산할 첫번째 숫자, 두번째 숫자 순서대로 받습니다.

    3. 연산 방법 선택 화면
    1. 더하기
    2. 빼기
    3. 곱하기
    4. 나누기(몫 구하기)
    5. 나누기(나머지 구하기)
    중에 한가지를 고를 수 있습니다.

    4. 정답 안내 화면
    각 연산별 다른 문구와 함께 연산 결과를 알려줍니다.

    5. 추가 계산 진행여부 / 처음부터 반복
    더 계산을 진행할 지 계속 의사결정이 가능합니다


    # while문 사용 관련 / 예외 처리 관련

    예외 처리를 위해 입력 받을 때(readln())마다
    while문을 사용했으며

    각 while문 전에
    check~ 이라는 변수를 만들고 기본값을 false로 두어
    while문 진행여부를 검사 할 수 있게 합니다
    - while문을 빠져나와야 할 때 해당 변수를 true로 바꾸는 방식 -
    */

    while (start() == "Y") {

        var checkFirstNumber = false
        var firstNumber = 0L

        while (!checkFirstNumber) {
            println("연산할 첫번째 숫자를 입력해주세요")
            val firstNumberInput = readln().toLongOrNull()

            if (firstNumberInput == null) {
                println("숫자를 입력 해주셔야 합니다.")
            } else {
                firstNumber = firstNumberInput
                checkFirstNumber = true
            }
        }

        var checkSecondNumber = false
        var secondNumber = 0L

        while (!checkSecondNumber) {
            println("연산할 두번째 숫자를 입력해주세요")
            val secondNumberInput = readln().toLongOrNull()

            if (secondNumberInput == null) {
                println("숫자를 입력 해주셔야 합니다.")
            } else {
                secondNumber = secondNumberInput
                checkSecondNumber = true
            }
        }

        if (firstNumber >= secondNumber) {
            var checkSelectionMethod = false

            while (!checkSelectionMethod) {

                printCalculationGuideMessage()

                val selectCalculationMethod = readln()

                if (selectCalculationMethod == "1") {
                    PlusOperation().operate(firstNumber, secondNumber)
                    checkSelectionMethod = true
                } else if (selectCalculationMethod == "2") {
                    MinusOperation().operate(firstNumber, secondNumber)
                    checkSelectionMethod = true
                } else if (selectCalculationMethod == "3") {
                    MultiplyOperation().operate(firstNumber, secondNumber)
                    checkSelectionMethod = true
                } else if (secondNumber == 0L && selectCalculationMethod == "4") {
                    println("두번째 숫자가 0인 상태에서 나누기를 진행 할 수없습니다.")
                    println("다시 입력해주세요!")
                    println("-----------------------------------------------")
                } else if (selectCalculationMethod == "4") {
                    DivideOperation().operate(firstNumber, secondNumber)
                    checkSelectionMethod = true
                } else if (secondNumber == 0L && selectCalculationMethod == "5") {
                    println("두번째 숫자가 0인 상태에서 나누기를 진행 할 수없습니다.")
                    println("다시 입력해주세요!")
                    println("-----------------------------------------------")
                } else if (selectCalculationMethod == "5") {
                    RemainderOperation().operate(firstNumber, secondNumber)
                    checkSelectionMethod = true
                } else {
                    println("잘못된 입력입니다. 다시 선택해주세요")
                    println("-------------------------------")
                }
            }
        } else {
            var checkSelectionMethod = false

            while (!checkSelectionMethod) {

                printCalculationGuideMessage()

                val selectCalculationMethod = readln()

                if (selectCalculationMethod == "1") {
                    PlusOperation().operate(firstNumber, secondNumber)
                    checkSelectionMethod = true
                } else if (selectCalculationMethod == "2") {
                    MinusOperation().operate(firstNumber, secondNumber)
                    checkSelectionMethod = true
                } else if (selectCalculationMethod == "3") {
                    MultiplyOperation().operate(firstNumber, secondNumber)
                    checkSelectionMethod = true
                } else if (firstNumber == 0L && selectCalculationMethod == "4") {
                    println("첫번째 숫자가 0인 상태에서 나누기를 진행 할 수없습니다.")
                    println("다시 입력해주세요!")
                    println("-----------------------------------------------")
                } else if (selectCalculationMethod == "4") {
                    println("이 계산기는 정수만 취급하기에 큰 숫자에서 작은 숫자를 나누면 0을 리턴합니다.")
                    checkSelectionMethod = true
                } else if (firstNumber == 0L && selectCalculationMethod == "5") {
                    println("첫번째 숫자가 0인 상태에서 나누기를 진행 할 수없습니다.")
                    println("다시 입력해주세요!")
                    println("-----------------------------------------------")
                } else if (selectCalculationMethod == "5") {
                    println("이 계산기는 정수만 취급하기에 큰 숫자에서 작은 숫자를 나누면 0을 리턴합니다.")
                    checkSelectionMethod = true
                } else {
                    println("잘못된 입력입니다. 다시 선택해주세요")
                    println("-------------------------------")
                }
            }
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
    val getStartRequest = readln()
    return when (getStartRequest) {
        "1" -> "Y"
        else -> "N"
    }
}

fun printCalculationGuideMessage() {
    println("연산 방법을 골라주세요")
    println("1. 더하기")
    println("2. 빼기")
    println("3. 곱하기")
    println("4. 나누기(몫 구하기)")
    println("5. 나누기(나머지 구하기)")
}

abstract class AbstractOperation {
    abstract fun operate(num1: Long, num2: Long)
}

class PlusOperation : AbstractOperation() {
    override fun operate(num1: Long, num2: Long) {
        println("${num1} 더하기 ${num2}은(는) ${num1 + num2}입니다.")
    }
}

class MinusOperation : AbstractOperation() {
    override fun operate(num1: Long, num2: Long) {
        println("${num1} 빼기 ${num2}은(는) ${num1 - num2}입니다.")
    }
}

class MultiplyOperation : AbstractOperation() {
    override fun operate(num1: Long, num2: Long) {
        println("${num1} 곱하기 ${num2}은(는) ${num1 * num2}입니다.")
    }
}

class DivideOperation : AbstractOperation() {
    override fun operate(num1: Long, num2: Long) {
        println("${num1}를(을) ${num2}로(으로) 나누면 몫은 ${num1 / num2} 입니다.")
    }
}

class RemainderOperation : AbstractOperation() {
    override fun operate(num1: Long, num2: Long) {
        println("${num1}를(을) ${num2}로(으로) 나누면 나머지는 ${num1 % num2} 입니다.")
    }
}
