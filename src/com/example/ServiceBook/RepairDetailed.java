package com.example.ServiceBook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by admin on 25.04.2015.
 */
public class RepairDetailed extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repair_detailed);

        ListView repairInfoList = (ListView) findViewById(R.id.repairInfo);
        final String[] repairInfo = getResources().getStringArray(R.array.repair_info);
        ArrayAdapter riAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, repairInfo);
        repairInfoList.setAdapter(riAdapter);

        ListView repairSpendingList = (ListView) findViewById(R.id.repairSpending);
        final String[] repairSpending = getResources().getStringArray(R.array.repair_spending);
        ArrayAdapter rsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, repairSpending);
        repairSpendingList.setAdapter(rsAdapter);
    }
}