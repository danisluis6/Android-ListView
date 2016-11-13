package vn.udn.dut.listviewb.bean;

/**
 * Created by vuongluis on 05/11/2016.
 */

public class User {

    private String title;
    private String content;

    public User() {
    }

    public User(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
