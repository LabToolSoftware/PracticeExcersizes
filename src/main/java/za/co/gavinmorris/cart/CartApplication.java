package za.co.gavinmorris.cart;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import za.co.gavinmorris.cart.entity.Cart;

import za.co.gavinmorris.cart.serializer.CartSerializer;

@SpringBootApplication
@EnableJpaRepositories("za.co.gavinmorris.cart")
public class CartApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Cart.class, new CartSerializer());
        mapper.registerModule(module);
    }
}
