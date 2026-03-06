package com.onaar.databasesvol2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BazaDao {
    @Insert
    public void wstawKonfliktDoBazy(Baza baza);
    @Insert
    public void wstawKilkaKonfliktow(Baza baza);
    @Delete
    public void usunZBazy(Baza baza);
    @Update
    public void zaktualizuj(Baza baza);
    @Query("Select *  From `current_wars_table`")
    List<Baza> zwrocWszystkieKonfliktyZBazy();
}
