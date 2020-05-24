package com.example.goksususuzlu_termproject;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectMotorFragment extends ListFragment {
    public static final String CAR_MODEL = "model";

    private Car newCar = new Car();
    private Listener listener;

    public Car getNewCar() {
        return newCar;
    }

    public void setNewCar(Car newCar) {
        this.newCar = newCar;
    }

    interface Listener{
        void itemClicked(long id);
    }

    public SelectMotorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int modelID = (int) getActivity().getIntent().getExtras().get(CAR_MODEL);
        newCar.setModel(Car.cars[modelID].getModel());
        newCar.setSelectedCarMotors(modelID);

        String[] motors = new String[newCar.getSelectedCarMotors().length];
        for (int i = 0; i < motors.length ; i++) {
            motors[i] = newCar.getSelectedCarMotors()[i];
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(),android.R.layout.simple_list_item_1,motors);
        setListAdapter(adapter);


        return super.onCreateView(inflater,container,savedInstanceState);


    }
    public void onAttach(Context context) {

        super.onAttach(context);
        this.listener = (Listener) context;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        if (listener!= null){
            listener.itemClicked(id);
        }
    }
}
