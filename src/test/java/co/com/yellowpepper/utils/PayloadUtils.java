package co.com.yellowpepper.utils;


import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadUtils {

    public static String getPayload(String filename, String key) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/test/resources/payloads/" + filename)));
            JSONObject json = new JSONObject(content);
            return json.getJSONObject(key).toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read payload file", e);
        }
    }
}
