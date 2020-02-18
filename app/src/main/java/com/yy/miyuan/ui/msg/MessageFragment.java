package com.yy.miyuan.ui.msg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.yy.lib_navigation.FragmentDestination;
import com.yy.miyuan.R;

/**
 * 作者：addison on 2020-02-18 22:26
 * 邮箱：gengxin@tech.youyuan.com
 */
@FragmentDestination(pageUrl = "main/tabs/msg",asStarter = false)
public class MessageFragment extends Fragment {

    private MsgViewModel msgViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        msgViewModel =
                ViewModelProviders.of(this).get(MsgViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        msgViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
