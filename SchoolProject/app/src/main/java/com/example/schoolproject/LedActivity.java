package com.example.schoolproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class LedActivity extends AppCompatActivity {

    private static final String FILE_NAME = "ipadress.txt";

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.modes_layout);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


    }
    public void load(View v) {
        FileInputStream fis = null;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            Settings.setIpAddressOfEsp(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_menu:
                Intent ht1 = new Intent(LedActivity.this, SettingsActivity.class);
                startActivity(ht1);
                return true;

            case R.id.help_menu:
                setContentView(R.layout.help_layout);
                return true;

            case R.id.modes_menu:
                setContentView(R.layout.modes_layout);
                return true;

            case R.id.information_menu:
                setContentView(R.layout.information_layout);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void btnRedClicked(View view){
        load(null);
        Drawable red = getResources().getDrawable(R.drawable.color);
        red.setColorFilter(getResources().getColor(R.color.colorRed), PorterDuff.Mode.SRC_IN);
        ImageView colorActive = findViewById(R.id.colorActive);
        colorActive.setColorFilter(getResources().getColor(R.color.colorRed));
        CommandToSend process1 = new CommandToSend("led1cervena");
        process1.execute();
    }

    public void btnBlueClicked (View view) {
        load(null);
        Drawable red = getResources().getDrawable(R.drawable.color);
        red.setColorFilter(getResources().getColor(R.color.colorBlue), PorterDuff.Mode.SRC_IN);
        ImageView colorActive = findViewById(R.id.colorActive);
        colorActive.setColorFilter(getResources().getColor(R.color.colorBlue));
        CommandToSend process1 = new CommandToSend("led1modra");
        process1.execute();

    }
    public void btnGreenClicked (View view) {
        load(null);
        Drawable red = getResources().getDrawable(R.drawable.color);
        red.setColorFilter(getResources().getColor(R.color.colorGreen), PorterDuff.Mode.SRC_IN);
        ImageView colorActive = findViewById(R.id.colorActive);
        colorActive.setColorFilter(getResources().getColor(R.color.colorGreen));
        CommandToSend process1 = new CommandToSend("led1zelena");
        process1.execute();
    }
    public void btnAzurClicked (View view) {
        load(null);
        Drawable red = getResources().getDrawable(R.drawable.color);
        red.setColorFilter(getResources().getColor(R.color.colorAzur), PorterDuff.Mode.SRC_IN);
        ImageView colorActive = findViewById(R.id.colorActive);
        colorActive.setColorFilter(getResources().getColor(R.color.colorAzur));
        CommandToSend process1 = new CommandToSend("led1azurova");
        process1.execute();

    }
    public void btnYellowClicked (View view) {
        load(null);
        Drawable red = getResources().getDrawable(R.drawable.color);
        red.setColorFilter(getResources().getColor(R.color.colorYellow), PorterDuff.Mode.SRC_IN);
        ImageView colorActive = findViewById(R.id.colorActive);
        colorActive.setColorFilter(getResources().getColor(R.color.colorYellow));
        CommandToSend process1 = new CommandToSend("led1zluta");
        process1.execute();

    }
    public void btnPurpleClicked (View view) {
        load(null);
        Drawable red = getResources().getDrawable(R.drawable.color);
        red.setColorFilter(getResources().getColor(R.color.colorPurple), PorterDuff.Mode.SRC_IN);
        ImageView colorActive = findViewById(R.id.colorActive);
        colorActive.setColorFilter(getResources().getColor(R.color.colorPurple));
        CommandToSend process1 = new CommandToSend("led1ruzova");
        process1.execute();
    }
    public void btnWhiteClicked (View view) {
        load(null);
        Drawable red = getResources().getDrawable(R.drawable.color);
        red.setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_IN);
        ImageView colorActive = findViewById(R.id.colorActive);
        colorActive.setColorFilter(getResources().getColor(R.color.colorWhite));
        CommandToSend process1 = new CommandToSend("led1bila");
        process1.execute();

    }

    public void btnStillClicked(View view){
        load(null);
        CommandToSend process1 = new CommandToSend("led1on");
        process1.execute();
    }
    public void btnFlashClicked(View view){
        load(null);
        CommandToSend process1 = new CommandToSend("led1flash");
        process1.execute();
    }
    public void btnOffClicked(View view){
        load(null);
        CommandToSend process1 = new CommandToSend("led1off");
        process1.execute();

    }
}