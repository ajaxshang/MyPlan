package com.ajax.myplan.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ajax.myplan.Base.PlanClass;
import com.ajax.myplan.Services.NotificationServices;
import com.ajax.myplan.adapters.DBAdapter;
import com.ajax.myplan.adapters.TodayPlanAdapter;
import com.ajaxshang.MyPlan.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements View.OnClickListener {
    //    SlidingMenu mSlidingMenu;
//    LeftFragment leftFragment;
//    RightFragment rightFragment;
//    ViewPageFragment viewPageFragment;
//    private SlidingMenu menu;
    private ListView listView;
    private TodayPlanAdapter adapter;
    private Button addPlan;
    private List<PlanClass> list = new ArrayList<PlanClass>();
    private TextView yesterday, today, tomorrow, everyweek, summary, setting;
    private DBAdapter db;
    private Intent intent = new Intent(MainActivity.this, NotificationServices.class);


    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        System.out.println("MainActivity onCreate....");
//        initMenu();
        listView = (ListView) this.findViewById(R.id.plan_list);


        initView();

        db = new DBAdapter().getInstance(this);
        db.open();
        Cursor cursor = db.getAllPlans();

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                PlanClass planClass = new PlanClass();
                planClass.setRowID(cursor.getLong(cursor.getColumnIndex("_id")));
                planClass.setDetails(cursor.getString(cursor.getColumnIndex("details")));
                planClass.setStarttime(cursor.getString(cursor.getColumnIndex("starttime")));
                planClass.setEndtime(cursor.getString(cursor.getColumnIndex("endtime")));
                if (cursor.getString(cursor.getColumnIndex("isactivate")).equals("1")) {
                    planClass.setIsactivate(true);
                }
                if (cursor.getString(cursor.getColumnIndex("isactivate")).equals("0")) {
                    planClass.setIsactivate(false);
                }

                if (cursor.getString(cursor.getColumnIndex("isday")).equals("1")) {
                    planClass.setIsday(true);
                }
                if (cursor.getString(cursor.getColumnIndex("isday")).equals("0")) {
                    planClass.setIsday(false);
                }
                if (cursor.getString(cursor.getColumnIndex("isweek")).equals("1")) {
                    planClass.setIsweek(true);
                }
                if (cursor.getString(cursor.getColumnIndex("isweek")).equals("0")) {
                    planClass.setIsweek(false);
                }
                if (cursor.getString(cursor.getColumnIndex("isexpire")).equals("1")) {
                    planClass.setIsexpire(true);
                }
                if (cursor.getString(cursor.getColumnIndex("isexpire")).equals("0")) {
                    planClass.setIsexpire(false);
                }
                list.add(planClass);
                adapter = new TodayPlanAdapter();
                adapter.setData(MainActivity.this, list);

                listView.setAdapter(adapter);
            }
        } else {
            Toast.makeText(getApplicationContext(), "暂无数据", Toast.LENGTH_SHORT).show();
        }


    }


    private void initView() {
        addPlan = (Button) this.findViewById(R.id.main_addplan_btn);
        addPlan.setOnClickListener(this);
    }


//    private void initMenu() {
//        menu = new SlidingMenu(this);
//        menu.setMode(SlidingMenu.LEFT);
//        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        menu.setShadowWidthRes(R.dimen.shadow_width);
//        menu.setShadowDrawable(R.drawable.shadow);
//        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
//        menu.setFadeDegree(0.35f);
//        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
//        menu.setMenu(R.layout.left);
//        yesterday = (TextView) menu.findViewById(R.id.plan_yesterday_textview);
//        today = (TextView) menu.findViewById(R.id.plan_today_textview);
//        tomorrow = (TextView) menu.findViewById(R.id.plan_tomorrow_textview);
//        everyweek = (TextView) menu.findViewById(R.id.plan_everyweek_textview);
//        summary = (TextView) menu.findViewById(R.id.plan_summary_textview);
//        setting = (TextView) menu.findViewById(R.id.plan_setting_textview);
//
//        yesterday.setOnClickListener(this);
//        today.setOnClickListener(this);
//        tomorrow.setOnClickListener(this);
//        everyweek.setOnClickListener(this);
//        summary.setOnClickListener(this);
//        setting.setOnClickListener(this);
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (menu.isMenuShowing()) {
//
//            menu.showContent();
//
//        } else {
//
//            super.onBackPressed();
//
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                adapter.notifyDataSetChanged();
                break;
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.plan_yesterday_textview:
                Toast.makeText(MainActivity.this, "yesterday", Toast.LENGTH_SHORT).show();
                startService(intent);
                break;
            case R.id.plan_today_textview:
                Toast.makeText(MainActivity.this, "today", Toast.LENGTH_SHORT).show();

                break;
            case R.id.plan_tomorrow_textview:
                Toast.makeText(MainActivity.this, "tomorrow", Toast.LENGTH_SHORT).show();
                break;
            case R.id.plan_everyweek_textview:
                Toast.makeText(MainActivity.this, "everyweek", Toast.LENGTH_SHORT).show();
                break;
            case R.id.plan_summary_textview:
                Toast.makeText(MainActivity.this, "summary", Toast.LENGTH_SHORT).show();
                break;
            case R.id.plan_setting_textview:
                Toast.makeText(MainActivity.this, "setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_addplan_btn:
                insertPlan();
                break;
        }
    }

    /**
     * 测试方法
     */

    private void insertPlan() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), PlanAddActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    /**
     * 登出
     */

    public void Logout() {
        db.close();
        stopService(intent);
    }
}
