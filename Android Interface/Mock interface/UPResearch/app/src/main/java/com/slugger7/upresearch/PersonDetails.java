package com.slugger7.upresearch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class PersonDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setData();
    }

    private void setData() {
        EditText name, surname, email, cellphone, username, staffnumber;
        Switch notifications;

        name = (EditText) findViewById(R.id.name_details);
        surname = (EditText) findViewById(R.id.surname_details);
        email = (EditText) findViewById(R.id.email_details);
        cellphone = (EditText) findViewById(R.id.cellphone_details);
        username = (EditText) findViewById(R.id.username_details);
        staffnumber = (EditText) findViewById(R.id.staffnumber_details);
        notifications = (Switch) findViewById(R.id.notifications_details);

        name.setText(Globals.getName());
        surname.setText(Globals.getSurname());
        email.setText(Globals.getEmail());
        cellphone.setText(Globals.getCellphone());
        username.setText(Globals.getUsername());
        staffnumber.setText(Globals.getStaffnumber());
        notifications.setChecked(Globals.getNotifications());
    }
}
