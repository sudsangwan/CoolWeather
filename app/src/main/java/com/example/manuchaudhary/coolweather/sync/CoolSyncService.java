package com.example.manuchaudhary.coolweather.sync;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.app.Service;

public class CoolSyncService extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static CoolSyncAdapter sCoolSyncAdapter = null;

    @Override
    public void onCreate() {
        Log.d("CoolSyncService", "onCreate - CoolSyncService");
        synchronized (sSyncAdapterLock) {
            if (sCoolSyncAdapter == null) {
                sCoolSyncAdapter = new CoolSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sCoolSyncAdapter.getSyncAdapterBinder();
    }
}
