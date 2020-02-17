package kulloveth.developer.com.pagingsample.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import kulloveth.developer.com.pagingsample.model.Result;

@Dao
public interface ResultDao {

    @Insert
    void insert(Result result);

    @Delete
    void delete(Result result);

    @Query("Select * from rickandmorty_table ORDER BY name ASC")
    LiveData<List<Result>> getAllResult();


}
