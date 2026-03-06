package com.onaar.databasesvol2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "current_wars_table")
public class Baza {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    @ColumnInfo(name = "Year_The_Conflict_Begun")
    private int start_date;
    @ColumnInfo(name = "Year_The_Conflict_Ended")
    private int end_date;
    @ColumnInfo(name = "Countries_Involwed")
    private String countries;
    private String winning_side;
    @ColumnInfo(name = "DWM_count")
    private String DWM;

    public Baza(String name, int start_date, int end_date, String countries, String winning_side, String DWM) {
        id = 0;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.countries = countries;
        this.winning_side = winning_side;
        this.DWM = DWM;
    }

    @Override
    public String toString() {
        return "Baza{" +
                "id=" + id +
                ", nazwa='" + name + '\n' +
                ", start_date='" + start_date + '\n'+
                ", end_date=" + end_date + '\n'+
                ", countries=" + countries + '\n'+
                ", winning_side=" + winning_side + '\n'+
                ", DWM=" + DWM +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart_date() {
        return start_date;
    }

    public void setStart_date(int start_date) {
        this.start_date = start_date;
    }

    public int getEnd_date() {
        return end_date;
    }

    public void setEnd_date(int end_date) {
        this.end_date = end_date;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getWinning_side() {
        return winning_side;
    }

    public void setWinning_side(String winning_side) {
        this.winning_side = winning_side;
    }

    public String getDWM() {
        return DWM;
    }

    public void setDWM(String DWM) {
        this.DWM = DWM;
    }
}
