package com.example.demo;

import java.util.Map;

public class Document {

    private String id;
    private String revision;

    public Document() {
    }

    public Document(String id, String revision) {
        this.id = id;
        this.revision = revision;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }
}
