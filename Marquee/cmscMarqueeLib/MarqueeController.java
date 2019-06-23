package cmscMarqueeLib;
import java.awt.event.*;
import javax.swing.*;

public class MarqueeController {
    private Cell[][] displayCells;
    private Timer timer;
    
    private Display marqueeDisplay;
    private DataManager marqueeDataManager;
    private int animationSpeedMilliSecs;
    
    public MarqueeController(Display marqueeDisplay,
            				 DataManager marqueeDataManager,
            				 int animationSpeedMilliSecs) {
        this.marqueeDisplay     = marqueeDisplay;
        this.marqueeDataManager = marqueeDataManager;
        this.animationSpeedMilliSecs = animationSpeedMilliSecs;
        this.displayCells       = null;
        
        /* Setting up the timer for animation */
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			    step();		
			}
		};
        timer = new Timer(animationSpeedMilliSecs, taskPerformer);
    } 

    public void start() {
        timer.start();
    }
     
    public void stop() {
        timer.stop();
    }
     
    public void setSpeed(int speedInMilliSeconds) {
        animationSpeedMilliSecs = speedInMilliSeconds;
        timer.setDelay(animationSpeedMilliSecs);
    }

    private void step() {
        // call the engine that does transformations
        displayCells = marqueeDataManager.step();
        marqueeDisplay.displayMessage(displayCells);
    }
}