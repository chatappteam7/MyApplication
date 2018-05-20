package com.example.ndh.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sua extends AppCompatActivity {
    EditText edtsuaten,edtsuanamsinh,edtsuadiachi;
    Button btnhuy,btnxacnhan;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua);
        anhXa();
        Intent intent = getIntent();

        if(intent!=null) {
            HocSinh hocsinh = intent.getParcelableExtra("hocsinh");
            id = hocsinh.getId();
            edtsuaten.setText(hocsinh.getHoTen());
            edtsuanamsinh.setText(hocsinh.getNamSinh()+"");
            edtsuadiachi.setText(hocsinh.getDiaChi());
        }else
        {
            Toast.makeText(this, "khong co du lieu", Toast.LENGTH_SHORT).show();
        }
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtsuaten.getText().toString();
                String namsinh = edtsuanamsinh.getText().toString();
                String diachi = edtsuadiachi.getText().toString();
                if(ten.isEmpty()&&namsinh.isEmpty()&&diachi.isEmpty())
                {
                    Toast.makeText(Sua.this, "Ban nhap thieu thong tin", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String update = "UPDATE HocSinh SET Ten = '"+ ten + "',Namsinh = '"+Integer.parseInt(namsinh)+"',Diadiem = '"+diachi+"' WHERE Id = "+id+"";
                    MainActivity.database.QueryData(update);
                    Intent intent = new Intent(Sua.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void anhXa() {
        edtsuaten = (EditText) findViewById(R.id.edtsuaten);
        edtsuanamsinh = (EditText) findViewById(R.id.edtsuanamsinh);
        edtsuadiachi = (EditText) findViewById(R.id.edtsuadichi);
        btnhuy = (Button) findViewById(R.id.btnhuy);
        btnxacnhan = (Button) findViewById(R.id.btnxacnhan);
    }
}
