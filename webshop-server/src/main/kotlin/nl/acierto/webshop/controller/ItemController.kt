package nl.acierto.webshop.controller

import nl.acierto.webshop.repository.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.kotlin.core.publisher.toFlux


@RestController
@RequestMapping("/items")
class ItemController {

    @Autowired
    lateinit var repository: ItemRepository

    @GetMapping("/all")
    private fun findAllProducts(): Flux<Item> {
        return repository.findAll().toFlux()
    }

    @GetMapping("/find/{name}")
    private fun findAllProducts(@PathVariable name: String): Flux<Item> {
        return repository.findItemsByNameContaining(name).toFlux()
    }
}
