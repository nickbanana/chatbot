package co.devcenter.android.sample;

import java.util.ArrayList;


public class KeywordContainer {



    private ArrayList<Keywords> Semantic_Frame;
    private int Framecount;

    public int getFramecount()
    {
        return Framecount;
    }

    public void setFramecount(int framecount)
    {
        Framecount = framecount;
    }

    public int getFrameLength()
    {
        return Semantic_Frame.size();
    }

    public KeywordContainer()
    {
        Semantic_Frame.clear();
        Framecount=0;
    }

    public boolean ContainerFilled()
    {
        return Semantic_Frame.size()==Framecount;
    }


}
