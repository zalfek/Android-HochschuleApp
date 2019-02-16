package marmiss.aleksejs.hochschuleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class timetableAdapter extends BaseAdapter {


    private List<TimeTable> dataList;

    public timetableAdapter(List<TimeTable> list) {

        this.dataList = list;

    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public TimeTable getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.timetable_list_item, null, false);
        }

        ImageView image =(ImageView)convertView.findViewById(R.id.list_image_view);
        String imageName = dataList.get(position).getAbbr().toLowerCase() + "_titelbild";
        image.setImageResource( context.getResources().getIdentifier(imageName, "drawable", "marmiss.aleksejs.hochschuleapp"));

        TextView spec = convertView.findViewById(R.id.list_programm);
        spec.setText(dataList.get(position).getSpecialization());

        return convertView;

    }



}
