package models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.sql.Date;

@Entity(tableName = "cars")//,indices = {@Index("date")})
public class Car {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String model;

    //@ColumnInfo(index = true)
    public Date date;

    @Ignore
    public Car(@NonNull String model, Date date) {
        this.model = model;
        this.date = date;
    }

    public Car(int id, @NonNull String model, Date date) {
        this.id = id;
        this.model = model;
        this.date = date;
    }
}
