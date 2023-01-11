package action;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import image_processing.*;
import main.Run;

public class Saturation_SliderAction implements ChangeListener{
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider)e.getSource();
        System.out.println("Saturation : "+slider.getValue());

        Run.hsv[1] = slider.getValue();

        Image_Processing.HSV_scale();

    }
}
