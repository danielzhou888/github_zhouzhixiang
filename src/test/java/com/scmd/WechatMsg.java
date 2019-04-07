package com.scmd;

import java.util.Date;

/**
 * Created by zhouzhixiang on 2018/10/21.
 */
public class WechatMsg {
    private Date sendtime;
    private String msg;

    public WechatMsg(Date sendtime, String msg) {
        this.sendtime = sendtime;
        this.msg = msg;
    }

    public WechatMsg() {
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
