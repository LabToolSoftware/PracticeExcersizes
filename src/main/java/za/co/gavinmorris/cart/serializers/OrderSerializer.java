package za.co.gavinmorris.cart.serializers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import za.co.gavinmorris.cart.domain.Cart;
import za.co.gavinmorris.cart.domain.Item;
import za.co.gavinmorris.cart.domain.Order;

import java.io.IOException;

public class OrderSerializer extends StdSerializer<Order> {
    public OrderSerializer() {
        this(null);
    }

    public OrderSerializer(Class<Order> t) {
        super(t);
    }

    public void serialize(Order order, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName(order.getId());
        jsonGenerator.writeObject(order.getTrolley());
        jsonGenerator.writeNumberField("ordertotal", order.getOrderTotal());
        jsonGenerator.writeEndObject();
    }
}