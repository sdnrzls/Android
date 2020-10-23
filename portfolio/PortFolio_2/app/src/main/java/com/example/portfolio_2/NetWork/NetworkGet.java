package com.example.portfolio_2.NetWork;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.portfolio_2.MainActivity;
import com.example.portfolio_2.MovieActivity;
import com.example.portfolio_2.R;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkGet extends AsyncTask<String, Void, String> {
    Activity act;
    private URL Url;
    private String URL_Adress = "http://10.100.206.29:8888/movie/movieDB_login.jsp";
    //중요포인트
    public NetworkGet(Activity act) {
        this.act = act;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String res= "";

        try {
            Url = new URL(URL_Adress);
            HttpURLConnection conn = (HttpURLConnection)Url.openConnection();
            //전송모드 설정
            conn.setDefaultUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            //content-type 설정
            conn.setRequestProperty("Content-type","application/x-www-form-urlencoded; charset=urf-8");

            //전송값 설정
            StringBuffer buffer = new StringBuffer();
            buffer.append("id").append("=").append(strings[0]);
            buffer.append("&password").append("=").append(strings[1]);


            //서버로 전송
            OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            StringBuilder builder = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null){
                builder.append(line+"\n");
            }
            res=builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("Get result", res);
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
            Toast.makeText(act,"회원이 아닙니다 회원가입을 해주세요",Toast.LENGTH_SHORT).show();
        }else if(res==2) {
            Toast.makeText(act,"비밀번호가 일치하지 않습니다",Toast.LENGTH_SHORT).show();
        }else if(res==1){

            View loginView = (View) View.inflate(act, R.layout.login_suc,null);
            AlertDialog.Builder dgv = new AlertDialog.Builder(act);
            dgv.setTitle("환영합니다");
            dgv.setView(loginView);

            dgv.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String id = ((EditText) act.findViewById(R.id.edtLoginID)).getText().toString();

                    Intent intent = new Intent(act, MovieActivity.class);
                   intent.putExtra("userid",id);
                    act.startActivity(intent);
                }
            });
            dgv.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            dgv.show();

        }
    }

}
