package com.revature.daos;

import java.util.List;

public interface DatasourceCRUD <T> {
    //CRUD
    void create (T t);
    T read(int index);
    List<T> readAll();
    void update(T t);
    void delete (int id);


}
