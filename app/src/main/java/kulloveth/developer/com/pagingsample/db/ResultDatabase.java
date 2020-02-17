package kulloveth.developer.com.pagingsample.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

import kulloveth.developer.com.pagingsample.model.Result;

@Database(entities = {Result.class}, version = 1, exportSchema = false)
public abstract class ResultDatabase extends RoomDatabase {

    private static ResultDatabase INSTANCE;

    public abstract ResultDao resultDao();

    public static synchronized ResultDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, ResultDatabase.class, "result-db")
                    .addCallback(roomCallback)
                    .build();
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            insertResult();
        }
    };

    private static void insertResult() {
        Executors.newSingleThreadExecutor().execute(() -> {
            Result result = new Result("Loveth", "Female");
            Result result2 = new Result("Blake", "Male");
            ResultDao resultDao = INSTANCE.resultDao();
            resultDao.insert(result);
            resultDao.insert(result2);
        });
    }
}
