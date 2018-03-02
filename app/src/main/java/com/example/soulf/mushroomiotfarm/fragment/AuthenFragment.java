package com.example.soulf.mushroomiotfarm.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soulf.mushroomiotfarm.R;

/**
 * Created by soulf on 3/2/2018.
 */

public class AuthenFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Login Controller
        loginController();

    }  //Main Method

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText userEditText = getView().findViewById(R.id.editUser);
                EditText PasswordEdiText = getView().findViewById(R.id.editPassword);

                String userString = userEditText.getText().toString().trim();
                String passwordString = PasswordEdiText.getText().toString().trim();

                if (userString.isEmpty() || passwordString.isEmpty()) {
//                    Have space
                    Toast.makeText(getActivity(), "Please Fill All Blank", Toast.LENGTH_SHORT).show();
                } else {
//                    No Space

                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authen, container, false);

        return view;
    }
}
