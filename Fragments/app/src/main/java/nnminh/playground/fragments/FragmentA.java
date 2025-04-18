package nnminh.playground.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {
     Button clickMeBtn;
     int count=0;

    private FragmentB.Counter counter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        this.clickMeBtn = v.findViewById(R.id.clickMeBtn);
        this.clickMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                counter = (FragmentB.Counter) getActivity();
//                assert counter == null;
                counter.incrementValue(count);
//                MainActivity mainActivity = (MainActivity) getActivity();
//                assert mainActivity != null;
//                mainActivity.incrementValue(count);
            }
        });
        return v;
    }
}
