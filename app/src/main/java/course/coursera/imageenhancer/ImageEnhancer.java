package course.coursera.imageenhancer;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class ImageEnhancer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_enhancer);

        final ImageView smallImage = (ImageView)findViewById(R.id.small);
        smallImage.setImageResource(R.drawable.android);

        final ImageView largeImage = (ImageView) findViewById(R.id.large);
        largeImage.setImageResource(R.drawable.android);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.seek);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int lastProgress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lastProgress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                largeImage.setColorFilter(Color.argb(255,0,lastProgress,255-lastProgress));
            }
        });
    }
}
