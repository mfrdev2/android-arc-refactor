package com.fr.refactordev.data.remote.network;

import com.fr.refactordev.model.api.Address;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AddressApiService {
    @GET("/search")
    Flowable<Response<List<Address>>> getAddressesList(@Query("q") String address,
                                                       @Query("addressdetails") Integer addressDetails,
                                                       @Query("format") String format,
                                                       @Query("countrycodes") String[] countryCode,
                                                       @Query("accept-language") String[] acceptLanguage);
}
