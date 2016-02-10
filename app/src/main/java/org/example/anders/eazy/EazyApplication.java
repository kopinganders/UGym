package org.example.anders.eazy;

/**
 * Created by Anders on 2016-02-02.
 */

import android.app.Application;
import com.firebase.client.Firebase;

/**
 * Initialize Firebase with the application context. This must happen before the client is used.
 */
public class EazyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}