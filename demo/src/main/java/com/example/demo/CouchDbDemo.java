package com.example.demo;

import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.lightcouch.CouchDbException;

import javax.script.ScriptEngine;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;

import static com.example.demo.CouchDbUtil.assertNotEmpty;
import static org.lightcouch.URIBuilder.buildUri;

public abstract class CouchDbDemo extends CouchDbManage {

    private URI baseURI;
    private URI dbURI;
    private Gson gson;
    private CouchDbManage manage;
    private CouchDbDesign design;
    final HttpClient httpClient;
    final HttpHost host;

    CouchDbDemo() {

    }

    CouchDbDemo(CouchDbConfig config) {
        final CouchDbPerso props = config.getCouchDbPerso();
        this.httpClient = createHttpClient(props);
        this.host = new HttpHost(props.getHost(),props.getPort(),props.getProtocol());
        this.design = new CouchDbDesign(this);


    }

    abstract HttpClient createHttpClient(CouchDbPerso props);

    public CouchDbDemo(CouchDbDesign design) {
        this.design = design;
    }

    public <T> T find(Class<T> classType, String id) {
        assertNotEmpty(classType, "Class");
        assertNotEmpty(id, "id");
        final URI uri = buildUri(getDBUri()).pathEncoded(id).build();
        return get(uri, classType);
    }

    public <T> T find(Class<T> classType, String id, String rev) {
        assertNotEmpty(classType, "Class");
        assertNotEmpty(id, "id");
        assertNotEmpty(id, "rev");
        final URI uri = buildUri(getDBUri()).pathEncoded(id).query("rev", rev).build();
        return get(uri, classType);
    }

    <T> T get(URI uri, Class<T> classType) {
        InputStream in = null;
        try {
            in = get(uri);
            return getGson().fromJson(new InputStreamReader(in, "UTF-8"), classType);
        } catch (UnsupportedEncodingException e) {
            throw new CouchDbException(e);
        } finally {
            close(in);
        }
    }


}
