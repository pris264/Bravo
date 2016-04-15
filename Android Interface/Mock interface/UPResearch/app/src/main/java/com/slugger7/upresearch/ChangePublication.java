package com.slugger7.upresearch;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Duncan on 2016/04/14.
 */
public class ChangePublication extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_publication);
        /*
        *list should populate through a request from the server
        *but for now list will be populated from strings.xml
        */
        Spinner pubList = (Spinner) findViewById(R.id.spnPubList);
        assert pubList != null;
        pubList.setOnItemSelectedListener(this);
        ArrayAdapter dataAdapter = ArrayAdapter.createFromResource(ChangePublication.this, R.array.Publications, android.R.layout.simple_list_item_1);
        //dropdown list layout style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //attaching data adapter to spinner
        pubList.setAdapter(dataAdapter);
        //creating the meta data for the publications

        //onclick event for submit
        Button submit = (Button) findViewById(R.id.btnSubmit);
        assert submit != null;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Changes Submitted", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //get the components to be edited
        EditText edtPubName = (EditText) findViewById(R.id.edtPubName);
        EditText edtPubWeb = (EditText) findViewById(R.id.edtPubWebSite);
        EditText edtDue = (EditText) findViewById(R.id.edtDueDate);
        EditText edtProg = (EditText) findViewById(R.id.edtProgress);
        CheckBox cbxComplete = (CheckBox) findViewById(R.id.cbxIsCompleted);

        //insert the new values into the components
        Publication curr = Globals.getPublications().get(position);
        edtPubName.setText(curr.getName());
        edtPubWeb.setText(curr.getUrl());
        edtDue.setText(curr.getDueDate());
        if(curr.getActive())
            edtProg.setText(curr.getProgress());
        else
            edtProg.setText("Inactive");
        cbxComplete.setChecked(curr.getComplete());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
