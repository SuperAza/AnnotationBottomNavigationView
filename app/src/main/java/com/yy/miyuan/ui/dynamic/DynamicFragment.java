package com.yy.miyuan.ui.dynamic;

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
 * 作者：addison on 2020-02-18 22:24
 * 邮箱：gengxin@tech.youyuan.com
 * 动态Tab
 */
@FragmentDestination(pageUrl = "main/tabs/dynamic",asStarter = false)
public class DynamicFragment  extends Fragment {

    private DynamicViewModel dynamicViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dynamicViewModel =
                ViewModelProviders.of(this).get(DynamicViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        dynamicViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
