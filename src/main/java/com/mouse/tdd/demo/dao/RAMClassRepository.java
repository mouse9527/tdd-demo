package com.mouse.tdd.demo.dao;

import com.mouse.tdd.demo.model.Class;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RAMClassRepository implements ClassRepository {
    private final List<Class> db;

    public RAMClassRepository() {
        this.db = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public void save(Class aClass) {
        db.add(aClass);
    }

    @Override
    public Boolean exists(String id) {
        return null;
    }
}
