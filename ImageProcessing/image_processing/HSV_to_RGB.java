package image_processing;


public class HSV_to_RGB {

    
    public static int[] HSVtoRGB(float[] hsv) {
        int[] rgb = new int[3];
        float h = hsv[0], s = hsv[1], v = hsv[2];
        float c = v * s;
        float x = c * (1 - Math.abs((h / 60) % 2 - 1));
        float m = v - c;
    
        if (h >= 0 && h < 60) {
            rgb[0] = (int) Math.round((c + m) * 255);
            rgb[1] = (int) Math.round((x + m) * 255);
            rgb[2] = (int) Math.round(m * 255);
        } else if (h >= 60 && h < 120) {
            rgb[0] = (int) Math.round((x + m) * 255);
            rgb[1] = (int) Math.round((c + m) * 255);
            rgb[2] = (int) Math.round(m * 255);
        } else if (h >= 120 && h < 180) {
            rgb[0] = (int) Math.round(m * 255);
            rgb[1] = (int) Math.round((c + m) * 255);
            rgb[2] = (int) Math.round((x + m) * 255);
        } else if (h >= 180 && h < 240) {
            rgb[0] = (int) Math.round(m * 255);
            rgb[1] = (int) Math.round((x + m) * 255);
            rgb[2] = (int) Math.round((c + m) * 255);
        } else if (h >= 240 && h < 300) {
            rgb[0] = (int) Math.round((x + m) * 255);
            rgb[1] = (int) Math.round(m * 255);
            rgb[2] = (int) Math.round((c + m) * 255);
        } else if (h >= 300 && h < 360) {
            rgb[0] = (int) Math.round((c + m) * 255);
            rgb[1] = (int) Math.round(m * 255);
            rgb[2] = (int) Math.round((x + m) * 255);
        }
        return rgb;
    }
}
