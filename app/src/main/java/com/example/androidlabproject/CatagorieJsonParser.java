package com.example.androidlabproject;

import android.app.Activity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
public class CatagorieJsonParser {

    public static void getObjectFromJson(String json, Activity activity) {

        try {
            JSONObject parentJsonObject = new JSONObject(json);
            JSONArray jsonArray = parentJsonObject.getJSONArray("categories");


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject = (JSONObject) jsonArray.get(i);
                Categorie categorie = new Categorie();
                categorie.setId(jsonObject.getInt("id"));
                categorie.setName(jsonObject.getString("name"));

                DataBaseHelper dataBaseHelper =new DataBaseHelper(activity,"ProjectDB",null,1);
                dataBaseHelper.insertCategorie(categorie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
