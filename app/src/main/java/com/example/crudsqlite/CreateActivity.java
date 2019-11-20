package com.example.crudsqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateActivity extends AppCompatActivity {
    private DatabaseHendler db;
    private EditText Ename, Ekelas;
    private String Snama, Skelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        db = new DatabaseHendler(this);

        Ename = (EditText) findViewById(R.id.create_nama);
        Ekelas = (EditText) findViewById(R.id.create_kelas);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Ename.getText());
                Skelas = String.valueOf(Ekelas.getText());

                if (Snama.equals("")){
                    Ename.requestFocus();
                    Toast.makeText(CreateActivity.this, "Silahkan isi nama", Toast.LENGTH_SHORT).show();
                }else if(Skelas.equals("")){
                    Ekelas.requestFocus();
                    Toast.makeText(CreateActivity.this, "Silahkan isi kelas", Toast.LENGTH_SHORT).show();
                }else{
                    Ename.setText("");
                    Ekelas.setText("");
                    Toast.makeText(CreateActivity.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateMahasiswa(new ModalMahasiswa(null, Snama, Skelas));
                }
            }
        });
    }
}
