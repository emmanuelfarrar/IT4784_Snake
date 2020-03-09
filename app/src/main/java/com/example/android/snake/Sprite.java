package com.example.android.snake;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.android.snake.OurView;

public class Sprite {

    //global variables
    int x, y;
    int xSpeed, ySpeed;
    int height, width;
    int currentFrame = 0;
    int direction;
    Bitmap snakeSprite;
    OurView ov;

    //Sprite.class constructor
    public Sprite(OurView ourView, Bitmap spriteSheet) {
        snakeSprite = spriteSheet;
        ov = ourView;
        height = snakeSprite.getHeight();           //1 row so no need to divide
        width = snakeSprite.getWidth() / 5;         //5 faces so need divide by 5
        x = 0;
        y = 0;
        xSpeed = 5;     //MAY NEED TO CHANGE TO 6
        ySpeed = 0;
    }

    private void update(){
        // row 0
        if (x > ov.getWidth() - width - xSpeed){
            x =0;
            xSpeed = 5;
            direction = 0;
        }

        //changing the current frame by adding 1 mod the number of images in the spritesheet
        currentFrame = ++ currentFrame % 5;

        x = x + xSpeed;
        y = y + ySpeed;
    }

    /*This setting up the bitmap
    Rect src: breaks up the bit map into sections starting at the top left
        if there were rows it would take modification to adjust for rows.
    Rect dst: deals with the placement on screen of the src
     */
    public void onDraw (Canvas canvas){
        update();
        int srcX = currentFrame * width;
        Rect src = new Rect(srcX,0, srcX + width, height);
        Rect dst = new Rect(x,y, x + width, y + height);    //x + width/y + height is scaling for movement

        canvas.drawBitmap(snakeSprite,src,dst,null);        //paint is set to null since not changing colors
    }
}
