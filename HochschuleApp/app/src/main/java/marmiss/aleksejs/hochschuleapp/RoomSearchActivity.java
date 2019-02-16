package marmiss.aleksejs.hochschuleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RoomSearchActivity extends AppCompatActivity {
ImageView imageView;
TextView textView_class;
EditText editText;
ImageView imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_search);
        editText = findViewById(R.id.editText);
        textView_class = findViewById(R.id.textView4);
        imageView = findViewById(R.id.imageView8);
        imageButton = findViewById(R.id.imageButton3);
        final String prittwit = "ABCDFH";
        final String einstein = "QRSTV";
        final String eberhardt = "MNOPZ";
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().toUpperCase().equals("AULA")){
                    imageView.setImageResource( getResources().getIdentifier("prittwit_plan", "drawable", "marmiss.aleksejs.hochschuleapp"));
                    textView_class.setText("The classroom is located in Prittwitstrasse campus in  \"B\" building on the -1(UG) floor(according to German standard). Please check the below shown plan for additional information");

                }
                else if(prittwit.indexOf(editText.getText().toString().toUpperCase().charAt(0))!=-1
                        && Integer.parseInt(Character.toString(editText.getText().toString().charAt(1))) <=3
                        && Integer.parseInt(Character.toString(editText.getText().toString().charAt(1))) >=0)
                {
                    imageView.setImageResource( getResources().getIdentifier("prittwit_plan", "drawable", "marmiss.aleksejs.hochschuleapp"));
                textView_class.setText("The classroom is located in Prittwitstrasse campus in  \"" + editText.getText().toString().toUpperCase().charAt(0) + "\" building on the "
                + editText.getText().toString().charAt(1) + " floor(according to German standard). Please check the below shown plan for additional information");
}

                else if(einstein.indexOf(editText.getText().toString().toUpperCase().charAt(0))!=-1
                        && Integer.parseInt(Character.toString(editText.getText().toString().charAt(1))) <=3
                        && Integer.parseInt(Character.toString(editText.getText().toString().charAt(1))) >=0){
                    imageView.setImageResource( getResources().getIdentifier("einstein_plan", "drawable", "marmiss.aleksejs.hochschuleapp"));
                    textView_class.setText("The classroom is located in Albert Einstein Allee campus in \"" + editText.getText().toString().toUpperCase().charAt(0) + "\" building on the "
                            + editText.getText().toString().charAt(1) + " floor(according to German standard). Please check the below shown plan for additional information");
                }

                else if(eberhardt.indexOf(editText.getText().toString().toUpperCase().charAt(0))!=-1
                        && Integer.parseInt(Character.toString(editText.getText().toString().charAt(1))) <=3
                        && Integer.parseInt(Character.toString(editText.getText().toString().charAt(1))) >=0){
                    imageView.setImageResource( getResources().getIdentifier("eberhardt_plan", "drawable", "marmiss.aleksejs.hochschuleapp"));
                    textView_class.setText("The classroom is located in Eberhard-Finckh Str. campus \"" + editText.getText().toString().toUpperCase().charAt(0) + "\" building on the "
                            + editText.getText().toString().charAt(1) + " floor(according to German standard). Please check the below shown plan for additional information");
                }else {
                    textView_class.setText("The specified classroom doesn't exist");
                }
            }
        });
    }
}
