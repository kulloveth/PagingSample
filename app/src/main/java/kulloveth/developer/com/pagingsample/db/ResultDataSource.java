package kulloveth.developer.com.pagingsample.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import java.util.List;

import kulloveth.developer.com.pagingsample.model.Result;

public class ResultDataSource extends PageKeyedDataSource<Integer, Result> {
    private ResultDao resultDao;

    public ResultDataSource(Context ctx) {
        resultDao = ResultDatabase.getDatabase(ctx).resultDao();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Result> callback) {
        List<Result> results = resultDao.getAllResult(0,params.requestedLoadSize);

        int noOfTryies = 0;
        while(results.size() == 0){
            results = resultDao.getAllResult(0, params.requestedLoadSize);
            noOfTryies++;
            if(noOfTryies == 6){
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {  }
        }

        callback.onResult(results,null,
                results.size()+1);

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Result> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Result> callback) {
        List<Result> results = resultDao.getAllResult( params.key, params.requestedLoadSize);
        int nextKey = params.key+results.size();
        callback.onResult(results, nextKey);
    }
}
