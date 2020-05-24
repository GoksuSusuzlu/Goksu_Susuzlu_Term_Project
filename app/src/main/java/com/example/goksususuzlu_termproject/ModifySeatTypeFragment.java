package com.example.goksususuzlu_termproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModifySeatTypeFragment extends Fragment {

    public ModifySeatTypeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView seatTypeRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_modify_seat_type,container,false);
        String[] seatTypeTexts = new String[Car.availableSeats.length];
        for (int i = 0; i < seatTypeTexts.length; i++) {
            seatTypeTexts[i] = Car.availableSeats[i].getSeatType();
        }
        int[] seatTypeImages = new int[Car.availableSeats.length];
        for (int i = 0; i < seatTypeImages.length ; i++) {
            seatTypeImages[i] = Car.availableSeats[i].getSeatTypeImageID();
        }

        ModelCardsAdapter adapter = new ModelCardsAdapter(seatTypeTexts,seatTypeImages);
        seatTypeRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        seatTypeRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new ModelCardsAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Car.currentCar.setSeat(Car.availableSeats[position]);
                Intent intent = new Intent(getActivity(),ModifySeatFurnishingActivity.class);
                startActivity(intent);
            }
        });

        return seatTypeRecycler;
    }
}
