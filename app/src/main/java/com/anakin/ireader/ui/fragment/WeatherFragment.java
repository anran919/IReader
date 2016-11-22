package com.anakin.ireader.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anakin.ireader.R;
import com.anakin.ireader.model.entity.Weather;
import com.anakin.ireader.model.entity.WeatherInfo;
import com.anakin.ireader.presenter.impl.WeatherPresenterImpl;
import com.anakin.ireader.ui.view.WeatherView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:43
 */
public class WeatherFragment extends BaseFragment implements WeatherView, View.OnClickListener {

    private static final WeatherFragment QUESTIONS_FRAGMENT = new WeatherFragment();
    @Bind(R.id.et_city_no)
    EditText mEtCityNo;
    @Bind(R.id.btn_go)
    Button mBtnGo;
    @Bind(R.id.tv_city)
    TextView mTvCity;
    @Bind(R.id.tv_city_no)
    TextView mTvCityNo;
    @Bind(R.id.tv_temp)
    TextView mTvTemp;
    @Bind(R.id.tv_WD)
    TextView mTvWD;
    @Bind(R.id.tv_WS)
    TextView mTvWS;
    @Bind(R.id.tv_SD)
    TextView mTvSD;
    @Bind(R.id.tv_WSE)
    TextView mTvWSE;
    @Bind(R.id.tv_time)
    TextView mTvTime;
    @Bind(R.id.tv_njd)
    TextView mTvNjd;
    private ProgressDialog mProgressDialog;
    private WeatherPresenterImpl mWeatherPresenter;

    private WeatherFragment() {
    }

    @Override
    public View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
        ButterKnife.bind(this, rootView);
        initData();
        initEvent();
        return rootView;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        mBtnGo.setOnClickListener(this);
        mWeatherPresenter = new WeatherPresenterImpl(this);  // 将View传递到Presenter
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setTitle("正在查询天气......");
    }

    public static WeatherFragment getInstance() {
        return QUESTIONS_FRAGMENT;
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showError() {
        Toast.makeText(mContext, "加载数据失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWeatherInfo(Weather weather) {
        WeatherInfo info = weather.getWeatherInfo();
        mTvCity.setText(info.getCity());
        mEtCityNo.setText(info.getCityid());
        mTvTemp.setText(info.getTemp());
        mTvWD.setText(info.getWD());
        mTvWS.setText(info.getWS());
        mTvSD.setText(info.getSD());
        mTvWS.setText(info.getWS());
        mTvNjd.setText(info.getNjd());
        mTvTime.setText(info.getTime());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_go:
                // 将输入的内容传递到presnter
                mWeatherPresenter.getWeather(mTvCityNo.getText().toString().trim());
                break;
        }
    }
}
