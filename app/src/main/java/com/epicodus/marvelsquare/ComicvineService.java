package com.epicodus.marvelsquare;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ComicvineService {

    public static void findCharacters(String name, Callback callback) {
        String COMICVINE_KEY = Constants.COMICVINE_KEY;
        String COMICVINE_SEARCH_FILTER = Constants.COMICVINE_SEARCH_FILTER;

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.COMICVINE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("api_key", COMICVINE_KEY);
        urlBuilder.fragment(Constants.COMICVINE_SEARCH_FILTER);
        urlBuilder.addQueryParameter(Constants.COMICVINE_CHARACTER_QUERY_PARAMETER, name);

        String url = urlBuilder.build().toString();
        Log.v("Full URL PATH", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
