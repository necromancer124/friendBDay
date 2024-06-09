package com.example.romasbirthday;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.romasbirthday.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private MediaPlayer nuhuhh;
    private MediaPlayer hid;
    private ImageView imageView;
    private ImageButton imageButton;
    private Handler handler;
    private int screenWidth, screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.imageButton);
imageView=findViewById(R.id.hhh);
        // Get screen dimensions
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;

        // Start moving the ImageButton
        startMovingImageButton();
        hid=MediaPlayer.create(this,R.raw.hide);
        nuhuhh=MediaPlayer.create(this,R.raw.nuhuhh);
mediaPlayer=MediaPlayer.create(this,R.raw.boom);
        nuhuhh.setVolume(1.0f, 1.0f);
        mediaPlayer.setVolume(1.0f, 1.0f);
        hid.setVolume(1.0f,1.0f);
        hid.start();
        // Set touch listener to handle button click
        imageButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Button clicked, stop moving and show message
                    stopMovingImageButton();
                    Toast.makeText(MainActivity.this, "Button clicked!", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }

    // Method to start moving ImageButton periodically
    private void startMovingImageButton() {
        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                moveImageButtonRandomly();
                handler.postDelayed(this, 100); // Move the button every 2 seconds
            }
        }, 500); // Initial delay before the first movement
    }

    // Method to move ImageButton to a random location
    private void moveImageButtonRandomly() {
        // Calculate random coordinates within the screen bounds
        Random random = new Random();
        int randomX = random.nextInt(screenWidth - imageButton.getWidth());
        int randomY = random.nextInt(screenHeight - imageButton.getHeight());

        // Move the ImageButton to the random coordinates
        imageButton.setX(randomX);
        imageButton.setY(randomY);
    }

    // Method to stop moving ImageButton
    private void stopMovingImageButton() {
        Random random = new Random();
        imageView.setVisibility(View.VISIBLE);
Handler handler1=new Handler(Looper.getMainLooper());
handler1.postDelayed(new Runnable() {
    @Override
    public void run() {
        imageView.setVisibility(View.GONE);
    handler1.removeCallbacksAndMessages(null);

    }
},500);
if(random.nextInt(1)==0)
{
   nuhuhh=MediaPlayer.create(this,R.raw.nuhuhh);
}
else {
    nuhuhh=MediaPlayer.create(this,R.raw.nuhh2);
}
            nuhuhh.start();
        mediaPlayer.start();

    }
}
