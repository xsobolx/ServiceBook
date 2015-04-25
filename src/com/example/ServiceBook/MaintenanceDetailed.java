package com.example.ServiceBook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by admin on 25.04.2015.
 */
public class MaintenanceDetailed extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maintenance_deatailed);

        ListView replaceList = (ListView) findViewById(R.id.replaceList);
        final String[] replaced = getResources().getStringArray(R.array.replace_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, replaced);
        replaceList.setAdapter(adapter);
    }
}