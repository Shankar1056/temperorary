package mainscreen.govt.maidi.com.maidi;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anupamchugh on 05/01/17.
 */

class APIClient {

    private static Retrofit retrofit = null;

    static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).build();

        //

       /* OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new LoggingInterceptor())
                .build();

        Request request = new Request.Builder()
                .url("http://www.publicobject.com/helloworld.txt")
                .header("User-Agent", "OkHttp Example")
                .build();

        Response response = client.newCall(request).execute();
        response.body().close();*/

        //  http://192.168.1.3:3187    // Moderm Server

        // http://maidiapp.icmr.org.in  // Production Server




        retrofit = new Retrofit.Builder()
                .baseUrl("https://maidiapp.icmr.org.in") //   https://reqres.in //  //
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
       /* Response response = client.newCall(retrofit).execute();
        response.body().close();*/



        return retrofit;
    }

}
