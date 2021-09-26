package nl.acierto.webshop.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono


@RestController
@RequestMapping("/items")
class ItemController {

    @GetMapping("/{id}")
    private fun getEmployeeById(@PathVariable id: String): Mono<Item> {
        return Item(id).toMono()
    }
}
