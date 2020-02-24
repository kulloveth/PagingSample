package kulloveth.developer.com.pagingsample.db;

import android.content.Context;

import androidx.paging.DataSource;

import kulloveth.developer.com.pagingsample.model.Result;

public class ResultDatasourceFactory extends DataSource.Factory<Integer, Result> {
    private Context ctx;
    private ResultDataSource resultDataSource;


    public ResultDatasourceFactory(Context ctx) {
        this.ctx = ctx;
    }

    public DataSource<Integer, Result> create() {

        if (resultDataSource == null){
            resultDataSource = new ResultDataSource(ctx);
        }
        return resultDataSource;
    }
}
