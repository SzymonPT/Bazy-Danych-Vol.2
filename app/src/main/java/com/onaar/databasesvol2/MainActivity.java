package com.onaar.databasesvol2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        KonflliktyDataBase konflliktyDataBase;

        Button button, button2;
        EditText name, start_date, end_date, countries,;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        konflliktyDataBase = KonflliktyDataBase.zwrocInstancjeBazyDanych(MainActivity.this);
        konflliktyDataBase.zwrocKonfliktyDao().wstawKonfliktDoBazy(new Baza("I Wojna Czeczeńska",1994,1996, "Rosja i Republika Czeczeńska", "Zwycięstwo Czeczeni",  "Zabici: 80 000 - 160 000, Ranni: 120 000+, Zaginieni: 5000"));
    }
}