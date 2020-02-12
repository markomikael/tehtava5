package com.example.tehtava5;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class BlankFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private TextView text;
    private EditText edittext;

    private IBlankFragment mListener;

    public BlankFragment() {

    }

    public void asetateksti(int id,String txt){



        text.setText(txt);
        edittext.setText("");


    }


    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        Button b = v.findViewById(R.id.nappula);

         this.edittext = v.findViewById(R.id.edittext);
         this.text = v.findViewById(R.id.teksti);




        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.onFragmentInteraction(getId(),edittext.getText().toString());



            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IBlankFragment) {
            mListener = (IBlankFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IBlankFragment");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface IBlankFragment {
        // TODO: Update argument type and name
        void onFragmentInteraction(int id,String txt);
    }
}
