package com.example.ServiceBook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by admin on 23.04.2015.
 */
public class AllMaintenance extends Activity {
    private MaintenanceList maintenanceList;
    private MaintenanceAdapter adapter;
    private ListView lvMaintenance;
    private Vehicle vehicle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_maintenance);
        setTitle(R.string.all_maintenance);

        lvMaintenance = (ListView) findViewById(R.id.lvMaintenance);
        Intent box = getIntent();
        vehicle = (Vehicle) box.getSerializableExtra("KEY1");
        maintenanceList = vehicle.getMaintenanceList();

        createMaintenance();
        fillList();
    }

    public void fillList(){
        adapter = MaintenanceAdapter.getInstance(this, maintenanceList);
        lvMaintenance.setAdapter(adapter);
    }

    public void createMaintenance(){
        Random r = new Random();
        Calendar c = Calendar.getInstance();
        c.roll(Calendar.YEAR, -25);
        long date = c.getTimeInMillis();
        for (int i = 0; i < 7; i++) {
            Maintenance maintenance = new Maintenance();
            maintenance.setMileage(i);
            maintenance.setDate(r.nextLong() % date);
            maintenanceList.addMaintenance(maintenance);
        }
    }
}