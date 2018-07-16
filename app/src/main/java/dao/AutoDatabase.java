package dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import models.Car;
import models.Converters;

@Database(entities = {Car.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AutoDatabase extends RoomDatabase {

    public abstract CarStore carStore();

    private static final String DB_NAME = "autodatabase.db";
    private static volatile AutoDatabase INSTANCE = null;

    public synchronized static AutoDatabase get(Context ctxt) {
        if (INSTANCE == null) {
            INSTANCE = create(ctxt, false);
        }
        return (INSTANCE);
    }

    public static AutoDatabase create(Context ctxt, boolean memoryOnly) {
        RoomDatabase.Builder<AutoDatabase> b;
        if (memoryOnly) {
            b = Room.inMemoryDatabaseBuilder(ctxt.getApplicationContext(),
                    AutoDatabase.class).allowMainThreadQueries();
        } else {
            b = Room.databaseBuilder(ctxt.getApplicationContext(), AutoDatabase.class, DB_NAME).allowMainThreadQueries();
        }
        return (b.build());
    }
}
