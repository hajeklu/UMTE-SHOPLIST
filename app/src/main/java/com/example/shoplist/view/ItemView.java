package com.example.shoplist.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.shoplist.Model.Item;
import com.example.shoplist.R;

public class ItemView extends View {


    private View root;
    private TextView name;
    private TextView description;
    private Switch aSwitch;
    private Item item;
    private Button editbtn;
    private Button deletebtn;

    public ItemView(Context context) {
        super(context);
        root = inflate(context, R.layout.item_issue, null);

        name = root.findViewById(R.id.name_text);
        description = root.findViewById(R.id.textdesc);
        aSwitch = root.findViewById(R.id.switch1);
        editbtn = root.findViewById(R.id.btnedit);
        deletebtn = root.findViewById(R.id.btndelete);

    }

    public void setItem(Item item) {
        this.item = item;
        name.setText(item.getName());
        description.setText(item.getDescription());
        aSwitch.setChecked(item.isDone());
    }

    public View getRoot() {
        return root;
    }

    public void setRoot(ViewGroup root) {
        this.root = root;
    }


    public void setOnEditClickListener(View.OnClickListener clickListener) {
        editbtn.setOnClickListener(clickListener);
    }

    public void setOnDeleteClickListener(View.OnClickListener clickListener) {
        deletebtn.setOnClickListener(clickListener);
    }

}
