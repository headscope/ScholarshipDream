package com.example.chutbaksa.scholarshipdream.JSONparser;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.net.URL;

public class JanghakObject {

    public String Jid;
    public String janghakname;
    public String foundation;
    public String weblink;
    public String payamount;
    public String downloadlink;
    public String startdate;
    public String enddate;
    public int dday;



// Must have no-argument constructor

    public String getJid() {
        return Jid;
    }

    public void setJid(String jid) {
        Jid = jid;
    }

    public String getJanghakname() {
        return janghakname;
    }

    public void setJanghakname(String janghakname) {
        this.janghakname = janghakname;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

    public String getPayamount() {
        return payamount;
    }

    public void setPayamount(String payamount) {
        this.payamount = payamount;
    }

    public String getDownloadlink() {
        return downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public int getDday() {
        return dday;
    }

    public void setDday(int dday) {
        this.dday = dday;
    }


    public JanghakObject() {

    }

    public JanghakObject(String Jid, String janghakname,
                         String foundation,String payamount,
                         String weblink, String downloadlink,
                         String startdate, String enddate, int dday)
    {
        this.Jid = Jid;
        this.janghakname = janghakname;
        this.foundation = foundation;
        this.payamount = payamount;
        this.downloadlink = downloadlink;
        this.weblink = weblink;
        this.startdate = startdate;
        this.enddate = enddate;
        this.dday = dday;

    }

}