import java.math.BigDecimal

data class Product(
    val productName: String,
    val price: BigDecimal
)

fun main() {
    var products = arrayOf(
        Product(
            "item 1",
            BigDecimal("1.99")
        ),
        Product(
            "item 2",
            BigDecimal("3.99")
        ),
        Product(
            "item 3",
            BigDecimal("7.79")
        )
    )

    var totalPrice = addPrices(products)
    println("total value: R$ $totalPrice")

    println("Type the paid value")
    val pricePaid = readlnOrNull()

    println("----------------------------------")
    println("amount paid: R$$pricePaid")
    println("total value: R$$totalPrice")
    if (pricePaid != null) {
        addReturned(pricePaid.toBigDecimal(), totalPrice)
    }

}

fun addReturned(pricePaid:BigDecimal , totalPrice:BigDecimal){
    if (pricePaid > totalPrice) {
        println("returned: R$" + (pricePaid - totalPrice))
    } else {
        println("purchase denied")
    }
}
fun addPrices(products:  Array<Product>): BigDecimal {
    var totalPrice = BigDecimal.ZERO
    for (product in products){
        println(product.productName + " | " + product.price)
        totalPrice = totalPrice.add(product.price)
    }
    return totalPrice
}