package nl.acierto.webshop.repository

import nl.acierto.webshop.controller.Item
import org.springframework.data.repository.CrudRepository


interface ItemRepository : CrudRepository<Item, Long> {
    fun findItemsByNameContaining(str: String): List<Item>
}
