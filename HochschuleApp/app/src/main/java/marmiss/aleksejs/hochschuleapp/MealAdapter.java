package marmiss.aleksejs.hochschuleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class MealAdapter extends BaseAdapter {

    private List<dayMenu>  dataList;

public MealAdapter(List<dayMenu> list) {

        this.dataList = list;

}

    @Override
    public int getCount() {
    return dataList.size();
     }

    @Override
    public dayMenu getItem(int position) {
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
            convertView = inflater.inflate(R.layout.list_view_item, null, false);
        }

       TextView day = convertView.findViewById(R.id.list_text_day);
        day.setText(dataList.get(position).getDay());

        TextView tagessoup= convertView.findViewById(R.id.list_text_soup);
        tagessoup.setText(dataList.get(position).getTagessupe());

        TextView gutUndGunst = convertView.findViewById(R.id.list_text_Gut);
        gutUndGunst.setText(dataList.get(position).getGutUndGgunstig().getName());

        TextView gutUndGunstPrice = convertView.findViewById(R.id.list_text_Gut_price);
        double bufferGutPrice = dataList.get(position).getGutUndGgunstig().getPrice();
        gutUndGunstPrice.setText("" + bufferGutPrice +"€");

        TextView primaKlima = convertView.findViewById(R.id.list_text_prima);
        primaKlima.setText(dataList.get(position).getPrimaKlima().getName());

        TextView primaKlimaPrice = convertView.findViewById(R.id.list_text_prima_price);
        double bufferPrima = dataList.get(position).getPrimaKlima().getPrice();
        primaKlimaPrice.setText("" + bufferPrima +"€");

        TextView gourmet = convertView.findViewById(R.id.list_text_gourmet);
        gourmet.setText(dataList.get(position).getGourmet().getName());

        TextView gourmetPrice = convertView.findViewById(R.id.list_text_gourmet_price);
        double buffergourmet = dataList.get(position).getGourmet().getPrice();
        gourmetPrice.setText("" + buffergourmet +"€");


        return convertView;

    }

}
