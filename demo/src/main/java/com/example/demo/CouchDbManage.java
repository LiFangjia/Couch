package com.example.demo;

import com.google.gson.JsonParser;
import org.apache.commons.codec.Charsets;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.lightcouch.NoDocumentException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;

import static com.example.demo.CouchDbUtil.assertNotEmpty;

public class CouchDbManage {

    private CouchDbDemo dbc;

    CouchDbManage(CouchDbDemo dbc, CouchDbPerso props) {
        this.dbc = dbc;
        if(props.isIfExist()) {
            createDB(props.getDbName());
        } else {
            System.out.println("not found");
        }
    }

    public void deleteDB(String dbName, String confirm) {
        assertNotEmpty(dbName, "dbName");
        if(!"delete database".equals(confirm))
            throw new IllegalArgumentException("Invalid confirm!");
        dbc.delete(buildUri(dbc.getBaseUri()).path(dbName).build());
    }

    /**
     * Requests CouchDB creates a new database; if one doesn't exist.
     * @param dbName The Database name
     */
    public void createDB(String dbName) {
        assertNotEmpty(dbName, "dbName");
        InputStream getresp = null;
        HttpResponse putresp = null;
        final URI uri = buildUri(dbc.getBaseUri()).path(dbName).build();
        try {
            getresp = dbc.get(uri);
        } catch (NoDocumentException e) { // db doesn't exist
            final HttpPut put = new HttpPut(uri);
            putresp = dbc.executeRequest(put);
        }
    }

}
