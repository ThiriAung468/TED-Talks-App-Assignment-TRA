package com.padcmyanmar.ted.talks.assignment.tra.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.padcmyanmar.ted.talks.assignment.tra.events.ApiErrorEvent;
import com.padcmyanmar.ted.talks.assignment.tra.events.SuccessGetTalksEvent;
import com.padcmyanmar.ted.talks.assignment.tra.network.responses.GetTalksResponse;
import com.padcmyanmar.ted.talks.assignment.tra.utils.TalksConstants;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HttpUrlConnectionDataAgentImpl implements TalksDataAgent {
    private static HttpUrlConnectionDataAgentImpl objInstance;

    private HttpUrlConnectionDataAgentImpl() {


    }

    public static HttpUrlConnectionDataAgentImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new HttpUrlConnectionDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void loadTalksList(final int page, final String accessToken) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                URL url;
                BufferedReader reader = null;
                StringBuilder stringBuilder;

                try {
                    url = new URL(TalksConstants.API_BASE + TalksConstants.GET_TALKS);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setReadTimeout(15 * 1000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    List<NameValuePair> params = new ArrayList<>();
                    params.add(new BasicNameValuePair(TalksConstants.PARAM_ACCESS_TOKEN,accessToken));
                    params.add(new BasicNameValuePair(TalksConstants.PARAM_PAGE,String.valueOf(page)));
                    OutputStream outputStream = connection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(outputStream, "UTF-8"));
                    writer.write(getQuery(params));
                    writer.flush();
                    writer.close();
                    outputStream.close();
                    connection.connect();
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    stringBuilder = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }
                    String responseString = stringBuilder.toString();

                    return responseString;


                } catch (Exception e) {
                    Log.e("", e.getMessage());

                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }

                }

                return null;
            }

            @Override
            protected void onPostExecute(String responseString) {
                super.onPostExecute(responseString);
                Gson gson = new Gson();
                GetTalksResponse talksResponse = gson.fromJson(responseString, GetTalksResponse.class);
                Log.d("onPostExecute","Talks List Size : "+talksResponse.getTedTalks().size());

                if(talksResponse.isResponseOK()){
                    SuccessGetTalksEvent event = new SuccessGetTalksEvent(talksResponse.getTedTalks());
                    EventBus.getDefault().post(event);
                }else{
                    ApiErrorEvent event = new ApiErrorEvent(talksResponse.getMessage());
                    EventBus.getDefault().post(event);
                }
            }
        }.execute();
    }


    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }



}

