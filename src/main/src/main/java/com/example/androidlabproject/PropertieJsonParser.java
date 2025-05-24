package com.example.androidlabproject;

import android.app.Activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
public class PropertieJsonParser {

    public static void getObjectFromJson(String json, Activity activity) {
//        List<Propertie> properties;
        try {
            JSONObject parentJsonObject = new JSONObject(json);
            JSONArray jsonArray = parentJsonObject.getJSONArray("properties");

//            properties = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject = (JSONObject) jsonArray.get(i);

                Propertie propertie = new Propertie();
                propertie.setId(jsonObject.getInt("id"));
                propertie.setTitle(jsonObject.getString("title"));
                propertie.setType(jsonObject.getString("type"));
                propertie.setPrice(jsonObject.getInt("price"));
                propertie.setLocation(jsonObject.getString("location"));
                propertie.setArea(jsonObject.getString("area"));
                propertie.setBathrooms(jsonObject.getInt("bedrooms"));
                propertie.setBathrooms(jsonObject.getInt("bathrooms"));
                propertie.setImage_url(jsonObject.getString("image_url"));
                propertie.setDescription(jsonObject.getString("description"));


                DataBaseHelper dataBaseHelper =new DataBaseHelper(activity,"ProjectDB",null,1);
                dataBaseHelper.insertPropertie(propertie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
