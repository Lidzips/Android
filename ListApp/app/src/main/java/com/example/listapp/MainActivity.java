package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    String[] prodNames;
    int[] prodPrices;
    ArrayList<Product> products = new ArrayList<Product>();
    ListView productsList;
    ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        prodNames = getResources().getStringArray(R.array.products);
        prodPrices = getResources().getIntArray(R.array.prices);
        setInitialData();
        // получаем элемент ListView
        productsList = findViewById(R.id.productsList);
        // создаем адаптер
        productAdapter = new ProductAdapter(this, R.layout.list_item, products);
        // устанавливаем адаптер
        productsList.setAdapter(productAdapter);
        // настраиваем автозаполнение
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autocomplete);
        ArrayAdapter<String> adapter = new ArrayAdapter (this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, prodNames);
        autoCompleteTextView.setAdapter(adapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                Product selectedProduct = (Product)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedProduct.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        productsList.setOnItemClickListener(itemListener);
    }

    private void setInitialData() {
        products.clear();
        products.add(new Product (prodNames[0], prodPrices[0], R.drawable.hpv20));
        products.add(new Product (prodNames[1], prodPrices[1], R.drawable.phil241v8l));
        products.add(new Product (prodNames[2], prodPrices[2], R.drawable.hp24f));
        products.add(new Product (prodNames[3], prodPrices[3], R.drawable.acerka242ybi));
        products.add(new Product (prodNames[4], prodPrices[4], R.drawable.lg24mp));
        products.add(new Product (prodNames[5], prodPrices[5], R.drawable.lg24mk));
        products.add(new Product (prodNames[6], prodPrices[6], R.drawable.hpx24c));
    }

    public void onSearch(View view) {
        setInitialData();
        AutoCompleteTextView textView = findViewById(R.id.autocomplete);
        String text = textView.getText().toString();
        if (!text.equals("")) {
            boolean[] checker = new boolean[products.size()];
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getName().contains(text)) {
                    checker[i] = true;
                    System.out.println(i);
                }
            }
            int maxpos = products.size();
            int j = 0;
            for (int i = 0; i < maxpos; i++) {
                if (!checker[j]) {
                    productAdapter.remove(products.get(i));
                    maxpos--;
                    i--;
                }
                j++;
            }
        } else {
            setInitialData();
        }
        productAdapter.notifyDataSetChanged();
    }

    public void onSort(View view) {
        Collections.shuffle(products);
        productAdapter.notifyDataSetChanged();
    }
}