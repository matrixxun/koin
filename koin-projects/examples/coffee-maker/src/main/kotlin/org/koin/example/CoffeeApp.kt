package org.koin.example

import org.koin.log.PrintLogger
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import kotlin.system.measureTimeMillis

class CoffeeApp : KoinComponent {

    val maker: CoffeeMaker by inject()
}

fun main(vararg args: String) {

    startKoin(
        list = listOf(coffeeAppModule),
        logger = PrintLogger(showDebug = true)
    )
    val coffeeShop = CoffeeApp()

    val appDuration = measureTimeMillis {
        coffeeShop.maker.brew()
    }

    println("executed in $appDuration ms")
}
