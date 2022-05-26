package com.example.zachet;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "zachet.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE_PERSON = "person"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_ADDRESS = "address";

    static final String TABLE_JOB = "job"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID1 = "_id";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_PAYMENT = "payment";
    public static final String COLUMN_PERSON_ID = "person_id";

    public static boolean firstLoad = true;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_PERSON + " (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME
                + " TEXT, " + COLUMN_AGE + " INTEGER, " + COLUMN_ADDRESS + " TEXT);");
        db.execSQL("CREATE TABLE " + TABLE_JOB + " (" + COLUMN_ID1
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DESCRIPTION
                + " TEXT, " + COLUMN_PAYMENT + " REAL, "
                + COLUMN_PERSON_ID + " INTEGER,"
                + " FOREIGN KEY (" + COLUMN_PERSON_ID + ") REFERENCES " + TABLE_PERSON + "(" + COLUMN_ID + ") );");
        // добавление начальных данных
        if (firstLoad) {
            db.execSQL("INSERT INTO " + TABLE_PERSON +" (" + COLUMN_NAME
                    + ", " + COLUMN_AGE  + ", " + COLUMN_ADDRESS + ") VALUES ('Андрей', 28, 'ул. Железнодорожная д. 16, подъезд 1, квартира 1');");
            db.execSQL("INSERT INTO " + TABLE_PERSON +" (" + COLUMN_NAME
                    + ", " + COLUMN_AGE  + ", " + COLUMN_ADDRESS + ") VALUES ('Анастасия', 31, 'ул. Железнодорожная д. 16, подъезд 2, квартира 35');");
            db.execSQL("INSERT INTO " + TABLE_PERSON +" (" + COLUMN_NAME
                    + ", " + COLUMN_AGE  + ", " + COLUMN_ADDRESS + ") VALUES ('Геннадий', 41, 'ул. Железнодорожная д. 16, подъезд 3, квартира 67');");
            db.execSQL("INSERT INTO " + TABLE_PERSON +" (" + COLUMN_NAME
                    + ", " + COLUMN_AGE  + ", " + COLUMN_ADDRESS + ") VALUES ('Ольга', 29, 'ул. Железнодорожная д. 16, подъезд 4, квартира 89');");
            db.execSQL("INSERT INTO " + TABLE_PERSON +" (" + COLUMN_NAME
                    + ", " + COLUMN_AGE  + ", " + COLUMN_ADDRESS + ") VALUES ('Михаил', 36, 'ул. Железнодорожная д. 16, подъезд 5, квартира 102');");
            db.execSQL("INSERT INTO " + TABLE_PERSON +" (" + COLUMN_NAME
                    + ", " + COLUMN_AGE  + ", " + COLUMN_ADDRESS + ") VALUES ('Олег', 24, 'ул. Ягодная д. 16, подъезд 1, квартира 1');");
            db.execSQL("INSERT INTO " + TABLE_PERSON +" (" + COLUMN_NAME
                    + ", " + COLUMN_AGE  + ", " + COLUMN_ADDRESS + ") VALUES ('Сергей', 42, 'ул. Ягодная д. 16, подъезд 2, квартира 35');");
            db.execSQL("INSERT INTO " + TABLE_PERSON +" (" + COLUMN_NAME
                    + ", " + COLUMN_AGE  + ", " + COLUMN_ADDRESS + ") VALUES ('Вадим', 26, 'ул. Ягодная д. 16, подъезд 3, квартира 67');");
            db.execSQL("INSERT INTO " + TABLE_PERSON +" (" + COLUMN_NAME
                    + ", " + COLUMN_AGE  + ", " + COLUMN_ADDRESS + ") VALUES ('Наталья', 35, 'ул. Ягодная д. 16, подъезд 4, квартира 89');");
            db.execSQL("INSERT INTO " + TABLE_PERSON +" (" + COLUMN_NAME
                    + ", " + COLUMN_AGE  + ", " + COLUMN_ADDRESS + ") VALUES ('Галина', 46, 'ул. Ягодная д. 16, подъезд 5, квартира 102');");

            db.execSQL("INSERT INTO " + TABLE_JOB +" (" + COLUMN_DESCRIPTION
                    + ", " + COLUMN_PAYMENT  + ", " + COLUMN_PERSON_ID + ") VALUES ('Нужно почистить снег на парковочном месте', 500.0, 1);");
            db.execSQL("INSERT INTO " + TABLE_JOB +" (" + COLUMN_DESCRIPTION
                    + ", " + COLUMN_PAYMENT  + ", " + COLUMN_PERSON_ID + ") VALUES ('Ищу того кто может поухаживать за попугаем, пока я буду в отпуске', 1500.0, 2);");
            db.execSQL("INSERT INTO " + TABLE_JOB +" (" + COLUMN_DESCRIPTION
                    + ", " + COLUMN_PAYMENT  + ", " + COLUMN_PERSON_ID + ") VALUES ('Нужна помощь в починке машины', 700.0, 3);");
            db.execSQL("INSERT INTO " + TABLE_JOB +" (" + COLUMN_DESCRIPTION
                    + ", " + COLUMN_PAYMENT  + ", " + COLUMN_PERSON_ID + ") VALUES ('Помогите прикрутить полку', 600.0, 4);");
            db.execSQL("INSERT INTO " + TABLE_JOB +" (" + COLUMN_DESCRIPTION
                    + ", " + COLUMN_PAYMENT  + ", " + COLUMN_PERSON_ID + ") VALUES ('Нужно срочно принести суперклей в подъезд 5 кв 102', 500.0, 5);");
            db.execSQL("INSERT INTO " + TABLE_JOB +" (" + COLUMN_DESCRIPTION
                    + ", " + COLUMN_PAYMENT  + ", " + COLUMN_PERSON_ID + ") VALUES ('Нужно срочно принести ключ на 16 в подъезд 1 кв 1', 500.0, 6);");
            db.execSQL("INSERT INTO " + TABLE_JOB +" (" + COLUMN_DESCRIPTION
                    + ", " + COLUMN_PAYMENT  + ", " + COLUMN_PERSON_ID + ") VALUES ('Помогите прикрутить полку', 700.0, 7);");
            db.execSQL("INSERT INTO " + TABLE_JOB +" (" + COLUMN_DESCRIPTION
                    + ", " + COLUMN_PAYMENT  + ", " + COLUMN_PERSON_ID + ") VALUES ('Нужна помощь в починке машины', 1500.0, 8);");
            db.execSQL("INSERT INTO " + TABLE_JOB +" (" + COLUMN_DESCRIPTION
                    + ", " + COLUMN_PAYMENT  + ", " + COLUMN_PERSON_ID + ") VALUES ('Ищу того кто может поухаживать за попугаем, пока я буду в отпуске', 1200.0, 9);");
            db.execSQL("INSERT INTO " + TABLE_JOB +" (" + COLUMN_DESCRIPTION
                    + ", " + COLUMN_PAYMENT  + ", " + COLUMN_PERSON_ID + ") VALUES ('Нужно почистить снег на парковочном месте', 500.0, 10);");
        }
        firstLoad = false;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOB);
        onCreate(db);
    }
}
