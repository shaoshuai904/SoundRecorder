package com.maple.soundrecorder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.maple.soundrecorder.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author maple
 * @time 2018/2/27.
 */
public class MsTimerView extends FrameLayout {
    @BindView(R.id.ll_time_root) LinearLayout llTimeRoot;
    @BindView(R.id.iv_minute_decade) ImageView ivMinuteDecade;// 分钟_十位
    @BindView(R.id.iv_minute_unit) ImageView ivMinuteUnit;// 分钟_个位
    @BindView(R.id.iv_second_decade) ImageView ivSecondDecade;// 秒_十位
    @BindView(R.id.iv_second_unit) ImageView ivSecondUnit;// 秒_个位

    private Context mContext;
    private View mView;
    private String mTimerFormat;
    int[] numberResArr = new int[]{
            R.drawable.number_0,
            R.drawable.number_1,
            R.drawable.number_2,
            R.drawable.number_3,
            R.drawable.number_4,
            R.drawable.number_5,
            R.drawable.number_6,
            R.drawable.number_7,
            R.drawable.number_8,
            R.drawable.number_9
    };

    public MsTimerView(Context context) {
        this(context, null);
    }

    public MsTimerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MsTimerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.setClickable(true);
        this.mContext = context;
        init();
    }

    private void init() {
        mView = View.inflate(mContext, R.layout.view_time, this);
        ButterKnife.bind(this, mView);

        mTimerFormat = getResources().getString(R.string.timer_format);
    }

    public void setTimerView(long time) {
        String timeStr = String.format(mTimerFormat, time / 60, time % 60);
        llTimeRoot.removeAllViews();
        for (int i = 0; i < timeStr.length(); i++) {
            llTimeRoot.addView(getTimerImag(timeStr.charAt(i)));
        }
    }

    public void setTimer(long time) {
        String timeStr = String.format(mTimerFormat, time / 60, time % 60);

        ivMinuteDecade.setImageResource(numberResArr[3]);
        ivMinuteUnit.setImageResource(getTimerImage(timeStr.charAt(3)));
        ivSecondDecade.setImageResource(getTimerImage(timeStr.charAt(1)));
        ivSecondUnit.setImageResource(getTimerImage(timeStr.charAt(0)));

    }

    private ImageView getTimerImag(char number) {
        ImageView image = new ImageView(getContext());
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        if (number != ':') {
            image.setBackgroundResource(R.drawable.background_number);
        }
        switch (number) {
            case '0':
                image.setImageResource(R.drawable.number_0);
                break;
            case '1':
                image.setImageResource(R.drawable.number_1);
                break;
            case '2':
                image.setImageResource(R.drawable.number_2);
                break;
            case '3':
                image.setImageResource(R.drawable.number_3);
                break;
            case '4':
                image.setImageResource(R.drawable.number_4);
                break;
            case '5':
                image.setImageResource(R.drawable.number_5);
                break;
            case '6':
                image.setImageResource(R.drawable.number_6);
                break;
            case '7':
                image.setImageResource(R.drawable.number_7);
                break;
            case '8':
                image.setImageResource(R.drawable.number_8);
                break;
            case '9':
                image.setImageResource(R.drawable.number_9);
                break;
            case ':':
                image.setImageResource(R.drawable.colon);
                break;
        }
        image.setLayoutParams(lp);
        return image;
    }

    private int getTimerImage(int number) {
        int[] resArr = new int[]{
                R.drawable.number_0,
                R.drawable.number_1,
                R.drawable.number_2,
                R.drawable.number_3,
                R.drawable.number_4,
                R.drawable.number_5,
                R.drawable.number_6,
                R.drawable.number_7,
                R.drawable.number_8,
                R.drawable.number_9
        };
        return resArr[number];
    }

}
