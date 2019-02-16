package marmiss.aleksejs.hochschuleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProfAdapter extends BaseAdapter {
    private List<Professor> dataList;

    public ProfAdapter(List<Professor> list) {

        this.dataList = list;

    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Professor getItem(int position) {
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
            convertView = inflater.inflate(R.layout.spinnerlay, null, false);
        }

        TextView textView = convertView.findViewById(R.id.profesor);
        textView.setText(dataList.get(position).getName());

        return convertView;

    }

}
