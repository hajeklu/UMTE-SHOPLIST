package com.example.shoplist.DAO;

import com.example.shoplist.Model.Item;

import java.util.List;

public interface IDAO {

    void save(Item item);
    List<Item> findAll();
    void delete(Item item);
    void edit(Item item);
}
