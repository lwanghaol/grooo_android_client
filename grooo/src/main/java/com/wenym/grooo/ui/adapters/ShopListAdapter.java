package com.wenym.grooo.ui.adapters;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.runzii.lib.utils.Logs;
import com.wenym.grooo.R;
import com.wenym.grooo.databinding.RestaurantListItemDevBinding;
import com.wenym.grooo.model.app.Shop;
import com.wenym.grooo.ui.activities.RestaurantDetailActivity;
import com.wenym.grooo.util.SmallTools;

import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class ShopListAdapter extends RecyclerView.Adapter<ShopListAdapter.ShopViewHolder> {

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;
    private List<Shop> contents;

    public List<Shop> getContents() {
        return contents;
    }

    public void setContents(List<Shop> contents) {
        this.contents = contents;
    }

    public ShopListAdapter(List<Shop> contents) {
        this.contents = contents;
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public ShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_list_item_dev, parent, false);
        return new ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ShopViewHolder holder, final int position) {
        final Shop shop = contents.get(position);
        holder.devBinding.setShop(shop);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), RestaurantDetailActivity.class);
            intent.putExtra("shopid", SmallTools.toGsonString(shop));
            holder.itemView.getContext().startActivity(intent);
        });

    }

    public static class ShopViewHolder extends RecyclerView.ViewHolder {

        RestaurantListItemDevBinding devBinding;

        public ShopViewHolder(View itemView) {
            super(itemView);
            devBinding = DataBindingUtil.bind(itemView);
        }
    }
}