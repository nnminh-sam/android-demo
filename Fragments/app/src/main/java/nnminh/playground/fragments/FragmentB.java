package nnminh.playground.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {
    private TextView counterView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        this.counterView = v.findViewById(R.id.counterView);
        return v;
    }

    public interface Counter {
        public void incrementValue(int value);
    }

    void updateCounter(int value) {
        this.counterView.setText("Count: " + value);
    }
}
