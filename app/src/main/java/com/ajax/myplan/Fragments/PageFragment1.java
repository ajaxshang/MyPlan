package com.ajax.myplan.Fragments;///*
// * Copyright (C) 2012 yueyueniao
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package com.ajaxshang.MyPlan.Fragments;
//
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListView;
//import com.ajaxshang.MyPlan.R;
//import com.ajaxshang.MyPlan.adapters.TodayPlanAdapter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class PageFragment1 extends Fragment {
//
//    private ListView listView;
//    private TodayPlanAdapter adapter;
//    private List<String> list = new ArrayList<String>();
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.page1, null);
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        listView = (ListView) view.findViewById(R.id.plan_list);
//        adapter = new TodayPlanAdapter();
//        adapter.setData(getActivity(), list);
//        listView.setAdapter(adapter);
//
//        return view;
//    }
//
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//    }
//
//}
//
