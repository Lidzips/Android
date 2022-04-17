package com.example.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class ProductAdapter extends ArrayAdapter<Product> {
    private LayoutInflater inflater;
    private int layout;
    private List<Product> products;

    public ProductAdapter(Context context, int resource, List<Product> products) {
        super(context, resource, products);
        this.products = products;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView==null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Product product = products.get(position);

        viewHolder.imageView.setImageResource(product.getImgResource());
        viewHolder.nameView.setText(product.getName());
        viewHolder.priceView.setText(String.format(Double.toString(product.getPrice())) + " " + "руб");

        return convertView;
    }

    private class ViewHolder {
        final ImageView imageView;
        final TextView nameView, priceView;
        ViewHolder(View view) {
            imageView = view.findViewById(R.id.pic);
            nameView = view.findViewById(R.id.name);
            priceView = view.findViewById(R.id.price);
        }
    }
}
