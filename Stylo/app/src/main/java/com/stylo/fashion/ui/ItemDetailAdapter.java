package com.stylo.fashion.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.stylo.fashion.R;
import com.stylo.fashion.model.Item;
import com.stylo.fashion.model.Product;
import com.stylo.fashion.util.GenerelHelper;

import java.util.List;

/**
 * Created by goman on 15/11/14.
 */
public class ItemDetailAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Item> mListOfItems;

    public ItemDetailAdapter(Context mContext) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setData(List<Item> listOfItems) {
        this.mListOfItems = listOfItems;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 20;//GenerelHelper.isListNullOrEmpty(mListOfProducts) ? 0 : mListOfProducts.size();
    }

    @Override
    public Item getItem(int position) {
        return GenerelHelper.isListNullOrEmpty(mListOfItems) ? null : mListOfItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        Item item = getItem(position);
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.item_list_product, parent, false);
            holder.imageProduct = (ImageView) convertView.findViewById(R.id.imageProduct);
            holder.textPrice = (TextView) convertView.findViewById(R.id.textPrice);
            holder.textCount = (TextView) convertView.findViewById(R.id.textCount);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
//        holder.textPrice.setText(product.getProductPrice());
//        Picasso.with(mContext).load(product.getProductImageUrl()).into(holder.imageProduct);
        holder.textPrice.setText(String.format(mContext.getResources().getString(R.string.item_price), "300"));
        holder.textCount.setText(String.format(mContext.getResources().getString(R.string.item_count), "5"));
        if(position % 2 == 0){

            Picasso.with(mContext)
                    .load("http://cdn11.lbstatic.nu/files/looks/medium/2014/11/15/4150082_image.jpg?1416047828")
                    .fit()
                    .into(holder.imageProduct);
        }
        else{
            Picasso.with(mContext)
                    .load("http://cdn9.lbstatic.nu/files/looks/medium/2014/11/15/4149988_image.jpg?1416041771")
                    .fit()
                    .into(holder.imageProduct);
        }

        return convertView;
    }

    private static class Holder {
        public TextView textPrice;
        public ImageView imageProduct;
        public TextView textCount;

    }

}
