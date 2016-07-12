package jntuh.net.loginscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import jntuh.net.loginscreen.R;

public class welcome_activity extends Activity implements CompoundButton.OnCheckedChangeListener {

     public static final String TAG = welcome_activity.class.getSimpleName();
     private String sendingStats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_activity);

        Intent intent = getIntent();
        String username =intent.getStringExtra("username");

        boolean userText = true;
        if(userText == true) {


            Button userButton = new Button(this);
            userButton.setText("ON");
            userButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(welcome_activity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button customizeBtn = (Button)findViewById(R.id.welcomeButton);
        customizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(welcome_activity.this, RoomConfig.class);
                 startActivity(intent1);
            }
        });
        TextView welcomeHeader = (TextView)findViewById(R.id.welcomeheader);
        welcomeHeader.setText("Welcome  "+username);

        Switch switch1 = (Switch)findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b){
        if(b == true){
            sendingStats = "ON";
           new  MyTask().execute();
            Toast.makeText(welcome_activity.this,"Light Turned On", Toast.LENGTH_SHORT).show();
        }else{
            sendingStats = "OFF";
            new  MyTask().execute();
            Toast.makeText(welcome_activity.this,"Light Turned OFF", Toast.LENGTH_SHORT).show();
        }

    }

    private  class MyTask extends AsyncTask<Void, Void, Void>{


        @Override
        protected Void doInBackground(Void... arg0) {
            try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://0920ce2a.ngrok.io/pivalue/updater");
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("triggerValue",sendingStats));
                post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = client.execute(post);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
