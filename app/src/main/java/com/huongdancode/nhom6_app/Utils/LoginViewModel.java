package com.huongdancode.nhom6_app.Utils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.huongdancode.nhom6_app.Model.User;


public class LoginViewModel extends ViewModel{
    private final MutableLiveData<User> selectedItem = new MutableLiveData<>();

    public MutableLiveData<User> getData() {
        return  selectedItem;
    }

    public void setData(User user) {
        selectedItem.setValue(user);
    }
    public User getSelectedItem() {
        return selectedItem.getValue();
    }
}
