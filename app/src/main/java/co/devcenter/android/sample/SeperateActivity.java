package co.devcenter.android.sample;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import co.devcenter.android.ChatView;
import co.devcenter.android.models.ChatMessage;
import co.devcenter.android.models.ChatMessage.Type;


public class SeperateActivity extends AppCompatActivity {

    private static final int RESULT_SPEECH = 1;
    private ArrayList<String> text;
    private String sendtxt;
    private String response;
    private ChatView chatView;
    //private ChatMessage chatMessage = new ChatMessage("",1,Type.SENT);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seperate);

        chatView = (ChatView) findViewById(R.id.chat_view);

        FloatingActionButton floatingActionButton = chatView.getSendButton();

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_speak();
            }
        };

        floatingActionButton.setOnClickListener(onClickListener);


        chatView.setChatListener(new ChatView.ChatListener() {
            @Override
            public void userIsTyping() {

                // do something while user is typing
            }

            @Override
            public void userHasStoppedTyping() {

                // do something when user has stopped typing
            }

            @Override
            public void onMessageReceived(String message, long timestamp) {

                // do something when chat view receives a message
            }

            @Override
            public boolean sendMessage(String message, long timestamp) {

                // do something when the user hits the send button
                return true;
            }
        });
    }



    private void start_speak(){
        Intent intent_speak = new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        intent_speak.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");

        try {
            startActivityForResult(intent_speak, RESULT_SPEECH);
        } catch (ActivityNotFoundException a) {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Ops! Your device doesn't support Speech to Text",
                    Toast.LENGTH_SHORT);
            t.show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null != data) {

                    text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    sendtxt = text.get(0);

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("是這樣?");
                    builder.setMessage(sendtxt+"?");

                    builder.setPositiveButton(" ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            chatView.sendMessage(sendtxt,System.currentTimeMillis());


                        }

                    });
                    builder.setNegativeButton(" ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            start_speak();
                        }

                    });
                    AlertDialog alertDialog = builder.create();
                    //t1.speak(text.get(0)+" ", TextToSpeech.QUEUE_FLUSH, null);
                    alertDialog.show();
                    Button b1 = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    b1.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.tick,0,0);
                    Button b2 = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                    b2.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.cross2,0,0);
                }
                //else{
                    //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                    //if(response.equals("Success")){
                    //    Log.v("RESPONSE","Success");
                        //ExitToMain();
                   // }
                //}
                break;
            }

        }

    }
}
