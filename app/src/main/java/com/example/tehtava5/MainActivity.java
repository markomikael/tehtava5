package com.example.tehtava5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlankFragment.IBlankFragment {

    BlankFragment fragment1;
    BlankFragment fragment2;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       this.manager = getSupportFragmentManager();
       fragment1 = (BlankFragment) this.manager.findFragmentById(R.id.id_fragment_sisalto1);
       fragment2 = (BlankFragment) this.manager.findFragmentById(R.id.id_fragment_sisalto2);





    }


    @Override
    public void onFragmentInteraction(int id,String txt) {


        if (id == fragment1.getId())
        {
            fragment2.asetateksti(id,txt);
            fragment1.asetateksti(id," ");
        }
        else
        {
            fragment1.asetateksti(id,txt);
            fragment2.asetateksti(id," ");
        }



    }
}
