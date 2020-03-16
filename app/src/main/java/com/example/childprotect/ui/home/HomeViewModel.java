package com.example.childprotect.ui.home;

import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.childprotect.Child;
import com.example.childprotect.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    String result = "{\n" +
            "  \"name\": \"Ahmed\",\n" +
            "  \"email\": \"Ahmed@gmail.com\",\n" +
            "  \"numOfChildren\": 2,\n" +
            "  \"children\": [\n" +
            "    {\n" +
            "        \"name\": \"Mohammed\",\n" +
            "        \"id\": 1\n" +
            "    },\n" +
            "    {\n" +
            "    \"name\": \"mustafa\",\n" +
            "    \"id\": 2\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    JSONArray jArray;
    ArrayList<Child> children = new ArrayList<>();
//    String name;

    public HomeViewModel() {
        try {
            JSONObject jObject = new JSONObject(result);
            jArray = jObject.getJSONArray("children");
//            name = jObject.getString("name");
            for (int i = 0; i < jArray.length(); i++){
                JSONObject object = jArray.getJSONObject(i);
                children.add(new Child(object.getString("name"),object.getInt("id")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Child> getArray(){
        return children;
    }

}