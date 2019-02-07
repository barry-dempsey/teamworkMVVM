package com.dempsey.teamwork.service.project;

import com.dempsey.teamwork.data.model.Project;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class ProjectDeserializer implements JsonDeserializer<Project> {
    @Override
    public Project deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonElement content = je.getAsJsonObject().get("project");
        return new Gson().fromJson(content, Project.class);
    }
}
