package json;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private final Map<String, Json> jsonObject;

    public JsonObject(JsonPair... jsonPairs) {
        jsonObject = new HashMap<>();
        for (JsonPair jsonPair: jsonPairs) {
            jsonObject.put(jsonPair.key, jsonPair.value);
        }
    }

    @Override
    public String toJson() {
        Iterator<Map.Entry<String, Json>> itr = jsonObject.entrySet().iterator();

        String objStr = "{";

        while (itr.hasNext()){
            Map.Entry<String, Json> jsonPair = itr.next();
            objStr += "'" + jsonPair.getKey() + "': " + jsonPair.getValue().toJson();
            if (itr.hasNext()) {
                objStr += ", ";
            }
        }
        return objStr + "}";
    }

    public void add(JsonPair jsonPair) {
        jsonObject.put(jsonPair.key, jsonPair.value);
    }

    public boolean contains(String name) {
        return jsonObject.containsKey(name);
    }

    public Json find(String name) {
        if (contains(name)) {
            return jsonObject.get(name);
        } else {
            return null;
        }
    }

    public JsonObject projection(String... names) {
        JsonObject cJsonObject = new JsonObject();
        for(String name: names) {
            if (contains(name)) {
                cJsonObject.add(new JsonPair(name, jsonObject.get(name)));
            }
        }
        return cJsonObject;
    }
}
