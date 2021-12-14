package com.example.tp6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RecyclerView rv;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rv=(RecyclerView)findViewById(R.id.ReciclerViewGit);

        Intent intent=getIntent();
        String repo =intent.getStringExtra("GitRepo");

        Githubservice githubservice = new Retrofit.Builder()
                .baseUrl(Githubservice.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Githubservice.class);

        githubservice.listrepos(repo)
                .enqueue(new Callback<List<Githubservice.Repo>>() {

                    @Override
                    public void onResponse(Call<List<Githubservice.Repo>> call, Response<List<Githubservice.Repo>> response) {
                        showRepo(response.body());

                    }

                    @Override
                    public void onFailure(Call<List<Githubservice.Repo>> call, Throwable t) {

                    }

                    @SuppressLint("SetTextI18n")
                    public void showRepo(List<Githubservice.Repo> repos) {
                        RecyclerView.Adapter adapter = (RecyclerView.Adapter) repos;
                        rv.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        TextView tv =(TextView)findViewById(R.id.textView1);
                        tv.setText("You have this number of reposes :"+repos.size() );
                        Log.d(String.valueOf(repos.size()), "showRepo: ");
                    }

                });
    }
}