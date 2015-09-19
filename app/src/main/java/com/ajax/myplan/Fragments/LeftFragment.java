/*
 * Copyright (C) 2012 yueyueniao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ajax.myplan.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.ajaxshang.MyPlan.R;

public class LeftFragment extends Fragment implements View.OnClickListener {
    private TextView yesterday, today, tomorrow, everyweek, summary, setting;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left, null);
        yesterday = (TextView) view.findViewById(R.id.plan_yesterday_textview);
        today = (TextView) view.findViewById(R.id.plan_today_textview);
        tomorrow = (TextView) view.findViewById(R.id.plan_tomorrow_textview);
        everyweek = (TextView) view.findViewById(R.id.plan_everyweek_textview);
        summary = (TextView) view.findViewById(R.id.plan_summary_textview);
        setting = (TextView) view.findViewById(R.id.plan_setting_textview);

        yesterday.setOnClickListener(this);
        today.setOnClickListener(this);
        tomorrow.setOnClickListener(this);
        everyweek.setOnClickListener(this);
        summary.setOnClickListener(this);
        setting.setOnClickListener(this);

        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plan_yesterday_textview:
                Toast.makeText(getActivity(), "yesterday", Toast.LENGTH_SHORT).show();
                break;
            case R.id.plan_today_textview:
                Toast.makeText(getActivity(), "today", Toast.LENGTH_SHORT).show();
                break;
            case R.id.plan_tomorrow_textview:
                Toast.makeText(getActivity(), "tomorrow", Toast.LENGTH_SHORT).show();
                break;
            case R.id.plan_everyweek_textview:
                Toast.makeText(getActivity(), "everyweek", Toast.LENGTH_SHORT).show();
                break;
            case R.id.plan_summary_textview:
                Toast.makeText(getActivity(), "summary", Toast.LENGTH_SHORT).show();
                break;
            case R.id.plan_setting_textview:
                Toast.makeText(getActivity(), "setting", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
