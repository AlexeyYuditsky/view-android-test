package com.alexeyyuditsky.test.example

interface NotificationService {
    fun sendMessage(message: String)
}

class EmailNotification : NotificationService {
    override fun sendMessage(message: String) {
        //write email
        //use JavaMailSenderAPI
    }
}

class MobileNotification : NotificationService {
    override fun sendMessage(message: String) {
        //write sms
        //send sms
    }
}

class NotificationService2 {
    fun sendMessage(typeMessage: String, message: String?) {
        if (typeMessage == "email") {
            //write email
            //use JavaMailSenderAPI
        }
    }
}

class PrinterService {
    fun printOrder(order: Order?) {
        //print order
    }
}

class CarInfoService {
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
}

class CarService {
    fun findCar(carNo: String?): Carr {
        //find car by number
        return Carr()
    }
}


class RentCarService2 {
    fun orderCar(carNo: String?, client: Client?): Order {
        //client order car
        return Order()
    }
}