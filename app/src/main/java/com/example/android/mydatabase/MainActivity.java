package com.example.android.mydatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 1 ) try catch blogu oluşturma
        try{

            // 2 ) Veritabanı oluşturma
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);

            // 3 ) Tablo oluşturma
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (name VARCHAR, age INT(2))");

            // 4 ) Tabloya Veri Ekleme
            sqLiteDatabase.execSQL("INSERT INTO musicians (name,age) VALUES ('James',50)");

            // 5 ) Cursor Oluşturma
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM musicians",null);

            // 6 ) Column Indexleri Almak
            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");

            // 7 ) cursor Veritabanı tablosunda başa alma
            cursor.moveToFirst();

            while(cursor != null){

                // 9 ) Değerleri Alma
                System.out.print("Name :" + cursor.getString(nameIndex));
                System.out.print("Age :" + cursor.getInt(ageIndex));

                // 8 ) cursor devam ettirme
                cursor.moveToNext();
            }


        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
