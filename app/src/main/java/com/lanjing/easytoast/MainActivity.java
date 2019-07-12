package com.lanjing.easytoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


import com.lanjing.easytoastlibrary.EasyToast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.success)
    Button success;
    @BindView(R.id.warning)
    Button warning;
    @BindView(R.id.error)
    Button error;
    @BindView(R.id.info)
    Button info;
    @BindView(R.id.default_e)
    Button defaultE;
    @BindView(R.id.confusion)
    Button confusion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ButterKnife.bind(this);
    }

    public void showSuccessToast(View view) {
        EasyToast.showShortSuccessToast(getApplicationContext(),"成功");
    }

    public void showWarningToast(View view) {
        EasyToast.showShortWarningToast(getApplicationContext(),"警告");
    }

    public void showErrorToast(View view) {
        EasyToast.showShortErrorToast(getApplicationContext(),"错误");
    }

    public void showInfoToast(View view) {
        EasyToast.showShortInfoToast(getApplicationContext(),"信息");
    }

    public void showDefaultToast(View view) {
        EasyToast.showShortDefaultToast(getApplicationContext(),"默认");
    }

    public void showConfusionToast(View view) {
        EasyToast.showShortConfusingToast(getApplicationContext(),"困惑");
    }

}
