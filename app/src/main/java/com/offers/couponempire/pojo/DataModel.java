package com.offers.couponempire.pojo;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by root on 4/11/14.
 */
public class DataModel implements Serializable {

ArrayList<JSONObject> Campaignslist;
ArrayList<JSONObject> termsandconditionslist;
ArrayList<JSONObject> tags_list;
JSONObject SubscriberModel;
Map<String,ArrayList<JSONObject>> CampaignListBytagname;
String message;
ArrayList<String> buttonimage;


    private static DataModel dataModel;

    // Private constructor prevents instantiation from other classes
    private DataModel() { }

    public void addStuff(Object stuff){}

    public Map<String,ArrayList<JSONObject>> getCampaignListBytagname() {
        return CampaignListBytagname;
    }

    public void setCampaignListBytagname(Map<String,ArrayList<JSONObject>> campaignListBytagname) {
        CampaignListBytagname = campaignListBytagname;
    }

    public static DataModel getInstance() {

        if(dataModel == null) dataModel = new DataModel();
        return dataModel;
    }


    public ArrayList<JSONObject> getplaybuttonimage() {
        return Campaignslist;
    }

    public void setplaybuttonimage(int postion) {
        this.Campaignslist = Campaignslist;
    }







    public ArrayList<JSONObject> getCampaignslist() {
        return Campaignslist;
    }

    public void setCampaignslist(ArrayList<JSONObject> Campaignslist) {
        this.Campaignslist = Campaignslist;
    }

    public ArrayList<JSONObject> gettermsandconditionslist() {
        return  termsandconditionslist;
    }

    public void settermsandconditionslistt(ArrayList<JSONObject> termsandconditionslist) {
        this. termsandconditionslist=  termsandconditionslist;
    }

    public ArrayList<JSONObject> gettags_list() {
        return  tags_list;
    }

    public void settags_list(ArrayList<JSONObject> tags_list) {
        this. tags_list=  tags_list;
    }



    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }





    public JSONObject getSubscriberModel() {
        return SubscriberModel;
    }

    public void setSubscriberModel(JSONObject SubscriberModel) {
        this.SubscriberModel = SubscriberModel;
    }


}
