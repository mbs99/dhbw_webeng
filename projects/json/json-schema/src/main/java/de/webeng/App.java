package de.webeng;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class App {
    public static void main(String[] args) {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(App.class.getResourceAsStream("/company-schema.json")));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(App.class.getResourceAsStream("/company.json")));

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
    }
}
