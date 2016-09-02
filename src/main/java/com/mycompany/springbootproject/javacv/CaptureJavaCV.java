/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootproject.javacv;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;

/**
 *
 * @author wmfsystem
 */
public class CaptureJavaCV {
    
    public OpenCVFrameGrabber capturador;

    public CaptureJavaCV() {
        this.capturador = new OpenCVFrameGrabber(0);
    }
    
    public void startCapture() throws FrameGrabber.Exception {
        this.capturador.start();
    }
    
    public Frame capture() throws FrameGrabber.Exception {
        return capturador.grab();
    }
    
    public void stopCapture() throws FrameGrabber.Exception {
        this.capturador.stop();
    }
    
    public void CanvasFilm(int width, int height) {
        CanvasFrame canvasFrame = new CanvasFrame("Teste");
        canvasFrame.setCanvasSize(width, height);
        
//        while (canvasFrame.)
    }
    
    
}
