package com.ckt.ued.sioeye.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ckt.ued.sioeye.R;
import com.ckt.ued.sioeye.activity.EditAccountActivity;
import com.ckt.ued.sioeye.activity.SettingsActivity;

/**
 * Created by ckt on 12/14/16.
 */

public class MeFragment extends Fragment {
    private TextView tvSetting;
    private RelativeLayout rlUser;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_me, container, false);
        tvSetting = (TextView) rootView.findViewById(R.id.tv_setting);
        rlUser = (RelativeLayout) rootView.findViewById(R.id.rl_user);
        tvSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });
        rlUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), EditAccountActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
