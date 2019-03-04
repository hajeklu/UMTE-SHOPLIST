package com.example.shoplist.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shoplist.Activity.FeedActvity;
import com.example.shoplist.Model.Item;
import com.example.shoplist.view.ItemView;
import com.example.shoplist.view.ItemViewHolder;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<Item> items;
    private TextView textView;
    private ItemView itemView;

    public FeedAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        itemView = new ItemView(viewGroup.getContext());
        textView = new TextView(viewGroup.getContext());
        ItemViewHolder itemViewHolder = new ItemViewHolder(itemView.getRoot());
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        itemView.setItem(items.get(i));
        textView.setText(items.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
