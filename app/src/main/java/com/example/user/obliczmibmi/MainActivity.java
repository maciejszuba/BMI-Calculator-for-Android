package com.example.user.obliczmibmi;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.weight_seekbar_tens)
    SeekBar weightTensSeekbar;
    @BindView(R.id.weight_seekbar_units)
    SeekBar weightUnitsSeekbar;
    @BindView(R.id.weight_seekbar_value_display)
    TextView weightSeekbarValueDisplay;

    @BindView(R.id.height_seekbar_tens)
    SeekBar heightTensSeekBar;
    @BindView(R.id.height_seekbar_units)
    SeekBar heightUnitsSeekbar;
    @BindView(R.id.height_seekbar_value_display)
    TextView heightSeekbarValueDisplay;

    @BindView(R.id.display)
    TextView bmiDisplay;
    @BindView(R.id.spooky_skeleton)
    ImageView leftSkeleton;
    @BindView(R.id.spooky_skeleton2)
    ImageView rightSkeleton;
    private Counter counter;
    private int weightTens;
    private int weightUnits;
    private int heightTens;
    private int heightUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    private void init() {
        ButterKnife.bind(this);
        counter = new Counter();
        setSeekBars();
    }

    private void setSeekBars() {
        weightTensSeekbar.setMax(9);
        weightTensSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                weightTens = progress;
                setWeight();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        weightUnitsSeekbar.setMax(9);
        weightUnitsSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                weightUnits = progress;
                setWeight();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        heightTensSeekBar.setMax(10);
        heightTensSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                heightTens = progress;
                setHeight();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        heightUnitsSeekbar.setMax(9);
        heightUnitsSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                heightUnits = progress;
                setHeight();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setWeight() {
        weightSeekbarValueDisplay.setText(String.valueOf(((weightTens * 10) + 30) + weightUnits));
        float rotation = leftSkeleton.getScaleX();
        if (rotation == 1) {
            leftSkeleton.setScaleX(-1);
        } else {
            leftSkeleton.setScaleX(1);
        }
    }

    private void setHeight() {
        heightSeekbarValueDisplay.setText(String.valueOf(((heightTens * 10) + 100) + heightUnits));
        float rotation = rightSkeleton.getScaleX();
        if (rotation == -1) {
            rightSkeleton.setScaleX(1);
        } else {
            rightSkeleton.setScaleX(-1);
        }
    }

    @OnClick(R.id.count)
    public void countBmi() {
        double weight = Integer.parseInt(weightSeekbarValueDisplay.getText().toString());
        double height = Integer.parseInt(heightSeekbarValueDisplay.getText().toString());
        bmiDisplay.setText(counter.countBMI(weight, height));

    }

}
