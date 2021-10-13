# PATHWAY 1: Coroutines
[PATHWAY 1 사이트](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-1)


## Welcome to Unit 4: Connect to the internet
이전의 학습들에서는 데이터들을 미리 정해두고 개발을 하였다.</br>
이번에는 서버를 통해 외부의 데이터를 가져와 개발 하는 방법을 배울 것이다.</br>
`Retrofit 라이브러리`를 통해 웹 서버와 통신을하고 `코일 라이브러리`를 통해 이미지를 로드하는 것을 해볼 것이다.</br>
이미지를 다운로드하고 이미지를 볼 수 있도록 로드하는 것을 처리할 수 있어야 한다.

또한 `Concurrency(동시성)`에 대해서도 배운다.</br>
외부에서 데이터를 요청하고 처리하는 것은 복잡하고 시간이 많이 걸린다. 인터넷 속도, 데이터 크기 등에 따라서도 시간에 영향을 준다.</br>
이러한 시간동안 유저들은 가만히 기다리는 상황이 생길 수 있지만 안드로이드는 동시에 많은 일을 할 수 있다는 장점이 있다.</br>
다시 말하자면 앱의 백그라운드에서 서버의 결과를 기다리는 동안 사용자는 앱을 사용할 수 있다.</br>
메인 스레드가 UI와 피드백을 표시하는 것을 담당하고, 유저가 UI를 만지는 동안 백그라운드 스레드가 동작하여 데이터를 처리해야 한다.</br>
이러한 방법은 어려울 수 있지만, 코틀린의 `Coroutine(코루틴)`을 통해 쉽게 처리할 수 있다.

## Introduction to coroutines
[코루틴 소개](https://developer.android.com/codelabs/basic-android-kotlin-training-introduction-coroutines?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-4-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-introduction-coroutines#0)

 - `Thread(스레드)`</br>
    스레드는 코드를 작성할 때 각 명령어가 선택해야 하는 실행 경로를 결정하는데 사용할 수 있는 추상화이다. 다시 말하면 프로세서가 어떻게 한 번에 여러 작업을 처리하는 것처럼 보이는지에 관한 추상화이다.

    모든 안드로이드 앱에는 여러 스레드가 있지만 각 앱에는 전용 스레드가 하나 있고 특히 앱의 UI를 담당한다. 이것을 기본 스레드 또는 UI 스레드라고 한다(경우에 따라 UI 스레드와 기본 스레드가 다를 수 있다.). 지금까지 작성한 코드는 모두 기본 스레드에 속한다. 각 명령어는 다음 줄이 실행되기 전에 이전 줄이 완료되기를 기다린다.

    기본 스레드 외에도 스레드가 더 있다. 내부적으로 프로세서는 별도의 스레드로 작동하지 않고 일련의 여러 명령어 간에 전환하여 멀티태스킹의 모양을 제공한다. 기본 스레드가 아닌 스레드로 작업하면 앱의 사용자 인터페이스 응답섭을 유지하면서 앱이 이미지 다운로드와 같은 복잡한 작업을 백그라운드에서 실행할 수 있다. 이를 동시 실행 코드 또는 동시 실행이라고 한다.

    ```kotlin
        // 간단한 스레드 사용법
        val thread = Thread {
            println("${Thread.currentThread()} has run.")
        }
        thread.start() // start 함수에 도착할 때까지 스레드는 실행하지 않는다.
    ```

    - `Thread.start()`</br>
        스레드를 실행시키는 함수.

    - `Thread.currentThread()`</br>
        스레드의 이름, 우선순위, 스레드 그룹을 문자열 표현으로 변환되는 Thread 인스턴스를 반환한다.

- `멀티 스레딩 및 동시 실행`</br>
    동시 실행을 통해 여러 코드 단위를 순서에 맞지 않거나 병렬로 실행할 수 있어 리소스 사용의 효율성이 높아진다.</br>
    운영체제는 시스템, 프로그래밍 언어, 동시 실행 단위의 특성을 사용하여 멀티태스킹을 관리할 수 있다.</br>
    ![image](https://user-images.githubusercontent.com/52282493/137117259-96db67c0-7d93-4419-9350-111fbb3b4af3.png)

- `휴대전화의 UI 업데이트`</br>
    현재 휴대전화는 UI 업데이트를 초당 60회~120회(최소 60회)를 시도한다. 초당 60프레임, 각 화면 업데이트에 걸리는 시간은 16ms로 한정된 짧은 시간에 UI를 준비하고 그려야 한다. 안드로이드는 프레임을 드롭하거나 단일 업데이트 주기를 완료하려는 시도를 중단하여 따라잡으려고 한다. 일부 프레임 드롭 및 변동은 일반적이지만 너무 많으면 앱이 응답하지 않게 된다.

- `Coroutine(코루틴)`</br>
    코루틴은 동시 실행을 더 유연하고 쉽게 관리할 수 있도록 코틀린에서 제공하는 것이다. 멀티태스킹을 지원하지만 단순히 스레드로 작업하는 것보다 다른 수준의 추상화를 제공한다. 코루틴의 주요 기능 중 하나는 상태를 저장하여 중단했다가 재개할 수 있다는 것이다. 즉, 코루틴은 실행되거나 실행되지 않을 수 있다.

    연속으로 표시되는 상태를 통해 코드 일부가 제어권을 넘겨주거나 재개되기 전에 다른 코루틴이 작업을 완료할 때까지 기다려야 하는 시기를 나타낼 수 있다. 이러한 흐름은 **협력적인 멀티태스킹**이라고 한다.

    - `CoroutineScope`</br>
        하위 요소와 그 하위 요소에 취소 및 기타 규칙을 반복적으로 적용하는 context이다.</br>
        CoroutineScope 내에서 수명 주기가 있는 취소 가능한 작업 단위인 **Job**의 작업이 포함된다.
        launch() 및 async()와 같은 새 코루틴을 만드는데 사용되는 함수는 CoroutineScope를 확장한다.</br>

    - `Job`</br>
        취소 가능한 작업 단위이다.</br>
        ex)→ launch() 함수로 만든 작업 단위

    - `Dispatcher`</br>
        코루틴이 사용할 스레드를 결정한다. 메인 Dispatcher는 항상 기본 스레드에서 코루틴을 실행하지만 Default나 IO, Unconfined와 같은 Dispatcher는 다른 스레드를 사용한다.</br>
        코루틴이 실행행에 사용할 지원 스레드를 관리하므로 개발자가 새 스레드를 사용할 시기와 위치를 파악하지 않아도 된다.
        Dispatcher는 코루틴이 좋은 성능을 발휘할 수 있는 방법 중 하나이다.

- `GlobalScope.launch{}`</br>
    ```kotlin
        import kotlinx.coroutines.*
        // 코루틴 사용예제
        fun main() {
            repeat(3) {
                GlobalScope.launch {
                    println("Hi from ${Thread.currentThread()}")
                }
            }
        }
    ```
    GlobalScope는 앱이 실행되는 한 내부의 코루틴이 실행되도록 허용한다.</br>
    launch() 함수는 취소 가능한 Job 객체에 래핑된 닫힌 코드에서 코루틴을 만든다. launch()는 반환 값이 코루틴의 범위 밖에서 필요하지 않을 때 사용된다.

- `runBlocking()`</br>
    새 코루틴을 시작하고 완료될 때까지 현재 스레드를 차단하는 역할을 한다.</br>
    주로 기본 함수와 테스트에서 차단 코드와 비치단 코드 사이를 연결하는데 사용된다.(안드로이드에 코드에서는 자주 사용하지 않는다.)

- `async()`</br>
    코틀린에서 launch()와 비슷한 함수로 async()가 있다.</br>
    async() 함수는 **Deferred** 유형의 값을 반환한다.

- `Deferred`<br>
    미래 값 참조를 보유할 수 있는 취소 가능한 Job이다. Deferred를 사용하면 즉시 값을 반환하는 것처럼 함수를 계속 호출할 수 있다.</br>
    비동기 작업이 언제 반환될지 확신할 수 없기 때문에  Deferred는 자리표시자 역할만 한다.</br>
    Deferred는 나중에 이 객체에 값이 반환된다고 보장한다. 반면 비동기 작업은 기본적으로 실행을 차단하거나 기다리지 않는다. Deferred의 출력을 기다리도록 하려면 **await()**을 호출해야 한다.