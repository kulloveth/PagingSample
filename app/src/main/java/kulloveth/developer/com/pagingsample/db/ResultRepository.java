package kulloveth.developer.com.pagingsample.db;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import kulloveth.developer.com.pagingsample.model.Result;

public class ResultRepository {
   private ResultDao resultDao;
   // private DataSource.Factory<Integer, Result> allResult;
    private Executor executor;
    private LiveData<PagedList<Result>> resultList;

    public ResultRepository(Application application) {
        executor = Executors.newFixedThreadPool(4);
        ResultDatabase database = ResultDatabase.getDatabase(application);
        resultDao = database.resultDao();
        ResultDatasourceFactory resultDatasourceFactory = new ResultDatasourceFactory(application);
        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setPageSize(10)
                        .setPrefetchDistance(10)
                        .setEnablePlaceholders(true)
                        .build();
       // allResult = resultDao.getAllResult();
        resultList = new LivePagedListBuilder<>(resultDatasourceFactory, pagedListConfig)
                .setFetchExecutor(executor)
                .build();

    }

    public void insertResult(Result result) {
        executor.execute(() -> resultDao.insert(result));
    }

    public void deleteResult(Result result) {
        executor.execute(() -> resultDao.delete(result));
    }

    public LiveData<PagedList<Result>> getAllResult() {
        return resultList;
    }
}
