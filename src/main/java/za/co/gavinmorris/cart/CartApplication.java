package za.co.gavinmorris.cart;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import za.co.gavinmorris.cart.entity.Cart;

import za.co.gavinmorris.cart.serializer.CartSerializer;

@SpringBootApplication
public class CartApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);

        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("beans.xml");
        //context.scan("za.co.gavinmorris.cart");

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Cart.class, new CartSerializer());
        mapper.registerModule(module);
    }
}
