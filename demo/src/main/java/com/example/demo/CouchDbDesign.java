package com.example.demo;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.CouchDbUtil.assertNotEmpty;
import static java.lang.String.format;
import static org.lightcouch.CouchDbUtil.listResources;
import static org.lightcouch.URIBuilder.buildUri;

public class CouchDbDesign {

    private CouchDbManage dbc;

    CouchDbDesign(CouchDbManage dbc){
        this.dbc = dbc;
    }

    public DesignDocument getFromDb(String id) {
        assertNotEmpty(id, "id");
        final URI uri = buildUri(dbc.getDBUri()).path(id).build();
        return dbc.get(uri, DesignDocument.class);
    }

    public DesignDocument getFromDb(String id, String rev) {
        assertNotEmpty(id, "id");
        assertNotEmpty(id, "rev");
        final URI uri = buildUri(dbc.getDBUri()).path(id).query("rev", rev).build();
        return dbc.get(uri, DesignDocument.class);
    }

    public DesignDocument getFromDesk(String id) {
        assertNotEmpty(id, "id");
        final DesignDocument dd = new DesignDocument();
        final String rootPath = format("%s/%s/", DESIGN_DOCS_DIR, id);
        final List<String> elements = listResources(rootPath);
        if (elements == null) {
            throw new IllegalArgumentException("Design docs directory cannot be empty.");
        }
        // Views
        Map<String, org.lightcouch.DesignDocument.MapReduce> views = null;
        if (elements.contains(VIEWS)) {
            views = new HashMap<String, org.lightcouch.DesignDocument.MapReduce>();
            final String viewsPath = format("%s%s/", rootPath, VIEWS);
            for (String viewDirName : listResources(viewsPath)) { // views sub-dirs
                final org.lightcouch.DesignDocument.MapReduce mr = new org.lightcouch.DesignDocument.MapReduce();
                final String viewPath = format("%s%s/", viewsPath, viewDirName);
                final List<String> dirList = listResources(viewPath);
                for (String fileName : dirList) { // view files
                    final String def = readFile(format("/%s%s", viewPath, fileName));
                    if (MAP_JS.equals(fileName))
                        mr.setMap(def);
                    else if (REDUCE_JS.equals(fileName))
                        mr.setReduce(def);
                }
                views.put(viewDirName, mr);
            }
        }
    }

}
