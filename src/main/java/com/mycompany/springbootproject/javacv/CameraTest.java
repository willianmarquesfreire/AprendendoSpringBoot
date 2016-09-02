package com.mycompany.springbootproject.javacv;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameGrabber;

/**
 * @author wmfsystem
 */
public class CameraTest {

    public static final String FILENAME = "output.mp4";

    public static void main(String[] args) throws Exception {
        
        CaptureJavaCV cv = new CaptureJavaCV();
        cv.startCapture();
        
        Frame imagem = cv.capture();
        
        CanvasFrame canvasFrame = new CanvasFrame("Teste");
        canvasFrame.setCanvasSize(250, 250);
        
        while(canvasFrame.isVisible() && (imagem = cv.capture()) != null) {
            canvasFrame.showImage(imagem);
        }
        
        cv.stopCapture();
        

//        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
//        grabber.start();
//        Frame grabbedImage = grabber.grab();
//        
//        CanvasFrame canvasFrame = new CanvasFrame("Cam");
//        canvasFrame.setCanvasSize(250, 250);
//        
//        System.out.println("framerate " + grabber.getFrameRate());
//        grabber.setFrameRate(grabber.getFrameRate());
//        
//        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(FILENAME, grabber.getImageWidth(), grabber.getImageHeight());
//        
//        recorder.setVideoCodec(13);
//        recorder.setFormat("mp4");
//        recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
//        recorder.setFrameRate(30);
//        recorder.setVideoBitrate(10 * 1024 * 1024);
//        
//        recorder.start();
//        
//        while (canvasFrame.isVisible() && (grabbedImage = grabber.grab()) != null) {
//            canvasFrame.showImage(grabbedImage);
//            recorder.record(grabbedImage);
    }
//        
//        recorder.stop();
//        grabber.stop();
//        canvasFrame.dispose();
//        
}
