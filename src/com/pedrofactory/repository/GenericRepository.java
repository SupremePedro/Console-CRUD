package com.pedrofactory.repository;

public interface GenericRepository<T, ID> {
    ID create(T t);
    T read(ID id);
    T update(ID id, T t);
    void delete(ID id);
}
