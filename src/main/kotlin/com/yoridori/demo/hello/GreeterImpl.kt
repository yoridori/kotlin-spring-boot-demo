package com.yoridori.demo.hello

import org.springframework.stereotype.Component

@Component
class GreeterImpl : Greeter{
    override fun sayHello(name: String): String {
        return "Hello $name"
    }
}