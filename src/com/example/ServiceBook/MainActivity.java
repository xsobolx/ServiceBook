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
