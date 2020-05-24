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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModifyRimsFragment extends Fragment {

    public ModifyRimsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView rimRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_modify_rims,container,false);
        String[] rimTexts = new String[Car.availableRims.length];
        for (int i = 0; i < rimTexts.length; i++) {
            rimTexts[i] = Car.availableRims[i].getName();
        }
        int[] rimImages = new int[Car.availableRims.length];
        for (int i = 0; i < rimImages.length ; i++) {
            rimImages[i] = Car.availableRims[i].getImageID();
        }

        ModelCardsAdapter adapter = new ModelCardsAdapter(rimTexts,rimImages);
        rimRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        rimRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new ModelCardsAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Car.currentCar.setRims(Car.availableRims[position]);
                Intent intent = new Intent(getActivity(),ModifyCarActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(), R.string.rims_selected,Toast.LENGTH_SHORT).show();
            }
        });
        return rimRecycler;
    }
}
