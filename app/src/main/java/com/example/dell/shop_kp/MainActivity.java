package com.example.dell.shop_kp;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView rv_trangchu;
    NavigationView navigationView;
    ListView lv_trangchu;
    DrawerLayout drawerLayout;
    TextView tv_sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Anhxa();
        ActionBar();
        ActionViewFlipper();    

    }
    private void Anhxa() {
        toolbar = findViewById( R.id.toolbar_trangchu );
        viewFlipper = findViewById( R.id.view_flipper );
        rv_trangchu = findViewById( R.id.rv_trangchu );
        navigationView = findViewById( R.id.navigationview );
        lv_trangchu = findViewById( R.id.lv_trangchu );
        drawerLayout = findViewById( R.id.drawerlayout );
        tv_sp = findViewById( R.id.tv_sp );
    }

    private void ActionBar() {
        //Tạo menu cho Action Bar
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        toolbar.setNavigationIcon( android.R.drawable.ic_menu_sort_by_size );
        //Xét sự kiên click
        toolbar.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mở ra nhờ drawverLayout + nhảy ra giữa
                drawerLayout.openDrawer( GravityCompat.START );
            }
        } );
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add( "https://image.thanhnien.vn/665/uploaded/minhquang/2018_04_28/hackers_tfgt.jpg" );
        mangquangcao.add( "http://vnreview.vn/image/17/96/27/1796277.jpg?t=1524826253417" );
        mangquangcao.add( "http://static.cand.com.vn/Files/Image/chienthang/2018/04/28/thumb_660_8b3ce6b2-4890-4a8d-968b-7691a7d048d6.jpg" );
        mangquangcao.add( "https://image.thanhnien.vn/1600/uploaded/nthanhluan/2018_04_28/office2019_yrat.jpg" );
        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView( getApplicationContext() );
            //Load đường dẫn vào trong imageview nhờ thư viện Picasso
            Picasso.with( getApplicationContext() ).load( mangquangcao.get( i ) ).into( imageView );
            //Căn Imageview vừa đủ  flipper
            imageView.setScaleType( ImageView.ScaleType.FIT_XY );
            viewFlipper.addView( imageView );
        }
        //bắt sự kiện cho viewFlipper tự chạy
        viewFlipper.setFlipInterval( 5000 );
        viewFlipper.setAutoStart( true );
        Animation animation_slide_right = AnimationUtils.loadAnimation( getApplicationContext(), R.anim.slide_out_right );
        Animation animation_slide_left = AnimationUtils.loadAnimation( getApplicationContext(), R.anim.slide_out_reft );
        viewFlipper.setInAnimation( animation_slide_right );
        viewFlipper.setOutAnimation( animation_slide_left );
    }




}
