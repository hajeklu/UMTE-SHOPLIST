package com.example.shoplist.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.example.shoplist.DAO.DAOListImpl;
import com.example.shoplist.DAO.IDAO;
import com.example.shoplist.Listeners.ItemViewListener;
import com.example.shoplist.Model.Item;
import com.example.shoplist.R;
import com.example.shoplist.view.ItemViewHolder;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private IDAO idao = DAOListImpl.getInstanc();

    private List<Item> items;

    private ItemViewListener listener;

    public FeedAdapter(List<Item> items, ItemViewListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_issue, viewGroup, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.setItem(items.get(i));

        final int index = i;

        itemViewHolder.editbntSetOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEditClicked(items.get(index));
            }
        });

        itemViewHolder.deleteSetbtnOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDeleteByID(index);
            }
        });

        itemViewHolder.doneSetOnClickListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listener.isDoneChange(items.get(index));
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
