package com.hope.sms;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.net.URLEncoder;

public class InvitationSmsReceiver extends BroadcastReceiver {

 /*   public class get extends Activity {
    @Override
        public void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    }*/
 String from;
 String finder="+916265262196";
    String message;
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Bundle bundle = intent.getExtras();
            SmsMessage[] msgs;


            if (bundle != null) {
            try {
                Object[] pdus = (Object[]) bundle.get("pdus");
                msgs = new SmsMessage[pdus.length];
                for (int i = 0; i < msgs.length; i++) {


                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    from = msgs[i].getOriginatingAddress();
                    message = msgs[i].getMessageBody();

                 //   Toast.makeText(context, "From\t" + from + ",Body=" + message, Toast.LENGTH_SHORT).show();
                }
                    if (from.equals(finder)) {
                        PackageManager packageManager=context.getPackageManager();
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
                      }
                    }


                }
                catch (Exception e){

                    e.printStackTrace();
                }
            }
        }
    }
 }
               /* Activity call = new Activity() {

                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        if (from == "+916265262196") {
                            String phone = "6265262196";
                            Intent intent1 = new Intent(Intent.ACTION_CALL);
                            intent1.setData(Uri.parse("tel:+91" + phone));
                        }

                    }

                };
            }
            catch (Exception e){

                e.printStackTrace();

            }

            }

        }
    }


}

      Bundle bundle=intent.getExtras();
        SmsMessage[] msgs=null;
        String message="";
        if(bundle !=null){

            Object[] pdus=(Object[]) bundle.get("pdus");
            msgs=new SmsMessage[pdus.length];
            for (int i=0;i<msgs.length;i++){

                msgs[i]=SmsMessage.createFromPdu((byte[]) pdus[i]);
                message=msgs[i].getMessageBody();
                Toast.makeText(context,message,Toast.LENGTH_SHORT).show();



            }

        }


        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");
 */