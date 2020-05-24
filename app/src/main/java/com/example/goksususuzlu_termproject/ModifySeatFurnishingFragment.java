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


public class ModifySeatFurnishingFragment extends Fragment {

    public ModifySeatFurnishingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView seatFurnishingRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_modify_seat_furnishing,container,false);
        String[] seatFurnishingTexts = new String[Car.availableSeatFurnishings.length];
        for (int i = 0; i < seatFurnishingTexts.length ; i++) {
            seatFurnishingTexts[i] = Car.availableSeatFurnishings[i].getName();
        }
        int[] seatFurnishingImages = new int[Car.availableSeatFurnishings.length];
        for (int i = 0; i < seatFurnishingImages.length; i++) {
            seatFurnishingImages[i] = Car.availableSeatFurnishings[i].getImageID();
        }

        ModelCardsAdapter adapter = new ModelCardsAdapter(seatFurnishingTexts,seatFurnishingImages);
        seatFurnishingRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        seatFurnishingRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new ModelCardsAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Car.currentCar.getSeat().setFurnishing(Car.availableSeatFurnishings[position]);
                Intent intent = new Intent(getActivity(),ModifyCarActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(), R.string.seats_configured,Toast.LENGTH_SHORT).show();
            }
        });

        return seatFurnishingRecycler;

    }
}
