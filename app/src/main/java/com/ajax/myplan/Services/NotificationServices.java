package com.ajax.myplan.Services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.ajax.myplan.adapters.DBAdapter;

/**
 * Created by ajax on 2015/7/15.
 */
public class NotificationServices extends Service {
    AlarmManager manager = null;
    PendingIntent pendingIntent = null;
    DBAdapter db;


    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(getApplicationContext(), NotificationServices.class);
        manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        pendingIntent = PendingIntent.getService(this, 0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
        long now = System.currentTimeMillis();
        manager.setInexactRepeating(AlarmManager.RTC, now, 6000, pendingIntent);
        db = new DBAdapter().getInstance(this);
        db.open();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "Callback Successed!", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * -------------------����ݿ�����ȡ����ʼʱ���ÿ�ռƻ��ļ�����ݽ��м�ʱ��ʾ---------------
     */
    public void startNotification() {

    }

}
