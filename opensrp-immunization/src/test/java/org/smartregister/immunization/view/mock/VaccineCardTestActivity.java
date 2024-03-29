package org.smartregister.immunization.view.mock;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import org.joda.time.DateTime;
import org.mockito.Mockito;
import org.smartregister.domain.Alert;
import org.smartregister.domain.AlertStatus;
import org.smartregister.domain.Photo;
import org.smartregister.immunization.R;
import org.smartregister.immunization.db.VaccineRepo;
import org.smartregister.immunization.domain.VaccineWrapper;
import org.smartregister.immunization.domain.VaccineWrapperTest;
import org.smartregister.immunization.view.VaccineCard;

import java.util.ArrayList;

/**
 * Created by real on 05/11/17.
 */

public class VaccineCardTestActivity extends Activity implements View.OnClickListener {

    private VaccineCard view;

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCreate(Bundle bundle) {
        setTheme(R.style.AppTheme); //we need this here
        super.onCreate(bundle);
        LinearLayout linearLayout;
        linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public VaccineCard getInstance() {
        return (view == null) ? new VaccineCard(this) : view;
    }

    public VaccineCard getInstance1() {
        return new VaccineCard(this, ViewAttributes.attrs);
    }

    public VaccineCard getInstance2() {
        return new VaccineCard(this, ViewAttributes.attrs, 0);
    }

    public VaccineCard getInstance3() {
        return new VaccineCard(this, ViewAttributes.attrs, 0, 0);
    }

    public ArrayList<VaccineWrapper> vaccineWrapperList() {
        DateTime datetime = new DateTime();
        Alert alert = new Alert("", "", "", AlertStatus.complete, "", "");
        VaccineWrapper tag = new VaccineWrapper();
        tag.setId(VaccineWrapperTest.ID);
        tag.setDbKey(0l);
        tag.setStatus(VaccineWrapperTest.STATUS);
        tag.setVaccine(VaccineRepo.Vaccine.bcg);
        tag.setVaccineDate(datetime);
        tag.setAlert(alert);
        tag.setName(VaccineWrapperTest.NAME);
        tag.setPreviousVaccine(VaccineWrapperTest.ID);
        tag.setCompact(true);
        tag.setColor(VaccineWrapperTest.COLOR);
        tag.setFormattedVaccineDate(VaccineWrapperTest.DD_MM_YYYY);
        tag.setExistingAge(VaccineWrapperTest.AGE);
        tag.setPatientName(VaccineWrapperTest.PATIENTNAME);
        tag.setUpdatedVaccineDate(datetime, true);
        tag.setPatientNumber(VaccineWrapperTest.NUMBER);
        Photo photo = Mockito.mock(Photo.class);
        tag.setPhoto(photo);
        tag.setGender(VaccineWrapperTest.GENDER);
        tag.setDefaultName(VaccineWrapperTest.DEFAULTNAME);
        tag.setSynced(true);

        ArrayList<VaccineWrapper> taglist = new ArrayList<VaccineWrapper>();
        taglist.add(tag);
        return taglist;
    }

}
