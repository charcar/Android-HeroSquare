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

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.COMICVINE_BASE_URL).newBuilder();
        urlBuilder.addPathSegment(COMICVINE_KEY);
//        urlBuilder.addPathSegment(Constants.COMICVINE_NAME_FILTER);
        urlBuilder.addQueryParameter(Constants.COMICVINE_CHARACTER_QUERY_PARAMETER, name);
//        urlBuilder.addPathSegment(Constants.COMICVINE_KEY);
//        urlBuilder.addPathSegment(Constants.COMICVINE_SEARCH_FILTER);

        String url = urlBuilder.build().toString() + Constants.COMICVINE_SEARCH_FILTER;
        Log.v("Full URL PATH", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
