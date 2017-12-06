package com.example.kevin.ibmchallenge;

import android.content.Intent;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevin.ibmchallenge.Models.Flight;

public class Main2Activity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;

    View[] flights = new View[4];
    Flight[] flightData = new Flight[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Big Blue Business App");
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }

        flightData[0] = new Flight("Wednesday","6","December","SFO -> LAX");
        flightData[1] = new Flight("Friday","8","December","LAX -> SJC");
        flightData[2] = new Flight("Saturday","9","December","SJC -> JFK");
        flightData[3] = new Flight("Tuesday","12","December","JFK -> SFO");

        flights[0] = findViewById(R.id.item1);
        flights[1] = findViewById(R.id.item2);
        flights[2] = findViewById(R.id.item3);
        flights[3] = findViewById(R.id.item4);

        for (int i = 0; i < 4; i++) {
            ((TextView) flights[i].findViewById(R.id.flight_dep_to_dest)).setText(flightData[i].getDepToDest());
            ((TextView) flights[i].findViewById(R.id.flight_month_day)).setText(flightData[i].getDepMonth() + " - " + flightData[i].getDepDay());
            ((TextView) flights[i].findViewById(R.id.flight_date_number)).setText(flightData[i].getDepDayNum());
        }

        expand(flights[0], false);
        collapse(flights[1]);
        collapse(flights[2]);
        collapse(flights[3]);

        flights[1].findViewById(R.id.flight_item_title).setVisibility(View.GONE);
        flights[2].findViewById(R.id.flight_item_title).setVisibility(View.GONE);
        flights[3].findViewById(R.id.flight_item_title).setVisibility(View.GONE);

        ImageView expanderButton1 = (ImageView) flights[0].findViewById(R.id.expand_button);
        ImageView expanderButton2 = (ImageView) flights[1].findViewById(R.id.expand_button);
        ImageView expanderButton3 = (ImageView) flights[2].findViewById(R.id.expand_button);
        ImageView expanderButton4 = (ImageView) flights[3].findViewById(R.id.expand_button);

        expanderButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expand(flights[0],false);
                collapse(flights[1]);
                collapse(flights[2]);
                collapse(flights[3]);
            }
        });
        expanderButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expand(flights[1],false);
                collapse(flights[0]);
                collapse(flights[2]);
                collapse(flights[3]);
            }
        });
        expanderButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expand(flights[2],false);
                collapse(flights[0]);
                collapse(flights[1]);
                collapse(flights[3]);
            }
        });
        expanderButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expand(flights[3],false);
                collapse(flights[0]);
                collapse(flights[1]);
                collapse(flights[2]);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Intent intent = new Intent(this, PickReplacementFlightActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void expand(View v, boolean late) {
        v.findViewById(R.id.view_details_button).setVisibility(View.VISIBLE);
        v.findViewById(R.id.dest_image).setVisibility(View.VISIBLE);
        v.findViewById(R.id.expand_button).setVisibility(View.GONE);
        if (late) {
            v.findViewById(R.id.delayed_notification).setVisibility(View.VISIBLE);
            v.findViewById(R.id.schedule_another_flight_notification).setVisibility(View.VISIBLE);
            v.setBackgroundColor(Color.parseColor("#ff8282"));
        }
    }

    private void collapse(View v) {
        v.findViewById(R.id.view_details_button).setVisibility(View.GONE);
        v.findViewById(R.id.dest_image).setVisibility(View.GONE);
        v.findViewById(R.id.expand_button).setVisibility(View.VISIBLE);
        v.findViewById(R.id.delayed_notification).setVisibility(View.GONE);
        v.findViewById(R.id.schedule_another_flight_notification).setVisibility(View.GONE);
    }
}
