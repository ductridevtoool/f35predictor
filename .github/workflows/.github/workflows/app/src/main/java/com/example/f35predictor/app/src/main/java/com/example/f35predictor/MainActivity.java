
package com.example.f35predictor;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/ketqua")
    Call<KetQuaResponse> getKetQua();
}
