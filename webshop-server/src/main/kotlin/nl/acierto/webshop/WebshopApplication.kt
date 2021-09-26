package nl.acierto.webshop

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@SpringBootApplication
class WebshopApplication

fun main(args: Array<String>) {
    runApplication<WebshopApplication>(*args)
}

@Bean
fun htmlRouter(@Value("classpath:/static/index.html") html: Resource): RouterFunction<ServerResponse> {
    return RouterFunctions.route(
        GET("/")
    ) { _ ->
        ServerResponse.ok().contentType(MediaType.TEXT_HTML).bodyValue(html)
    }
}

