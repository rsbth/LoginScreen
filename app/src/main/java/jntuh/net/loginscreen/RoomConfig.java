package jntuh.net.loginscreen;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import jntuh.net.loginscreen.R;

public class RoomConfig extends Activity {
    private Button myButton[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_config);

        Intent intent = getIntent();
        String username =intent.getStringExtra("number");

        int number = Integer.parseInt(username);


        for(int index = 0; index < number; index++) {
            myButton[index] = new Button(this); //initialize the button here
            myButton[index].setText("Button # "+ index);
        }

        RelativeLayout rel = (RelativeLayout)findViewById(R.id.rel);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rel.addView(rel,params);
    }



}
