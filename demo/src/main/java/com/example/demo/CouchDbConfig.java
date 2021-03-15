package com.example.demo;


import static com.example.demo.CouchDbUtil.assertNotEmpty;

public class CouchDbConfig {

    private CouchDbPerso couchDbPerso;

    public CouchDbConfig(CouchDbPerso couchDbPerso) {
        assertNotEmpty(couchDbPerso, "Properties");
        assertNotEmpty(couchDbPerso.getDbName(), "Database");
        assertNotEmpty(couchDbPerso.getProtocol(), "Protocol");
        assertNotEmpty(couchDbPerso.getHost(), "Host");
        assertNotEmpty(couchDbPerso.getPort(), "Port");
        this.couchDbPerso = couchDbPerso;
    }

    public CouchDbConfig() {

    }

    private void readInfo() {
        try {
            couchDbPerso = new CouchDbPerso();
            couchDbPerso.setDbName(couchDbPerso.getDbName());
            couchDbPerso.setIfExist(couchDbPerso.isIfExist());
            couchDbPerso.setProtocol(couchDbPerso.getProtocol());
            couchDbPerso.setHost(couchDbPerso.getHost());
            couchDbPerso.setPath(couchDbPerso.getPath());
            couchDbPerso.setPort(couchDbPerso.getPort());
            couchDbPerso.setUsername(couchDbPerso.getUsername());
            couchDbPerso.setPassword(couchDbPerso.getPassword());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public CouchDbPerso getCouchDbPerso() {
        return couchDbPerso;
    }
}
