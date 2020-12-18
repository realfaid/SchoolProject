package com.example.schoolproject;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class SettingsActivity extends AppCompatActivity {
   // private EditText ipxx1; - uložení pouze do řádku
    private static final String FILE_NAME = "ipadress.txt";
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout1);

        //ipxx1 = (EditText) findViewById(R.id.ipadd); - uložení pouze do řádku
        mEditText = findViewById(R.id.ipadd);

    }
    public void btnSaveClicked(View view)
    {
        //Settings.setIpAddressOfEsp(ipxx1.getText().toString()); - uložení pouze do řádku
        String text = mEditText.getText().toString();
        FileOutputStream fos = null;

        mEditText.getText().clear();
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(this, "Uloženo do " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                      fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Intent ht1 = new Intent(SettingsActivity.this, LedActivity.class);
        startActivity(ht1);

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_menu:

                return true;

            case R.id.help_menu:
                setContentView(R.layout.help_layout);
                return true;

            case R.id.modes_menu:
                Intent ht1 = new Intent(SettingsActivity.this, LedActivity.class);
                startActivity(ht1);

                return true;

            case R.id.information_menu:
                setContentView(R.layout.information_layout);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

