package com.example.book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.book.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ActivityMainBinding binding;
    String s1[], s2[],s3[];
    int images[] ={R.drawable.theangel,R.drawable.alyasan,R.drawable.gimai_seikatsu};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.preOder:
                    replaceFragment(new PreOderFragment());
                    break;
                case R.id.settings:
                    replaceFragment(new SettingsFragment());
                    break;
            }
            return true;
        });

//        recyclerView = findViewById(R.id.recycle);
//        s1 = getResources().getStringArray(R.array.book_name);
//        s2 = getResources().getStringArray(R.array.book_price);
//        s3 = getResources().getStringArray(R.array.made);
//
//        MyAdapter myAdapter = new MyAdapter(this,s1,s2,s3,images);
//        recyclerView.setAdapter(myAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PreOderFragment shopFragment = new PreOderFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout,shopFragment);
        fragmentTransaction.commit();

        HomeFragment homeFragment = new HomeFragment();
        FragmentManager fragmentManager2 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
        fragmentTransaction2.add(R.id.frame_layout,homeFragment);
        fragmentTransaction2.commit();

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}