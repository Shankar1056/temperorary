package org.smartregister.immunization.fragment;

import android.content.Intent;
import android.util.Log;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.smartregister.CoreLibrary;
import org.smartregister.immunization.BaseUnitTest;
import org.smartregister.immunization.R;
import org.smartregister.immunization.domain.VaccineWrapper;
import org.smartregister.immunization.fragment.mock.UndoVaccinationDialogFragmentTestActivity;

/**
 * Created by onaio on 30/08/2017.
 */

public class UndoVaccinationDialogFragmentTest extends BaseUnitTest {

    private ActivityController<UndoVaccinationDialogFragmentTestActivity> controller;

    @InjectMocks
    private UndoVaccinationDialogFragmentTestActivity activity;

    @Mock
    private org.smartregister.Context context_;

    @Before
    public void setUp() {
        CoreLibrary.init(context_);
        org.mockito.MockitoAnnotations.initMocks(this);

        activity = Robolectric.buildActivity(UndoVaccinationDialogFragmentTestActivity.class).create().start().get();
        activity.setContentView(R.layout.service_dialog_view);
    }

    @After
    public void tearDown() {
        destroyController();
        activity = null;
        controller = null;

    }

    private void destroyController() {
        try {
            activity.finish();
            controller.pause().stop().destroy(); //destroy controller if we can
        } catch (Exception e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
        System.gc();
    }

    @Test
    public void assertOnCreateViewTestSetsUpTheActivity() {
        destroyController();
        Intent intent = new Intent(RuntimeEnvironment.application, UndoVaccinationDialogFragmentTestActivity.class);
        controller = Robolectric.buildActivity(UndoVaccinationDialogFragmentTestActivity.class, intent);
        activity = controller.get();
        controller.setup();
        Assert.assertNotNull(activity);
    }

    @Test
    public void assertThatCallToNewInstanceCreatesAFragment() {
        Assert.assertNotNull(UndoVaccinationDialogFragment.newInstance(new VaccineWrapper()));
    }


}
