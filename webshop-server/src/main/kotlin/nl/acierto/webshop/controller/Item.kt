package nl.acierto.webshop.controller

import java.math.BigDecimal
import javax.persistence.*

@Entity
class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val price: BigDecimal
)
