package com.lanjing.easytoastlibrary;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;


/**
 * Created by rahul on 28/7/16.
 */
public class EasyToast {
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;


    public static final int SUCCESS = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;
    public static final int INFO = 4;
    public static final int DEFAULT = 5;
    public static final int CONFUSING = 6;

    static SuccessToastView successToastView;
    static WarningToastView warningToastView;
    static ErrorToastView errorToastView;
    static InfoToastView infoToastView;
    static DefaultToastView defaultToastView;
    static ConfusingToastView confusingToastView;

    public static void showLongToast(Context context, CharSequence llw) {
        Toast.makeText(context.getApplicationContext(), llw, Toast.LENGTH_LONG).show();
    }

    public static void showShortToast(Context context, CharSequence llw) {
        Toast.makeText(context.getApplicationContext(), llw, Toast.LENGTH_SHORT).show();
    }


    public static Toast showShortSuccessToast(Context context,CharSequence llw){

        Toast toast = new Toast(context);

        View layout = LayoutInflater.from(context).inflate(R.layout.success_toast_layout, null, false);
        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(llw);
        successToastView = (SuccessToastView) layout.findViewById(R.id.successView);
        successToastView.startAnim();
        text.setBackgroundResource(R.drawable.success_toast);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
        return toast;
    }

    public static Toast showShortWarningToast(Context context,CharSequence llw){

        Toast toast = new Toast(context);
        View layout = LayoutInflater.from(context).inflate(R.layout.warning_toast_layout, null, false);
        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(llw);

        warningToastView = (WarningToastView) layout.findViewById(R.id.warningView);
        SpringSystem springSystem = SpringSystem.create();
        final Spring spring = springSystem.createSpring();
        spring.setCurrentValue(1.8);
        SpringConfig config = new SpringConfig(40, 5);
        spring.setSpringConfig(config);
        spring.addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                float value = (float) spring.getCurrentValue();
                float scale = (float) (0.9f - (value * 0.5f));

                warningToastView.setScaleX(scale);
                warningToastView.setScaleY(scale);
            }
        });
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                spring.setEndValue(0.4f);
            }
        });
        t.start();
        text.setBackgroundResource(R.drawable.warning_toast);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        toast.setView(layout);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
        return toast;
    }

    public static Toast showShortErrorToast(Context context,CharSequence llw){

        Toast toast = new Toast(context);

        View layout = LayoutInflater.from(context).inflate(R.layout.error_toast_layout, null, false);

        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(llw);
        errorToastView = (ErrorToastView) layout.findViewById(R.id.errorView);
        errorToastView.startAnim();
        text.setBackgroundResource(R.drawable.error_toast);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        toast.setView(layout);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
        return toast;
    }

    public static Toast showShortInfoToast(Context context,CharSequence llw){

        Toast toast = new Toast(context);

        View layout = LayoutInflater.from(context).inflate(R.layout.info_toast_layout, null, false);

        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(llw);
        infoToastView = (InfoToastView) layout.findViewById(R.id.infoView);
        infoToastView.startAnim();
        text.setBackgroundResource(R.drawable.info_toast);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        toast.setView(layout);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
        return toast;
    }

    public static Toast showShortDefaultToast(Context context,CharSequence llw){

        Toast toast = new Toast(context);

        View layout = LayoutInflater.from(context).inflate(R.layout.default_toast_layout, null, false);

        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(llw);
        defaultToastView = (DefaultToastView) layout.findViewById(R.id.defaultView);
        defaultToastView.startAnim();
        text.setBackgroundResource(R.drawable.default_toast);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        toast.setView(layout);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
        return toast;
    }

    public static Toast showShortConfusingToast(Context context,CharSequence llw){

        Toast toast = new Toast(context);

        View layout = LayoutInflater.from(context).inflate(R.layout.confusing_toast_layout, null, false);
        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(llw);
        confusingToastView = (ConfusingToastView) layout.findViewById(R.id.confusingView);
        confusingToastView.startAnim();
        text.setBackgroundResource(R.drawable.confusing_toast);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        toast.setView(layout);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
        return toast;
    }

    public static Toast showLongSuccessToast(Context context,CharSequence llw){

        Toast toast = new Toast(context);

        View layout = LayoutInflater.from(context).inflate(R.layout.success_toast_layout, null, false);
        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(llw);
        successToastView = (SuccessToastView) layout.findViewById(R.id.successView);
        successToastView.startAnim();
        text.setBackgroundResource(R.drawable.success_toast);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
        return toast;
    }

    public static Toast showLongWarningToast(Context context,CharSequence llw){

        Toast toast = new Toast(context);
        View layout = LayoutInflater.from(context).inflate(R.layout.warning_toast_layout, null, false);
        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(llw);

        warningToastView = (WarningToastView) layout.findViewById(R.id.warningView);
        SpringSystem springSystem = SpringSystem.create();
        final Spring spring = springSystem.createSpring();
        spring.setCurrentValue(1.8);
        SpringConfig config = new SpringConfig(40, 5);
        spring.setSpringConfig(config);
        spring.addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                float value = (float) spring.getCurrentValue();
                float scale = (float) (0.9f - (value * 0.5f));

                warningToastView.setScaleX(scale);
                warningToastView.setScaleY(scale);
            }
        });
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                spring.setEndValue(0.4f);
            }
        });
        t.start();
        text.setBackgroundResource(R.drawable.warning_toast);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        toast.setView(layout);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
        return toast;
    }

    public static Toast showLongErrorToast(Context context,CharSequence llw){

        Toast toast = new Toast(context);

        View layout = LayoutInflater.from(context).inflate(R.layout.error_toast_layout, null, false);

        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(llw);
        errorToastView = (ErrorToastView) layout.findViewById(R.id.errorView);
        errorToastView.startAnim();
        text.setBackgroundResource(R.drawable.error_toast);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        toast.setView(layout);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
        return toast;
    }

    public static Toast showLongInfoToast(Context context,CharSequence llw){

        Toast toast = new Toast(context);

        View layout = LayoutInflater.from(context).inflate(R.layout.info_toast_layout, null, false);

        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(llw);
        infoToastView = (InfoToastView) layout.findViewById(R.id.infoView);
        infoToastView.startAnim();
        text.setBackgroundResource(R.drawable.info_toast);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        toast.setView(layout);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
        return toast;
    }

    public static Toast showLongDefaultToast(Context context,CharSequence llw){

        Toast toast = new Toast(context);

        View layout = LayoutInflater.from(context).inflate(R.layout.default_toast_layout, null, false);

        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(llw);
        defaultToastView = (DefaultToastView) layout.findViewById(R.id.defaultView);
        defaultToastView.startAnim();
        text.setBackgroundResource(R.drawable.default_toast);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        toast.setView(layout);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
        return toast;
    }

    public static Toast showLongConfusingToast(Context context,CharSequence llw){

        Toast toast = new Toast(context);

        View layout = LayoutInflater.from(context).inflate(R.layout.confusing_toast_layout, null, false);
        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(llw);
        confusingToastView = (ConfusingToastView) layout.findViewById(R.id.confusingView);
        confusingToastView.startAnim();
        text.setBackgroundResource(R.drawable.confusing_toast);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        toast.setView(layout);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
        return toast;
    }

}
