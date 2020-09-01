package com.example.arvaria.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.arvaria.R;

public class HomeFragment extends Fragment{
    public HomeFragment(){

    }

//    pprivate MaterialCardView documents, inventory, expenses, clients, settings;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
//        MaterialCardView documents = (MaterialCardView) v.findViewById(R.id.documents);
//        inventory = (MaterialCardView) findViewById(R.id.inventory);
//        expenses = (MaterialCardView) findViewById(R.id.expenses);
//        clients = (MaterialCardView) findViewById(R.id.clients);
//        settings = (MaterialCardView) findViewById(R.id.settings);
//        documents.setOnClickListener(this);
//        inventory.setOnClickListener(this);
//        expenses.setOnClickListener(this);
//        clients.setOnClickListener(this);
//        settings.setOnClickListener(this);

    }


}
