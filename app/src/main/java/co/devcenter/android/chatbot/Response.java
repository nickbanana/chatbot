package co.devcenter.android.chatbot;

/**
 * Created by chococsie on 2016/8/3.
 */
public class Response {

    private String Question;
    public String Ans;



    public Response(String question)
    {
        this.Question=question;
    }

    public String Answer()
    {
        if(Question.equals("我要買飲料"))
        {
            Ans = "哪一家";
        }
        else if(Question.equals("五十嵐")||Question.equals("50嵐"))
        {
            Ans = "哪一種飲料";
        }
        else if(Question.equals("泡沫紅茶"))
        {
            Ans = "多少錢";
        }
        else if (Question.equals("15元")|| Question.equals("十五元"))
        {
            Ans = "可以到長榮路買";
        }











        //Ans="This is your question:" + Question;
        //Log.v("test", Ans);
        return Ans;
    }


}
