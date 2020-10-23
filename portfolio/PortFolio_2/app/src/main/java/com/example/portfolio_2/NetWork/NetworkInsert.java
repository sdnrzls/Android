package com.example.portfolio_2.NetWork;


import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkInsert extends AsyncTask<String, Void, String> {
        Activity Act;
        private URL Url;
        private String URL_Adress = "http://10.100.206.29:8888/movie/movieDB_join.jsp";

    public NetworkInsert(Activity act) {
        Act = act;
    }

    @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String res = "";

            try {
                Url = new URL(URL_Adress);
                HttpURLConnection conn = (HttpURLConnection) Url.openConnection();
                //전송모드 설정
                conn.setDefaultUseCaches(false);
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");

                //content-type 설정
                conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=urf-8");
                //전송값 설정
                StringBuffer buffer = new StringBuffer();
                buffer.append("id").append("=").append(strings[0]);
                buffer.append("&name").append("=").append(strings[1]);
                buffer.append("&password").append("=").append(strings[2]);
                buffer.append("&phone").append("=").append(strings[3]);
                buffer.append("&email").append("=").append(strings[4]);

                //서버로 전송
                OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
                PrintWriter writer = new PrintWriter(outStream);
                writer.write(buffer.toString());
                writer.flush();

                StringBuilder builder = new StringBuilder();
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    builder.append(line + "\n");
                }
                res = builder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        int res = 0;
        try {
            res = JsonPaser.getResultJson(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(res==0){
            Toast.makeText(Act,"회원가입을 축하드립니다.",Toast.LENGTH_SHORT).show();
        }else {

        }

    }
    }

