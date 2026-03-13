package com.onaar.databasesvol2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        KonflliktyDataBase konflliktyDataBase;

        Button button, button2;
        EditText Nazwa,Rok_Rozp, Rok_Zak, Kraje_Biorące_Udział, winner, DWM;
        ListView listaView;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        konflliktyDataBase = KonflliktyDataBase.zwrocInstancjeBazyDanych(MainActivity.this);
        //konflliktyDataBase.zwrocKonfliktyDao().wstawKonfliktDoBazy(new Baza("I Wojna Czeczeńska",1994,1996, "Rosja i Republika Czeczeńska", "Zwycięstwo Czeczeni",  "Zabici: 80 000 - 160 000, Ranni: 120 000+, Zaginieni: 5000"));

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        Nazwa = findViewById(R.id.Nazwa);
        Rok_Rozp = findViewById(R.id.Rok_Rozp);
        Rok_Zak = findViewById(R.id.Rok_Zak);
        Kraje_Biorące_Udział = findViewById(R.id.Kraje_Biorące_Udział);
        winner = findViewById(R.id.winner);
        DWM = findViewById(R.id.DWM);
        ListView listView = findViewById(R.id.listaView);
        List<Baza> wszystkieKonfliktyLista = konflliktyDataBase
                .zwrocKonfliktyDao()
                .zwrocWszystkieKonfliktyZBazy();
        ArrayAdapter<Baza> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                wszystkieKonfliktyLista
        );
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        konflliktyDataBase.zwrocKonfliktyDao().usunZBazy(wszystkieKonfliktyLista.get(i));
                        wszystkieKonfliktyLista.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                    }
               }
        );
        listView.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        return false;
                    }
                }
        );
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String nazwa = Nazwa.getText().toString();
                        int rokR = Integer.parseInt(Rok_Rozp.getText().toString());
                        int rokZ = Integer.parseInt(Rok_Zak.getText().toString());
                        String kraje = Kraje_Biorące_Udział.getText().toString();
                        String wygrany = winner.getText().toString();
                        String dwm = DWM.getText().toString();

                        konflliktyDataBase
                                .zwrocKonfliktyDao()
                                .wstawKonfliktDoBazy(new Baza(nazwa, rokR, rokZ, kraje, wygrany, dwm));

                        wszystkieKonfliktyLista.clear();
                        wszystkieKonfliktyLista.addAll(
                                konflliktyDataBase
                                        .zwrocKonfliktyDao()
                                        .zwrocWszystkieKonfliktyZBazy()
                        );
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
        );
    }
}