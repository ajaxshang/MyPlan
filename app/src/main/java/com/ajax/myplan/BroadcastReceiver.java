package com.ajax.myplan;

import android.content.Context;
import android.content.Intent;
import com.ajaxshang.MyPlan.Services.NotificationServices;

/**
 * Created by ajax on 2015/7/15.
 */
public class BroadcastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent startServiceIntent = new Intent(context, NotificationServices.class);
            startServiceIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startService(startServiceIntent);
        }
    }
}
