package com.dempsey.teamwork;

import android.content.Context;
import android.content.SharedPreferences;
import com.dempsey.teamwork.data.net.ApiClient;
import com.dempsey.teamwork.service.account.AccountRequest;
import com.dempsey.teamwork.service.project.ProjectRequest;
import com.dempsey.teamwork.service.tasks.TasksRequest;

import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public final class Teamwork {
    private static final String PREFERENCE_NAME = "com.dempsey.teamwork.SDK_STORE";
    private static final String SHA_256_PREFIX = "sha256/";
    private static final String SSL_FINGERPRINT = "QSiElEKKeAgIBOJuy6Lg4dDUNqWNGCb4sQTHFSKd0co=";
    private static final String SSL_API_HOST = "*.teamwork.com";

    private static ApiClient apiClient;
    private static Context applicationContext;

    private Teamwork() {
        throw new AssertionError("This constructor shouldn't be called!");
    }

    public static synchronized void initialize(final Context applicationContext) {
        Teamwork.applicationContext = applicationContext.getApplicationContext();
        final Cache cache = createCache(applicationContext.getCacheDir());
        final OkHttpClient okHttpClient = createOkHttpClient(cache);
        apiClient = new ApiClient.Builder()
                .okHttpClient(okHttpClient)
                .interceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    private static Cache createCache(final File cacheDir) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(cacheDir, cacheSize);
    }

    private static OkHttpClient createOkHttpClient(final Cache cache) {
        return new OkHttpClient.Builder()
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(15000, TimeUnit.MILLISECONDS)
                .cache(cache)
                .build();
    }

    private static CertificatePinner providePinner() {
        return new CertificatePinner
                .Builder()
                .add(SSL_API_HOST, SHA_256_PREFIX + SSL_FINGERPRINT).build();
    }

    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static SharedPreferences getSharedPreferences() {
        if (applicationContext == null) {
            return null;
        } else {
            return applicationContext.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        }
    }

    public static AccountRequest accountRequest() {
        final AccountRequest accountRequest = AccountRequest.getInstance();
        accountRequest.init(apiClient);
        return accountRequest;
    }

    public static ProjectRequest projectRequest() {
        final ProjectRequest projectRequest = ProjectRequest.getInstance();
        projectRequest.init(apiClient);
        return projectRequest;
    }

    public static TasksRequest tasksRequest() {
        final TasksRequest tasksRequest = TasksRequest.getInstance();
        tasksRequest.init(apiClient);
        return tasksRequest;
    }
}
