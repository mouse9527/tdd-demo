package com.mouse.tdd.demo.dao;

import com.mouse.tdd.demo.model.Class;

public interface ClassRepository {
    void save(Class aClass);

    Boolean exists(String id);

    void delete(String id);
}
