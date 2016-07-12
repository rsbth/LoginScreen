package jntuh.net.loginscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jntuh.net.loginscreen.R;

public class customizeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        EditText number = (EditText) findViewById(R.id.editText);
        final String entNum = number.getText().toString();
        Button nextBtn = (Button) findViewById(R.id.button);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(customizeActivity.this, RoomConfig.class);
                intent.putExtra("number",entNum);
                startActivity(intent);
            }
        });
    }


}
