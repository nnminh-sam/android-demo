package nnminh.android.demoweatherapi.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import nnminh.android.demoweatherapi.R;
import nnminh.android.demoweatherapi.adapter.WeatherAdapter;
import nnminh.android.demoweatherapi.model.WeatherForecastModel;

public class MainActivity extends AppCompatActivity {

    private TextView txtCityName, txtTemperature;
    private EditText editTextTextPersonName;
    private ImageView imgSearch;
    private ListView rvWeatherForecast;
    private WeatherAdapter weatherAdapter;
    private ArrayList<WeatherForecastModel> weatherForecastModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCityName = findViewById(R.id.txtCityName);
        txtTemperature = findViewById(R.id.txtTemperature);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        imgSearch = findViewById(R.id.imgSearch);
        rvWeatherForecast = findViewById(R.id.rvWeatherForecast);

        weatherForecastModelList = new ArrayList<>();
        weatherAdapter = new WeatherAdapter(this, weatherForecastModelList);
        rvWeatherForecast.setAdapter(weatherAdapter);

        GetData("Ho Chi MInh");

        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cityName = editTextTextPersonName.getText().toString();
                System.out.println("Search for " + cityName);
                GetData(cityName);
            }
        });
    }

    private void GetData(String cityName) {
        String url = "https://api.weatherapi.com/v1/forecast.json?key=2aca6dba9c1741ad98d64036250804&q=" + cityName + "&days=1&aqi=no&alerts=no";

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        Log.d("BBB", url);

        txtCityName.setText(cityName);
        weatherForecastModelList.clear();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Get current weather data
                            String temperature = response.getJSONObject("current")
                                    .getString("temp_c");
                            txtTemperature.setText(temperature + "°C");

                            // Get condition (e.g., sunny, rainy)
                            String condition = response.getJSONObject("current")
                                    .getJSONObject("condition")
                                    .getString("text");
                            Log.d("WeatherCondition", condition);

                            // Get forecast data
                            JSONObject forecast = response.getJSONObject("forecast");
                            JSONArray hourArray = forecast.getJSONArray("forecastday")
                                    .getJSONObject(0)
                                    .getJSONArray("hour");

                            for (int i = 0; i < hourArray.length(); i++) {
                                JSONObject hourObj = hourArray.getJSONObject(i);
                                String time = hourObj.getString("time");
                                String temp = hourObj.getString("temp_c");
                                String icon = hourObj.getJSONObject("condition").getString("icon");
                                String wind = hourObj.getString("wind_kph");

                                Log.d("AAA", time + " " + temp + " " + icon + " " + wind);
                                weatherForecastModelList.add(new WeatherForecastModel(time, temp, icon, wind));
                            }

                            weatherAdapter.notifyDataSetChanged();

                            // Show toast with temperature
                            Toast.makeText(MainActivity.this, "Temperature: " + temperature + "°C", Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("AAA", "Error parsing JSON: " + e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VolleyError", "Error fetching data: " + error.getMessage());
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}

