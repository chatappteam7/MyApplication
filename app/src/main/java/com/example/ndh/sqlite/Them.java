package com.example.ndh.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Them extends AppCompatActivity {


    EditText edtten,edtnamsinh,edtdiachi;
    Button btnthem,btnhuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them);
        anhXa();
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ten = edtten.getText().toString();
                int namsinh = Integer.parseInt(edtnamsinh.getText().toString().trim());
                String diachi = edtdiachi.getText().toString();
                if(ten.equals("")&&diachi.equals(""))
                {
                    Toast.makeText(Them.this, "ban chua nhap du thong tin", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String insert = "INSERT INTO HocSinh VALUES(null,'"+ ten +"',"+ namsinh +",'"+diachi+"')";
                    MainActivity.database.QueryData(insert);
                    Intent intent = new Intent(Them.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void anhXa() {
        edtten = (EditText) findViewById(R.id.edtnhapten);
        edtnamsinh = (EditText) findViewById(R.id.edtnhapnamsinh);
        edtdiachi = (EditText) findViewById(R.id.edtnhapdiachi);
        btnhuy = (Button) findViewById(R.id.btnhuy);
        btnthem = (Button) findViewById(R.id.btnthem);

    }
}
