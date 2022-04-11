package com.example.book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DescriptionBook extends AppCompatActivity {

    ImageView mainImageView;
    TextView nameBook,priceBook,madeBook;
    Button preOrderButton;

    String data1,data2,data3;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_book);

        mainImageView = findViewById(R.id.desImageView);
        nameBook = findViewById(R.id.desNameBook);
        priceBook = findViewById(R.id.desPriceBook);
        madeBook = findViewById(R.id.desMadeBook);

        preOrderButton = findViewById(R.id.preOrderBot);
        preOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clk();
            }
        });

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("name") && getIntent().hasExtra("price") && getIntent().hasExtra("made")
        && getIntent().hasExtra("myImage")){
            data1 = getIntent().getStringExtra("name");
            data2 = getIntent().getStringExtra("price");
            data3 = getIntent().getStringExtra("made");
            image = getIntent().getIntExtra("myImage",1);

        }else{
            Toast.makeText(this,"No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        nameBook.setText(data1);
        priceBook.setText(data2);
        madeBook.setText(data3);
        mainImageView.setImageResource(image);
    }

    public void clk(){
        Intent intent =  new Intent(this, PreOrder.class);
        intent.putExtra("name",data1);
        intent.putExtra("price",data2);
        intent.putExtra("myImage",image);
        startActivity(intent);
    }
}