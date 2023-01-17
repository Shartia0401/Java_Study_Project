package action.rgb;

import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import image_processing.ImagePanel;
import image_processing.Image_Processing;
import main.Run;

public class Blue_ScaleAct implements ChangeListener{

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider)e.getSource();
        System.out.println(slider.getValue());

        Run.rgb[2] = slider.getValue();
        
        
        ImagePanel.image.setIcon(new ImageIcon(Image_Processing.RGB_scale()));
        


    }

}