package com.example.shoplist.Activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shoplist.Adapter.FeedAdapter;
import com.example.shoplist.DAO.DAOListImpl;
import com.example.shoplist.DAO.IDAO;
import com.example.shoplist.Listeners.ItemViewListener;
import com.example.shoplist.Model.Item;
import com.example.shoplist.R;

import java.util.List;

public class FeedActvity extends AppCompatActivity implements ItemViewListener {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;

    IDAO idao = DAOListImpl.getInstanc();

    List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_actvity);

        //DATABASE
        items = idao.findAll();

        //RECYCLERVIEW
        recyclerView = findViewById(R.id.recyclerView);

        //MANAGER LINEAR - budou pod sebou
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        //ADAPTER
        adapter = new FeedAdapter(items, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onEditClicked(Item item) {
        Intent intent = new Intent(FeedActvity.this, DetailActivity.class);
        intent.putExtra("itemName", item.getName());
        intent.putExtra("itemDesc", item.getDescription());
        startActivityForResult(intent, MainActivity.REQUEST_EDIT);
    }

    @Override
    public void onDeleteClicked(Item item) {

    }

    @Override
    public void onDeleteByID(int id) {
        idao.deleteByID(id);
        adapter.notifyItemRangeChanged(id,idao.getCount());
        adapter.notifyItemRemoved(id);

    }

    @Override
    public void isDoneChange(Item item) {
        item.setDone(!item.isDone());
        System.out.println(item.isDone());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MainActivity.REQUEST_ADD && resultCode == RESULT_OK) {
            //idao.save();
        }else if (requestCode == MainActivity.REQUEST_EDIT && resultCode == RESULT_OK) {
           // editItem(data.getStringExtra("name"), data.getStringExtra("desc"));
        }
    }

}
