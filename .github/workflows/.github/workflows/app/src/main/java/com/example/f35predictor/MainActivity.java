
package com.example.f35predictor;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.result_text);

        ApiService apiService = RetrofitClient.getClient("https://api.example.com/").create(ApiService.class);
        apiService.getKetQua().enqueue(new Callback<KetQuaResponse>() {
            @Override
            public void onResponse(Call<KetQuaResponse> call, Response<KetQuaResponse> response) {
                if (response.isSuccessful()) {
                    resultText.setText(response.body().result);
                }
            }

            @Override
            public void onFailure(Call<KetQuaResponse> call, Throwable t) {
                resultText.setText("Lỗi: " + t.getMessage());
            }
        });
    }
}
