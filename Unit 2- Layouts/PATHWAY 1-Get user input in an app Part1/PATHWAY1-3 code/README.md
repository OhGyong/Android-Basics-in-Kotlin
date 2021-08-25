``` kotlin
import kotlin.math.PI
import kotlin.math.sqrt

// 추상 클래스 생성(생성자는 거주민)
abstract class Dwelling(private var residents: Int){

    abstract val buildingMaterial: String // 추상 데이터, 건물 재질
    abstract val capacity: Int // 추상 데이터, 건물의 수용가능 인원

    abstract fun floorArea(): Double // 추상 함수, 건물의 면적

    // 남은 방이 있는지 확인하는 함수
    fun hasRoom(): Boolean {
        return residents < capacity
    }
    
    // 남은 방을 파악하여 Text로 알려주는 함수
    fun getRoom(){
        if(capacity > residents){
            residents++
            println("방을 구하셨습니다!")
        } else {
            println("미안하지만 남은 방이 없어요.")
        }
    }
}

/**
 * 네모난 오두막 클래스(생성자는 Dwelling의 거주민을 똑같이 받고 길이가 있음)
 * Dwelling 클래스로부터 상속받음(SquareCabin은 Dwelling 클래스의 서브 클래스)
 * 상위 클래스에서 하위 클래스로 확장할 때 상위 클래스의 매개변수를 필수적으로 전달해야 한다.
 */
class SquareCabin(residents: Int,
                  val length: Double): Dwelling(residents){

    // 추상 데이터 및 함수를 override를 통하여 재정의한다.
    override val buildingMaterial = "Wood";
    override val capacity = 6

    override fun floorArea(): Double{
        return length*length
    }
}

/**
 * 둥근 오두막 클래스
 * 다른 클래스에 상속을 해주기 위해서 open 클래스로 생성
 */
open class RoundHut(residents: Int,
                    val radius: Double) : Dwelling(residents){

    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }
    
    // 카펫의 면적을 구하는 함수
    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

/**
 * 둥근 오두막을 여러개 쌓은 타워 클래스
 * RoundHut 클래스를 상속
 */
class RoundTower(residents: Int,
                 radius: Double,
                 val floors: Int = 2): RoundHut(residents, radius){

    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}


fun main() {
    val squareCabin = SquareCabin(6,50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)

    with(squareCabin){
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Floor area: ${floorArea()}")
    }
    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Floor area: ${floorArea()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Floor area: ${floorArea()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
}
```


### 실행결과

![image](https://user-images.githubusercontent.com/52282493/129825882-b8bfe0ce-1ee5-446e-adf5-e24497b45088.png)
