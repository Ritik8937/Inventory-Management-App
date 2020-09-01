package com.example.arvaria.chambal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.arvaria.AddRecordActivity;
import com.example.arvaria.PersonAdapter;
import com.example.arvaria.PersonDBHelper;
import com.example.arvaria.R;

public class chambal extends AppCompatActivity {
    private RecyclerView cRecyclerView;
    private RecyclerView.LayoutManager cLayoutManager;
    private ChambalDBHelper dbHelper;
    private ChambalAdapter adapter;
    private String filter = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chambal);
        cRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewc);
        cRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        cLayoutManager = new LinearLayoutManager(this);
        cRecyclerView.setLayoutManager(cLayoutManager);

        //populate recyclerview
        populaterecyclerViewc(filter);
    }

    private void populaterecyclerViewc(String filter) {
        dbHelper = new ChambalDBHelper(this);
        adapter = new ChambalAdapter(dbHelper.peopleList(filter), this, cRecyclerView);
        cRecyclerView.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);

        MenuItem item = menu.findItem(R.id.filterSpinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.filterOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String filter = parent.getSelectedItem().toString();
                populaterecyclerViewc(filter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                populaterecyclerViewc(filter);
            }
        });


        spinner.setAdapter(adapter);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.addMenu:
                goToAddChambalActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToAddChambalActivity() {
        Toast.makeText(getApplicationContext(),"Checking",Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(fortune_refined.this, AddRecordActivity.class);
//        startActivity(intent);
        Intent it=new Intent(chambal.this,chambaladdrecord.class);
        startActivity(it);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
    }

