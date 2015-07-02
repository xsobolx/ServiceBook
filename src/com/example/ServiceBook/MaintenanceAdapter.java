package com.example.ServiceBook;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by admin on 01.07.2015.
 */
public class MaintenanceAdapter extends BaseAdapter {
    private MaintenanceList maintenanceList;
    private Context context;
    private static MaintenanceAdapter sMaintenanceAdapter;

    public MaintenanceAdapter(Context appContext, MaintenanceList mList){
        this.context = appContext;
        this.maintenanceList = mList;
    }

    public static MaintenanceAdapter getInstance(Context c, MaintenanceList ml){
        if (sMaintenanceAdapter == null){
            sMaintenanceAdapter = new MaintenanceAdapter(c, ml);
        }
        return sMaintenanceAdapter;
    }


    @Override
    public int getCount() {
        return maintenanceList.getCount();
    }

    @Override
    public Object getItem(int position) {
        return maintenanceList.getMaintenance(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.maintenance_list_item, null);
        fillView(convertView, position);
        return convertView;
    }

    public void fillView(View v, int position){
        Maintenance maintenance = maintenanceList.getMaintenance(position);
        View maintenanceView = v;

        if(maintenanceView == null)
            maintenanceView = LayoutInflater.from(context).inflate(R.layout.maintenance_list_item, null);

        TextView tvMileage = (TextView) maintenanceView.findViewById(R.id.tvMaintenanceMileage);
        tvMileage.setText("Пробег: " + maintenance.getMileage() + " км");

        TextView tvMaintenanceDate = (TextView) maintenanceView.findViewById(R.id.tvMaintenanceDate);
        tvMaintenanceDate.setText(DateFormat.format("dd.MM.yyyy", maintenance.getDate()));
    }
}
