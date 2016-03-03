package com.example.manuchaudhary.coolweather.sync;

import android.content.Intent;
import android.os.IBinder;
import android.app.Service;

/**
 * The service which allows the sync adapter framework to access the authenticator.
 */
public class CoolAuthenticatorService extends Service {
    // Instance field that stores the authenticator object
    private CoolAuthenticator mAuthenticator;

    @Override
    public void onCreate() {
        // Create a new authenticator object
        mAuthenticator = new CoolAuthenticator(this);
    }

    /*
     * When the system binds to this Service to make the RPC call
     * return the authenticator's IBinder.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }
}
