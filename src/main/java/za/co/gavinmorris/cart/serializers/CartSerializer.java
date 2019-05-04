package za.co.gavinmorris.cart.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.domain.Item;

import java.io.IOException;

public class CartSerializer extends StdSerializer<Cart> {
    public CartSerializer() {
        this(null);
    }

    public CartSerializer(Class<Cart> t) {
        super(t);
    }

    public void serialize(Cart cart, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("cartID", cart.getId());
        jsonGenerator.writeFieldName("basket");
        jsonGenerator.writeStartObject();
        for(Item i: cart.getBasket().keySet()){
            jsonGenerator.writeFieldName(i.getSku());
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name",i.getName());
            jsonGenerator.writeNumberField("cost",i.getCost());
            jsonGenerator.writeNumberField("quantity",cart.getBasket().get(i));
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndObject();
        jsonGenerator.writeNumberField("total", cart.getTotal());
        jsonGenerator.writeEndObject();
    }
}
