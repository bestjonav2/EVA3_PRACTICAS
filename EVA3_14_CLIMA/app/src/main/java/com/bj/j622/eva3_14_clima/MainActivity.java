package com.bj.j622.eva3_14_clima;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos = findViewById(R.id.resultTV);
    }

    public void conOnClick(View v){
        Toast.makeText(this, "XD", Toast.LENGTH_SHORT).show();
        Connection con = new Connection();
        con.execute();
    }

    class Connection extends AsyncTask<Void,Void,String> {
        final String sLink = "http://api.openweathermap.org/data/2.5/box/city?bbox=-106,21,-104,28,10&appid=6d3f28d706799a6bcb2b1785529fbfb7";

        @Override
        protected String doInBackground(Void... voids) {
            String result = "";
            try {
                URL url = new URL(sLink);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                if(con.getResponseCode() == HttpURLConnection.HTTP_OK){
                    BufferedReader data = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    result = data.readLine();
                } else {
                    return "Err";
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JSONArray ciudades = null;
            if(!s.equals("")) {
                Toast.makeText(MainActivity.this, "no null", Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsDatos = new JSONObject(s);
                    ciudades = jsDatos.getJSONArray("list");
                    for (int i = 0; i < ciudades.length(); i++) {
                        JSONObject jCiudad = ciudades.getJSONObject(i);
                        datos.append("Ciudad: " + jCiudad.getString("name"));
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Err", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                datos.setText(s);
            }
        }
    }
}
