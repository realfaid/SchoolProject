package com.example.schoolproject;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class CommandToSend extends AsyncTask<Void,Void,String> {
    String commandString;

    public CommandToSend(String commandString){
        this.commandString = commandString;

    }
    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url = new URL("http://"+Settings.ipAddressOfEsp+"/"+commandString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));


        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);

    }

    
}

