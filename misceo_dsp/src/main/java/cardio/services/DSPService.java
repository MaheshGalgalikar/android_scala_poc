package cardio.services;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


/**
 * Created by ubu on 4/9/2016.
 */
public class DSPService extends Service  {

    String DEBUG_LOG = "DSPService !!!!!!!! ";

    public final static String DSP_DATA_ACTION = "DSP_DATA_ACTION";
    public final static String  DATA_PACKET = "DATA_PACKET";

    private boolean stopService = false;
    private Thread thread = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(DEBUG_LOG, "onStartCommand  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        if (thread == null) {
            thread = new Thread(new Runnable() {


                @Override
                public void run() {
                    Log.d(DEBUG_LOG, " Runnable  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                    Intent passDspData = new Intent();
                    passDspData.setAction(DSP_DATA_ACTION);
                    passDspData.putExtra(DATA_PACKET, String.format("%s", "THIS IS POP"));
                    sendBroadcast(passDspData);
                    Log.d(DEBUG_LOG, "made it past  sendBroadcast(passDspData)  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }

            });

            Log.d(DEBUG_LOG, " start  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            thread.start();

        } else {
            thread.run();
        }

        return START_STICKY;


    }

}
