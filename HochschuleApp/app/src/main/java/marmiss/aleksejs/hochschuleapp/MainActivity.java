package marmiss.aleksejs.hochschuleapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;


import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private PopupWindow popupWindow;
    private Spinner spinner;
    private Professor[] professors = new Professor[]{new Professor("Prof. Dr. Philipp Graf","grafsa@hs-ulm.de"),
            new Professor("Prof. Dr. Klaus Peter Kratzer","kratzerss@hs-ulm.de"),
            new  Professor("Prof. Dr. Klaus Baer", "baersa@hs-ulm.de"),
            new Professor("Test","aleksejs.marmiss@gmail.com"),
            new Professor("Prof. Dr. Georg Schied","schied@hs-ulm.de"),
            new Professor("Prof. Dr. Frank Steiper", "steiper@hs-ulm.de"),
            new Professor("Prof. Dr. Martin Severin","severin@hs-ulm.de")};
    private ProfAdapter profAdapter = new ProfAdapter(Arrays.asList(professors));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        try {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }catch (NullPointerException e){
            Log.d("AppName", "Null Pointer exception");
        }
        ImageView campus = findViewById(R.id.image_campus);
        ImageView mensa = findViewById(R.id.imageView7);
        ImageView timeTable = findViewById(R.id.imageView6);
        ImageView classRoom = findViewById(R.id.imageView3);

        campus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAnotherActivity(v);
                v.
            }
        });

        mensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAnotherActivity(v);
            }
        });

        timeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAnotherActivity(v);
            }
        });
        classRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAnotherActivity(v);
            }
        });


    }

    public void goToAnotherActivity(View view){

        if(view.getId() == R.id.image_campus) {
            Intent myIntent = new Intent(MainActivity.this, CampusActivity.class);
            startActivity(myIntent);
        }
        else if (view.getId() == R.id.imageView7){
            Intent myIntent = new Intent(MainActivity.this, mealMenuActivity.class);
            startActivity(myIntent);
        }
        else if (view.getId() == R.id.imageView6){
            Intent myIntent = new Intent(MainActivity.this, TimetableActivity.class);
            startActivity(myIntent);
        }
        else if (view.getId() == R.id.imageView3){
            Intent myIntent = new Intent(MainActivity.this, RoomSearchActivity.class);
            startActivity(myIntent);
        }



    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.my_menu, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String link;
        Intent intent;
        switch (item.getItemId()){
            case R.id.moodle:
                link = "https://moodle-hs-ulm.de/login/index.php";
                intent = new Intent(getApplicationContext(), WebViewActivity.class);
                intent.putExtra("link", link);
                startActivity(intent);
                return true;
            case R.id.email:
                link = "https://webmail.hs-ulm.de/";
                intent = new Intent(getApplicationContext(), WebViewActivity.class);
                intent.putExtra("link", link);
                startActivity(intent);
                return true;
            case R.id.contact:
                showPopup(item.getActionView());
                return true;
            default:return super.onOptionsItemSelected(item);
        }

    }

    public void showPopup(View v){
                LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View container =  layoutInflater.inflate(R.layout.popup,null);
                 int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                 int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                popupWindow = new PopupWindow(container,width,height,true);
               View constraintLayout = findViewById(R.id.constraint);
                popupWindow.showAtLocation(constraintLayout,Gravity.CENTER,0,0);
                populatePopup(container);

    }

    public void populatePopup(final View container){

        spinner = container.findViewById(R.id.spinner1);
        spinner.setAdapter(profAdapter);
        Button button = container.findViewById(R.id.button2);
        Button cancel_button = container.findViewById(R.id.cancel_button);
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spinner.getSelectedItemPosition();
                String contact = profAdapter.getItem(pos).getContact();
                EditText editText = container.findViewById(R.id.editText2);
                try{
                    Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + contact));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Student's question");
                    intent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    Log.d("SendAction","ActivityNotfound");
                }
                popupWindow.dismiss();
            }
        });
    }
}
