package com.onaar.databasesvol2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Baza.class},version= 1)
public abstract class KonflliktyDataBase extends RoomDatabase {
    public abstract BazaDao zwrocKonfliktyDao();

    public static KonflliktyDataBase instancja;

    public static KonflliktyDataBase zwrocInstancjeBazyDanych(Context context){
        if(instancja == null){
            instancja = Room.databaseBuilder(
                    context, KonflliktyDataBase.class,
                    "konflikty_db"
            ).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instancja;
    }
}
