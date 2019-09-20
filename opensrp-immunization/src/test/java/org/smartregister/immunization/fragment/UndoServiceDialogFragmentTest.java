package org.smartregister.immunization.fragment;

import android.content.Intent;
import android.util.Log;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.smartregister.CoreLibrary;
import org.smartregister.immunization.BaseUnitTest;
import org.smartregister.immunization.R;
import org.smartregister.immunization.customshadows.FontTextViewShadow;
import org.smartregister.immunization.domain.ServiceWrapper;
import org.smartregister.immunization.fragment.mock.UndoServiceDialogFragmentTestActivity;

/**
 * Created by onaio on 30/08/2017.
 */
@Config (shadows = {FontTextViewShadow.class})
public class UndoServiceDialogFragmentTest extends BaseUnitTest {

    private ActivityController<UndoServiceDialogFragmentTestActivity> controller;

    @InjectMocks
    private UndoServiceDialogFragmentTestActivity activity;

    @Mock
    private org.smartregister.Context context_;

    @Before
    public void setUp() {
        CoreLibrary.init(context_);
        org.mockito.MockitoAnnotations.initMocks(this);

        activity = Robolectric.buildActivity(UndoServiceDialogFragmentTestActivity.class).create().start().get();
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
    public void assertThatCallToNewInstanceCreatesAFragment() {
        junit.framework.Assert.assertNotNull(UndoServiceDialogFragment.newInstance(new ServiceWrapper()));
    }

    @Test
    public void assertOnCreateViewTestSetsUpTheActivity() throws Exception {
        destroyController();
        Intent intent = new Intent(RuntimeEnvironment.application, UndoServiceDialogFragmentTestActivity.class);
        controller = Robolectric.buildActivity(UndoServiceDialogFragmentTestActivity.class, intent);
        activity = controller.get();
        controller.setup();
        Assert.assertNotNull(activity);
    }
}
