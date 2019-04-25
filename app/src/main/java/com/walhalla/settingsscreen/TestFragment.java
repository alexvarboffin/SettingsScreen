package com.walhalla.settingsscreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TestFragment extends Fragment {

    private int id;

    public static TestFragment newInstance(int id) {
        TestFragment fragment = new TestFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("l1", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(id, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button ok = view.findViewById(R.id.ok);
        ok.setOnClickListener(v -> {
            MyView myView = view.findViewById(R.id.my_view);
            MyViewGroup myVigroupw = view.findViewById(R.id.my_view_group);

            myView.setExampleString("" + System.currentTimeMillis());
            myVigroupw.setExampleString("" + System.currentTimeMillis());
        });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            this.id = getArguments().getInt("l1");
        }
    }
}
