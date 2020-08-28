package de.webeng;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Parser {
    public void parse(InputStream jsonStream) {
        JSONArray root = new JSONArray(readStream(jsonStream));

        for (int i = 0; i < root.length(); i++) {
            JSONObject jsonObject = root.getJSONObject(i);
            System.out.println(jsonObject.getString("firstname"));
        }
    }

    private String readStream(InputStream inputStream) {
        return new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining(""));
    }
}