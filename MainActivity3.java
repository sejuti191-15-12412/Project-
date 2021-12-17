package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    ListView listViewId1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listViewId1 =  findViewById(R.id.listViewId);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RequestQueue queue = Volley.newRequestQueue(MainActivity3.this);
        String url ="https://mahim2798.000webhostapp.com/list.php";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        List<String> NameArray = new ArrayList<String>();

                        try {
                            JSONArray array = response.getJSONArray("data");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject jsonObject = array.getJSONObject(i);

                                String id = jsonObject.getString("id");
                                String name = jsonObject.getString("std_name");

                                NameArray.add(name);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity3.this,R.layout.sample_view,R.id.textViewId,NameArray);
                        listViewId1.setAdapter(adapter);


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String sm = error.getMessage();
                        Toast.makeText(MainActivity3.this,sm, Toast.LENGTH_SHORT).show();

                    }
                });
        queue.add(jsonObjectRequest);
    }
}