package com.example.android.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class OurView extends SurfaceView implements Runnable {

        Thread t = null;
        SurfaceHolder holder;
        boolean isItOk = false;

        public OurView(Context context) {
            super(context);
            holder =getHolder();
        }

        @Override
        public void run() {
            while (isItOk == true) {
                //check if holder is available; if so perform canvas drawing
                if(!holder.getSurface().isValid()) {
                    continue;
                }
                Canvas c = holder.lockCanvas();
                //onDraw(c);
                holder.unlockCanvasAndPost(c);

            }
        }

        /*pause() use isITOk to see if the state is running.
         * While loops that is active while functioning in the thread
         * if we pause we set the thread to null then use join() to complete the thread.
         * t.join()
         * The catch is for throwing an error message
         */
        public void pause() {
            isItOk = false;
            while (true) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            t = null;
        }

        /* resume() used to resume running the app
         * use isITOk to see if the state is running.
         * when the thread is called back to starting run THIS instance of the thread
         * t.start() starting the thread
         * The catch is for throwing an error message
         */
        public void resume() {
            isItOk = true;
            t = new Thread(this);
            t.start();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(255,255,255,255);

        }
}


