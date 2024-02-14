package com.alexeyyuditsky.test.test

class Carr
class Client
class Order

class RentCarService {
    fun findCar(carNo: String?): Carr {
        //find car by number
        return Carr()
    }

    fun orderCar(carNo: String?, client: Client): Order {
        //client order car
        return Order()
    }

    fun printOrder(order: Order?) {
        //print order
    }

    fun getCarInterestInfo(carType: String) {
        if (carType == "sedan") {
            //do some job
        }
        if (carType == "pickup") {
            //do some job
        }
        if (carType == "van") {
            //do some job
        }
    }

    fun sendMessage(typeMessage: String, message: String?) {
        if (typeMessage == "email") {
            //write email
            //use JavaMailSenderAPI
        }
    }
}