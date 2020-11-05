package de.dhbw.webeng.chat.view;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private String userName = "";
    private String msg;
    private List<ChatMsg> history = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<ChatMsg> getHistory() {
        return history;
    }

    public void setHistory(List<ChatMsg> chats) {
        this.history = chats;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
