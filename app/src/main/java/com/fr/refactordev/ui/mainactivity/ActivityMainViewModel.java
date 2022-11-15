package com.fr.refactordev.ui.mainactivity;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.fr.refactor.utils.network.Resource;
import com.fr.refactordev.MyApp;
import com.fr.refactordev.R;
import com.fr.refactordev.base.BaseViewModel;
import com.fr.refactordev.data.remote.repositories.AddressRepo;
import com.fr.refactordev.model.api.Address;

import java.util.List;

import javax.inject.Inject;

public class ActivityMainViewModel extends BaseViewModel<com.fr.refactor.ui.mainactivity.Navigator> {

    final MediatorLiveData<Resource<List<Address>>> addressListData = new MediatorLiveData<>();
    @Inject
    public AddressRepo addressRepo;

    private Application application;

    private String text = "I am from ViewModel";

    public LiveData<Resource<List<Address>>> getAddressData(){
        return addressListData;
    }

    public ActivityMainViewModel(@NonNull Application application) {
        super(application);
        this.application = application;

        setText(getVersionName());
        (((MyApp)application)).appComponent.inject(this);

        System.out.println(addressRepo);
        sendAddressListRequest("Dhaka",null);


    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void onClick(View v){
        getNavigator().onGO(v);
    }



    public void sendAddressListRequest(String address, String language) {
        if (!isNetworkConnected()) {
            addressListData.setValue(Resource.error(application.getResources().getString(R.string.check_internet), null));
            return;
        }

        addressRepo.sendAddressListRequest(addressListData,address,language);
    }
}
