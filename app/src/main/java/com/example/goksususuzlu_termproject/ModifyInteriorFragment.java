package com.example.goksususuzlu_termproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModifyInteriorFragment extends Fragment implements View.OnClickListener{

    public ModifyInteriorFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_modify_interior, container, false);


        Button seatsButton = layout.findViewById(R.id.seats_button);
        seatsButton.setOnClickListener(this);

        Button steeringWheelButton = layout.findViewById(R.id.steering_wheel_button);
        steeringWheelButton.setOnClickListener(this);

        Button decorativeInsertsButton = layout.findViewById(R.id.decorative_elements_button);
        decorativeInsertsButton.setOnClickListener(this);


        return layout;
    }

    public void onSeatsButtonClick() {
        Intent intent = new Intent(getActivity(), ModifySeatTypeActivity.class);
        startActivity(intent);
    }

    public void onSteeringWheelButtonClick() {
        Intent intent = new Intent(getActivity(), ModifySteeringWheelActivity.class);
        startActivity(intent);
    }

    public void onDecorativeElementsButtonClick() {
        Intent intent = new Intent(getActivity(), DecorativeElementsActivity.class);
        startActivity(intent);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.seats_button:
                onSeatsButtonClick();
                break;
            case R.id.steering_wheel_button:
                onSteeringWheelButtonClick();
                break;
            case R.id.decorative_elements_button:
                onDecorativeElementsButtonClick();
                break;

        }
    }
}
