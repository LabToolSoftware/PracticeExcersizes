package za.co.gavinmorris.cart.repository;

interface CustomRepository<T> {
    T find(String id);
    void save(T t);
    void remove(String id);
}
