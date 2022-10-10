package com.ashikrabbani.TodayLamongan;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {


    TextView menu, htv, btv, ftv, rtv, fitv, dtv;
    TextView hptv, bptv, fptv, rptv, fiptv, dptv;
    String choices = "";
    String prices, usd_price_string;
    Button ayam, bebek, nila, lele, esteh, esjeruk;

    Button rm_ayam, rm_bebek, rm_nila, rm_lele, rm_esteh, rm_esjeruk, order;

    int bp = 0, hp = 0, pp = 0, drp = 0, frp = 0, fip = 0;
    int tbp = 0, thp = 0, tpp = 0, tdrp = 0, tfrp = 0, tfip = 0;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.menuTv);
        htv = findViewById(R.id.bebek_textView);
        btv = findViewById(R.id.ayam_textView);
        ftv = findViewById(R.id.nila_textView);
        rtv = findViewById(R.id.lele_textView);
        fitv = findViewById(R.id.esteh_textView);
        dtv = findViewById(R.id.esjeruk_textView);

        ayam = (Button) findViewById(R.id.ayam_button);
        bebek = (Button) findViewById(R.id.bebek_button);
        nila = (Button) findViewById(R.id.nila_button);
        lele = (Button) findViewById(R.id.lele_button);
        esteh = (Button) findViewById(R.id.esteh_button);
        esjeruk = (Button) findViewById(R.id.esjeruk_button);

        rm_ayam = (Button) findViewById(R.id.ayam_button_rm);
        rm_bebek = (Button) findViewById(R.id.bebek_button);
        rm_nila = (Button) findViewById(R.id.nila_button_rm);
        rm_lele = (Button) findViewById(R.id.esteh_button_rm);
        rm_esteh = (Button) findViewById(R.id.lele_button_rm);
        rm_esjeruk = (Button) findViewById(R.id.esjeruk_button_rm);

        order = (Button) findViewById(R.id.order_button);


        hptv = findViewById(R.id.bebek_price);
        bptv = findViewById(R.id.ayam_price);
        fptv = findViewById(R.id.nila_price);
        rptv = findViewById(R.id.lele_price);
        fiptv = findViewById(R.id.esteh_price);
        dptv = findViewById(R.id.esjeruk_price);

        Typeface french_font = ResourcesCompat.getFont(this, R.font.french);
        Typeface gatholic = ResourcesCompat.getFont(this, R.font.gatholic);

        menu.setTypeface(french_font);

        htv.setTypeface(french_font);
        btv.setTypeface(french_font);
        ftv.setTypeface(french_font);
        rtv.setTypeface(french_font);
        fitv.setTypeface(french_font);
        dtv.setTypeface(french_font);


        hptv.setTypeface(gatholic);
        bptv.setTypeface(gatholic);
        fptv.setTypeface(gatholic);
        rptv.setTypeface(gatholic);
        fiptv.setTypeface(gatholic);
        dptv.setTypeface(gatholic);
        order.setTypeface(gatholic);

    }


    public void place_order(View view) {

        balancesheet();
        Intent i = new Intent(MainActivity.this, orderDetails.class);
        Bundle bundle = new Bundle();
        bundle.putString("choice_iteams", choices);
        bundle.putString("bdt_price", prices);
        bundle.putString("usd_price", usd_price_string);
        i.putExtras(bundle);
        startActivity(i);
        choices = "";
    }


    public void add_to_list(View view) {

        if (view == findViewById(R.id.bebek_button)) {
            Toast.makeText(this, "Tambah Bebek", Toast.LENGTH_SHORT).show();
            hp = hp + 1;
            bebek.setText(Integer.toString(hp));

        } else if (view == findViewById(R.id.ayam_button)) {
            Toast.makeText(this, "Tambah Ayam", Toast.LENGTH_SHORT).show();
            bp = bp + 1;
            ayam.setText(Integer.toString(bp));

        } else if (view == findViewById(R.id.nila_button)) {
            Toast.makeText(this, "Tambah Nila", Toast.LENGTH_SHORT).show();
            frp = frp + 1;
            nila.setText(Integer.toString(frp));

        } else if (view == findViewById(R.id.lele_button)) {
            Toast.makeText(this, "Tambah Lele", Toast.LENGTH_SHORT).show();
            pp = pp + 1;

            lele.setText(Integer.toString(pp));
        } else if (view == findViewById(R.id.esteh_button)) {
            Toast.makeText(this, "Tambah Es Teh", Toast.LENGTH_SHORT).show();
            fip = fip + 1;

            esteh.setText(Integer.toString(fip));
        } else if (view == findViewById(R.id.esjeruk_button)) {
            Toast.makeText(this, "Tambah Es Jeruk", Toast.LENGTH_SHORT).show();
            drp = drp + 1;
            esjeruk.setText(Integer.toString(drp));
        }

    }

    public void rmv_from_list(View view) {

        if (view == findViewById(R.id.bebek_button_rm)) {
            if (hp > 0) {

                hp = hp - 1;
                bebek.setText(Integer.toString(hp));
                Toast.makeText(this, "Tambah Bebek", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Tambah Item Dulu", Toast.LENGTH_SHORT).show();

        } else if (view == findViewById(R.id.ayam_button_rm)) {

            if (bp > 0) {
                bp = bp - 1;

                ayam.setText(Integer.toString(bp));
                Toast.makeText(this, "Tambah Ayam", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Tambah Item Dulu", Toast.LENGTH_SHORT).show();

        } else if (view == findViewById(R.id.nila_button_rm)) {

            if (frp > 0) {

                frp = frp - 1;
                nila.setText(Integer.toString(frp));
                Toast.makeText(this, "Tambah Nila", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Tambah Item Dulu", Toast.LENGTH_SHORT).show();

        } else if (view == findViewById(R.id.lele_button_rm)) {

            if (pp > 0) {

                pp = pp - 1;
                lele.setText(Integer.toString(pp));
                Toast.makeText(this, "Tambah Lele", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Tambah Item Dulu", Toast.LENGTH_SHORT).show();


        } else if (view == findViewById(R.id.esteh_button_rm)) {

            if (fip > 0) {

                fip = fip - 1;
                esteh.setText(Integer.toString(fip));
                Toast.makeText(this, "Tambah Es Teh", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Tambah Item Dulu", Toast.LENGTH_SHORT).show();


        } else if (view == findViewById(R.id.esjeruk_button_rm)) {

            if (drp > 0) {
                drp = drp - 1;
                esjeruk.setText(Integer.toString(drp));
                Toast.makeText(this, "Tambah Es Jeruk", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(this, "Tambah Item Dulu", Toast.LENGTH_SHORT).show();

        }

    }

    public void balancesheet() {
        tbp = bp * 15000;
        tdrp = drp * 3000;
        tfip = fip * 2000;
        tfrp = frp * 13000;
        thp = hp * 18000;
        tpp = pp * 11000;
        total = tbp + tdrp + tfip + thp + tpp + tfrp;
        prices = Integer.toString(total);

        if (bp > 0) {
            choices = choices + "\n\nAyam       (" + bp + " x 15.000) = " + tbp;
        }

        if (hp > 0) {
            choices = choices + "\n\nBebek      (" + hp + " x 18000) = " + thp;
        }

        if (frp > 0) {
            choices = choices + "\n\nNila       (" + frp + " x 13000) = " + tfrp;
        }

        if (pp > 0) {
            choices = choices + "\n\nLele       (" + pp + " x 11000) = " + tpp;
        }
        if (fip > 0) {
            choices = choices + "\n\nEs Teh     (" + fip + " x 2000) = " + tfip;
        }

        if (drp > 0) {
            choices = choices + "\n\nEs Jeruk   (" + drp + " x 3000) = " + tdrp;
        }


    }

    public void banner_about(View view) {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.about_dialogue);
        dialog.setTitle("About Developer");
        dialog.show();



        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                dialog.dismiss();
                t.cancel();
            }
        }, 800000);
    }
}
