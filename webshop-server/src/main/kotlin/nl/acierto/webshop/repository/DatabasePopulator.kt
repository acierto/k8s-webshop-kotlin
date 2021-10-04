package nl.acierto.webshop.repository

import nl.acierto.webshop.controller.Item
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import java.math.BigDecimal
import javax.annotation.PostConstruct

@Configuration
class DatabasePopulator {

    @Autowired
    lateinit var repository: ItemRepository

    @PostConstruct
    fun populate() {
        if (repository.count() == 0L) {
            repository.save(Item(null, "Tomato", BigDecimal("2.56")))
            repository.save(Item(null, "Potato", BigDecimal("1.15")))
            repository.save(Item(null, "Banana", BigDecimal("1.17")))
        }
    }
}
