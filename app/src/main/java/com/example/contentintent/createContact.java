package com.example.contentintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class createContact extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etNumber, etWeb, etMap;
    ImageView ivSad, ivHappy, ivOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        etName=findViewById(R.id.etName);
        etNumber=findViewById(R.id.etNumber);
        etWeb=findViewById(R.id.etWeb);
        etMap=findViewById(R.id.etMap);

        ivSad=findViewById(R.id.ivSad);
        ivHappy=findViewById(R.id.ivHappy);
        ivOk=findViewById(R.id.ivOk);

        ivSad.setOnClickListener(this);
        ivHappy.setOnClickListener(this);
        ivOk.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(etName.getText().toString().isEmpty() || etWeb.getText().toString().isEmpty() ||
                etMap.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent=new Intent();
            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("number",etNumber.getText().toString().trim());
            intent.putExtra("web",etWeb.getText().toString().trim());
            intent.putExtra("map",etMap.getText().toString().trim());

            if(v.getId() == R.id.ivHappy)
            {
                intent.putExtra("mood", "happy");
            }
            else if(v.getId() == R.id.ivOk)
            {
                intent.putExtra("mood", "ok");
            }
            else
            {
                intent.putExtra("mood", "sad");
            }

            setResult(RESULT_OK,intent);
            createContact.this.finish();
        }
    }
}
