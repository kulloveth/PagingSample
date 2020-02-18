package kulloveth.developer.com.pagingsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import kulloveth.developer.com.pagingsample.model.Result;
import kulloveth.developer.com.pagingsample.ui.MainActivityViewModel;

public class AddActivity extends AppCompatActivity {
    MainActivityViewModel viewModel;
    EditText name, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name = findViewById(R.id.name_et);
        gender = findViewById(R.id.gender_et);
        Button save = findViewById(R.id.save);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        save.setOnClickListener(v->{
            viewModel.insertResult(new Result(name.getText().toString(), gender.getText().toString()));
            finish();
        });


    }


}
