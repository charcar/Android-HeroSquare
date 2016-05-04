package com.epicodus.marvelsquare;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ComicvineService {

    public static void findCharacters(String name, Callback callback) {

        String COMICVINE_KEY = Constants.COMICVINE_KEY;
        String COMICVINE_SEARCH_LIMIT = Constants.COMICVINE_SEARCH_LIMIT;
        String COMICVINE_NAME_SIGNIFIER = Constants.COMICVINE_NAME_SIGNIFIER;
        String COMICVINE_FORMAT = Constants.COMICVINE_FORMAT;



        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.COMICVINE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("api_key", COMICVINE_KEY);
        urlBuilder.addQueryParameter(COMICVINE_SEARCH_LIMIT, "15");
        urlBuilder.addQueryParameter(COMICVINE_FORMAT, Constants.COMICVINE_JSON);
        urlBuilder.addQueryParameter(Constants.COMICVINE_CHARACTER_QUERY_PARAMETER, COMICVINE_NAME_SIGNIFIER + name);

        String url = urlBuilder.build().toString();
        Log.v("Full URL PATH", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
