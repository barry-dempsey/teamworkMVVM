package com.dempsey.teamwork.service.account;

import com.dempsey.teamwork.data.model.Account;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class AccountDeserializer implements JsonDeserializer<Account> {
    @Override
    public Account deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonElement content = je.getAsJsonObject().get("account");
        return new Gson().fromJson(content, Account.class);
    }
}