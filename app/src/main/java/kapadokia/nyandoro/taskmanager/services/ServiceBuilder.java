package kapadokia.nyandoro.taskmanager.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    // building the URL and automatically handle the data mapping
    private static final String URL = "http://localhost:8080/";  // replace with a working url

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    // helper method that enables us to build services
    public static <S> S buildService(Class<S> serviceType){
        return retrofit.create(serviceType);
    }
}
