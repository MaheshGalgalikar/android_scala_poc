package cardio.services;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboSharedPreferences;


import cardio.application.BuildConfig;

import static org.junit.Assert.assertNotSame;

/**
 * Created by ubu on 4/9/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk=19)
public class PeakDetectionTest {

    @Test
    public void addsDataToSharedPreference() {
        Application application = RuntimeEnvironment.application;
        RoboSharedPreferences preferences = (RoboSharedPreferences) application
                .getSharedPreferences("dsp_csv", Context.MODE_PRIVATE);

        Intent intent =  new Intent(application, DSPIntentService.class);
        DSPIntentService registrationService = new DSPIntentService();

        registrationService.onHandleIntent(intent);

        assertNotSame("", preferences.getString(DSPService.DATA_PACKET, ""), "");

        System.out.println(preferences.getString(DSPService.DATA_PACKET, ""));

    }


}
