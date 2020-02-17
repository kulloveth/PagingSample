package kulloveth.developer.com.pagingsample.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import kulloveth.developer.com.pagingsample.model.Result;

public class ResultRepository {
    private ResultDao resultDao;
    private LiveData<List<Result>> allResult;
    private Executor executor;

    public ResultRepository(Application application) {
        ResultDatabase database = ResultDatabase.getDatabase(application);
        resultDao = database.resultDao();
        allResult = resultDao.getAllResult();
        executor = Executors.newFixedThreadPool(4);
    }

    public void insertResult(Result result){
        executor.execute(() -> resultDao.insert(result));
    }

    public void deleteResult(Result result){
        executor.execute(() -> resultDao.delete(result));
    }

    public LiveData<List<Result>> getAllResult(){
        return allResult;
    }
}
