import java.io.*;
import java.util.*;

class Main {

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        // your code goes here
        HashMap<String, String> output = new HashMap<>();
        System.out.println("Workng on: " + dict);
        flatten(output, null, dict);
        return output;
    }

    public static void main(String[] args) {

    }

    /** Recursively add the elements of the given dict to the given output. */
    static void flatten(HashMap<String, String> output, String key, Map<String, Object> dict) {
        // Ensure that an empty dictionary makes no contribution to the output.
        if (dict == null)
            return;

        // Process the entries in the dictionary ensuring that empty keys use the given key,
        // otherwise concatenate the given key and the dictionary entry key for use as the key in
        // the output dictionary.
        for (String k : dict.keySet()) {
            Object item = dict.get(k);
            System.out.println(key + ":" + k + ":" + item.getClass().getSimpleName() + ":" + item);
            String outputKey = key == null || key.isEmpty() ? k : k.isEmpty() ? key : key + "." + k;
            if (item instanceof String)
                output.put(outputKey, (String) item);
            else if (item instanceof Map)
                flatten(output, outputKey, (Map) item);
        }
    }
}
