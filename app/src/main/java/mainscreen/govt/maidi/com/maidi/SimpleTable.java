package mainscreen.govt.maidi.com.maidi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import pojo.ChildRegisterResponse;
import pojo.Reportwriting;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tablefixheaders.TableFixHeaders;
import tablefixheaders.adapters.MatrixTableAdapter;
import tablefixheaders.adapters.SampleTableAdapter;
import tablefixheaders.adapters.SampleTableAdapter;

public class SimpleTable extends Activity {
	ProgressDialog pd = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);
		APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
		//SimpleTable report = new SimpleTable();
		Call<ChildRegisterResponse> call1 = apiInterface.SimpleTable();
		call1.enqueue(new Callback<ChildRegisterResponse>() {

			public void onResponse(Call<ChildRegisterResponse> call, Response<ChildRegisterResponse> response) {
				ChildRegisterResponse user1 = response.body();
				pd.dismiss();
                        /*AlertDialog.Builder builder = new AlertDialog.Builder(
                                OtpVerifyActivty.this);
                        builder.setTitle(" Report Writing");
                        builder.setMessage("Successfully Report is registered");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                       *//* Intent child = new Intent(getApplicationContext(), Modules1Activity.class);
                                        startActivity(child);*//*
                                    }
                                });
                        builder.show();

                        //  Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
*/
			}

			public void onFailure(Call<ChildRegisterResponse> call, Throwable t) {
				/*call.cancel();
				pd.dismiss();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						SimpleTable.this);
				builder.setTitle("Report Writing");
				builder.setMessage("Report Writing register Error");
				builder.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
												int which) {
                                        *//*Intent child = new Intent(getApplicationContext(), Modules1Activity.class);
                                        startActivity(child);*//*
								pd.dismiss();
							}
						});
				builder.show();*/
			}
		});




		TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
		MatrixTableAdapter<String> matrixTableAdapter = new MatrixTableAdapter<String>(this, new String[][] {
				{
						"Name",
						"DOB",
						"Reg ID",
						"BCG",
						"OPV1",
						"OPV2"


/*"IPV1",
				"OPV3"		"MMR1",
						"DPT1",
						"Swetha",
						"MP0771",
						"DPT2"*/
				},
				{
						"Swetha",
						"1/01/2019",
						"MP0771",
						"15/02/2019",
						"15/03/2019",
						"19/07/2019"
						},
				/*{
						"Rahual",
						"09/08/2019",
						"MP2487",
						"17/06/2019",
						"17/08/2019",
						"17/06/2019" },
				{
						"Semma",
						"01/06/2019",
						"MP8761",
						"13/08/2019",
						"15/07/2019",
						"13/08/2019"},
				{
						"DeshaPandu",
						"15/02/2019",
						"MP9808",
						"18/07/2019",
						"12/01/2019",
						"18/07/2019" },
				{
						"Singhdr",
						"18/01/2018",
						"MP8970",
						"17/08/2019",
						"13/09/2018",
						"17/08/2019"},
				{
						"Meera",
						"14/03/2017",
						"MP6785",
						"15/07/2019",
						"15/09/2018",
						"15/07/2019",
						"15/07/2019" },
				{
						"Singhdr",
						"18/01/2018",
						"MP8970",
						"12/01/2019",
						"13/09/2018",
						"15/09/2018" },*/
				/*{
						"14/07/2019",
						"17/06/2019",
						"13/08/2019",
						"18/07/2019",
						"17/08/2019",
						"15/07/2019" },
				{
						"18/07/2019",
						"17/08/2019",
						"15/07/2019",
						"12/01/2019",
						"13/09/2018",
						"15/09/2018" },
				{
						"14/07/2019",
						"17/06/2019",
						"13/08/2019",
						"18/07/2019",
						"17/08/2019",
						"15/07/2019" },*/
		});
		tableFixHeaders.setAdapter(matrixTableAdapter);
	}
}
