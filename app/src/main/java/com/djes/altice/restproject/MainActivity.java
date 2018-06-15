package com.djes.altice.restproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> listFruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetFruits();
    }

    public void GetFruits()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vinrosa.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DJConnection.MyRemoteService service = retrofit.create(DJConnection.MyRemoteService.class);
        service.getFruits().enqueue(new Callback<List<Fruit>>() {
            @Override
            public void onResponse(Call<List<Fruit>> call, Response<List<Fruit>> response) {
                listFruits = response.body();
                RecyclerView rv =(RecyclerView) findViewById(R.id.my_recycler_view);
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL,false));
                rv.setAdapter(new MyRecyclerAdapter(getApplicationContext(),listFruits));
            }

            @Override
            public void onFailure(Call<List<Fruit>> call, Throwable t) {

            }
        });
    }

//    class GetAsync extends AsyncTask<Void,Void,String>
//    {
//        @Override
//        protected String doInBackground(Void... voids)
//        {
//            HttpURLConnection connection =null;
//            try
//            {
//                try {
//                    String s = DJConnection.Connect();
//                    System.out.println(s);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }
}
