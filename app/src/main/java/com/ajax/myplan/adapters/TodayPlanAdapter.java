package com.ajax.myplan.adapters;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.ajax.myplan.Base.PlanClass;
import com.ajax.myplan.activities.MainActivity;
import com.ajaxshang.MyPlan.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajax on 2015/6/23.
 */
public class TodayPlanAdapter extends BaseAdapter {
    private List<PlanClass> list = new ArrayList<PlanClass>();
    private Context mContext;
    private LayoutInflater mInflater;
    private Notification.Builder builder;
    private NotificationManager manager;
    private DBAdapter adapter;

    public void setData(Context context, List<PlanClass> list) {
        this.list = list;
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        adapter = DBAdapter.getInstance(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.planitem, null);
            convertView.setTag(holder);
            holder.activate = (Switch) convertView.findViewById(R.id.isActivate);
            holder.details = (TextView) convertView.findViewById(R.id.item_details_text);
            holder.time = (TextView) convertView.findViewById(R.id.itme_time_text);
            holder.date = (TextView) convertView.findViewById(R.id.itme_date_text);
            holder.week = (TextView) convertView.findViewById(R.id.itme_week_text);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final PlanClass planClass = list.get(position);
        if (planClass.isactivate()) {
            holder.activate.setChecked(true);
            /**
             *  ----------以下添加各种提醒方法-----------
             */

        }
        holder.date.setText(planClass.getRowID() + "");
        holder.time.setText(planClass.getStarttime());
        holder.week.setText(planClass.getEndtime());
        holder.details.setText(planClass.getDetails());

        holder.activate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    System.out.println("激活计划");
                    /**
                     * --------更新数据库数据------------
                     */
                    planClass.setIsactivate(true);
                    adapter.updatePlan(planClass);


                } else {
                    System.out.println("取消计划");
                    /**
                     * --------更新数据库数据------------
                     */
                    planClass.setIsactivate(false);
                    adapter.updatePlan(planClass);
                }
            }
        });

        System.out.println("position:" + position);
        System.out.println(planClass.getRowID() + "");
        System.out.println(planClass.getDetails() + "");
        System.out.println(planClass.getStarttime() + "");
        System.out.println(planClass.getEndtime() + "");
        System.out.println(planClass.isactivate() + "");
        System.out.println(planClass.isday() + "");
        System.out.println(planClass.isexpire() + "");
        System.out.println(planClass.isweek() + "");
        return convertView;
    }

    public final class ViewHolder {
        TextView details;          // 提醒内容
        TextView time;             // 提醒时间
        TextView date;             // 提醒日期
        TextView week;             // 提醒星期几
        Switch activate;           // 是否激活

    }

    private void showNotification() {
        manager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        // 设置通知的属性:至少包含一个小图标，标题，内容
        builder = new Notification.Builder(mContext);
        builder.setTicker("有短信来了");
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("晚上有时间吗？");
        builder.setContentText("老地方见!!");

        builder.setDefaults(Notification.DEFAULT_SOUND
                | Notification.DEFAULT_VIBRATE);

        Intent intent = new Intent(mContext, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                mContext, 1, intent,
                PendingIntent.FLAG_ONE_SHOT);
        builder.setContentIntent(pendingIntent);
        manager.notify((int) System.currentTimeMillis(),
                builder.build());
    }
}
