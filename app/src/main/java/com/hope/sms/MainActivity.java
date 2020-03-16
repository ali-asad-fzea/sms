package com.hope.sms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.Manifest;
import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URLEncoder;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M &&( checkSelfPermission(Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED))
        {

                 requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS},1000);


        }
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M &&( checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED))
        {


            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},2000);

        }
        {
            String phone="6265262196";
            Intent intent1=new Intent(Intent.ACTION_CALL);
            intent1.setData(Uri.parse("tel:+91"+phone));
        }
//&& checkSelfPermission(Manifest.permission.CALL_PHONE)
    }
    public void call(View view){
        String phone="+916265262196";
        PackageManager packageManager=getPackageManager();
        try {
            Intent send = new Intent(Intent.ACTION_VIEW);
            String url = "https://api.whatsapp.com/send?phone=" + phone + "&text=" + URLEncoder.encode("ALHAMDULILLAH it worked", "UTF-8");
            send.setPackage("com.whatsapp");
            send.setData(Uri.parse(url));
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phone));
            if(send.resolveActivity(packageManager)!=null){
                TaskStackBuilder.create(this).addNextIntent(send).addNextIntent(intent).startActivities();

            }
        }
        catch(Exception e){

            e.printStackTrace();
        }
/* PackageManager packageManager=context.getPackageManager();
                          String phone = "+916265262196";
                          Intent send=new Intent(Intent.ACTION_VIEW);
                          try {
                              String url="https://api.whatsapp.com/send?phone="+phone+"&text="+ URLEncoder.encode("ALHAMDULILLAH it worked","UTF-8");
                              send.setPackage("com.whatsapp");
                              send.setData(Uri.parse(url));




                          Intent intent_call = new Intent(Intent.ACTION_CALL);
                          intent_call.setData(Uri.parse("tel:" + phone));
                          //context.startActivity(intent_call);
                              if(send.resolveActivity(packageManager)!=null){
                                  TaskStackBuilder.create(context).addNextIntent(send).addNextIntent(intent_call).startActivities();

                              }

                          }
                      catch(Exception e){

                          e.printStackTrace();
                      }*/
    }

@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults){

        if(requestCode==1000)
        {
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){

                Toast.makeText(this,"Permission granted!",Toast.LENGTH_SHORT).show();
            }
            else{

                Toast.makeText(this,"Permission not granted!",Toast.LENGTH_SHORT).show();
                finish();
            }

        }


    if(requestCode==2000)
    {
        if(grantResults[1]==PackageManager.PERMISSION_GRANTED){

            Toast.makeText(this,"Permission granted!",Toast.LENGTH_SHORT).show();
        }
        else{

            Toast.makeText(this,"Permission not granted!",Toast.LENGTH_SHORT).show();
            finish();
        }

    }


}

  /*  public void get(View view)
    {

        StringBuilder smsBuilder = new StringBuilder();
        final String SMS_URI_INBOX = "content://sms/inbox";
        final String SMS_URI_ALL = "content://sms/";
        try {
            Uri uri = Uri.parse(SMS_URI_INBOX);
            String[] projection = new String[] { "_id", "address", "person", "body", "date", "type" };
            Cursor cur = getContentResolver().query(uri, projection, "address='+916265262196'", null, "date desc");
            if (cur.moveToFirst()) {
                int index_Address = cur.getColumnIndex("address");
                int index_Person = cur.getColumnIndex("person");
                int index_Body = cur.getColumnIndex("body");
                int index_Date = cur.getColumnIndex("date");
                int index_Type = cur.getColumnIndex("type");
                do {
                    String strAddress = cur.getString(index_Address);
                    int intPerson = cur.getInt(index_Person);
                    String strbody = cur.getString(index_Body);
                    long longDate = cur.getLong(index_Date);
                    int int_Type = cur.getInt(index_Type);

                    smsBuilder.append("[ ");
                    smsBuilder.append(strAddress + ", ");
                    smsBuilder.append(intPerson + ", ");
                    smsBuilder.append(strbody + ", ");
                    smsBuilder.append(longDate + ", ");
                    smsBuilder.append(int_Type);
                    smsBuilder.append(" ]\n\n");
                } while (cur.moveToNext());

                if (!cur.isClosed()) {
                    cur.close();
                    cur = null;
                }
            } else {
                smsBuilder.append("no result!");
            } // end if

        }catch (SQLiteException ex) {
            Log.d("SQLiteException", ex.getMessage());
        }*/


    }













