package com.example.apptonghop_giuaki.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apptonghop_giuaki.R;

import java.util.List;

public class XeConAdapterFragment extends BaseAdapter {
    private Context context;
    private int layout;
    private List<XeConFragment> xeConList;

    public XeConAdapterFragment(Context context, int layout, List<XeConFragment> xeConList) {
        this.context = context;
        this.layout = layout;
        this.xeConList = xeConList;
    }

    @Override
    public int getCount() {
        return xeConList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout,null);

        //ánh xạ view
        TextView txtTen = (TextView) view.findViewById(R.id.textviewTen);
        TextView txtMoTa = (TextView) view.findViewById(R.id.textviewMoTa);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imageViewHinh);

        //gán giá trị
        XeConFragment xeCon = xeConList.get(i);

        txtTen.setText(xeCon.getTen());
        txtMoTa.setText(xeCon.getMoTa());
        imgHinh.setImageResource(xeCon.getHinh());

        return view;
    }
}
