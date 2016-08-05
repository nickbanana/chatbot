package co.devcenter.android.chatbot;


public class Keywords {

    private String keyword;
    private String property;

    public Keywords(String keyword, String property)
    {
        super();
        this.keyword=keyword;
        this.property=property;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getProperty() {
        return property;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
