package com.rafaels.secondsamplemvp.main_activity;

import com.rafaels.secondsamplemvp.model.Notice;

import java.util.ArrayList;

public interface MainContract {

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched
     * from the GetNoticeInteractorImpl class
     **/
    interface MainView {
        void showProgress();
        void hideProgress();
        void setDataToRecyclerView(ArrayList<Notice> noticeArrayList);
        void onResponseFailure(Throwable throwable);

    }

    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface Presenter{
        void onDestroy();
        void onRefreshButtonClick();
        void requestDataFromServer();
    }

    /**
     * Intractors are classes built for fetching data from your database,
     * web services, or any other data source.
     **/
    interface GetNoticeIntractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<Notice> noticeArrayList);
            void onFailure(Throwable t);
        }

        void getNoticeArrayList(OnFinishedListener onFinishedListener);
    }

}
