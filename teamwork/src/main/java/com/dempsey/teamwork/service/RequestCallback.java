package com.dempsey.teamwork.service;

public interface RequestCallback<T> {

    void onGetContent(T content);
    void onError(Exception e);

}
