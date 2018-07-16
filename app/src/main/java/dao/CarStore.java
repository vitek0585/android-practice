package dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import models.Car;

@Dao
public interface CarStore {

    @Query("SELECT * FROM Cars ORDER BY Id")
    List<Car> all();

    @Query("SELECT * FROM Cars WHERE Id = :id LIMIT 1")
    Car get(int id);

    @Insert
    List<Long> insert(Car ...cars);

    @Update
    void update(Car... trips);

    @Delete
    void delete(Car... trips);
}
