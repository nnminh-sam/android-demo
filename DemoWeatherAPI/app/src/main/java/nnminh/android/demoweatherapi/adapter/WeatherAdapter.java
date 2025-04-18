package nnminh.android.demoweatherapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import nnminh.android.demoweatherapi.R;
import nnminh.android.demoweatherapi.model.WeatherForecastModel;

public class WeatherAdapter extends BaseAdapter {
    private ArrayList<WeatherForecastModel> weatherForecastModelList;
    private Context context;

    public WeatherAdapter(Context context, ArrayList<WeatherForecastModel> weatherForecastModelList) {
        this.weatherForecastModelList = weatherForecastModelList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return this.weatherForecastModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.weatherForecastModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_weather_items, viewGroup, false);
        }

        TextView txtTimeForecast = view.findViewById(R.id.txtTimeForecast);
        TextView txtTemperatureForecast = view.findViewById(R.id.txtTemperatureForecast);
        TextView txtWindForecast = view.findViewById(R.id.txtWindForecast);
        ImageView imgForecast = view.findViewById(R.id.imgForecast);

        WeatherForecastModel weatherForecastModel = weatherForecastModelList.get(i);
        txtTimeForecast.setText("" + weatherForecastModel.getTime());
        txtTemperatureForecast.setText(weatherForecastModel.getTemperature()+"°C");
        txtWindForecast.setText(weatherForecastModel.getWind()+ " km");
        Picasso.get().load("https:"+weatherForecastModel.getIconUrl()).into(imgForecast);

        //imgForecast.src(weatherForecastModel.getTemperature());
        return view;

    }
}
