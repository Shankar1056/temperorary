package tablefixheaders.adapters;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class APIClient1 {

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

        //




        retrofit = new Retrofit.Builder()
                .baseUrl("https://maidiapp.icmr.org.in") //   https://reqres.in //  //http://maidiapp.icmr.org.in
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
       /* Response response = client.newCall(retrofit).execute();
        response.body().close();*/



        return retrofit;
    }

}
