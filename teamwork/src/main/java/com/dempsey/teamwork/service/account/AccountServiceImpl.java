package com.dempsey.teamwork.service.account;

import android.content.SharedPreferences;
import com.dempsey.teamwork.Teamwork;
import com.dempsey.teamwork.data.model.Account;
import com.dempsey.teamwork.data.net.ApiClient;
import com.dempsey.teamwork.service.RequestCallback;
import com.dempsey.teamwork.service.Util;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.Response;

import static com.dempsey.teamwork.data.net.ApiClient.HOST_PREFERENCE_KEY;

class AccountServiceImpl implements AccountService {

    static final String GET_ACCOUNT_DETAILS_URL_PATH = "/account.json";
    static final String AUTHENTICATE_URL_PATH = "/authenticate.json";

    private final ApiClient apiClient;
    private final Gson gson;

    AccountServiceImpl(final ApiClient apiClient, final Gson gson) {
        this.apiClient = apiClient;
        this.gson = gson;
    }

    @Override
    public void getAccountDetails(@Nullable final RequestCallback<Account> accountCallback) {
        apiClient.withPath(GET_ACCOUNT_DETAILS_URL_PATH).get(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (accountCallback != null) {
                    accountCallback.onError(e);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String content = response.body().string();
                final Account account = gson.fromJson(content, Account.class);
                if (accountCallback != null) {
                    accountCallback.onGetContent(account);
                }
            }
        });
    }

    @Override
    public Observable<Account> getAccountDetails() {
        return apiClient.withPath(GET_ACCOUNT_DETAILS_URL_PATH)
            .get()
            .map(Util::getContent)
            .map(content -> gson.fromJson(content, Account.class));
    }

    @Override
    public void authenticate(String userName, String password, @Nullable RequestCallback<Account> accountCallback) {
        final String credentials = Credentials.basic(userName, password);
        createAuthenticateCall(credentials, accountCallback);
    }

    @Override
    public Observable<Account> authenticate(String userName, String password) {
        final String credentials = Credentials.basic(userName, password);
        return createAuthenticateCall(credentials);
    }

    @Override
    public void authenticate(String apiKey, @Nullable RequestCallback<Account> accountCallback) {
        final String credentials = Credentials.basic(apiKey, "");
        createAuthenticateCall(credentials, accountCallback);
    }

    @Override
    public Observable<Account> authenticate(String apiKey) {
        final String credentials = Credentials.basic(apiKey, "");
        return createAuthenticateCall(credentials);
    }

    private void createAuthenticateCall(@NonNull final String credential,
                                        @Nullable final RequestCallback<Account> accountCallback) {
        apiClient.withPath(AUTHENTICATE_URL_PATH)
                .authorizationHeader(credential)
                .get(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (accountCallback != null) {
                    accountCallback.onError(e);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String content = response.body().string();
                final Account account = gson.fromJson(content, Account.class);
                saveAccountUrlHost(account);
                if (accountCallback != null) {
                    accountCallback.onGetContent(account);
                }
            }
        });
    }

    private Observable<Account> createAuthenticateCall(final String credential) {
        return apiClient.withPath(AUTHENTICATE_URL_PATH)
            .authorizationHeader(credential)
            .get()
            .map(Util::getContent)
            .map(content -> gson.fromJson(content, Account.class))
            .map(account -> {
                saveAccountUrlHost(account);
                return account;
            });
    }


    private void saveAccountUrlHost(final Account account) {
        final String url = account.getUrl();
        final HttpUrl httpUrl = HttpUrl.parse(url);
        final SharedPreferences sharedPreferences = Teamwork.getSharedPreferences();
        if (sharedPreferences != null) {
            sharedPreferences.edit()
                    .putString(HOST_PREFERENCE_KEY, httpUrl.host())
                    .apply();
        }
    }

}
