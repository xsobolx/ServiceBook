package com.example.ServiceBook;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by admin on 01.07.2015.
 */
public class MaintenanceList implements Serializable{
    private ArrayList<Maintenance> maintenances;
//    private static MaintenanceList sMaintenanceList;
//    private Context context;
//
//    public MaintenanceList(Context appContext){
//        this.maintenances = new ArrayList<Maintenance>();
//    }
//
//    public static MaintenanceList getInstance(Context c){
//        if(sMaintenanceList == null)
//            sMaintenanceList = new MaintenanceList(c.getApplicationContext());
//        return sMaintenanceList;
//    }
    public MaintenanceList(){
        maintenances = new ArrayList<Maintenance>();
    }

    public void addMaintenance(Maintenance m){
        maintenances.add(m);
    }

    public ArrayList getMaintenances(){
        return maintenances;
    }

    public Maintenance getMaintenance(int position){
        return maintenances.get(position);
    }

    public int getCount(){
        return maintenances.size();
    }
}
