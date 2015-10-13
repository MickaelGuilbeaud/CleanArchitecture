package com.mickaelg.cleanarchitecture.presentation.common.presenter;

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 * Hold the base methods that every Presenter have to implement.
 */
public interface IBasePresenter {

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    void pause();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    void destroy();
}
