package com.yoridori.demo.hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("greeter/hello")
class GreeterController(private val greeter: Greeter) {
    // KotlinでConstructor Injectionする場合はAutowiredが不要
    // KotlinでField Injectionする場合はAutowiredが必要
    // ほとんどの場合でコンストラクタインジェクションを使用する
    @Autowired
    private lateinit var fieldGreeter: Greeter

    @GetMapping()
    fun hello(@RequestParam("name") name: String): HelloResponse {
        return HelloResponse("Hello $name")
    }

    @GetMapping("/{name}")
    fun helloPathValue(@PathVariable("name") name: String): HelloResponse {
        return HelloResponse("Hello $name")
    }

    @PostMapping()
    fun helloByPost(@RequestBody request: HelloRequest): HelloResponse {
        return HelloResponse("Hello ${request.name}")
    }

    @GetMapping("/byservice/{name}")
    fun helloByService(@PathVariable("name") name: String): HelloResponse {
        val message = greeter.sayHello(name)
        val fieldInjectionMessage = fieldGreeter.sayHello(name)
        return HelloResponse(message+fieldInjectionMessage)
    }
}