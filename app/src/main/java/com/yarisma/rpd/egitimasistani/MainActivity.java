package com.yarisma.rpd.egitimasistani;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import java.io.IOException;
import java.util.List;

import org.jsoup.*;

import javax.net.ssl.HttpsURLConnection;



public class MainActivity extends AppCompatActivity {
//    private List<String> cookies;
//    private HttpsURLConnection conn;
//    private final String USER_AGENT = "Mozilla/5.0";


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MyTask().execute();


//
//        EditText id = (EditText)findViewById(R.id.editText2);
//        EditText password = (EditText)findViewById(R.id.editText);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Bu bir denemedir")
                .setMessage("Veriler Logcatte mi")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Yes button clicked, do something
                        Toast.makeText(MainActivity.this, "Yes button pressed",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", null)						//Do nothing on no
                .show();


    }
}

class MyTask extends AsyncTask<Void, Void, String>  {

    @Override
    protected String doInBackground(Void... params) {
        String title ="";
        String icerik ="";
        Document doc;
        String username = "id";
        String password = "pass";
        String login = username + ":" + password;
        String base64login = new String(Base64.encodeToString(login.getBytes(),0));

//
////        EditText _id = MyProperties.getInstance().id;
////        EditText _password = MyProperties.getInstance().password;
//        String local_id = MyProperties.getInstance().id_s;
//        String local_password = MyProperties.getInstance().password_s;


//        String local_id = "gizlidir";
//        String local_password = "*******";

        try {
            //kullanici adi sifre isteyen siteler icin
            //doc = Jsoup.connect("siteadi").data("param01",local_id).data("param02",local_password).data("param03","123").get();

            doc = Jsoup.connect("http://www.google.com.tr").get();
            title = doc.title();
            icerik = doc.text();

            Log.d("hello_title",title.toString());
            Log.d("hello_icerik",icerik.toString());



        } catch (IOException e) {
            e.printStackTrace();
        }
        return title;
    }

    @Override
    protected void onPostExecute(String result) {
        //((TextView)findViewById (R.id)).setText (result);
    }

}

 class MyProperties {
    private static MyProperties mInstance= null;

//     EditText id = (EditText)findViewById(R.id.editText2);
//     EditText password = (EditText)findViewById(R.id.editText);
//     String id_s= id.toString();
//     String password_s= password.toString();

     protected MyProperties(){}

    public static synchronized MyProperties getInstance(){
        if(null == mInstance){
            mInstance = new MyProperties();
        }
        return mInstance;
    }
}