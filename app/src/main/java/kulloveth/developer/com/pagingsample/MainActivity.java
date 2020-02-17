package kulloveth.developer.com.pagingsample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import kulloveth.developer.com.pagingsample.model.Result;
import kulloveth.developer.com.pagingsample.ui.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getAllResult().observe(this, results -> {
            for (Result result : results) {
                Log.d("fetch", "onChanged:" + result);
            }
        });
    }
}
