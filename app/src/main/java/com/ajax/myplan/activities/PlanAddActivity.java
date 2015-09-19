package com.ajax.myplan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.ajaxshang.MyPlan.Base.PlanClass;
import com.ajaxshang.MyPlan.R;
import com.ajaxshang.MyPlan.Utils.DateUtils;
import com.ajaxshang.MyPlan.adapters.DBAdapter;

/**
 * Created by ajax on 2015/6/24.
 */

public class PlanAddActivity extends BaseActivity implements View.OnClickListener {
    private Button save;
    private Button starttime_btn;
    private Button endtime_btn;
    private EditText details;
    private TextView starttime_text;
    private TextView endtime_text;
    private DBAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planadd);
        db = new DBAdapter().getInstance(this);
        db.open();
        save = (Button) this.findViewById(R.id.planadd_save_btn);
        starttime_btn = (Button) this.findViewById(R.id.planadd_starttime_btn);
        endtime_btn = (Button) this.findViewById(R.id.planadd_endtime_btn);
        details = (EditText) this.findViewById(R.id.planadd_details);
        starttime_text = (TextView) this.findViewById(R.id.planadd_starttime_text);
        endtime_text = (TextView) this.findViewById(R.id.plandd_endtime_text);

        save.setOnClickListener(this);
        starttime_btn.setOnClickListener(this);
        endtime_btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.planadd_save_btn:
                long num = 0;
                String plan = details.getText().toString().trim();
                String starttime = DateUtils.getFormatDate();
                String endtime = "2015/10/1 08:00:00";
                PlanClass planClass = new PlanClass(plan, starttime, endtime, true, true, true, true);
                System.out.println("----onClick-----");
                System.out.println("plan isactivate:" + planClass.isactivate());

                num = db.insertPlan(planClass);
                System.out.println("--------->" + num);
                if (num != 0) {
                    showShortTos(getApplicationContext(), "save success");
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), MainActivity.class);
//                    startActivity(intent);
                    startActivityForResult(intent,RESULT_OK);
                    finish();
                } else {
                    showShortTos(getApplicationContext(), "save failed");
                }
                break;
            case R.id.planadd_starttime_btn:
                /**
                 *  -------------chose start time---------------
                 */

                break;
            case R.id.planadd_endtime_btn:
                /**
                 *  -------------chose end time---------------
                 */
                break;
        }
    }
}
