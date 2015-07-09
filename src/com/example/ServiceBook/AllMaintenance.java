package com.example.ServiceBook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by admin on 23.04.2015.
 */
public class AllMaintenance extends Activity implements View.OnClickListener{
    private MaintenanceList maintenanceList;
    private MaintenanceAdapter adapter;
    private ListView lvMaintenance;
    private Vehicle vehicle;
    private Button btnAddReplacement;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_maintenance);
        setTitle(R.string.all_maintenance);

        lvMaintenance = (ListView) findViewById(R.id.lvMaintenance);
        Intent box = getIntent();
        vehicle = (Vehicle) box.getSerializableExtra("KEY1");
        maintenanceList = vehicle.getMaintenanceList();

        btnAddReplacement = (Button) findViewById(R.id.btn_add_replacement);
        btnAddReplacement.setOnClickListener(this);

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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_replacement:
                Intent intent = new Intent(this, MaintenanceDetailed.class);
                intent.putExtra("KEY1", vehicle);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}