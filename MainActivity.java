package com.example.android.xsandos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play = (Button) findViewById(R.id.play_button);

        /*  This  eventListener executes when the play button is clicked*/
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(MainActivity.this,BoardActivity.class);
                startActivity(playIntent);
//                Toast.makeText(view.getContext(),"ready to go",Toast.LENGTH_SHORT).show();

            }
        });

        Button settings = (Button) findViewById(R.id.settings_button);

        /*  This  eventListener executes when the play button is clicked*/
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settIntent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(settIntent);
//                Toast.makeText(view.getContext(),"ready to set",Toast.LENGTH_SHORT).show();

            }
        });

        Button about = (Button) findViewById(R.id.about_button);

        /*  This  eventListener executes when the play button is clicked*/
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abtIntent = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(abtIntent);
//                Toast.makeText(view.getContext(),"ready for abt",Toast.LENGTH_SHORT).show();

            }
        });


    }
}
