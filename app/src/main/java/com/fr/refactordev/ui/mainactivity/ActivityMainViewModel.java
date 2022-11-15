package com.fr.refactordev.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.fr.refactordev.R;
import com.fr.refactordev.data.remote.repositories.AddressRepo;
import com.fr.refactordev.model.api.Address;
import com.fr.refactordev.utils.network.NetworkUtils;
import com.fr.refactordev.utils.network.Resource;

import java.util.List;

public class ActivityMainViewModel extends AndroidViewModel {

    final MediatorLiveData<Resource<List<Address>>> addressListData = new MediatorLiveData<>();

    public AddressRepo addressRepo;

    private Application application;

    private String text = "I am from ViewModel";

    public LiveData<Resource<List<Address>>> getAddressData(){
        return addressListData;
    }

    public ActivityMainViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        System.out.println(addressRepo);
        sendAddressListRequest("Dhaka",null);


    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }





    public void sendAddressListRequest(String address, String language) {
        if (NetworkUtils.isNetworkConnected(application.getApplicationContext())) {
            addressListData.setValue(Resource.error(application.getResources().getString(R.string.check_internet), null));
            return;
        }

        addressRepo.sendAddressListRequest(addressListData,address,language);
    }
}
