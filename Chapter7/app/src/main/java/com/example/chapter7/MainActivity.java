package com.example.chapter7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

//public class MainActivity extends AppCompatActivity {

    /* Пример 1 - вывод списка с помощью массива
    * строк, как переменной в классе Activity */
    // набор данных, которые свяжем со списком
//    String[] food = { "Колбаса", "Сыр", "Молоко", "Яйца", "Креветки"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // получаем элемент ListView
//        ListView countriesList = findViewById(R.id.eateriesList);
//
//        // создаем адаптер
//        ArrayAdapter<String> adapter = new ArrayAdapter(this,
//                android.R.layout.simple_list_item_1, food);
//
//        // устанавливаем для списка адаптер
//        countriesList.setAdapter(adapter);
//    }

    /* Пример 2 - вывод списка с помощью массива строк
    * из файла resources */
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // получаем элемент ListView
//        ListView countriesList = findViewById(R.id.eateriesList);
//
//        // получаем ресурс
//        String[] eateries = getResources().getStringArray(R.array.eateries);
//
//        // создаем адаптер
//        ArrayAdapter<String> adapter = new ArrayAdapter(this,
//                android.R.layout.simple_list_item_1, eateries);
//
//        // устанавливаем для списка адаптер
//        countriesList.setAdapter(adapter);
//    }

    // Пример 2.1
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    // Пример 3 - обработка нажатия на элемент списка с помощью слушателя
//    String[] countries = { "Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // получаем элемент TextView
//        TextView selection = findViewById(R.id.selection);
//        // получаем элемент ListView
//        ListView countriesList = findViewById(R.id.countriesList);
//        // создаем адаптер
//        ArrayAdapter<String> adapter = new ArrayAdapter(this,
//                android.R.layout.simple_list_item_1, countries);
//        // устанавливаем для списка адаптер
//        countriesList.setAdapter(adapter);
//        // добавляем для списка слушатель
//        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
//            {
//                // 1 получаем выбранный элемент по позиции
//                String selectedItem = countries[position];
//
//                // 2 получаем выбранный элемент через адаптервью
//                String selectedItem1 = (String)parent.getItemAtPosition(position);
//
//                // 3 получаем выбранный элемент, если мы знаем
//                // что элемент листа находится внутри TextView
//                TextView textView = (TextView) v;
//                String selectedItem2 = (String)textView.getText();
//
//                // установка текста элемента TextView
//                selection.setText(selectedItem);
//            }
//        });
//    }

    // Пример 4 - множественный выбор в списке
//    String[] countries = { "Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // получаем элемент TextView
//        TextView selection = findViewById(R.id.selection);
//        // получаем элемент ListView
//        ListView countriesList = findViewById(R.id.countriesList);
//        // создаем адаптер
//        ArrayAdapter<String> adapter = new ArrayAdapter(this,
//                android.R.layout.simple_list_item_multiple_choice, countries);
//        // устанавливаем для списка адаптер
//        countriesList.setAdapter(adapter);
//        // добавляем для списка слушатель
//        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
//            {
//                SparseBooleanArray selected = countriesList.getCheckedItemPositions();
//
//                String selectedItems = "";
//                for (int i=0; i < countries.length; i++) {
//                    if(selected.get(i))
//                        selectedItems+=countries[i]+",";
//                }
//                // установка текста элемента TextView
//                selection.setText("Выбрано: " + selectedItems);
//            }
//        });
//    }

    // Пример 5 - добавление и удаление
//    ArrayList<String> users = new ArrayList<String>();
//    ArrayList<String> selectedUsers = new ArrayList<String>();
//    ArrayAdapter<String> adapter;
//    ListView usersList;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // добавляем начальные элементы
//        Collections.addAll(users, "Tom", "Bob", "Sam", "Alice");
//        // получаем элемент ListView
//        usersList = findViewById(R.id.usersList);
//        // создаем адаптер
//        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, users);
//        // устанавливаем для списка адаптер
//        usersList.setAdapter(adapter);
//
//        // обработка установки и снятия отметки в списке
//        usersList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
//            {
//                // получаем нажатый элемент
//                String user = adapter.getItem(position);
//                if(usersList.isItemChecked(position))
//                    selectedUsers.add(user);
//                else
//                    selectedUsers.remove(user);
//            }
//        });
//    }
//
//    public void add(View view) {
//
//        EditText userName = findViewById(R.id.userName);
//        String user = userName.getText().toString();
//        if(!user.isEmpty()){
//            adapter.add(user);
//            userName.setText("");
//            adapter.notifyDataSetChanged();
//        }
//    }
//
//    public void remove(View view) {
//        // получаем и удаляем выделенные элементы
//        for (int i=0; i < selectedUsers.size(); i++) {
//            adapter.remove(selectedUsers.get(i));
//        }
//        // снимаем все ранее установленные отметки
//        usersList.clearChoices();
//        // очищаем массив выбраных объектов
//        selectedUsers.clear();
//
//        adapter.notifyDataSetChanged();
//    }

    // Пример 6,7 - расширенные списки
//    ArrayList<State> states = new ArrayList<State>();
//    ListView countriesList;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        // начальная инициализация списка
//        setInitialData();
//        // получаем элемент ListView
//        countriesList = findViewById(R.id.countriesList);
//        // создаем адаптер
//        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, states);
//        // устанавливаем адаптер
//        countriesList.setAdapter(stateAdapter);
//        // слушатель выбора в списке
//        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//
//                // получаем выбранный пункт
//                State selectedState = (State)parent.getItemAtPosition(position);
//                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
//                        Toast.LENGTH_SHORT).show();
//            }
//        };
//        countriesList.setOnItemClickListener(itemListener);
//    }
//    private void setInitialData() {
//        states.add(new State ("Бразилия", "Бразилиа", R.drawable.br));
//        states.add(new State ("Аргентина", "Буэнос-Айрес", R.drawable.ar));
//        states.add(new State ("Колумбия", "Богота", R.drawable.co));
//        states.add(new State ("Уругвай", "Монтевидео", R.drawable.uy));
//        states.add(new State ("Чили", "Сантьяго", R.drawable.cl));
//        states.add(new State ("Бразилия", "Бразилиа", R.drawable.br));
//        states.add(new State ("Аргентина", "Буэнос-Айрес", R.drawable.ar));
//        states.add(new State ("Колумбия", "Богота", R.drawable.co));
//        states.add(new State ("Уругвай", "Монтевидео", R.drawable.uy));
//        states.add(new State ("Чили", "Сантьяго", R.drawable.cl));
//        states.add(new State ("Бразилия", "Бразилиа", R.drawable.br));
//        states.add(new State ("Аргентина", "Буэнос-Айрес", R.drawable.ar));
//        states.add(new State ("Колумбия", "Богота", R.drawable.co));
//        states.add(new State ("Уругвай", "Монтевидео", R.drawable.uy));
//        states.add(new State ("Чили", "Сантьяго", R.drawable.cl));
//        states.add(new State ("Бразилия", "Бразилиа", R.drawable.br));
//        states.add(new State ("Аргентина", "Буэнос-Айрес", R.drawable.ar));
//        states.add(new State ("Колумбия", "Богота", R.drawable.co));
//        states.add(new State ("Уругвай", "Монтевидео", R.drawable.uy));
//        states.add(new State ("Чили", "Сантьяго", R.drawable.cl));
//        states.add(new State ("Бразилия", "Бразилиа", R.drawable.br));
//        states.add(new State ("Аргентина", "Буэнос-Айрес", R.drawable.ar));
//        states.add(new State ("Колумбия", "Богота", R.drawable.co));
//        states.add(new State ("Уругвай", "Монтевидео", R.drawable.uy));
//        states.add(new State ("Чили", "Сантьяго", R.drawable.cl));
//    }

    // Пример 8 - расширенный список с кнопками
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ArrayList<Product> products = new ArrayList<Product>();
//        if(products.size()==0){
//            products.add(new Product("Картофель", "кг."));
//            products.add(new Product("Чай", "шт."));
//            products.add(new Product("Яйца", "шт."));
//            products.add(new Product("Молоко", "л."));
//            products.add(new Product("Макароны", "кг."));
//        }
//        ListView productList = findViewById(R.id.productList);
//        ProductAdapter adapter = new ProductAdapter(this, R.layout.list_item1, products);
//        productList.setAdapter(adapter);
//    }

    // Пример 9 - ListActivity
//public class MainActivity extends ListActivity {
//    String[] countries = { "Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // создаем адаптер
//        ArrayAdapter<String> adapter = new ArrayAdapter(this,
//                android.R.layout.simple_list_item_1, countries);
//        setListAdapter(adapter);
//
//        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//
//                Toast.makeText(getApplicationContext(), "Был выбран пункт " +
//                        parent.getItemAtPosition(position).toString(),  Toast.LENGTH_SHORT).show();
//            }
//        };
//        getListView().setOnItemClickListener(itemListener);
//    }
//}

// Пример 10 - Spinner
public class MainActivity extends AppCompatActivity {

//    String[] countries = { "Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Spinner spinner = findViewById(R.id.spinner);
//        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
//        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
//        // Определяем разметку для использования при выборе элемента
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Применяем адаптер к элементу spinner
//        spinner.setAdapter(adapter);
//    }

    // Пример 10.1 - Spinner обработка выбора
//    String[] countries = { "Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        TextView selection = findViewById(R.id.selection);
//
//        Spinner spinner = findViewById(R.id.spinner);
//        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
//        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
//        // Определяем разметку для использования при выборе элемента
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Применяем адаптер к элементу spinner
//        spinner.setAdapter(adapter);
//
//        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                // Получаем выбранный объект
//                String item = (String)parent.getItemAtPosition(position);
//                selection.setText(item);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        };
//        spinner.setOnItemSelectedListener(itemSelectedListener);
//    }

    // Пример 11 - виджет автодополнения
//    String[] cities = {"Moscow", "Samara", "Vologda", "Volgograd", "Saratov", "Voronezh"};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Получаем ссылку на элемент AutoCompleteTextView в разметке
//        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autocomplete);
//        // Создаем адаптер для автозаполнения элемента AutoCompleteTextView
//        ArrayAdapter<String> adapter = new ArrayAdapter (this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cities);
//        autoCompleteTextView.setAdapter(adapter);
//    }

    // Пример 12 - GridView
//    String[] countries = { "Бразилия", "Аргентина", "Чили", "Колумбия", "Уругвай"};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // получаем элемент GridView
//        GridView countriesList = findViewById(R.id.gridview);
//        // создаем адаптер
//        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, countries);
//        countriesList.setAdapter(adapter);
//
//        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),"Вы выбрали "
//                                + parent.getItemAtPosition(position).toString(),
//                        Toast.LENGTH_SHORT).show();
//            }
//        };
//        countriesList.setOnItemClickListener(itemListener);
//    }

    // Пример 13 - RecyclerView
    ArrayList<State> states = new ArrayList<State>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        // создаем адаптер
        StateAdapter adapter = new StateAdapter(this, states);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){

        states.add(new State ("Бразилия", "Бразилиа", R.drawable.br));
        states.add(new State ("Аргентина", "Буэнос-Айрес", R.drawable.ar));
        states.add(new State ("Колумбия", "Богота", R.drawable.co));
        states.add(new State ("Уругвай", "Монтевидео", R.drawable.uy));
        states.add(new State ("Чили", "Сантьяго", R.drawable.cl));
    }

}