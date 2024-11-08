package com.example.imageexperiment;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;


public class MainActivity extends AppCompatActivity {
    private RelativeLayout layout;
    private boolean isBackgroundOne = true;private int currentBackgroundIndex = 0;
    private int[] backgrounds = { R.drawable.bsh2, R.drawable.bsh3, R.drawable.bird, R.drawable.bird2 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        Button switchBackgroundButton =
                findViewById(R.id.switchBackgroundButton);
        switchBackgroundButton.setOnClickListener(v -> {
            applyFadeAnimation();
            currentBackgroundIndex = (currentBackgroundIndex + 1) % backgrounds.length;
            layout.setBackgroundResource(backgrounds[currentBackgroundIndex]);
        });
    }
        private void applyFadeAnimation() {
            AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
            fadeOut.setDuration(300);
            fadeOut.setFillAfter(true);

            AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
            fadeIn.setDuration(300);
            fadeIn.setFillAfter(true);

            layout.startAnimation(fadeOut);
            layout.startAnimation(fadeIn);
        }
    }
