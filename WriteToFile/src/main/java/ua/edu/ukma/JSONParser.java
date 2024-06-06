package ua.edu.ukma;
import org.json.JSONObject;


public class JSONParser {
    JSONObject json;

    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        jsonParser.add("Hello", "World");
        jsonParser.add("Goodbye", "World");
        System.out.println(jsonParser.getJSON());
    }

    public JSONParser() {
        json = new JSONObject();
    }

    public void add(String text, String cypheredtext){
        json.append(text, cypheredtext);
    }

    public String getJSON(){
        return json.toString();
    }
}
