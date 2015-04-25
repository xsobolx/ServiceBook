package com.example.ServiceBook;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by admin on 23.04.2015.
 */
public class VehicleCard extends Activity implements View.OnClickListener {
    Button btnGotoMaintenance;
    Button btnGotoRepairs;
    Button btnGotoSpending;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_card);
        setTitle(R.string.vehicle_card);


//        TODO добавить фото ТС
//        ImageView imageView = (ImageView) findViewById(R.id.auto_photo);
//        imageView.setImageResource(R.drawable.vazz2106);

//        Краткая информация о ТС
        ListView vehicleInfoList = (ListView) findViewById(R.id.vehicle_info);
        final String[] vehicleInfo = getResources().getStringArray(R.array.vehicle_info);
        ArrayAdapter<String> vehicleAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, vehicleInfo);
        vehicleInfoList.setAdapter(vehicleAdapter);

//        Информация о последнем ТО
        ListView lastMaintenanceInfoList = (ListView) findViewById(R.id.lastMaintenanceInfo);
        final String[] lastMaintenanceInfo = getResources().getStringArray(R.array.last_maintenance_info);
        ArrayAdapter<String> lmAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lastMaintenanceInfo);
        lastMaintenanceInfoList.setAdapter(lmAdapter);

        //        Иформация о последнем ремонте
        ListView lastRepairInfoList = (ListView) findViewById(R.id.lastRepairInfo);
        final String[] lastRepairInfo = getResources().getStringArray(R.array.last_repair_info);
        ArrayAdapter<String> lrAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lastRepairInfo);
        lastRepairInfoList.setAdapter(lrAdapter);

//        Информация о затратах
        ListView spendingInfoList = (ListView) findViewById(R.id.spendingInfo);
        final String[] spendingInfo = getResources().getStringArray(R.array.main_spending);
        ArrayAdapter<String> spendingAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, spendingInfo);
        spendingInfoList.setAdapter(spendingAdapter);

//      Прослушка кнопок
        btnGotoMaintenance = (Button) findViewById(R.id.btn_all_maintenance);
        btnGotoMaintenance.setOnClickListener(this);

        btnGotoRepairs = (Button) findViewById(R.id.btn_all_repairs);
        btnGotoRepairs.setOnClickListener(this);

        btnGotoSpending = (Button) findViewById(R.id.btn_spending);
        btnGotoSpending.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_all_maintenance:
                Intent intent = new Intent(this, AllMaintenance.class);
                startActivity(intent);
                break;
            case R.id.btn_all_repairs:
                startActivity(new Intent(this, AllRepairs.class));
            default:
                break;
        }
    }
}