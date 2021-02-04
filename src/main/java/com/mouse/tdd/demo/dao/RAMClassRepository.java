package com.mouse.tdd.demo.dao;

import com.mouse.tdd.demo.model.Class;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

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
        return db.stream().anyMatch(isSameClass(id));
    }

    @Override
    public void delete(String id) {
        db.removeIf(isSameClass(id));
    }

    private Predicate<Class> isSameClass(String id) {
        return aClass -> aClass.getId().equals(id);
    }
}
