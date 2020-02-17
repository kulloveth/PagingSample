package kulloveth.developer.com.pagingsample.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;

import kulloveth.developer.com.pagingsample.R;
import kulloveth.developer.com.pagingsample.model.Result;

@Database(entities = {Result.class}, version = 1, exportSchema = false)
public abstract class ResultDatabase extends RoomDatabase {

    private static Context activity;
    private static ResultDatabase INSTANCE;

    public abstract ResultDao resultDao();

    public static synchronized ResultDatabase getDatabase(Context context) {
        activity = context.getApplicationContext();
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(activity, ResultDatabase.class, "result-db")
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
            fillWithJsonData(activity);
        });
    }

    private static void fillWithJsonData(Context context){
        ResultDao resultDao = getDatabase(context).resultDao();
        JSONArray results = loadJsonArray(context);
        try{
            for(int i = 0; i<results.length(); i++){
                JSONObject result = results.getJSONObject(i);
                String resultName = result.getString("name");
                String resultGender = result.getString("gender");
                resultDao.insert(new Result(resultName,resultGender));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static JSONArray loadJsonArray(Context context) {
        StringBuilder builder = new StringBuilder();
        InputStream in = context.getResources().openRawResource(R.raw.ricky);

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;

        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            JSONObject jsonObject = new JSONObject(builder.toString());
            return jsonObject.getJSONArray("results");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
