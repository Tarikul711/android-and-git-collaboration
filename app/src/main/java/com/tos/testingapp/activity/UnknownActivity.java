package com.tos.testingapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.os.Bundle;

import com.tos.testingapp.R;
import com.tos.testingapp.adapter.UnknownListAdapter;
import com.tos.testingapp.webapi.APIService;
import com.tos.testingapp.webapi.RootUrl;
import com.tos.testingapp.webapi.WebInterface;
import com.tos.testingapp.webapi.unknown.UnknownData;

import org.jetbrains.annotations.NotNull;

public class UnknownActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    private WebInterface webInterface;
    Context context;
    UnknownListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unknown);
        context = this;
        webInterface = APIService.createService(WebInterface.class, RootUrl.BASE_URL);
        recyclerview = findViewById(R.id.recyclerview);

        webInterface.getAllUnknownData().enqueue(new Callback<UnknownData>() {
            @Override
            public void onResponse(@NotNull Call<UnknownData> call, @NotNull Response<UnknownData> response) {
                if (response.code() == 200) {
                    listAdapter = new UnknownListAdapter(context, response.body().getData());
                    recyclerview.setLayoutManager(new LinearLayoutManager(context));
                    recyclerview.setAdapter(listAdapter);
                }
            }

            @Override
            public void onFailure(@NotNull Call<UnknownData> call, @NotNull Throwable t) {

            }
        });
    }
}
