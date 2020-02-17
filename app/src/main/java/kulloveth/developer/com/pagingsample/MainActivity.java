package kulloveth.developer.com.pagingsample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kulloveth.developer.com.pagingsample.model.Result;
import kulloveth.developer.com.pagingsample.ui.MainActivityViewModel;
import kulloveth.developer.com.pagingsample.ui.ResultAdapter;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mainActivityViewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ResultAdapter adapter = new ResultAdapter();
        recyclerView = findViewById(R.id.result_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getAllResult().observe(this, results -> {
            for (Result result : results) {
                Log.d("fetch", "onChanged:" + result.toString());
            }
            adapter.submitList(results);
        });
    }
}
