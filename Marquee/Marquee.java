import javax.swing.*;
import cmscMarqueeLib.MarqueeController;
import cmscMarqueeLib.MarqueeDisplay;

public class Marquee {

    public static void main(String[] args) {
        int animationDelayMilliSecs = 50, animationPattern = 0;
        
        String message = JOptionPane.showInputDialog("Enter message:");
        MarqueeDisplay display = new MarqueeDisplay();
        MarqueeDataManager dataManager = new MarqueeDataManager(message,animationPattern);
        MarqueeController controller = new MarqueeController(display, dataManager,
                							                 animationDelayMilliSecs);
        controller.start();
    }
}