package kapadokia.nyandoro.taskmanager.services;

import retrofit2.Call;
import retrofit2.http.GET;

// simple interface that will implement the news texts in our landing page
public interface MessageService {

    @GET("/messages") // tells the retrofit that when we call this method we should match it to a get request of the base Url
    Call<String> getMessages();

}
