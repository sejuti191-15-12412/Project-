package com.example.register;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {
   // ed_username,ed_email,
    EditText ed_password,ed_std_id,ed_std_name,ed_batch,ed_section;
    String str_std_name,str_password,str_id,str_batch,str_section;
    String Url="https://mahim2798.000webhostapp.com/std_register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ed_std_id = findViewById(R.id.ed_std_id);
        ed_std_name = findViewById(R.id.ed_std_name);
        ed_batch = findViewById(R.id.ed_batch);
        ed_section = findViewById(R.id.ed_section);
        ed_password = findViewById(R.id.ed_password);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void moveToLogin(View view) {

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

    public void Register(View view) {
       final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait....");


        if(ed_std_id.getText().toString().equals("")){
            Toast.makeText(this, "Enter Student ID", Toast.LENGTH_SHORT).show();
        }
        else if(ed_std_name.getText().toString().equals("")){
            Toast.makeText(this, "Enter Student Name", Toast.LENGTH_SHORT).show();
        }
        else if(ed_batch.getText().toString().equals("")){
            Toast.makeText(this, "Enter Batch", Toast.LENGTH_SHORT).show();
        }
        else if(ed_section.getText().toString().equals("")){
            Toast.makeText(this, "Enter Section", Toast.LENGTH_SHORT).show();
        }
        else if(ed_password.getText().toString().equals("")){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }
        else{
            progressDialog.show();
            str_id = ed_std_id.getText().toString().trim();
            str_std_name = ed_std_name.getText().toString().trim();
            str_batch = ed_batch.getText().toString().trim();
            str_section = ed_section.getText().toString().trim();
            str_password = ed_password.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    ed_std_id.setText("");
                    ed_std_name.setText("");
                    ed_batch.setText("");
                    ed_section.setText("");
                    ed_password.setText("");
                    Toast.makeText(Registration.this, response, Toast.LENGTH_SHORT).show();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(Registration.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            ){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String,String>();
                    params.put("std_id",str_id);
                    params.put("std_name",str_std_name);
                    params.put("batch",str_batch);
                    params.put("section",str_section);
                    params.put("std_password",str_password);
                    return params;


                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(Registration.this);
            requestQueue.add(request);

        }

    }
}