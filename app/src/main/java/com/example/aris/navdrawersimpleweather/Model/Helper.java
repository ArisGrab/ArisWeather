package com.example.aris.navdrawersimpleweather.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by al-kahyatamar on 24.03.18.
 */

public class Helper {
    private static String stream=null;
    public Helper(){

    }
    public String   getHTTPData(String httpurl)
    {
        URL url = null;
        try {
            url = new URL(httpurl);
            HttpURLConnection connection =
                    (HttpURLConnection)url.openConnection();
            if(connection.getResponseCode()==200)//200=OK
            {
                BufferedReader buf=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb=new StringBuilder();
                String newline;
                while ((newline= buf.readLine())!=null)
                    sb.append(newline);
                stream=sb.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stream;
    }
}
