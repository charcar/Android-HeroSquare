package com.epicodus.marvelsquare;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ComicvineService {

    public static void findCharacters(String character, Callback callback) {
        String COMICVINE_KEY = Constants.COMICVINE_KEY;

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.COMICVINE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.COMICVINE_CHARACTER_QUERY_PARAMETER, character);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
