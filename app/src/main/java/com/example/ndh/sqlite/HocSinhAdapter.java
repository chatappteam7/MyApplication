package com.example.ndh.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by NDH on 9/16/2017.
 */

public class HocSinhAdapter extends BaseAdapter {

    Context context;
    int Layout;
    ArrayList<HocSinh> hocSinhs;

    public HocSinhAdapter(Context context, int layout, ArrayList<HocSinh> hocSinhs) {
        this.context = context;
        Layout = layout;
        this.hocSinhs = hocSinhs;
    }

    @Override
    public int getCount() {
        return hocSinhs.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    class  ViewHoder{
        TextView txtten,txtnamsinh,txtdiachi;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder viewHoder ;
        if(convertView == null)
        {
            viewHoder = new ViewHoder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(Layout,null);

            viewHoder.txtten = (TextView) convertView.findViewById(R.id.txtten);
            viewHoder.txtnamsinh = (TextView) convertView.findViewById(R.id.txtnamsinh);
            viewHoder.txtdiachi = (TextView) convertView.findViewById(R.id.txtdiachi);
             convertView.setTag(viewHoder);
        }
        else{
            viewHoder= (ViewHoder) convertView.getTag();
        }
        HocSinh hocSinh = hocSinhs.get(position);
        viewHoder.txtten.setText("Ten : "+hocSinh.getHoTen());
        viewHoder.txtnamsinh.setText("Nam sinh: "+hocSinh.getNamSinh());
        viewHoder.txtdiachi.setText("Dia chi : "+hocSinh.getDiaChi());

        return convertView;
    }
}
