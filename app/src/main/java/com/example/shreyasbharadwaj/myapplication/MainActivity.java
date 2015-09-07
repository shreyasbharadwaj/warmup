package com.example.shreyasbharadwaj.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String lowerCase = "abcdefghijklmnopqrstuvwxyzabc";
    private final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZABC";

    private Button encoder;
    private EditText nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = (EditText) findViewById(R.id.namefield);
        encoder = (Button) findViewById(R.id.encode);

        encoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                encodeName();
            }
        });

    }


    private void encodeName(){
        String text = nameField.getText().toString();

        String newString = "";

        for (int i=0; i<text.length(); i++){
            char c = text.charAt(i);

            if (lowerCase.indexOf(c)!=-1){
                int n = lowerCase.indexOf(c);
                newString += lowerCase.charAt(n+3);
            }
            else if (upperCase.indexOf(c)!=-1){
                int n = upperCase.indexOf(c);
                newString += upperCase.charAt(n+3);
            }
            else{
                newString += c;
            }
        }

        Toast toast = Toast.makeText(getApplicationContext(), newString, Toast.LENGTH_LONG);
        toast.show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
