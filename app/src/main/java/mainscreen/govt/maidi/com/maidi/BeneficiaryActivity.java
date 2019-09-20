package mainscreen.govt.maidi.com.maidi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class BeneficiaryActivity extends Activity {
    ProgressDialog progressDialog;
    URL url;
    String responseText;
    StringBuffer response;


    EditText mobileNumber;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficiary);
        Button button = (Button) findViewById(R.id.button);
        mobileNumber = (EditText) findViewById(R.id.edtext1);



/*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                */
        /**//*

                String mobile = mobileNumber.getText().toString();
             //  new GetServerData().execute(mobile);
            }

        });
    }
*/


        class GetServerData extends AsyncTask<String, Integer, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                // Showing progress dialog
                progressDialog = new ProgressDialog(BeneficiaryActivity.this);
                progressDialog.setMessage("Progressing...");
                progressDialog.setCancelable(false);
                progressDialog.show();

            }


            @Override
            protected String doInBackground(String... dat) {

                String data = getWebServiceResponseData(dat);

                return data;
            }


            @Override
            protected void onPostExecute(String da) {
                super.onPostExecute(da);

                // Dismiss the progress dialog
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
                Intent i = new Intent(BeneficiaryActivity.this, MainActivity.class);
                i.putExtra("sessionValue", da);
                startActivity(i);
                // For populating list data

               /* CustomCountryList customCountryList = new CustomCountryList(activity, countries);
                listView.setAdapter(customCountryList);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Toast.makeText(getApplicationContext(), "You Selected " + countries.get(position).getCountryName() + " as Country", Toast.LENGTH_SHORT).show();
                    }
                });*/
            }


            protected String getWebServiceResponseData(String val[]) {
                String details = null;
                String country = null;
                String getOtp = "https://2factor.in/API/V1/6c45af7c-b385-11e9-ade6-0200cd936042/SMS/+91" + val[0] + "/AUTOGEN";
                try {

                    url = new URL(getOtp);

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
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                responseText = response.toString();
                //Call ServerData() method to call webservice and store result in response
                //  response = service.ServerData(path, postDataParams);

                try {
                    // JSONArray jsonarray = new JSONArray(responseText);
                    JSONObject object = new JSONObject(responseText);

                    details = object.getString("Details");


                    System.out.print(details);

                    // Country countryObj=new Country(id,country);
                    //  countries.add(countryObj);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return details;
            }
        }
    }
}


