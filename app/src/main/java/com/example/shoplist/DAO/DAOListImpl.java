package com.example.shoplist.DAO;

import com.example.shoplist.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class DAOListImpl implements IDAO {

    private List<Item> items = new ArrayList<>();

    private static DAOListImpl daoList;

    private DAOListImpl(){
        Item item = new Item();
        item.setName("První");
        item.setDescription("Muj prvni ukol");
        items.add(item);

        item = new Item();
        item.setName("Druhy");
        item.setDescription("Muj druhy ukol");
        items.add(item);

        item = new Item();
        item.setName("Třetí");
        item.setDescription("Muj třetí ukol");
        items.add(item);

        item = new Item();
        item.setName("Čtvrtý");
        item.setDescription("Muj čtvrtý ukol");
        items.add(item);

        item = new Item();
        item.setName("Pátý");
        item.setDescription("Muj pátý ukol");
        items.add(item);

        item = new Item();
        item.setName("Šestý");
        item.setDescription("Muj šestý ukol");
        items.add(item);

        item = new Item();
        item.setName("Sedmí");
        item.setDescription("Muj sedmí ukol");
        items.add(item);

        for(int i = 8; i < 180; i++){
            item = new Item();
            item.setName(i+"");
            item.setDescription("Muj " + i + " ukol");
            item.setDone(Math.random() < 0.5);
            items.add(item);
        }


    }

    public static DAOListImpl getInstanc(){
        if(daoList == null){
            daoList = new DAOListImpl();
        }
        return daoList;
    }

    @Override
    public void save(Item item) {
        items.add(item);
    }

    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public void delete(Item item) {
        for(int i = 0; i<items.size(); i++){
            item.equals(items.get(i));
            items.remove(i);
        }
    }

    @Override
    public void edit(Item item) {

    }

    @Override
    public void deleteByID(int id) {
        items.remove(id);
    }

    @Override
    public int getCount() {
        return items.size();
    }

}
