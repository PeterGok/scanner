package com.saladbar;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;


import java.util.ArrayList;

/**
 * @author ericjbruno
 */
public class Scanner {

    public static double angle = 0;
    public static ArrayList<double[]> points;
    public static VideoCapture camera;
    
    public static void main(String[] args) throws Exception {
        points = new ArrayList<double[]>();

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        camera = new VideoCapture(0);
        camera.open(0);
        Thread.sleep(1000);

        if (camera.isOpened()) {
            System.out.println("Opened");
        }

        Mat frame = new Mat();

        camera.read(frame);

        Communicator test = new Communicator();

        if (test.initialize()) {
            // Give initial angle
            test.sendData(angle + "");

            captureImage();
            angle += 0.5;
            test.sendData(angle + "");
            processImage();


            // LOOP:
                // Capture image
                // Give new angle
                // Process image
                // Render new frame

            test.sendData("y");
            try { Thread.sleep(2000); } catch (InterruptedException ie) {}
            test.sendData("n");
            try { Thread.sleep(2000); } catch (InterruptedException ie) {}
            test.close();
        }

        // Wait 5 seconds then shutdown
        try { Thread.sleep(2000); } catch (InterruptedException ie) {}
    }

    public static void captureImage() {

    }

    public static void processImage() {

    }
}



