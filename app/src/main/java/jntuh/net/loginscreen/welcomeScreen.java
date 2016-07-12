package jntuh.net.loginscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import jntuh.net.loginscreen.R;

public class welcomeScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        Intent intent = getIntent();
        final String username =intent.getStringExtra("username");

        TextView welcomeText = (TextView)findViewById(R.id.welcome);
        welcomeText.setText("Welcome " + username);

        Button customizeButton = (Button) findViewById(R.id.customisehome);
        customizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(welcomeScreen.this, customizeActivity.class);
                startActivity(intent);
            }
        });

        final Button monitor = (Button)findViewById(R.id.customizebutton);
        monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(welcomeScreen.this, monitoring.class);
                startActivity(intent1);
            }
        });

        Button livingRoom = (Button) findViewById(R.id.livingroom);
        livingRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(welcomeScreen.this, welcome_activity.class);
                intent2.putExtra("room","Living Room");
                intent2.putExtra("username", username);
                startActivity(intent2);
            }
        });
    }



}
