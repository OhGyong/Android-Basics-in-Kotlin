``` kotlin
/**
 * 주문 목록 클래스
 */ 
class Order(val order:Int){
    val orderList = mutableListOf<Menu>()
    var orderPrice = 0

    fun addList(newOrder: Menu): Order{
        orderList.add(newOrder)
        return this
    }

    fun addAllList(newOrders: List<Menu>): Order{
        orderList.addAll(newOrders)
        return this
    }

    fun print(){
        println("Order #${order}")
        for(order in orderList){
            println(order)
            orderPrice += order.price
        }
        println("Total: $${orderPrice}")
        println()
    }

}

open class Menu(val menu: String, var price: Int)

class Noodle: Menu("noodle", 10){
    override fun toString(): String{
        return "Noodles" +": $" + price
    }
}

class Topping(vararg val topping: String): Menu("topping", 0){

    override fun toString(): String{
        for(num in topping){
            price++ 
        }
        return "Vegetables " + topping.joinToString() + ": " + "$" + price
    }
}


fun main(){

//     val order1 = Order(1)
//     order1.addList(Noodle())
//     order1.addList(Topping("Carrots", "Beans", "Celery"))
//     order1.print()

//     val order2 = Order(2)
//     order2.addList(Noodle())
//     order2.addList(Noodle())
//     order2.print()

//     val order3 = Order(3)
//     order3.addAllList(listOf(Noodle(),Topping("Carrots", "Beans")))
//     order3.print()
    
//     val order4 = Order(4)
//     order4.addList(Noodle())
//         .addAllList(listOf(Noodle(), Topping("Carrots", "Beans", "Celery")))
//     order4.print()
    
    val orderList = mutableListOf<Order>()
    val order1 = Order(1)
    order1.addList(Noodle())
    order1.addList(Topping("Carrots", "Beans", "Celery"))
    orderList.add(order1)

    val order2 = Order(2)
    order2.addList(Noodle())
    order2.addList(Noodle())
    orderList.add(order2)

    val order3 = Order(3)
    order3.addAllList(listOf(Noodle(),Topping("Carrots", "Beans")))
    orderList.add(order3)
    
    val order4 = Order(4)
    order4.addList(Noodle())
        .addAllList(listOf(Noodle(), Topping("Carrots", "Beans", "Celery")))
    orderList.add(order4)
    
    for(order in orderList){
        order.print()
    }
    
}
```