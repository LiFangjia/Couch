package com.example.demo;

public class CouchDbPerso {

    private String dbName;
    private boolean ifExist;
    private String protocol;
    private String host;
    private String path;
    private int port;
    private String username;
    private String password;

    public CouchDbPerso() {

    }

    public CouchDbPerso(String dbName, boolean ifExist, String protocol, String host, String path, int port, String username, String password) {
        this.dbName = dbName;
        this.ifExist = ifExist;
        this.protocol = protocol;
        this.host = host;
        this.path = path;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public boolean isIfExist() {
        return ifExist;
    }

    public void setIfExist(boolean ifExist) {
        this.ifExist = ifExist;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
