package nl.acierto.webshop.resolvers

import graphql.kickstart.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import nl.acierto.webshop.controller.Item
import nl.acierto.webshop.repository.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class ItemQueryResolver : GraphQLQueryResolver {

    @Autowired
    lateinit var repository: ItemRepository

    fun findAll(environment: DataFetchingEnvironment): Iterable<Item> {
        return repository.findAll()
    }

    fun findOne(id: Long): Optional<Item> {
        return repository.findById(id)
    }

    fun findByNameContaining(name: String): Iterable<Item> {
        return repository.findItemsByNameContaining(name)
    }
}
