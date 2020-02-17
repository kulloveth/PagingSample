package kulloveth.developer.com.pagingsample.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import kulloveth.developer.com.pagingsample.db.ResultRepository;
import kulloveth.developer.com.pagingsample.model.Result;

public class MainActivityViewModel extends AndroidViewModel {
    private ResultRepository resultRepository;
    private LiveData<List<Result>> allResult;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        resultRepository = new ResultRepository(application);
        allResult = resultRepository.getAllResult();
    }

    public void insertResult(Result result){
        resultRepository.insertResult(result);
    }

    public void deleteResult(Result result){
        resultRepository.deleteResult(result);
    }

    public LiveData<List<Result>> getAllResult(){
      return allResult;
    }
}
