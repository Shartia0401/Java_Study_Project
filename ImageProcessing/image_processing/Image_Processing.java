package image_processing;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Kernel;

import main.Run;

import java.awt.image.ConvolveOp;

public class Image_Processing
{

    private static BufferedImage changedImage;
    static Image img;

    public static Image GrayScale(BufferedImage is)//고쳐야함
    {

        int width = is.getWidth(null);
        int height = is.getHeight(null);
        System.out.println(width + " " + height);

        changedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {

                Color c = new Color(is.getRGB(j,i));
                // int red = (int)(c.getRed() * 0.299);
                // int green = (int)(c.getGreen() * 0.587);
                // int blue =  (int)(c.getBlue() * 0.114);
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                Color newColor = new Color((int)((red+green+blue)/3), (int)((red+green+blue)/3), (int)((red+green+blue)/3));
                changedImage.setRGB(j, i, newColor.getRGB());
            }
        }

        img = changedImage;
        return img;
    }


    public static Image Edge_Detect(BufferedImage is)
    {
        changedImage = is;
        float[] sharpen = new float[] {
                0.0f, -1.0f, 0.0f,
                -1.0f, 5.0f, -1.0f,
                0.0f, -1.0f, 0.0f
        };
        Kernel kernel = new Kernel(3, 3, sharpen);
        ConvolveOp op = new ConvolveOp(kernel);
        changedImage = op.filter(changedImage, null);
        double[][] ar = toArray(changedImage);
        double[][] filterBlur = { { 0.088, 0.107, 0.088 },
                                { 0.107, 0.214, 0.107 },
                                { 0.088, 0.107, 0.088 } };
        ar = convolution(ar, filterBlur);
        double[][] filterEdge = { { -1, -1, -1 },
                                  { -1, 8, -1  },
                                  { -1, -1, -1 } };
        ar = convolution(ar, filterEdge);
        ar = arrayInColorBound(ar);
        ar = arrayColorInverse(ar);
        changedImage = toImage(ar);

        img = changedImage;
        Run.Currentimage = changedImage;
        return img;
    }   

    public Image RGB_scale()
    {
        return img;
    }



    public static Image HSV_scale()
    {

        RGB_to_HSV();

        changedImage = new BufferedImage(ImagePanel.width,ImagePanel.height, BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < ImagePanel.height; i++)
        {
            for(int j = 0; j < ImagePanel.width; j++)
            {
                for(int k = 0; k < 3; k++)
                {   if(k >= 1 && ImagePanel.Image_array[j][i][k] < 1)
                    {
                        float a = (((float)Run.hsv[k])/100);
                        if(a > 1)
                        {
                            a = 1;
                        }
                        else if(a < 0)
                        {
                            a = 0;
                        }
                        ImagePanel.Image_array[j][i][k] += a;
                        
                    }
                    else if(ImagePanel.Image_array[j][i][k] < 359){
                        ImagePanel.Image_array[j][i][k] += Run.hsv[k];
                    }
                    
                }
            }
        }

    
        for(int i = 0; i < ImagePanel.height; i++)
        {
            for(int j = 0; j < ImagePanel.width; j++)
            {
                int[] RGB = HSV_to_RGB.HSVtoRGB(ImagePanel.Image_array[j][i]);

                try {

                    Color newColor = new Color(RGB[0], RGB[1], RGB[2]);
                    changedImage.setRGB(j,i, newColor.getRGB());
                } catch (IllegalArgumentException e) {
                    System.out.println(RGB[0] + " "+ RGB[1] + " " +RGB[2] );
                }
            }

        }
        img = changedImage;
        Run.Currentimage = changedImage;
        return img;
    }


    private static BufferedImage toImage(double[][] ar) { 
		BufferedImage output = new BufferedImage(ar[0].length, ar.length, BufferedImage.TYPE_INT_BGR); 
		for (int y = 0; y < ar.length; y++) { 
			for (int x = 0; x < ar[0].length; x++) { 
				output.setRGB(x, y, new Color((int) ar[y][x], (int) ar[y][x], (int) ar[y][x]).getRGB()); 
			} 
		} 
		return output; 
	} 


    private static double[][] toArray(BufferedImage bi) {
		double [][] output = new double[bi.getHeight()][bi.getWidth()];
		for(int y = 0; y < bi.getHeight(); y++) {
			for(int x = 0; x < bi.getWidth(); x++) {
				Color c = new Color(bi.getRGB(x, y));
				output [y][x] = (c.getRed() + c.getBlue() + c.getGreen())/3;
			}
		}
		return output;
	}

    private static double[][] convolution(double map[][], double[][] filter){

		double output[][] = new double[map.length][map[0].length];
		for (int y = 0; y < map.length; y++) { 
			for (int x = 0; x < map[y].length; x++) { 
				for (int i = 0; i < filter.length; i++) { 
					for (int j = 0; j < filter[i].length; j++) { 
						try { 
							output[y][x] += map[y - i + 1][x - j + 1] * filter[i][j]; 
						} catch (ArrayIndexOutOfBoundsException e) { 
						}
					}
				}
			}
		}
		return output;

	}

    private static double[][] arrayInColorBound(double[][] ar){
		for (int i = 0; i < ar.length; i++) { 
			for (int j = 0; j < ar[i].length; j++) { 
				ar[i][j] = Math.max(0, ar[i][j]); 
				ar[i][j] = Math.min(225, ar[i][j]); 
			} 
		} 
		return ar; 
	}
	private static double[][] arrayColorInverse(double[][] ar) { 
		for (int i = 0; i < ar.length; i++) { 
			for (int j = 0; j < ar[i].length; j++) { 
				ar[i][j] = 255 - ar[i][j]; 
			} 
		} 
		return ar; 
	} 

    public static void RGB_to_HSV()
    {

        
        ImagePanel.width = ImagePanel.img.getWidth(null);
        ImagePanel.height = ImagePanel.img.getHeight(null);

        float[] hsv = new float[3];

        ImagePanel.Image_array = new float[ImagePanel.width][ImagePanel.height][3];
        for(int i  = 0; i < ImagePanel.height; i++)
        {
            for(int j = 0; j < ImagePanel.width; j++)
            {
                Color c = new Color(ImagePanel.file.getRGB(j, i));

                float[] a = Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), hsv);
                for(int k = 0; k < 3; k++)
                {
                    ImagePanel.Image_array[j][i][k] = a[k];
                }
            }
        }
    
    }

}
