package com.example.schoolproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Colors extends AppCompatActivity{
    public void btnRed (View view) {
        Drawable red = getResources().getDrawable(R.drawable.color);
        red.setColorFilter(getResources().getColor(R.color.colorRed), PorterDuff.Mode.SRC_IN);
        ImageView colorActive = findViewById(R.id.colorActive);
        colorActive.setColorFilter(getResources().getColor(R.color.colorRed));
    }
    public void btnBlue (View view) {
        Drawable red = getResources().getDrawable(R.drawable.color);
        red.setColorFilter(getResources().getColor(R.color.colorBlue), PorterDuff.Mode.SRC_IN);
        ImageView colorActive = findViewById(R.id.colorActive);
        colorActive.setColorFilter(getResources().getColor(R.color.colorBlue));

    }
    public void btnGreen (View view) {
        Drawable red = getResources().getDrawable(R.drawable.color);
        red.setColorFilter(getResources().getColor(R.color.colorGreen), PorterDuff.Mode.SRC_IN);
        ImageView colorActive = findViewById(R.id.colorActive);
        colorActive.setColorFilter(getResources().getColor(R.color.colorGreen));

    }
    public void btnYellow (View view) {
        Drawable red = getResources().getDrawable(R.drawable.color);
        red.setColorFilter(getResources().getColor(R.color.colorYellow), PorterDuff.Mode.SRC_IN);
        ImageView colorActive = findViewById(R.id.colorActive);
        colorActive.setColorFilter(getResources().getColor(R.color.colorYellow));

    }
    public void btnWhite (View view) {
        Drawable red = getResources().getDrawable(R.drawable.color);
        red.setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_IN);
        ImageView colorActive = findViewById(R.id.colorActive);
        colorActive.setColorFilter(getResources().getColor(R.color.colorWhite));

    }
    public void btnPurple (View view) {
        Drawable red = getResources().getDrawable(R.drawable.color);
        red.setColorFilter(getResources().getColor(R.color.colorPurple), PorterDuff.Mode.SRC_IN);
        ImageView colorActive = findViewById(R.id.colorActive);
        colorActive.setColorFilter(getResources().getColor(R.color.colorPurple));

    }
}
