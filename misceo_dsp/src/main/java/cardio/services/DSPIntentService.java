package cardio.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import cardio.peak.PeakDetectionAnalysis;
import scala.collection.Seq;

/**
 * Created by ubu on 4/9/2016.
 */
public class DSPIntentService extends IntentService {

    public DSPIntentService() {
        super("DSPIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String inputFileName = "ecg1.csv";
        PeakDetectionAnalysis.performAnalysis(50d, inputFileName);

        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(
                "dsp_csv", Context.MODE_PRIVATE).edit();
        editor.putString(DSPService.DATA_PACKET, "DSPIntentService sample data");
        editor.apply();
    }
}
