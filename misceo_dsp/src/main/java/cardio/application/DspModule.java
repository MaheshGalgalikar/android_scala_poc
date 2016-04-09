package cardio.application;

import android.app.Application;

/**
 * Created by ubu on 4/9/2016.
 */
public class DspModule  extends Application {
    public static DspModule instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static DspModule getInstance() {

        return instance;
    }

}
