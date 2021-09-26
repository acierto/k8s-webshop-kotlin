package nl.acierto.webshop.repository

import nl.acierto.webshop.controller.Item
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
class DatabasePopulator {

    @Autowired
    lateinit var repository: ItemRepository

    @PostConstruct
    fun populate() {
        repository.save(Item(null, "Tomato"))
        repository.save(Item(null, "Potato"))
        repository.save(Item(null, "Banana"))
    }
}
