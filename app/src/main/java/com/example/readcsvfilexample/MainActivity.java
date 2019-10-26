package com.example.readcsvfilexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.readcsvfilexample.model.HealthyData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readHealthyData();
    }

    private List<HealthyData> healthyDataList = new ArrayList<>();
    private void readHealthyData() {
        InputStream is = getResources().openRawResource(R.raw.data_upt_dinas_kesehatan);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                // spilt by ",'
                String[] tokens = line.split(",");

                // Read the data
                HealthyData sample = new HealthyData();
                sample.setName(tokens[0]);
                sample.setCode(tokens[1]);
                sample.setAddress(tokens[2]);
                sample.setPhone(tokens[3]);
                sample.setType(tokens[4]);
                healthyDataList.add(sample);

                Log.d(TAG, "readHealthyData: Just Created " + sample);
            }
        } catch (IOException e) {
            Log.d(TAG, "readHealthyData: " + e.getMessage());
        }
    }
}
