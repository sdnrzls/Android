package com.example.portfolio.NetWork;
import com.example.portfolio.UserInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonPaser {

    static public int getUserInfoJson(String response, ArrayList<UserInfo> userList) throws JSONException {
        String strID;
        String strName;
        String strPassword;
        String strPhone;
        String stremail;


        JSONObject rootJSON = new JSONObject(response);
        JSONArray jsonArray = new JSONArray(rootJSON.getString("datas"));

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObj = (JSONObject) jsonArray.get(i);

            if (jsonObj.getString("ID").toString().equals("null"))
                strID = "-";
            else
                strID = jsonObj.getString("ID").toString();

            if (jsonObj.getString("NAME").toString().equals("null"))
                strName = "-";
            else
                strName = jsonObj.getString("NAME").toString();

            if (jsonObj.getString("password").toString().equals("null"))
                strPassword = "-";
            else
                strPassword = jsonObj.getString("password").toString();

            if (jsonObj.getString("PHONE").toString().equals("null"))
                strPhone = "-";
            else
                strPhone = jsonObj.getString("PHONE").toString();

            if (jsonObj.getString("email").toString().equals("null"))
                stremail = "-";
            else
                stremail = jsonObj.getString("email").toString();

            userList.add(new UserInfo(strID, strName, strPassword, strPhone, stremail));
        }
        return jsonArray.length();
    }
    static public int getResultJson(String response) throws JSONException{
        JSONArray jsonArray = new JSONArray(response);
        JSONObject jsonObject = new JSONObject(jsonArray.getString(0));
        return Integer.parseInt(jsonObject.getString("RESULT_OK"));
    }
}
