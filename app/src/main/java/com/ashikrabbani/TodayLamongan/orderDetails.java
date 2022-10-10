package com.ashikrabbani.TodayLamongan;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class orderDetails extends Activity {

    TextView ordered__list, bdt_price_view, show_price_view, orderlistText;
    String bdt_price, usd_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderdetails);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("choice_iteams");
        bdt_price = bundle.getString("bdt_price");

        orderlistText = findViewById(R.id.orderlistTextview);
        ordered__list = findViewById(R.id.orderDetailstextView);

        show_price_view = findViewById(R.id.showprice);
        show_price_view.setText("Jumlah : " +" Rp"+ bdt_price + "\n" + "Bayar : " + " Rp"+ bdt_price );

        ordered__list.setText(data);


        Typeface gatholic = ResourcesCompat.getFont(this, R.font.gatholic);

        ordered__list.setTypeface(gatholic);

        Typeface french = ResourcesCompat.getFont(this, R.font.french);

        orderlistText.setTypeface(french);

    }
    public void kemenu(View view) {

        Intent j = new Intent(orderDetails.this, MainActivity.class);
        startActivity(j);
        Toast toast = Toast.makeText(this,"Pesanan Telah di Bayar",Toast.LENGTH_LONG);
        toast.show();
    }
}








