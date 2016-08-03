package co.devcenter.android.sample;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.Toast;

public class Automata {
    /* version 1 method : search on table */

    KeywordContainer keywordContainer;
    private String Response;
    private String Userdemand;
    private static final int RESULT_SPEECH = 1;

    public Automata()
    {
        initialize();
    }

    private void initialize()
    {
        Response="";
        Userdemand="";
    }


    public String SendResponse()
    {
        return Response;
    }

    public void getUserdemand(String userdemand)
    {
        this.Userdemand=userdemand;
    }


    public void Processing()
    {
        // first voice recognition
        // check the missing property (property count)

        while(!keywordContainer.ContainerFilled())
        {
            //ask the question
            //voice recognition
            //fill the blank
            //
        }
    }












}
