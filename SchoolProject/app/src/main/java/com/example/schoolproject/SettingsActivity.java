package com.example.schoolproject;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;




public class SettingsActivity extends AppCompatActivity {
    private EditText ipxx1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

        ipxx1 = (EditText) findViewById(R.id.ipadd);


    }
    public void btnSaveClicked(View view){
        Settings.setIpAddressOfEsp(ipxx1.getText().toString());





        Intent ht1 = new Intent(SettingsActivity.this, LedActivity.class);
        startActivity(ht1);

    }
}
