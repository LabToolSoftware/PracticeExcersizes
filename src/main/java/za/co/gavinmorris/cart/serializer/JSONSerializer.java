package za.co.gavinmorris.cart.serializer;


interface JSONSerializable{

    public void serialize();
    public Object deserialize();
}

public class JSONSerializer implements JSONSerializable{

    public void serialize(){

    }

    public Object deserialize(){
        Object o = new Object();
        return o;
    }
}
