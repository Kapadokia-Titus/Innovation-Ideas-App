package kapadokia.nyandoro.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import kapadokia.nyandoro.taskmanager.services.MessageService;
import kapadokia.nyandoro.taskmanager.services.ServiceBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        // this will act as implementation of our interface that maps our restful endpoints
        MessageService taskService = ServiceBuilder.buildService(MessageService.class);
        Call<String> call = taskService.getMessage();

        // we are then calling enqueue which behind the scenes will add it to an asynchronous
        // request queue that retrofit handles for us
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                ((TextView)findViewById(R.id.message)).setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                ((TextView)findViewById(R.id.message)).setText(R.string.request_failed);
            }
        });
      }

    public void GetStarted(View view){
        Intent intent = new Intent(this, IdeaListActivity.class);
        startActivity(intent);
    }
}
