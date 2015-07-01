package com.example.ServiceBook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity implements OnClickListener{
    /**
     * Called when the activity is first created.
     */
    private Spinner spinner;
    private Button btnAddVehicle;
    private VehicleList vehicleList;
    private VehicleAdapter adapter;
    private ListView lvVehicles;
    Vehicle vehicle = new Vehicle();
    Vehicle vehicle1 = new Vehicle();
    Vehicle vehicle2 = new Vehicle();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle(R.string.choose_vehicle);

        vehicleList = VehicleList.getInstance(this);
        lvVehicles = (ListView) findViewById(R.id.lvVehicles);

//
        fillList();

        lvVehicles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), VehicleCard.class);
                Vehicle v = vehicleList.getVehicle(position);
                intent.putExtra("KEY1", v);
                startActivity(intent);
            }
        });

        btnAddVehicle = (Button) findViewById(R.id.button_add_vehicle);
        btnAddVehicle.setOnClickListener(this);
    }



    public void addListenerOnSpinnerItemSelection(){
        spinner = (Spinner) findViewById(R.id.sortSpinner);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void addVehicles(){
        vehicle.setBrand("VAZ");
        vehicle.setModel("110");
        vehicle.setGraduationYear("1995");
        vehicle.setMileage(124987);

        vehicle1.setBrand("VAZ");
        vehicle1.setModel("2110");
        vehicle1.setGraduationYear("1992");
        vehicle1.setMileage(145676);

        vehicle2.setBrand("VAZ");
        vehicle2.setModel("2110");
        vehicle2.setGraduationYear("1983");
        vehicle2.setMileage(345987);

        vehicleList.addVehicle(vehicle);
        vehicleList.addVehicle(vehicle1);
        vehicleList.addVehicle(vehicle2);
    }

    public void fillList(){
        adapter = VehicleAdapter.getInstance(this, VehicleList.getInstance(this));
        lvVehicles.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_add_vehicle:
                startActivity(new Intent(this, AddVehicle.class));
                break;
            default:
                break;
        }
    }
}
