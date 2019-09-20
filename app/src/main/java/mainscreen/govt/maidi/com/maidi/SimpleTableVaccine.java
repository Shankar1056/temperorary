package mainscreen.govt.maidi.com.maidi;

import android.app.Activity;
import android.os.Bundle;

import tablefixheaders.TableFixHeaders;
import tablefixheaders.adapters.MatrixTableAdapter;

public class SimpleTableVaccine extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);

		TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
		MatrixTableAdapter<String> matrixTableAdapter = new MatrixTableAdapter<String>(this, new String[][] {
				{
						"Child Name",
						"Reg ID",
						"DOB(01/01/2019)",
						"15/02/2019",
						"15/03/2019",
						"01/09/2019"


/*"IPV1",
						"MMR1",
						"DPT1",
						"DPT2"*/
				},
				{
						"Swetha",
						"MP0771",
						"pv-o"+"Hep-B"+"BCG",
						"pv-o"+"Hep-B"+"BCG",
						"pv-o"+"Hep-B"+"BCG",
						"pv-o"+"Hep-B"+"BCG"

						},
				/*{
						"Anjali",
						"MP2019",
						"pv-o"+"Hep-B"+"BCG",
						"pv-o"+"Hep-B"+"BCG",
						"pv-o"+"Hep-B"+"BCG",
						"pv-o"+"Hep-B"+"BCG"

				},*/
				/*{
						"OPV1",
						"09/08/2019"
						 },
				{
						"OPV2",
						"01/06/2019"
						},
				{
						"IPV1",
						"15/02/2019"
						 },
				{
						"MMR1",
						"18/01/2018"
						},
				{
						"DPT1",
						"14/03/2017"
						},
				{
						"DPT2",
						"18/01/2018"
						 },*/
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
