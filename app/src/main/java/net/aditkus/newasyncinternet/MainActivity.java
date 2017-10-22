package net.aditkus.newasyncinternet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConnectInternetTask c1;
    static TextView myText;
    static EditText myEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (TextView) findViewById(R.id.myResult);
        myEdit = (EditText) findViewById(R.id.dataMasuk);


    }

    public void doSomething(View view) {
        ConnectivityManager cm = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected())
        {
            c1 = new ConnectInternetTask(this);
            String input = myEdit.getText().toString();
            c1.execute(input);
        }
        else
        {
            Toast.makeText(getApplication(), " you don't have connected", Toast.LENGTH_SHORT).show();
        }
    }

}


