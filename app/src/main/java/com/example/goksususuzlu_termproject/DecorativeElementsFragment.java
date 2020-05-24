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
public class DecorativeElementsFragment extends Fragment {

    public DecorativeElementsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView decorativeElementsRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_decorative_elements,container,false);
        String[] decorativeTexts = new String[Car.availableDecorativeInserts.length];
        for (int i = 0; i < decorativeTexts.length; i++) {
            decorativeTexts[i] = Car.availableDecorativeInserts[i].getName();
        }
        int[] decorativeImages = new int[Car.availableDecorativeInserts.length];
        for (int i = 0; i < decorativeImages.length ; i++) {
            decorativeImages[i] = Car.availableDecorativeInserts[i].getImageID();
        }

        ModelCardsAdapter adapter = new ModelCardsAdapter(decorativeTexts,decorativeImages);
        decorativeElementsRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        decorativeElementsRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new ModelCardsAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Car.currentCar.setDecorativeElements(Car.availableDecorativeInserts[position]);
                Intent intent = new Intent(getActivity(),ModifyCarActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(),"Decorative elements customized.",Toast.LENGTH_SHORT).show();
            }
        });
        return decorativeElementsRecycler;
    }
}
