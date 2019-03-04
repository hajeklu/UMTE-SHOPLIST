package com.example.shoplist.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shoplist.DAO.DAOListImpl;
import com.example.shoplist.DAO.IDAO;
import com.example.shoplist.Model.Item;
import com.example.shoplist.R;

public class DetailActivity extends AppCompatActivity {

    private IDAO dao = DAOListImpl.getInstanc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Button button = findViewById(R.id.btnSaveDetail);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item item = new Item();
                EditText co = findViewById(R.id.editTextCo);
                EditText kde = findViewById(R.id.editTextKde);
                item.setName(co.getText().toString());
                item.setDescription(kde.getText().toString());
                System.out.println(item);
                dao.save(item);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", item.getName());
                resultIntent.putExtra("desc", item.getDescription());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
