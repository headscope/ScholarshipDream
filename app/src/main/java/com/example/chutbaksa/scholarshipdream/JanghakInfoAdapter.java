package com.example.chutbaksa.scholarshipdream;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chutbaksa.scholarshipdream.JSONparser.JanghakObject;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class JanghakInfoAdapter extends BaseAdapter{

    private Context mContext = null;
    private ArrayList<JanghakObject> janghakList = new ArrayList<JanghakObject>();

    public JanghakInfoAdapter(Context mContext, ArrayList<JanghakObject> jarr) {
        super();
        this.mContext = mContext;
        this.janghakList = jarr;

    }

    @Override
    public int getCount() {
        return janghakList.size();
    }

    @Override
    public JanghakObject getItem(int position) {
        return janghakList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row, null);

            holder.foundation = (TextView) convertView.findViewById(R.id.et_foundation);
            holder.payamount = (TextView) convertView.findViewById(R.id.et_payamount);
            holder.dday = (TextView) convertView.findViewById(R.id.et_dday);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final JanghakObject mData = janghakList.get(position);

        holder.payamount.setText(mData.payamount);
        holder.foundation.setText(mData.foundation);
        holder.dday.setText(String.valueOf(mData.dday));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(mContext, DetailJanghak.class);
                intent.putExtra("janghakname", mData.janghakname);
                intent.putExtra("weblink", mData.weblink );
                intent.putExtra("downloadlink", mData.downloadlink);
                intent.putExtra("startdate", mData.startdate);
                intent.putExtra("enddate", mData.enddate);
                mContext.startActivity(intent);

            }
        });
        return convertView;
    }

    /* This method is not used anymore

    public void addItem(String foundation, String payamount, int dday) {
        JanghakObject addObj = new JanghakObject();
        addObj.foundation = foundation;
        addObj.payamount = payamount;
        addObj.dday = dday;

        janghakList.add(addObj);

    }

    */

    private class ViewHolder {
        public TextView foundation;
        public TextView payamount;
        public TextView dday;
    }


}