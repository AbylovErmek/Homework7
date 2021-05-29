package com.geektech.homework7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Objects;

public class ChooseColorDialog extends DialogFragment {

    @SuppressWarnings("FieldCanBeLocal")
    private RadioGroup rg;
    private RadioButton red, blue, black, yellow;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_radio_button, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);

        listeners();
    }

    @SuppressLint("NonConstantResourceId")
    private void listeners() {

        rg.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.rb_blue_btn:
                    onBtnClick(getResources().getColor(R.color.purple_700));
                    break;
            }
        });
    }

    private void onBtnClick(int color){
        button.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.putExtra("Constants.key.Color", color);
            startActivity(intent);
//            Objects.requireNonNull(getDialog()).dismiss();
        });
    }

    private void init(View view) {
        rg = view.findViewById(R.id.radio_group);
        button = view.findViewById(R.id.btn);
        red = view.findViewById(R.id.rb_blue_btn);
        blue = view.findViewById(R.id.rb2);
        black = view.findViewById(R.id.rb3);
        yellow = view.findViewById(R.id.rb4);

    }
}