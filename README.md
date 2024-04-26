# 과제 - 계산기

## 🔍 진행방식


- 과제는 필수 구현 사항 Lv1 ~Lv3, 선택 구현 사항 Lv4로 구성되어 있다.
- Lv4 선택 구현 기능 까지 시도해본다.
- 기능 요구사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## ✉️ 과제 제출 방법

- 과제 구현을 완료한 후 GitHub을 통해 제출해야 한다.
- 제출 기한 : 04/26(금) 14시까지
   

## ✔️ 환경 설정

- Language : Kotlin
- IDLE : IntelliJ
- JDK : 1.8.0


## 🚀 기능 요구사항

 ### 필수 구현 기능
  - [ ]  Lv1
    - [ ]  더하기, 빼기, 나누기, 곱하기 연산을 수행할 수 있는 Calculator 클래스를 만들기
    - [ ]  생성한 클래스를 이용하여 연산을 진행하고 출력하기

- [ ]  Lv2
    - [ ]  Lv1에서 만든 Calculator 클래스에 “나머지 연산”이 가능하도록 코드를 추가하고, 연산 진행 후 출력
    - [ ]  ex) 나머지 연산 예시 : 6을 3으로 나눈 나머지는 0 / 5를 3으로 나눈 나머지는 2

- [ ]  Lv3
    - [ ]  아래 각각 클래스들을 만들고 클래스간의 관계를 고려하여 Calculator 클래스와 관계 맺기
        - [ ]  AddOperation(더하기)
        - [ ]  SubstractOperation(빼기)
        - [ ]  MultiplyOperation(곱하기)
        - [ ]  DivideOperation(나누기)
        - [ ]  관계를 맺은 후 필요하다면 Calculator 클래스의 내부코드를 변경 세 가지로 구성되어 있다.
    ### 선택 구현 기능
- [ ]  Lv4
    - [ ]  아래 연산 클래스들을 AbstractOperation라는 클래스명으로 만들어 사용하여 추상 클래스로 정의하고 Calculator 클래스의 내부 코드를 변경합니다.
        - [ ]  AddOperation(더하기)
        - [ ]  SubtractOperation(빼기)
        - [ ]  MultiplyOperation(곱하기)
        - [ ]  DivideOperation(나누기)

## 기능
1. 계산기 시작 화면
    - 계산 방법을 안내합니다.
    - 사용자의 진행여부에 따라 계산 시작 or 종료 가능합니다.
```java
-----------------------------------
-------------계산 방법---------------
연산할 숫자를 안내에 따라 하나씩 입력해주세요
숫자 입력 후 연산 방법을 결정 할 수 있습니다.
-----------------------------------
메뉴를 골라주세요
계속 계산을 원하시면 숫자 1
계산 종료를 원하시면 아무거나 입력해주세요
```
2. 숫자 입력 받는 화면
    - 연산할 첫번째 숫자, 두번째 숫자 순서대로 받습니다.
```java
연산할 첫번째 숫자를 입력해주세요
10
연산할 두번째 숫자를 입력해주세요
5
```
3. 연산 방법 선택 화면
    - 각 연산 중 한가지를 고를 수 있습니다.

```java
연산 방법을 골라주세요
1. 더하기
2. 빼기
3. 곱하기
4. 나누기(몫 구하기)
5. 나누기(나머지 구하기)
```
4. 정답 안내 화면
    - 각 연산별 다른 문구와 함께 연산 결과를 알려줍니다.
```java
10를(을) 5로(으로) 나누면 몫은 2 입니다.
```
5. 처음으로 롤백 / 추가 계산 진행여부 확인
    - 더 계산을 진행할 지 의사결정이 가능합니다.
```java
-----------------------------------
-------------계산 방법---------------
연산할 숫자를 안내에 따라 하나씩 입력해주세요
숫자 입력 후 연산 방법을 결정 할 수 있습니다.
-----------------------------------
메뉴를 골라주세요
계속 계산을 원하시면 숫자 1
계산 종료를 원하시면 아무거나 입력해주세요
```

## 코드 구조

클래스는 `AbstractOperation`1개의 추상 클래스와 상속 받는 `Plus,Minus,Multiply, Divide,Remainder ` 5개의 클래스로 나뉩니다.

- `AbstractOperation`
  : 추상 클래스로 이 클래스를 수퍼 클래스로 상속 받은 클래스들은 모두 oprate를 구현하도록 했습니다.
```kotlin
abstract class AbstractOperation {
    abstract fun operate(num1: Long, num2: Long)
}
```
- `Plus, Minus, Multiply, Divide, Remainder`
  : 추상 클래스를 상속 받고 상속 받은 추상 함수를 각 클래스 별 성격에 맞게 구현하였습니다.
```kotlin
class PlusOperation : AbstractOperation() {
    override fun operate(num1: Long, num2: Long) {
        println("${num1} 더하기 ${num2}은(는) ${num1 + num2}입니다.")
    }
}
```

## 예외 처리 <br/>
※ try,catch가 미숙하여 조건문으로 예외처리를 시도했습니다. <br/>
### 1. readln() / 입력값 예외 처리 <br/>

#### 1-1 readln().toLongOrNull()
- 입력 별 원하는 데이터만 받기 위해 숫자 입력 부분에서는 `readln().toLongOrNull()`을 사용했습니다.
- 이유 1 `toLongOrNull()`은 <br/> `null` 그 자체뿐 아니라
받아온 데이터가 Long형으로 형 변환이 불가하면 <br/>
`null`을 리턴 해주기에 `null`에 대해서 예외처리 진행 시 많은 부분이 커버 되었기에 선택했습니다.

```kotlin

            println("연산할 첫번째 숫자를 입력해주세요")
            val firstNumberInput = readln().toLongOrNull()

            if (firstNumberInput == null) {
                println("숫자를 입력 해주셔야 합니다.")
            }
            ~
```

#### 1-2 그 외 입력값 예외처리 / while문 관련
- 각 입력 받는 부분마다 프로그램이 종료되지않고 예외처리를 하기 위해
while문을 사용해봤습니다
- 각 while문의 조건을 담당하는 check ~ 변수를 생성
- 기본값을 false로 주어 검사 후 반복문을 시작
- 요구하는 데이터가 들어올 시 while조건을 담당하는 변수를 true로 바꾸어 반복문을 빠져나간다.<br/>
  <ins> 따라서 요구하는 데이터 타입 이 외에 것을 입력 시 해당 입력 요청을 계속 반복합니다. </ins>

```kotlin

        var checkFirstNumber = false
        
        while (!checkFirstNumber) {
            println("연산할 첫번째 숫자를 입력해주세요")
            val firstNumberInput = readln().toLongOrNull()

            if (firstNumberInput == null) {
                println("숫자를 입력 해주셔야 합니다.")
            } else {
                checkFirstNumber = true
            }
        }
```
### 2. 0 나눗셈 예외처리 <br/>
※ 첫번째 숫자 두번째 숫자의 크고 작음을 조건문을 통해 비교 후 true,false에 따라 조건문이 진행되는 방식을 선택했습니다.
#### 2-1 두번째 숫자가 0일 때
- 예를 들어 첫번째 숫자는 0을 초과하는 임의의 정수이고<br/>
  두번째 숫자가 0일 때 나누기를 시도한다면 <br/>
  두번째 숫자가 0인 상태에서 나누기를 진행 할 수없으니<br/>
  <ins>연산 방법 선택을 다시 요청합니다.</ins>

```kotlin
             if (firstNumber >= secondNumber){


                              ~
              else if (secondNumber == 0L && selectCalculationMethod == "4") {
                    println("두번째 숫자가 0인 상태에서 나누기를 진행 할 수없습니다.")
                    println("다시 입력해주세요!")
                    println("-----------------------------------------------")
                }else if (secondNumber == 0L && selectCalculationMethod == "5") {
                    println("두번째 숫자가 0인 상태에서 나누기를 진행 할 수없습니다.")
                    println("다시 입력해주세요!")
                    println("-----------------------------------------------")
                }

                              ~

            }
```
#### 2-2 첫번째 숫자가 0일 때
- 반대로 <br/>
  첫번째 숫자가 0이고<br/>
  두번째 숫자가 0을 초과하는 임의의 정수일 때<br/>
  나누기를 시도한다면 두번째 숫자가 0인 상태에서도 나누기를 진행 할 수 없으니<br/>
  <ins>연산 방법 선택을 다시 요청합니다.</ins>

```kotlin
             if (firstNumber >= secondNumber){


                              ~
              else if (secondNumber == 0L && selectCalculationMethod == "4") {
                    println("첫번째 숫자가 0인 상태에서 나누기를 진행 할 수없습니다.")
                    println("다시 입력해주세요!")
                    println("-----------------------------------------------")
                }else if (secondNumber == 0L && selectCalculationMethod == "5") {
                    println("첫번째 숫자가 0인 상태에서 나누기를 진행 할 수없습니다.")
                    println("다시 입력해주세요!")
                    println("-----------------------------------------------")
                }

                              ~

            }
```
### 3. 큰 숫자에서 작은 숫자를 나눌때(실수) 예외처리 <br/>

#### 3-1 ex) 5를 10으로 나누기
- 5를 10으로 나누면 0.5와 같이 실수형으로 나타낼 수 있는데<br/>
해당 계산기에서는 정수만을 취급하기에 0을 리턴한다고 안내 후<br/>
<ins>다음 구문으로 넘어가도록 했습니다.(추가 반복 X)<ins>

```kotlin
             if (firstNumber >= secondNumber){


                              ~
              else if (selectCalculationMethod == "4") {
                    println("이 계산기는 정수만 취급하기에 큰 숫자에서 작은 숫자를 나누면 0을 리턴합니다.")
                    checkSelectionMethod = true
                }else if (selectCalculationMethod == "5") {
                    println("이 계산기는 정수만 취급하기에 큰 숫자에서 작은 숫자를 나누면 0을 리턴합니다.")
                    checkSelectionMethod = true
                }

                              ~

            }
```
- 해당 입력값의 while문 반복 조건 변수인 checkSelectionMethod를 true로 바꾸면서 <br/>
더이상 반복하지 않고 다음 구문으로 넘어가는 것을 알 수 있습니다.
