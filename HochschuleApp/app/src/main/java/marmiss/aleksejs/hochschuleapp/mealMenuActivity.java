package marmiss.aleksejs.hochschuleapp;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Calendar;

public class mealMenuActivity extends AppCompatActivity {
private WeekMenu list = new WeekMenu();
private  MealAdapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_menu);
        ad = new MealAdapter(Arrays.asList(list.getMembers()));
        ListView listView = findViewById(R.id.my_list_view);
        listView.setAdapter(ad);
        Toast toast = Toast.makeText(this, "Tap to download menu in pdf format.", Toast.LENGTH_LONG);
        toast.show();
        Calendar calendar = Calendar.getInstance();
        final int  week = calendar.get(Calendar.WEEK_OF_YEAR);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String urlString = "https://studierendenwerk-ulm.de/wp-content/uploads/speiseplaene/Prittwitzstr0" + week + ".pdf";
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(urlString));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try {
                    view.getContext().startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    intent.setPackage(null);
                    view.getContext().startActivity(intent);
                }

            }
        });

    }
}
