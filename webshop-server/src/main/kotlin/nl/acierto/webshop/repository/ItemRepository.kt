package nl.acierto.webshop.repository

import nl.acierto.webshop.controller.Item
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository


interface ItemRepository : CrudRepository<Item, Long>, JpaSpecificationExecutor<Item> {
    fun findItemsByNameContaining(str: String): List<Item>
}
