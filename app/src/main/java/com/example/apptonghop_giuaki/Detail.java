package com.example.apptonghop_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apptonghop_giuaki.fragment.ShowListFragment;

public class Detail extends AppCompatActivity {

    TextView txtDetail, txtMoTa;
    ImageView imgViewHinh;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtDetail = (TextView) findViewById(R.id.textViewDetail);
        txtMoTa = (TextView) findViewById(R.id.textViewMota);
        imgViewHinh = (ImageView) findViewById(R.id.imageViewHinh);
        btnBack = (ImageButton) findViewById(R.id.buttonBack);

        Intent intent = getIntent();

        String noiDung = intent.getStringExtra("tenxe");
        txtDetail.setText(noiDung);

        String moTa = intent.getStringExtra("mota");
        txtMoTa.setText(moTa);

        int hinhAnh = intent.getIntExtra("hinh", 1);
        imgViewHinh.setImageResource(hinhAnh);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Detail.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}