package mainscreen.govt.maidi.com.maidi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    URL url;
    String responseText;
    StringBuffer response;
    String sessionId;
    String otpValue;
    EditText otpVerfiy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit =(Button)findViewById(R.id.btnLogin);
        otpVerfiy = (EditText)findViewById(R.id.editText);

        Intent intent = getIntent();

        sessionId =intent.getStringExtra("sessionValue");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**/
                otpValue = otpVerfiy.getText().toString();


                new GetServerData().execute();
            }
        });

    }
    class GetServerData extends AsyncTask<String,Integer,String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Progressing...");
            progressDialog.setCancelable(false);
            progressDialog.show();

        }

        @Override
        protected String doInBackground(String...params) {

            String data = getWebServiceResponseData();


            return data;
        }

        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);

            // Dismiss the progress dialog
            if (progressDialog.isShowing())
                progressDialog.dismiss();
            if(o.equalsIgnoreCase("OTP Matched")) {
                Toast.makeText(getApplicationContext(),"OTP Matched",Toast.LENGTH_SHORT).show();
                Intent but = new Intent(getApplicationContext(), DashboardScreen.class);
                startActivity(but);
            }else{
                Toast.makeText(getApplicationContext(),"OTP Mismatched",Toast.LENGTH_SHORT).show();
            }


        }
    }
    protected String getWebServiceResponseData() {
        String details = null;
        String country = null;
         String validateOtp = "https://2factor.in/API/V1/6c45af7c-b385-11e9-ade6-0200cd936042/SMS/VERIFY/"+sessionId+"/"+otpValue;
        try {

            url = new URL(validateOtp);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();


            if (responseCode == HttpsURLConnection.HTTP_OK) {
                // Reading response from input Stream
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                String output;
                response = new StringBuffer();

                while ((output = in.readLine()) != null) {
                    response.append(output);
                }
                in.close();
            }}
        catch(Exception e){
            e.printStackTrace();
        }

        responseText = response.toString();
        //Call ServerData() method to call webservice and store result in response
        //  response = service.ServerData(path, postDataParams);

        try {
            JSONObject object = new JSONObject(responseText);

            details = object.getString("Details");


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return details;
    }

}
