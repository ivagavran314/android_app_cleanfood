package com.example.ivagavran;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ScreenSlidePageFragment extends Fragment {

    private static final String BUNDLE_MESSAGE1 = "message1";
    private static final String BUNDLE_MESSAGE2 = "message2";
    private TextView messageTextView, textTextView;

    public static ScreenSlidePageFragment newInstance(String message1, String message2) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_MESSAGE1, message1);
        args.putString(BUNDLE_MESSAGE2, message2);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        messageTextView = view.findViewById(R.id.tvMessage);
        textTextView = view.findViewById(R.id.tvText);
        setUpTextView();
    }

    private void setUpTextView() {
        String message1 = getString(R.string.hello_world1);
        if (getArguments() != null) {
            String argMessage = getArguments().getString(BUNDLE_MESSAGE1);
            if (argMessage != null && !argMessage.isEmpty()) {
                message1 = argMessage;
            }
        }
        messageTextView.setText(message1);
        String message2 = getString(R.string.hello_world2);
        if (getArguments() != null) {
            String argMessage = getArguments().getString(BUNDLE_MESSAGE2);
            if (argMessage != null && !argMessage.isEmpty()) {
                message2 = argMessage;
            }
        }
        textTextView.setText(message2);
    }
}