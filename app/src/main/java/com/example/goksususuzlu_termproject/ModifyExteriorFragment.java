package com.example.goksususuzlu_termproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModifyExteriorFragment extends Fragment implements View.OnClickListener {
    private View layout;
    public ModifyExteriorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_modify_exterior, container, false);
        Button rimsButton = layout.findViewById(R.id.rims_button);
        rimsButton.setOnClickListener(this);
        Button headlightsButton = layout.findViewById(R.id.headlights_button);
        headlightsButton.setOnClickListener(this);

        Button colorButton = layout.findViewById(R.id.select_color_button);
        colorButton.setOnClickListener(this);

        setExteriorImage();



        return layout;
    }

    public void setExteriorImage(){

        ImageView exteriorImage = layout.findViewById(R.id.exterior_image);
        if (Car.currentCar.getModel().equals("A3 Sedan")){
            exteriorImage.setImageResource(R.drawable.a3);
        }
        if (Car.currentCar.getModel().equals("A1 Sportback")){
            exteriorImage.setImageResource(R.drawable.a1);
        }
        if (Car.currentCar.getModel().equals("A4 Sedan")){
            exteriorImage.setImageResource(R.drawable.a4);
        }
        if (Car.currentCar.getModel().equals("A5 Sportback")){
            exteriorImage.setImageResource(R.drawable.a5);
        }
    }

    public void onRimsButtonClick() {

        Intent intent = new Intent(getActivity(),ModifyRimsActivity.class);
        startActivity(intent);
    }

    public void onHeadlightsButtonClick() {

        Intent intent = new Intent(getActivity(),ModifyHeadlightsActivity.class);
        startActivity(intent);
    }

    public void onSelectColorButtonClick(){
        Intent intent = new Intent(getActivity(),SelectColorActivity.class);
        startActivity(intent);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rims_button:
                onRimsButtonClick();
                break;
            case R.id.headlights_button:
                onHeadlightsButtonClick();
                break;
            case R.id.select_color_button:
                onSelectColorButtonClick();
                break;

        }
    }
}
