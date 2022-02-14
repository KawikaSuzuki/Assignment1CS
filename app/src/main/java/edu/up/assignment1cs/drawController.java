package edu.up.assignment1cs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

/**
 * @author: Kawika Suzuki
 *
 */
public class drawController implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

    private drawView DrawView; //private reference to drawView
    private drawModel DrawModel; //private reference to drawModel

    public drawController(drawView viewOfDrawing) {
        this.DrawView = viewOfDrawing;

        this.DrawModel = DrawView.getDrawModel();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()) {
            case R.id.redSeekBar:
                if (b) {
                    this.DrawModel.red = i;
                    break;
                }
            case R.id.greenSeekBar:
                if (b) {
                    this.DrawModel.green = i;
                    break;
                }
            case R.id.blueSeekBar:
                if (b) {
                    this.DrawModel.blue = i;
                    break;
                }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        //check to see if the touch was in line with the sun
        if (x >= 500.0f && x <= 1500.0f) {
            if (y >= 200.0f && y <= 1000.0f) {
                DrawModel.isSun = true;
                return true;
            }
        }
        //check to see if the touch was in line with the cloud 1
        if (x >= 50.0f && x <= 500.0f) {
            if (y >= 100.0f && y <= 300.0f) {
                DrawModel.isCloud = true;
                return true;
            }
        }
        //check to see if the touch was in line with cloud 2
        if (x >= 1500.0f && x <= 1950.0f) {
            if (y >= 100.0f && y <= 300.0f) {
                DrawModel.isCloud = true;
                return true;
            }
        }
        //check to see if the touch was in line with the ocean
        if (x >= -100.0f && x <= 2100.0f) {
            if (y >= 550.0f && y <= 1200.0f) {
               DrawModel.isOcean = true;
               return true;
            }
        }
        //check to see if the touch was in line with boat 1
        if (x >= 50.0f && x <= 500.0f) {
            if (y >= 600.0f && y <= 750.0f) {
                DrawModel.isBoat = true;
                return true;
            }
        }
        //check to see if the touch was in line with boat 2
        if (x >= 1400.0f && x <= 1950.0f) {
            if (y >= 600.0f && y <= 750.0f) {
                DrawModel.isBoat = true;
                return true;
            }
        }
        return false;
    }
}
