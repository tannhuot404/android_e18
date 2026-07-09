package com.example.demo_e18.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_e18.R;
import com.example.demo_e18.adapters.PlanetAdapter;
import com.example.demo_e18.models.PlanetModel;

import java.util.ArrayList;
import java.util.List;

public class PlanetActivity extends AppCompatActivity {

    List<PlanetModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_planet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            var defaultPadding = getResources().getDimensionPixelSize(R.dimen.default_padding);
            v.setPadding(systemBars.left + defaultPadding,
                    systemBars.top,
                    systemBars.right + defaultPadding,
                    systemBars.bottom);
            return insets;
        });

        setupData();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView rvPlanet = findViewById(R.id.rvPlanet);
        rvPlanet.setLayoutManager(new LinearLayoutManager(this));

        var adapter = new PlanetAdapter(data);
        rvPlanet.setAdapter(adapter);
    }

    private void setupData() {
        data = new ArrayList<>();

        PlanetModel PlanetModel3 = new PlanetModel("Earth",1,R.drawable.earth);
        PlanetModel PlanetModel1 = new PlanetModel("Mercury",0,R.drawable.mercury);
        PlanetModel PlanetModel2 = new PlanetModel("Venus", 0, R.drawable.venus);

        PlanetModel PlanetModel4 = new PlanetModel("Mars", 2, R.drawable.mars);
        PlanetModel PlanetModel5 = new PlanetModel("Jupiter", 79, R.drawable.jupiter);
        PlanetModel PlanetModel6 = new PlanetModel("Saturn", 83, R.drawable.saturn);

        PlanetModel PlanetModel7 = new PlanetModel("Uranus", 27, R.drawable.uranus);
        PlanetModel PlanetModel8 = new PlanetModel("Neptune", 14, R.drawable.neptune);

        data.add(PlanetModel1);
        data.add(PlanetModel2);
        data.add(PlanetModel3);
        data.add(PlanetModel4);
        data.add(PlanetModel5);
        data.add(PlanetModel6);
        data.add(PlanetModel7);
        data.add(PlanetModel8);
    }
}