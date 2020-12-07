package com.example.schoolproject;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class SettingsActivity extends AppCompatActivity {
   // private EditText ipxx1; - uložení pouze do řádku
    private static final String FILE_NAME = "ipadress.txt";
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

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
}

