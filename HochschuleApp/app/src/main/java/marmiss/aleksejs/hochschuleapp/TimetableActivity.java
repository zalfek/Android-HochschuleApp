package marmiss.aleksejs.hochschuleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;

public class TimetableActivity extends AppCompatActivity {
TimeTable[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        list = new TimeTable[]{new TimeTable("Computational Science and Engineering",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/CSE1.pdf",
                "CSE"),new TimeTable("Computer Science",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/CTS1.pdf",
                "CTS"),new TimeTable("Computer Science – International Program",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/ICS1.pdf",
                "ICS"),new TimeTable("Data Science in der Medizin",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/DSM1.pdf",
                "DSM"), new TimeTable("Digital Media",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/DM1.pdf",
                "DM"),new TimeTable("Elektrotechnik und Informationstechnik",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/ET1a.pdf",
                "ET"),new TimeTable("Energiesystemtechnik",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/EST1.pdf",
                "EST"),new TimeTable("Fahrzeugtechnik",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/FZ1.pdf",
                "FZ"),new TimeTable("Informatik",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/INF1.pdf",
                "INF"),new TimeTable("Informationsmanagement im Gesundheitswesen",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/IG1.pdf",
                "IG"),new TimeTable("Internationale Energiewirtschaft",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/IEW1.pdf",
                "IEW"),new TimeTable("Maschinenbau",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/MB1.pdf",
                "MB"),new TimeTable("Mechatronik",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/MC1.pdf",
                "MC"),new TimeTable("Medizintechnik",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/MT1.pdf",
                "MT"), new TimeTable("Produktionstechnik und Organisation",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/PO1.pdf",
                "PO"),new TimeTable("Wirtschaftsinformatik",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/WF1.pdf",
                "WF"),new TimeTable("Wirtschaftsingenieurwesen",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/WI1.pdf",
                "WI"),new TimeTable("Wirtschaftsingenieurwesen / Logistik",
                "http://www.hs-ulm.de/docs/dienste/Stundenplan/erstsemester/_docs//erstsemester/studiengaenge/WL1.pdf",
                "WL")};
        final timetableAdapter ad = new timetableAdapter(Arrays.asList(list));
        ListView listView = findViewById(R.id.timetable_view);
        listView.setAdapter(ad);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ad.getItem(position).getLink();
                Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        });

    }

    public void initTimetable(){


    }
}
