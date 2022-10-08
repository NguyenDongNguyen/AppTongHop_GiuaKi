package com.example.apptonghop_giuaki.fragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import com.example.apptonghop_giuaki.Detail;
import com.example.apptonghop_giuaki.R;

import java.util.ArrayList;

public class ShowListFragment extends Fragment{

    ListView lvXeCon;
    ArrayList<XeConFragment> arrayXeCon;
    XeConAdapterFragment adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_list,container,false);
        lvXeCon = (ListView) view.findViewById(R.id.listViewXeCon);

        AnhXa();

        adapter = new XeConAdapterFragment(getActivity(), R.layout.fragment_dong_xe_con, arrayXeCon);
        lvXeCon.setAdapter(adapter);

        lvXeCon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), Detail.class);
                XeConFragment xeCon = arrayXeCon.get(i);
                intent.putExtra("tenxe", xeCon.getTen());
                intent.putExtra("mota", xeCon.getMoTa());
                intent.putExtra("hinh",xeCon.getHinh());
                startActivity(intent);
            }
        });

        return view;
    }

//    @Override
//    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//        ShowListFragment showListFragment = new ShowListFragment();
//        FragmentManager fragmentManager = getChildFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
////        Bundle bundle = new Bundle();
////        XeConFragment xeCon = arrayXeCon.get(position);
////        bundle.putSerializable("tenxe", xeCon.getTen());
////        bundle.putSerializable("mota", xeCon.getMoTa());
////        bundle.putSerializable("hinh",xeCon.getHinh());
////        showListFragment.setArguments(bundle);
//
//        fragmentTransaction.replace(R.id.nav_listview_car,showListFragment);
//        fragmentTransaction.commit();
//    }

    private void AnhXa() {
        arrayXeCon = new ArrayList<>();
        arrayXeCon.add(new XeConFragment("Lamborghini","Information Of Car1", R.drawable.car1));
        arrayXeCon.add(new XeConFragment("Ferrari","Information Of Car2", R.drawable.car2));
        arrayXeCon.add(new XeConFragment("Porsche","Information Of Car3", R.drawable.car3));
        arrayXeCon.add(new XeConFragment("MCLaren","Information Of Car4", R.drawable.car4));
        arrayXeCon.add(new XeConFragment("Bentley","Information Of Car5", R.drawable.car5));
    }
}
