package com.example.shoplist.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shoplist.Adapter.FeedAdapter;
import com.example.shoplist.DAO.DAOListImpl;
import com.example.shoplist.DAO.IDAO;
import com.example.shoplist.Model.Item;
import com.example.shoplist.R;

import java.util.List;

public class FeedActvity extends AppCompatActivity {

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

        //MANAGER
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        //ADAPTER
        adapter = new FeedAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}
