package com.example.horizontallistview;

import android.content.Context;
import android.graphics.Paint;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    public Context context;
    public List<String> arrayList;
    private int selectedPosition = -1;

    public ListAdapter(Context context, List<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null != arrayList?arrayList.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){

            holder = new ViewHolder();
            //Log.d("取得Position ", String.valueOf(position) + " itemValue " + arrayList.get(position));

            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_view, parent, false);
            holder.tv = convertView.findViewById(R.id.tv_title);
            holder.iv = convertView.findViewById(R.id.iv_title);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv.setText(arrayList.get(position));

        if (arrayList.get(position).equals(context.getResources().getStringArray(R.array.title_bar)[0])){
            holder.tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.START);
        }else if(arrayList.get(position).equals(context.getResources().getStringArray(R.array.title_bar)[7])){
            holder.tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.END);
        }else {
            holder.tv.setGravity(Gravity.CENTER);
        }

        if(position == selectedPosition) {
            isSelected(holder);
        }else {
            holder.tv.setTextSize(18);
            holder.tv.setTextColor(context.getResources().getColor(R.color.white));
            holder.iv.setVisibility(View.GONE);
        }

        return convertView;
    }

    public static class ViewHolder {
        private TextView tv;
        private ImageView iv;
    }

    public void setSelectedPosition(int position){
        selectedPosition = position;
    }

    private void isSelected(ViewHolder holder){

        Paint paint = holder.tv.getPaint();
        paint.setFakeBoldText(true);
        holder.tv.setTextSize(20);
        holder.tv.setTextColor(context.getResources().getColor(R.color.purple_500));
        holder.iv.setVisibility(View.VISIBLE);

    }

}