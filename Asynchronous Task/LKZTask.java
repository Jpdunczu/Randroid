package com.example.joshuaduncan.ucbasynch;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by joshuaduncan on 8/20/16.
 */
public class LKZTask extends AsyncTask<Void, Void, String> {

    private static final String TAG = LKZTask.class.getSimpleName();
    String urlToShorten;
    MainActivity myActivity;
    ProgressDialog myDialog;

    private String UPLOAD_URL = "http://tinyurl.com/api-create.php?url=";
    //private String UPLOAD_URL
    // = "http://tinyurl.com/api-create.php?url=http://www.google.com/";
    public LKZTask(MainActivity activity, CharSequence fullUrl){

        this.myActivity = activity;
        urlToShorten = fullUrl.toString();
        UPLOAD_URL += fullUrl.toString();
    }

    public LKZTask(){super();}

    @Override
    protected String doInBackground(Void... voids) {
        HttpURLConnection conn = null;
        InputStream responseIn = null;

        try{
            conn = (HttpURLConnection) new URL(UPLOAD_URL).openConnection();
            conn.setRequestMethod("GET");
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                responseIn = conn.getInputStream();
                return onInput(responseIn);
            } else {
                Log.i(TAG, "JOSHUA responseCode=" + conn.getResponseCode());
                responseIn = conn.getErrorStream();
                StringBuilder sb = new StringBuilder();
                Scanner scanner = new Scanner(responseIn);
                while(scanner.hasNext()){
                    sb.append(scanner.next());
                }
                Log.i(TAG, "error response: " + sb.toString());
                return null;
            }
        }catch(Exception ex){
            Log.e(TAG, "Error during POST", ex);
            return null;
        }finally {
            try {
                responseIn.close();
            } catch(Exception ignore){
            }
            try{
                conn.disconnect();
            }catch(Exception ignore){
            }
        }
    }

    protected String onInput(InputStream in) throws Exception {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(in);
        while(scanner.hasNext()){
            sb.append(scanner.next());
        }

        Log.d("JOSHUA", " " + sb.toString());
        return sb.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        myDialog = new ProgressDialog(myActivity);
        myDialog.setMessage("Waiting... Waiting... ");
        myDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(myDialog != null){
            myDialog.dismiss();
        }
        MainActivity.tinyUrl = s;
        myActivity.update();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }



}
