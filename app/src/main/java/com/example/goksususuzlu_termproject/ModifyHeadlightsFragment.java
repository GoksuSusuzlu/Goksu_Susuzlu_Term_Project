package com.example.goksususuzlu_termproject;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModifyHeadlightsFragment extends Fragment {

    public ModifyHeadlightsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView headlightsRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_modify_headlights,container,false);
        String[] headlightTexts = new String[Car.availableHeadlights.length];
        for (int i = 0; i < headlightTexts.length ; i++) {
            headlightTexts[i] = Car.availableHeadlights[i].getName();
        }
        int[] headlightImages = new int[Car.availableHeadlights.length];
        for (int i = 0; i <headlightImages.length ; i++) {
            headlightImages[i] = Car.availableHeadlights[i].getImageID();
        }

        ModelCardsAdapter adapter = new ModelCardsAdapter(headlightTexts,headlightImages);
        headlightsRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        headlightsRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new ModelCardsAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Car.currentCar.setHeadlights(Car.availableHeadlights[position]);
                Intent intent = new Intent(getActivity(),ModifyCarActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(), R.string.headlights_selected,Toast.LENGTH_SHORT).show();

            }
        });


        return  headlightsRecycler;
    }
}
