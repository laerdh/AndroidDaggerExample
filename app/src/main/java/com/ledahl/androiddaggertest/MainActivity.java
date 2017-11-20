package com.ledahl.androiddaggertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.ledahl.androiddaggertest.service.RestService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button buttonPostData;
    private EditText editTextInputData;

    @Inject
    RestService restService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        ((MyApplication) getApplication()).getAppComponent().inject(this);
    }

    private void setupViews() {
        editTextInputData = findViewById(R.id.editTextInputData);
        buttonPostData = findViewById(R.id.buttonPostData);

        buttonPostData.setOnClickListener(view -> {
            String text = editTextInputData.getText().toString();

            Call<Void> call = restService.postSomeData(text);
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    editTextInputData.setText(response.isSuccessful() ? "Success" : "Failure, code: " + response.code());
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    editTextInputData.setText("Failure");
                }
            });
        });
    }
}