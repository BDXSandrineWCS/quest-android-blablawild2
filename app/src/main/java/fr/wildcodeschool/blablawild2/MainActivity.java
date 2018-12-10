package fr.wildcodeschool.blablawild2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bAddItinerary = findViewById(R.id.b_add_itinerary);
        bAddItinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ItineraryCreateActivity.class);
                startActivity(intent);
            }
        });

        Button bSearchItinerary = findViewById(R.id.b_search_itinerary);
        bSearchItinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ItinerarySearchActivity.class);
                startActivity(intent);
            }
        });

        initFirebase();;

    }

    private void initFirebase(){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        myRef.setValue(1);
        myRef.setValue(false);
        myRef.setValue(37.2f);
        myRef.setValue("Welcome into BlablaWild");

        // new Date() crée un objet contenant la date et l'heure du jour
        ItineraryModel itineraryModel = new ItineraryModel("Toulouse", "Paris", "Eric Cartman", new Date(), 15);
        DatabaseReference itineraryRef = database.getReference("itinerary");
        itineraryRef.setValue(itineraryModel);
    }
}
