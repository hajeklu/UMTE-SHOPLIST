package com.example.shoplist.Listeners;

import com.example.shoplist.Model.Item;

public interface ItemViewListener {

    void onEditClicked(Item item);

    void onDeleteClicked(Item item);

    void onDeleteByID(int id);

    void isDoneChange(Item item);
}
