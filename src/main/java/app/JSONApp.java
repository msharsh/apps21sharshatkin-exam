package app;

import domain.*;
import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        //BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        //print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

    public static JsonObject sessionResult() {
        JsonObject jsonObject;
        JsonPair year = new JsonPair("year", new JsonNumber(2));
        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));

        JsonObject tempObj1 = new JsonObject();
        tempObj1.add(new JsonPair("course", new JsonString("OOP")));
        tempObj1.add(new JsonPair("mark", new JsonNumber(3)));
        tempObj1.add(new JsonPair("passed", new JsonBoolean(true)));

        JsonObject tempObj2 = new JsonObject();
        tempObj2.add(new JsonPair("course", new JsonString("English")));
        tempObj2.add(new JsonPair("mark", new JsonNumber(5)));
        tempObj2.add(new JsonPair("passed", new JsonBoolean(true)));

        JsonObject tempObj3 = new JsonObject();
        tempObj3.add(new JsonPair("course", new JsonString("Math")));
        tempObj3.add(new JsonPair("mark", new JsonNumber(2)));
        tempObj3.add(new JsonPair("passed", new JsonBoolean(false)));

        JsonArray arrExams = new JsonArray(tempObj1, tempObj2, tempObj3);
        jsonObject = new JsonObject(name, surname, year, new JsonPair("exams", arrExams));
        return jsonObject;
    }
}
