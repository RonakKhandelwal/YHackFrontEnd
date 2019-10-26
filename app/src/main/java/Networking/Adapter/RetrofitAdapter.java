package Networking.Adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;

public class RetrofitAdapter {
    private static final String BASE_URL = "STUB";
    private static Retrofit retrofit;
    private static Gson gson;

    public static synchronized Retrofit getInstance() {
        if (retrofit == null) {
            if (gson == null) {
                gson = new GsonBuilder().setLenient().create();
            }

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

        }

        return retrofit;
    }
}