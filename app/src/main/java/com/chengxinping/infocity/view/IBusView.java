package com.chengxinping.infocity.view;

/**
 * Created by 平瓶平瓶子 on 2017/3/19.
 */

public interface IBusView {
    void showLoading();

    void hideLoading();

    void showError();

    void hideError();

    void showSnackBar(String message);

    void search();
}
