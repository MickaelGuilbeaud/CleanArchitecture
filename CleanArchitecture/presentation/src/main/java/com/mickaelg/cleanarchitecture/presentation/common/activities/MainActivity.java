package com.mickaelg.cleanarchitecture.presentation.common.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.mickaelg.cleanarchitecture.presentation.R;
import com.mickaelg.cleanarchitecture.presentation.posts.fragments.PostsFragment;

import butterknife.ButterKnife;

/**
 * Created by mguilbeaud on 29/07/2015.
 */
public class MainActivity extends BaseActivity {

    // region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setFragment(new PostsFragment());
    }

    protected void setFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_placeholder, fragment)
                .commit();
    }

    // endregion
}
