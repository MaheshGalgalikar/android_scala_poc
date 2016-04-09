package cardio.services;

import android.content.Context;
import android.content.Intent;

/**
 * Created by ubu on 4/9/2016.
 */
public class ServiceManager {

    Context context;

    public ServiceManager(Context context) {
        this.context = context;
    }


    public static ServiceManager newInstance(Context context) {

        return new ServiceManager(context);
    }

    public void startFxDataGeneratorService() {

        Intent dsperviceIntent = new Intent(context, DSPService.class);
        context.startService(dsperviceIntent);
    }

    public void stopFxDataGeneratorService() {

        Intent dsperviceIntent = new Intent(context, DSPService.class);
        context.stopService(dsperviceIntent);
    }


}
