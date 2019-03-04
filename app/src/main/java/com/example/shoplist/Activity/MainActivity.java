package com.example.shoplist.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.shoplist.DAO.DAOListImpl;
import com.example.shoplist.DAO.IDAO;
import com.example.shoplist.Model.Item;
import com.example.shoplist.R;
import com.example.shoplist.view.ItemView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private IDAO dao = DAOListImpl.getInstanc();
    private LinearLayout linearLayout;
    private static final int REQUEST_ADD = 1000;
    private static final int REQUEST_EDIT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        linearLayout = findViewById(R.id.layoutContainer);

        // linearLayout.setBackgroundColor(Color.RED);

        renderView();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivityForResult(intent, REQUEST_ADD);
                //startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ADD && resultCode == RESULT_OK) {
            addItemToLinearLayout(data.getStringExtra("name"), data.getStringExtra("desc"));
        }else if (requestCode == REQUEST_EDIT && resultCode == RESULT_OK) {
            editItem(data.getStringExtra("name"), data.getStringExtra("desc"));
        }
    }

    private void editItem(String name, String desc) {

    }

    private void renderView(){
        linearLayout.removeAllViews();
        List<Item> items = dao.findAll();
        for (int i = 0; i<items.size(); i++) {
            final Item item = items.get(i);
            ItemView itemView = new ItemView(this);
            itemView.setItem(item);

            itemView.setOnEditClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    startActivityForResult(intent, REQUEST_EDIT);
                }
            });
            itemView.setOnDeleteClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dao.findAll().remove(item);
                    renderView();
                }
            });
            linearLayout.addView(itemView.getRoot());
        }
    }

    private void addItemToLinearLayout(String name, String description) {
        Item item = new Item();
        item.setDescription(description);
        item.setName(name);
        ItemView itemView = new ItemView(this);
        itemView.setItem(item);
        linearLayout.addView(itemView.getRoot());
    }

}
