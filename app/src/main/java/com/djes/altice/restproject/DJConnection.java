package com.djes.altice.restproject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class DJConnection {

    public static String Connect() throws IOException {
        URL url;
        HttpURLConnection urlConnection;
        url = new URL("https://stackoverflow.com/questions/8376072/whats-the-readstream-method-i-just-can-not-find-it-anywhere");
        urlConnection = (HttpURLConnection) url.openConnection();
        try {

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return readStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            urlConnection.disconnect();
        }
        return "Nothing";
    }

    public interface MyRemoteService
    {
        @GET("/example/practica.json")
        Call<List<Fruit>> getFruits();
    }

    private static String readStream(InputStream in)
    {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = in.read();
            while(i != -1) {
                bo.write(i);
                i = in.read();
            }
            return bo.toString();
        } catch (IOException e) {
            return "";
        }
    }

}
