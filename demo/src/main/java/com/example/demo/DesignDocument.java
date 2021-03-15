package com.example.demo;

import com.google.gson.JsonObject;

import java.util.Map;

public class DesignDocument extends Document {
    private String language;
    private Map<String, org.lightcouch.DesignDocument.MapReduce> views;
    private Map<String, String> filters;
    private Map<String, String> lists;
    private JsonObject text;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Map<String, org.lightcouch.DesignDocument.MapReduce> getViews() {
        return views;
    }

    public void setViews(Map<String, org.lightcouch.DesignDocument.MapReduce> views) {
        this.views = views;
    }

    public Map<String, String> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, String> filters) {
        this.filters = filters;
    }

    public Map<String, String> getLists() {
        return lists;
    }

    public void setLists(Map<String, String> lists) {
        this.lists = lists;
    }

    public JsonObject getText() {
        return text;
    }

    public void setText(JsonObject text) {
        this.text = text;
    }

    public int hashCode() {
        int result = super.hashCode();
        result =
    }

    public static class MapReduce {
        private String map;
        private String reduce;

        public String getMap() {
            return map;
        }

        public void setMap(String map) {
            this.map = map;
        }

        public String getReduce() {
            return reduce;
        }

        public void setReduce(String reduce) {
            this.reduce = reduce;
        }


    }
}
