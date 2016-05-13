package com.epicodus.herosquare.services;

import com.epicodus.herosquare.Constants;
import com.epicodus.herosquare.models.Hero;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
//        Log.v("Full URL PATH", url);

        Request request = new Request.Builder()
                .url(url)
                .build();


        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }

    public ArrayList<Hero> processResults(Response response) {
        ArrayList<Hero> heroes = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject comicvineJSON = new JSONObject(jsonData);
                JSONArray resultsJSON = comicvineJSON.getJSONArray("results");
                for (int i = 0; i < resultsJSON.length(); i++) {
                    JSONObject heroJSON = resultsJSON.getJSONObject(i);
                    String name = heroJSON.optString("name", "N/A");
                    String aliases = heroJSON.optString("aliases", "N/A");
                    String realName = heroJSON.optString("real_name", "N/A");
                    String description = heroJSON.optString("deck", "N/A");

                    String rawBio = heroJSON.optString("description", "N/A");
                    String bio = html2text(rawBio);

                    String iconImageUrl = heroJSON.getJSONObject("image").optString("icon_url", "N/A");
                    String screenImageUrl = heroJSON.getJSONObject("image").optString("screen_url", "N/A");
                    String origin = heroJSON.getJSONObject("origin").optString("name", "N/A");
                    int popularity = heroJSON.getInt("count_of_issue_appearances");

                    Hero hero = new Hero(name, aliases, realName, description, bio, iconImageUrl,
                            screenImageUrl, origin, popularity);
                    heroes.add(hero);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return heroes;
    }
}
