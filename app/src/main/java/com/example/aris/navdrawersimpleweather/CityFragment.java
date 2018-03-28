package com.example.aris.navdrawersimpleweather;


import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aris.navdrawersimpleweather.Model.Helper;
import com.example.aris.navdrawersimpleweather.Model.OpenWeatherMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class CityFragment extends Fragment {
    private String cityUrl="http://app.openweathermap.org/data/2.5/weather?q=Vienna,AUT&appid=b6907d289e10d714a6e88b30761fae22";
    private Spinner sp1;
    TextView cityField;
    TextView updatedField;
    TextView detailsField;
    TextView currentTemperatureField;
    TextView weatherIcon;
    OpenWeatherMap openWeatherMap= new OpenWeatherMap();
    private String WeatherUrl;
  //  Handler handler;
    Typeface weatherFont;
    public CityFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View cityview= inflater.inflate(R.layout.fragment_city, container, false);
        weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "font/weather.ttf");
        cityField = (TextView) cityview.findViewById(R.id.city_field);
        updatedField = (TextView) cityview.findViewById(R.id.updated_field);
        detailsField = (TextView) cityview.findViewById(R.id.details_field);
        currentTemperatureField = (TextView) cityview.findViewById(R.id.current_temperature_field);
        weatherIcon = (TextView) cityview.findViewById(R.id.weather_icon);
        sp1=(Spinner)cityview.findViewById(R.id.spinner);
        weatherIcon.setTypeface(weatherFont);
        //handler = new Handler();
        final List<String> Array=new ArrayList<String>();
        Array.add("Vienna");
        Array.add("Graz");
        Array.add("Salzburg");
        Array.add("Eisenstadt");
        Array.add("Innsbruck");
        Array.add("Bregenz");
        Array.add("Sankt Poelten");
        Array.add("Klagenfurt");


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, Array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                switch (position) {
                    case 0:
                        cityUrl="Vienna,AUT";
                        break;
                    case 1:
                        cityUrl="Graz,AUT";
                        break;
                    case 2:
                        cityUrl="Salzburg,AUT";
                        break;
                    case 3:
                        cityUrl="Eisenstadt,AUT";
                        break;
                    case 4:
                        cityUrl="Innsbruck,AUT";
                        break;
                    case 5:
                        cityUrl="Bregenz,AUT";
                        break;
                    case 6:
                        cityUrl="St. Pölten,AUT";
                        break;
                    case 7:
                        cityUrl="Klagenfurt,AUT";

                        break;
                }
                new CityFragment.updateWeather().execute(Common.apiRequest(cityUrl));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        return cityview;
    }
/*
    private void updateWeatherData(final String url){
        new Thread(){
            public void run(){
                final JSONObject json = RemoteFetch.getJSON(getActivity(), url);
                if(json == null){
                    handler.post(new Runnable(){
                        public void run(){
                            Toast.makeText(getActivity(),
                                    getActivity().getString(R.string.place_not_found),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    handler.post(new Runnable(){
                        public void run(){
                            renderWeather(json);
                        }
                    });
                }
            }
        }.start();
    }
    private void renderWeather(JSONObject json){
        try {
            cityField.setText(json.getString("name"));

            JSONObject details = json.getJSONArray("weather").getJSONObject(0);
            JSONObject main = json.getJSONObject("main");
            detailsField.setText(
                    details.getString("description").toUpperCase(Locale.US) +
                            "\n" + "Humidity: " + main.getString("humidity") + "%" +
                            "\n" + "Pressure: " + main.getString("pressure") + " hPa");

            currentTemperatureField.setText(
                    String.format("%.2f", main.getDouble("temp")-273.5)+ " ℃");

            DateFormat df = DateFormat.getDateTimeInstance();
            String updatedOn = df.format(new Date(json.getLong("dt")*1000));
            updatedField.setText("Last update: " + updatedOn);

                setWeatherIcon(details.getInt("id"),
                    json.getJSONObject("sys").getLong("sunrise") * 1000,
                    json.getJSONObject("sys").getLong("sunset") * 1000);

        }catch(Exception e){
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }
    }
    */

    private void setWeatherIcon(int actualId, long sunrise, long sunset){
        int id = actualId / 100;
        String icon = "";
        if(actualId == 800){
            long currentTime = new Date().getTime();
            if(currentTime>=sunrise && currentTime<sunset) {
                icon = getActivity().getString(R.string.weather_sunny);
            } else {
                icon = getActivity().getString(R.string.weather_clear_night);
            }
        } else {
            switch(id) {
                case 2 : icon = getActivity().getString(R.string.weather_thunder);
                    break;
                case 3 : icon = getActivity().getString(R.string.weather_drizzle);
                    break;
                case 7 : icon = getActivity().getString(R.string.weather_foggy);
                    break;
                case 8 : icon = getActivity().getString(R.string.weather_cloudy);
                    break;
                case 6 : icon = getActivity().getString(R.string.weather_snowy);
                    break;
                case 5 : icon = getActivity().getString(R.string.weather_rainy);
                    break;
            }
        }
        weatherIcon.setText(icon);
    }


    private class updateWeather extends AsyncTask<String, Void,String> {
        ProgressDialog pd = new ProgressDialog(getActivity());

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.setTitle("please wait...");
            pd.show();

        }

        @Override
        protected String doInBackground(String... params) {
            String stream = null;
            String urlString = params[0];
            Helper http = new Helper();
            stream = http.getHTTPData(urlString);
            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s.contains("Error: not found ")){
                pd.dismiss();
                return;
            }
            Gson gson = new Gson();
            Type mytype= new TypeToken<OpenWeatherMap>(){}.getType();
            openWeatherMap=gson.fromJson(s,mytype);
            pd.dismiss();
            cityField.setText(String.format("%s, %s",openWeatherMap.getName(),openWeatherMap.getSys().getCountry()));
            updatedField.setText(String.format("last update: %s", Common.getDateNow()));
            detailsField.setText(String.format("%s\nHumidity: %s\nPressure: %s\n", openWeatherMap.getWeather().get(0).getDescription(),openWeatherMap.getMain().getHumidity(),
                    openWeatherMap.getMain().getPressure()));
          //  timeField.setText(String.format("%s/%s", Common.unixTimeStampToDateTime(openWeatherMap.getSys().getSunrise()),Common.unixTimeStampToDateTime(openWeatherMap.getSys().getSunset()) ));
            currentTemperatureField.setText(String.format("%.2f ℃", openWeatherMap.getMain().getTemp()-273.5));
            setWeatherIcon(openWeatherMap.getWeather().get(0).getId(),
                    (long)openWeatherMap.getSys().getSunrise(),
                    (long)openWeatherMap.getSys().getSunset());

        }
    }
}
