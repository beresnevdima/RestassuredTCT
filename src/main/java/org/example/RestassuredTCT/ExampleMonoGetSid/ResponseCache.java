package org.example.RestassuredTCT.ExampleMonoGetSid;

import java.util.HashMap;
import java.util.Map;

public class ResponseCache {

    private static final ResponseCache myInstance = new ResponseCache();

    private final Map<String, String> cacheStore = new HashMap<String, String>();

    public ResponseCache() {
    }

    public static ResponseCache getInstance() {
        return myInstance;
    }

    public void addResponse(String key, String value) {
        cacheStore.put(key, value);
    }

    public boolean exists(String key) {
        return cacheStore.containsKey(key);
    }

    public void remove(String key) {
        if (exists(key)) {
            cacheStore.remove(key);
        }
    }

    public String get(String key) {
        return exists(key) ? cacheStore.get(key).toString() : null;
    }
}
