package dao;

import android.content.Context;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import models.Car;
import victor.practice.BuildConfig;

import static org.hamcrest.MatcherAssert.assertThat;

@Config(sdk = 23, constants = BuildConfig.class)
@RunWith(RobolectricTestRunner.class)
public class AutoDatabaseTest {

    AutoDatabase db;
    CarStore store;
    @Before
    public void setUp() {
        Context applicationContext = RuntimeEnvironment.application.getApplicationContext();
        db=AutoDatabase.create(applicationContext, true);
        store=db.carStore();
    }
    @After
    public void tearDown() {
        db.close();
    }
    @Test
    public void create() {
        List<Long> cars = store.insert(new Car("Bmw", new Date(Calendar.getInstance().getTimeInMillis())));
       assertThat(cars, Matchers.hasSize(1));
       assertThat(cars.get(0), Matchers.equalTo(1l));
        Car createdCar = store.get(1);
        assertThat(createdCar.model,Matchers.is("Bmw"));
    }
}