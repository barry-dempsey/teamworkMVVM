package com.dempsey.teamwork.service;

import com.dempsey.teamwork.data.net.ApiClient;
import com.google.gson.Gson;

public abstract class BaseRequest<T> {

    protected Gson gson;
    protected T service;

    public abstract void init(final ApiClient apiClient);
}
