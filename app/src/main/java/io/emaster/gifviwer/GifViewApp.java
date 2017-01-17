package io.emaster.gifviwer;

import android.app.Application;
import android.graphics.Color;
import org.polaric.colorful.Colorful;

/**
 * Created by master on 26/12/2016.
 */
public class GifViewApp  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /*
        Colorful.defaults()
                .primaryColor(Colorful.ThemeColor.RED)
                .accentColor(Colorful.ThemeColor.BLUE)
                .translucent(false)
                .dark(true);
        Colorful.init(this);
        */
        Colorful.init(this);
    }
}
