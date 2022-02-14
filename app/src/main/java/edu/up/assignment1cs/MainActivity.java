package edu.up.assignment1cs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @author: Kawika Suzuki
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawView DrawView = (drawView) findViewById(R.id.image);
        drawController DrawController = new drawController(DrawView);

        //retrieve a reference to the red seek bar
        SeekBar RedSeekBar = findViewById(R.id.redSeekBar);
        RedSeekBar.setOnSeekBarChangeListener(DrawController);
        //retrieve a reference to the green seek bar
        SeekBar GreenSeekBar = findViewById(R.id.greenSeekBar);
        GreenSeekBar.setOnSeekBarChangeListener(DrawController);
        //retrieve a reference to the blue seek bar
        SeekBar BlueSeekBar = findViewById(R.id.blueSeekBar);
        BlueSeekBar.setOnSeekBarChangeListener(DrawController);
        //retrieve a reference to the on touch listener
        DrawView.setOnTouchListener(DrawController);
        //retrieve a reference to the text view and call the get name on it
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(DrawView.getName());

    }
}