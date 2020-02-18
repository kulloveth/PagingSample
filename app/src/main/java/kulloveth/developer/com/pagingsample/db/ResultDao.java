package kulloveth.developer.com.pagingsample.db;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import kulloveth.developer.com.pagingsample.model.Result;

@Dao
public interface ResultDao {

    @Insert
    void insert(Result result);

    @Delete
    void delete(Result result);

    @Query("Select * from rickandmorty_table ORDER BY name ASC")
    DataSource.Factory<Integer,Result> getAllResult();


}
