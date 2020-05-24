package com.example.goksususuzlu_termproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModifySteeringWheelFragment extends Fragment {

    public ModifySteeringWheelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView steeringWheelRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_modify_steering_wheel,container,false);
        String[] steeringWheelTexts = new String[Car.availableSteeringWheels.length];
        for (int i = 0; i < steeringWheelTexts.length ; i++) {
            steeringWheelTexts[i] = Car.availableSteeringWheels[i].getWheelType();
        }
        int[] steeringWheelImages = new int[Car.availableSteeringWheels.length];
        for (int i = 0; i < steeringWheelImages.length; i++) {
            steeringWheelImages[i] = Car.availableSteeringWheels[i].getImageID();
        }

        ModelCardsAdapter adapter = new ModelCardsAdapter(steeringWheelTexts,steeringWheelImages);
        steeringWheelRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        steeringWheelRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new ModelCardsAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Car.currentCar.setSteeringWheel(Car.availableSteeringWheels[position]);
                Intent intent = new Intent(getActivity(),ModifyCarActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(), R.string.steering_wheel_selected,Toast.LENGTH_SHORT).show();

            }
        });

        return steeringWheelRecycler;
    }
}
