package jntuh.net.loginscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends Activity {
      private EditText userName;
      private EditText pwd;
      private TextView header;
      private String enteredUname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       userName = (EditText)findViewById(R.id.unameFeild);
        pwd = (EditText)findViewById(R.id.passwordFeild);

        Button loginButton = (Button)findViewById(R.id.loginButton);
        header = (TextView)findViewById(R.id.header);

        enteredUname = userName.getText().toString();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //new MyTask().execute();
                Intent intent = new Intent(LoginActivity.this, welcomeScreen.class);
                intent.putExtra("username",enteredUname);
                startActivity(intent);
            }
        });
    }

    //Async task coz , main thread cant handle everything especially network connections

   /* private class MyTask extends AsyncTask<Void, Void, Void>{
        private String respGet;
        private String enteredUname = userName.getText().toString();
        private String enteredpassword = pwd.getText().toString();
        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                HttpClient client = new DefaultHttpClient();
                //HttpClient package of apache
                HttpPost post = new HttpPost("http://48defa66.ngrok.io/testing/test");
                //Dealing with Post Method
               //sample/process for auth java
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
                //To send multiple values created a list
                nameValuePairs.add(new BasicNameValuePair("username", enteredUname));
                //attached value 1 to list
                nameValuePairs.add(new BasicNameValuePair("password", enteredpassword));
                //attached value 2 to list

                post.setEntity(new UrlEncodedFormEntity(nameValuePairs)); //Preparing for response
                HttpResponse response = client.execute(post); //Executing post method
                final HttpEntity entity = response.getEntity(); //Piping in the PT
                respGet = EntityUtils.toString(entity); //Storing it into a string

                final HttpClient httpClient = new DefaultHttpClient();
                final HttpGet httpGet = new HttpGet("http://df539fe0.ngrok.io/sample/sample");
                HttpResponse response = httpClient.execute(httpGet);
                final HttpEntity entity = response.getEntity();
                //Log.i("connectionClass", "Servlet Result: " + EntityUtils.toString(entity));
                respGet = EntityUtils.toString(entity);
                --RSB -- Only to fetch PT from Tomcat

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
                 if(respGet.contains("ok")){
                     Intent intent = new Intent(LoginActivity.this, welcomeScreen.class);
                    intent.putExtra("username",enteredUname);
                     startActivity(intent);
                 }else{
                     header.setText("Invalid Credentials");
                 }
             // header.setText(respGet);
          super.onPostExecute(aVoid);
        }
    }
*/

}
