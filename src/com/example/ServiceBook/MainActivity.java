package com.example.ServiceBook;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
    /**
     * Called when the activity is first created.
     */
    private Spinner spinner;
    private Button btnGoToVaz;
    private Button btnAddVehicle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle(R.string.choose_vehicle);

        btnGoToVaz = (Button) findViewById(R.id.button_vaz);
        btnGoToVaz.setOnClickListener(this);
    }



    public void addListenerOnSpinnerItemSelection(){
        spinner = (Spinner) findViewById(R.id.sortSpinner);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_vaz:
                Intent intent = new Intent(this, VehicleCard.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
