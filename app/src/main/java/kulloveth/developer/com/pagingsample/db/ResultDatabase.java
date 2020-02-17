package kulloveth.developer.com.pagingsample.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import kulloveth.developer.com.pagingsample.model.Result;

@Database(entities = {Result.class}, version = 1, exportSchema = false)
public abstract class ResultDatabase extends RoomDatabase {

    private static ResultDatabase INSTANCE;

    public abstract ResultDao resultDao();

    public static synchronized ResultDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, ResultDatabase.class, "result-db")
                    .build();
        }
        return INSTANCE;
    }
}
