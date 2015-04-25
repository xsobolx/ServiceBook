package com.example.ServiceBook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by admin on 23.04.2015.
 */
public class AllMaintenance extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_maintenance);
        setTitle(R.string.all_maintenance);

        ListView allMaintenanceList = (ListView) findViewById(R.id.allMaintenanceList);
        final String[] allMaintenance = getResources().getStringArray(R.array.all_maintenance);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, allMaintenance);
        allMaintenanceList.setAdapter(adapter);

        allMaintenanceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(AllMaintenance.this, MaintenanceDetailed.class));
            }
        });
    }
}