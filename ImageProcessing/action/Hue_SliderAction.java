package action;

import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import image_processing.ImagePanel;
import image_processing.Image_Processing;
import main.Run;

public class Hue_SliderAction implements ChangeListener{

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider)e.getSource();
        System.out.println("Hue : "+slider.getValue());

        Run.hsv[0] = slider.getValue();
        
        
        ImagePanel.image.setIcon(new ImageIcon(Image_Processing.HSV_scale()));
        


    }

}
