package com.tos.testingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.os.Bundle;

import com.tos.testingapp.adapter.UserListAdapter;
import com.tos.testingapp.webapi.APIService;
import com.tos.testingapp.webapi.RootUrl;
import com.tos.testingapp.webapi.WebInterface;
import com.tos.testingapp.webapi.user.UserData;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    private WebInterface webInterface;
    Context context;
    UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        webInterface = APIService.createService(WebInterface.class, RootUrl.BASE_URL);
        recyclerview = findViewById(R.id.recyclerview);

        webInterface.getAllUserData().enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(@NotNull Call<UserData> call, @NotNull Response<UserData> response) {
                if (response.code() == 200) {
                    userListAdapter = new UserListAdapter(context, response.body().getData());
                    recyclerview.setLayoutManager(new LinearLayoutManager(context));
                    recyclerview.setAdapter(userListAdapter);
                }
            }

            @Override
            public void onFailure(@NotNull Call<UserData> call, @NotNull Throwable t) {

            }
        });
    }
}
