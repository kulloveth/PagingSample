package kulloveth.developer.com.pagingsample.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import kulloveth.developer.com.pagingsample.R;
import kulloveth.developer.com.pagingsample.model.Result;

public class ResultAdapter extends PagedListAdapter<Result, ResultAdapter.ResultViewHolder> {

    public ResultAdapter() {
        super(Result.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list_item, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        Result result = getItem(position);
        if (result != null) {
            holder.bind(result);
        }
    }


    class ResultViewHolder extends RecyclerView.ViewHolder {

        TextView name, gender;

        ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_tv);
            gender = itemView.findViewById(R.id.gender_tv);
        }

        void bind(Result result) {
            name.setText(result.getName());
            gender.setText(result.getGender());
        }
    }


}
