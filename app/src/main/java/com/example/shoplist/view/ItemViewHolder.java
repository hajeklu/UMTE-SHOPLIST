package com.example.shoplist.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.shoplist.Model.Item;
import com.example.shoplist.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView description;
    private Switch aSwitch;
    private Item item;
    private Button editbtn;
    private Button deletebtn;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name_text);
        description = itemView.findViewById(R.id.textdesc);
        aSwitch = itemView.findViewById(R.id.switch1);
        editbtn = itemView.findViewById(R.id.btnedit);
        deletebtn = itemView.findViewById(R.id.btndelete);

    }

    public void setItem(Item item) {
        this.item = item;
        name.setText(item.getName());
        description.setText(item.getDescription());
        aSwitch.setChecked(item.isDone());
    }

    public void editbntSetOnClickListener(View.OnClickListener listener) {
        editbtn.setOnClickListener(listener);
    }

    public void deleteSetbtnOnClickListener(View.OnClickListener listener) {
        deletebtn.setOnClickListener(listener);
    }

    public void doneSetOnClickListener(CompoundButton.OnCheckedChangeListener listener){
        aSwitch.setOnCheckedChangeListener(listener);
    }

}
