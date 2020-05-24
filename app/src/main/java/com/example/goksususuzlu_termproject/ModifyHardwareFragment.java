package com.example.goksususuzlu_termproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModifyHardwareFragment extends Fragment implements View.OnClickListener {
    private View layout;

    public ModifyHardwareFragment() {
        // Required empty public constructor
    }
    private void smartphoneInterfaceButtonClick(){
        Button thisButton = layout.findViewById(R.id.smartphone_interface_button);
        if (!Car.currentCar.isSmartphoneInterface()){
            thisButton.setText(R.string.button_text_remove);
            Snackbar.make(layout,"Smartphone interface added.",Snackbar.LENGTH_SHORT).show();
            Car.currentCar.setSmartphoneInterface(true);
        }else{
            thisButton.setText(R.string.button_text_add);
            Snackbar.make(layout,"Smartphone interface removed.",Snackbar.LENGTH_SHORT).show();
            Car.currentCar.setSmartphoneInterface(false);
        }

    }

    private void virtualCockpitButtonClick(){
        Button thisButton = layout.findViewById(R.id.virtual_cockpit_button);
        if (!Car.currentCar.isVirtualCockpit()){
            thisButton.setText(R.string.button_text_remove);
            Snackbar.make(layout,"Virtual cockpit added.",Snackbar.LENGTH_SHORT).show();
            Car.currentCar.setVirtualCockpit(true);
        }else{
            thisButton.setText(R.string.button_text_add);
            Snackbar.make(layout,"Virtual cockpit removed.",Snackbar.LENGTH_SHORT).show();
            Car.currentCar.setVirtualCockpit(false);
        }

    }

    private void parkAssistantButtonClick(){
        Button thisButton = layout.findViewById(R.id.park_assist_button);
        if (!Car.currentCar.isParkAssistant()){
            thisButton.setText(R.string.button_text_remove);
            Snackbar.make(layout,"Park assistant added.",Snackbar.LENGTH_SHORT).show();
            Car.currentCar.setParkAssistant(true);
        }else{
            thisButton.setText(R.string.button_text_add);
            Snackbar.make(layout,"Park assistant removed.",Snackbar.LENGTH_SHORT).show();
            Car.currentCar.setParkAssistant(false);
        }

    }

    private void hillStartAssistButtonClick(){
        Button thisButton = layout.findViewById(R.id.hill_start_assist_button);
        if (!Car.currentCar.isHillStartAssist()){
            thisButton.setText(R.string.button_text_remove);
            Snackbar.make(layout,"Hill start assist added.",Snackbar.LENGTH_SHORT).show();
            Car.currentCar.setHillStartAssist(true);
        }else{
            thisButton.setText(R.string.button_text_add);
            Snackbar.make(layout,"Hill start assist removed.",Snackbar.LENGTH_SHORT).show();
            Car.currentCar.setHillStartAssist(false);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_modify_hardware, container, false);
        // Inflate the layout for this fragment
        Button smartPhoneInterfaceButton = layout.findViewById(R.id.smartphone_interface_button);
        if (!Car.currentCar.isSmartphoneInterface()){
            smartPhoneInterfaceButton.setText(R.string.button_text_add);
        }else{
            smartPhoneInterfaceButton.setText(R.string.button_text_remove);
        }
        smartPhoneInterfaceButton.setOnClickListener(this);

        Button virtualCockpitButton = layout.findViewById(R.id.virtual_cockpit_button);
        if (!Car.currentCar.isVirtualCockpit()){
            virtualCockpitButton.setText(R.string.button_text_add);
        }else{
            virtualCockpitButton.setText(R.string.button_text_remove);
        }
        virtualCockpitButton.setOnClickListener(this);

        Button parkAssistantButton = layout.findViewById(R.id.park_assist_button);
        if (!Car.currentCar.isParkAssistant()){
            parkAssistantButton.setText(R.string.button_text_add);
        }else{
            parkAssistantButton.setText(R.string.button_text_remove);
        }
        parkAssistantButton.setOnClickListener(this);

        Button hillStartAssistButton = layout.findViewById(R.id.hill_start_assist_button);
        if (!Car.currentCar.isHillStartAssist()){
            hillStartAssistButton.setText(R.string.button_text_add);
        }else{
            hillStartAssistButton.setText(R.string.button_text_remove);
        }
        hillStartAssistButton.setOnClickListener(this);
        return layout;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.virtual_cockpit_button:
                virtualCockpitButtonClick();
                break;
            case R.id.smartphone_interface_button:
                smartphoneInterfaceButtonClick();
                break;
            case R.id.park_assist_button:
                parkAssistantButtonClick();
                break;
            case R.id.hill_start_assist_button:
                hillStartAssistButtonClick();

        }
    }


}
