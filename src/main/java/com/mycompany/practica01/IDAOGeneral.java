package com.mycompany.practica01;

import java.util.List;

public interface IDAOGeneral <T,I>{
    public T save(T pojo);
    public T update(T pojo, I id);
    public boolean delete(I id);
    public T findById(I id);
    public List<T> findAll();
}
