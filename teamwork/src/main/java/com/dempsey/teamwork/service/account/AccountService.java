package com.dempsey.teamwork.service.account;

import com.dempsey.teamwork.data.model.Account;
import com.dempsey.teamwork.service.RequestCallback;

import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;

public interface AccountService {

    void getAccountDetails(@Nullable RequestCallback<Account> accountCallback);
    Observable<Account> getAccountDetails();
    void authenticate(String apiKey, @Nullable RequestCallback<Account> accountCallback);
    Observable<Account> authenticate(String apiKey);
    void authenticate(String userName, String password, @Nullable RequestCallback<Account> accountCallback);
    Observable<Account> authenticate(String userName, String password);
}
