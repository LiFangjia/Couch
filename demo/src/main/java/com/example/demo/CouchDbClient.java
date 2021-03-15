package com.example.demo;

import org.apache.http.config.Registry;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.lightcouch.CouchDbClientBase;
import org.lightcouch.CouchDbConfig;
import sun.net.www.http.HttpClient;

import static java.rmi.registry.LocateRegistry.createRegistry;

public class CouchDbClient extends CouchDbClientBase {

    public CouchDbClient() {

    }

    public CouchDbClient(CouchDbPerso couchDbPerso) {
        super(new CouchDbConfig(couchDbPerso));
    }

    HttpClient createHttpClient(CouchDbPerso props) {
        try {
            HttpClientBuilder clientBuilder = HttpClients.custom();

            if(props.getUsername() != null) {

            }
        }

    }
}
