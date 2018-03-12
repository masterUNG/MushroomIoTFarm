package com.example.soulf.mushroomiotfarm.fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.soulf.mushroomiotfarm.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by soulf on 3/12/2018.
 */

public class CCTVFragment extends Fragment {
    private DatabaseReference databaseReference;
    private String CCTVString;
    private FirebaseDatabase firebaseDatabase;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //                Get Value From Firebase
        getValueFromFirebase();
//      On Controller
        onController();

//        Off Controller
        OffController();




    }  //Main method

    private void OffController() {
        Button button = getView().findViewById(R.id.btnOff);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCCTV("OFF");
            }
        });

    }

    private void updateCCTV(String CCTVString) {
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("CCTV", CCTVString);
        databaseReference.updateChildren(stringObjectMap);

    }

    private void onController() {
        Button button = getView().findViewById(R.id.btnOn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateCCTV("ON");
            }
        });

    }

    private void getValueFromFirebase() {
        final TextView textView = getView().findViewById(R.id.txtCCTV);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                CCTVString = String.valueOf(map.get("CCTV"));

                textView.setText(CCTVString);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        })

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cctv, container, false);

        return view;
    }
}
