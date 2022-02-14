package edu.up.assignment1cs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.TextView;

/**
 * @author: Kawika Suzuki
 *
 */
public class drawView extends SurfaceView {

    //instance variables for colors and a model of the drawing
    Paint skyBluePaint = new Paint();
    Paint sunOrange = new Paint();
    Paint whiteCloud = new Paint();
    Paint greyBoat = new Paint();
    private drawModel modelOfTheDrawing = new drawModel();

    //instance variables for the size of the ocean and location
    public static final float topOfOcean = 550.0f;
    public static final float leftOfOcean = -100.0f;
    public static final float widthOfOcean = 2100.0f;
    public static final float heightOfOcean = 1200.0f;

    //instance variables for the size of the sun and location
    public static final float topOfSun = 200.0f;
    public static final float leftOfSun = 500.0f;
    public static final float widthOfSun = 1600.0f;
    public static final float heightOfSun = 1000.0f;

    //instance variables for  the size of the part of the cloud on the left of the screen and location
    public static final float topOfCloud1 = 100.0f;
    public static final float leftOfCloud1 = 50.0f;
    public static final float widthOfCloud1 = 500.0f;
    public static final float heightOfCloud1 = 300.0f;

    //instance variables for the size of the part of the cloud on the right of the screen and location
    public static final float topOfCloud2 = 100.0f;
    public static final float leftOfCloud2 = 1500.0f;
    public static final float widthOfCloud2 = 1950.0f;
    public static final float heightOfCloud2 = 300.0f;

    //instance variables for the size of the boat 1
    public static final float topOfBoat1 = 600.0f;
    public static final float leftOfBoat1 = 50.0f;
    public static final float widthOfBoat1 = 500.0f;
    public static final float heightOfBoat1 = 750.0f;

    //instance variables for the size of the boat 2
    public static final float topOfBoat2 = 600.0f;
    public static final float leftOfBoat2 = 1400.0f;
    public static final float widthOfBoat2 = 1950.0f;
    public static final float heightOfBoat2 = 750.0f;

    public drawView(Context context) {
        super(context);
        initialize();
        setWillNotDraw(false);
    }

    public drawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
        setWillNotDraw(false);
    }

    public drawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
        setWillNotDraw(false);
    }

    /**
     * initialize
     *
     * sets up our surface view, it's model for the app
     */
    private void initialize() {
        setWillNotDraw(false);

        //initialize the sky color
        this.skyBluePaint.setColor(0xFF87CEEB);
        this.skyBluePaint.setStyle(Paint.Style.FILL);

        //initialize the suns color
        this.sunOrange.setColor(0xFFF48037);
        this.sunOrange.setStyle(Paint.Style.FILL);

        //initialize the clouds color
        this.whiteCloud.setColor(0xFFF3EEE1);
        this.whiteCloud.setStyle(Paint.Style.FILL);

        //initialize the boats color
        this.greyBoat.setColor(Color.GRAY);
        this.greyBoat.setStyle(Paint.Style.FILL);

        //if the user changes the colors initiate the change from the seekbar
        if (this.modelOfTheDrawing.isSun) {
            this.sunOrange.setARGB(255, this.modelOfTheDrawing.red, this.modelOfTheDrawing.green, this.modelOfTheDrawing.blue);
            this.invalidate();
        }
        if (this.modelOfTheDrawing.isCloud) {
            this.whiteCloud.setARGB(255, this.modelOfTheDrawing.red, this.modelOfTheDrawing.green, this.modelOfTheDrawing.blue);
            this.invalidate();
        }
        if (this.modelOfTheDrawing.isOcean) {
            this.skyBluePaint.setARGB(255, this.modelOfTheDrawing.red, this.modelOfTheDrawing.green, this.modelOfTheDrawing.blue);
            this.invalidate();
        }
        if (this.modelOfTheDrawing.isBoat) {
            this.greyBoat.setARGB(255, this.modelOfTheDrawing.red, this.modelOfTheDrawing.green, this.modelOfTheDrawing.blue);
            this.invalidate();
        }

        //set the color of the background to blue
        this.setBackgroundColor(Color.argb(255,244,216,198));

    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //draw the sun
        canvas.drawOval(leftOfSun, topOfSun, widthOfSun, heightOfSun, sunOrange);
        //draw the ocean
        canvas.drawOval(leftOfOcean, topOfOcean, widthOfOcean, heightOfOcean, skyBluePaint);
        //draw the cloud on the left of the screen
        canvas.drawOval(leftOfCloud1, topOfCloud1, widthOfCloud1, heightOfCloud1, whiteCloud);
        //draw the cloud on the right of the screen
        canvas.drawOval(leftOfCloud2, topOfCloud2, widthOfCloud2, heightOfCloud2, whiteCloud);
        //draw the first boat on the left side of the screen
        canvas.drawRect(leftOfBoat1, topOfBoat1, widthOfBoat1, heightOfBoat1, greyBoat);
        //draw the second boat on the right of the screen
        canvas.drawRect(leftOfBoat2, topOfBoat2, widthOfBoat2, heightOfBoat2, greyBoat);
    }
    /**
     * getName
     *
     * checks to see if one of the statements where the user clicked is true and sets the textview
     * to the name of the place where the user clicked
     */
    public String getName() {

        if (this.modelOfTheDrawing.isSun) {
            return "Sun";
        }
        if (this.modelOfTheDrawing.isCloud) {
            return "Clouds";
        }
        if (this.modelOfTheDrawing.isOcean) {
            return "Ocean";
        }
        if (this.modelOfTheDrawing.isBoat) {
            return "boat";
        }
        return "nothing clicked";
    }


    public drawModel getDrawModel() { return this.modelOfTheDrawing; }
}
