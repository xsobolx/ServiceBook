package com.example.ServiceBook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by admin on 25.04.2015.
 */
public class AllRepairs extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_repairs);

        ListView allRepairsList = (ListView) findViewById(R.id.all_repairs_list);
        final String[] allMaintenance = getResources().getStringArray(R.array.repairs_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, allMaintenance);
        allRepairsList.setAdapter(adapter);

        allRepairsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(AllRepairs.this, RepairDetailed.class));
            }
        });
    }
}