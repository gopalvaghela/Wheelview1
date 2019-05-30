package com.t.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private WheelView mainWheelView, subWheelView, childWheelView, hourWheelView, minuteWheelView, secondWheelView,
            commonWheelView,
            simpleWheelView, myWheelView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleWheelView = (WheelView) findViewById(R.id.simple_wheelview);
        simpleWheelView.setWheelAdapter(new SimpleWheelAdapter(this));
        simpleWheelView.setWheelSize(5);
        simpleWheelView.setWheelData(createDatas());
        simpleWheelView.setSkin(WheelView.Skin.None);
        simpleWheelView.setLoop(true);
        simpleWheelView.setWheelClickable(true);
        simpleWheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onItemClick(int position, Object o) {
                WheelUtils.log("click:" + position);
            }
        });
        simpleWheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener<WheelData>() {
            @Override
            public void onItemSelected(int position, WheelData data) {
                WheelUtils.log("selected:" + position);
            }
        });
    }
    private ArrayList<WheelData> createDatas() {
        ArrayList<WheelData> list = new ArrayList<WheelData>();
        WheelData item;
        for (int i = 0; i < 20; i++) {
            item = new WheelData();
            item.setId(R.mipmap.ic_launcher);
            item.setName((i < 10) ? ("0" + i) : ("" + i));
            list.add(item);
        }
        return list;
    }
}
