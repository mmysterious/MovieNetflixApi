package onlyme.sengupta.mon.observerpattern;

import android.app.Application;

/**
 * Created by mondrita on 11/11/16.
 */
public class OverserPatternApp extends Application {

    private static OverserPatternApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance= this;
    }

    public static OverserPatternApp getInstance() {
        return instance;
    }
}
