package com.mickaelg.cleanarchitecture.presentation.common.fragments;

import android.support.v4.app.Fragment;

import com.mickaelg.cleanarchitecture.presentation.common.di.HasComponent;

/**
 * Base {@link Fragment} class for every fragment in this application.
 */
public abstract class BaseFragment extends Fragment {

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>)getActivity()).getComponent());
    }
}
