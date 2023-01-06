
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

public class CalculatorAction implements ActionListener
{

    static String total_data = "";
    static String Countinue_data = "";
    static int text_length;
    static boolean isDemical;

    public void actionPerformed(ActionEvent e) { 
		 
        text_length = SwingGUI.text.getText().length();
		switch(e.getActionCommand()){
		case "0": 
			total_data += "0";
			SwingGUI.text.setText(total_data); 
			break;
			
		case "1": 
			total_data += "1";
			SwingGUI.text.setText(total_data); 
			break;
			
		case "2": 
			total_data += "2";
			SwingGUI.text.setText(total_data);		
			break;
			
		case "3": 
			total_data += "3";
			SwingGUI.text.setText(total_data);
			break;	
			
		case "4": 
			total_data += "4";
			SwingGUI.text.setText(total_data);
			break;	
			
		case "5": 
			total_data += "5";
			SwingGUI.text.setText(total_data); 
			break;
			
		case "6": 
			total_data += "6";
			SwingGUI.text.setText(total_data); 
			break;	
			
		case "7": 
			total_data += "7";
			SwingGUI.text.setText(total_data); 
			break;	
			
		case "8": 
			total_data += "8";
			SwingGUI.text.setText(total_data); 
			break;		
			
		case "9": 
			total_data += "9";
			SwingGUI.text.setText(total_data); 
			break;		
		
		case "×": 
			total_data += "×";
			SwingGUI.text.setText(total_data); 
            isDemical = false;
			break;		
			
		case "÷": 
			total_data += "÷";
			SwingGUI.text.setText(total_data); 
            isDemical = false;
			break;
			
		case "+": 
			total_data += "+";
			SwingGUI.text.setText(total_data); 
            isDemical = false;
			break;
			
		case "-": 
			total_data += "-";
			SwingGUI.text.setText(total_data);
            isDemical = false;
			break;
			
		case "C":
			total_data = "";
			SwingGUI.text.setText(""); 
			SwingGUI.TextLabel.setText("0");
            isDemical = false;
			break;
			
		case "=": 
			if(total_data != null && total_data.length() > 0) {
                SwingGUI.TextLabel.setText(total_data);
				double data = calc(total_data);
                total_data = fmt(data);
				SwingGUI.text.setText(String.valueOf(total_data));
			}
			else {
				SwingGUI.TextLabel.setText("result");	
			}			
			break;
        case "←":
            if(total_data != "")
            {
                if(total_data.substring(total_data.length()-1).equals("."))
                {
                    isDemical = false;
                }
                total_data = total_data.substring( 0, total_data.length()-1);
                SwingGUI.text.setText(total_data);
            }

            break;
        case "%":
            if(total_data != null && total_data.length() > 0) {
                double data = calc(total_data)/100;
                total_data = Double.toString(data);
                SwingGUI.TextLabel.setText(String.valueOf(total_data));
            }
            else {
                SwingGUI.TextLabel.setText("result");	
            }
            SwingGUI.text.setText(total_data);
            break;
        case "x²":
            if(total_data != null && total_data.length() > 0) {
                SwingGUI.TextLabel.setText(total_data);
                double data = calc(total_data);
                data = Math.pow(data, 2);
                total_data = fmt(data);
                SwingGUI.text.setText(String.valueOf(total_data));
            }
            else {
                SwingGUI.TextLabel.setText("result");	
            }	
            break;
        case ".":
            double a = 0;
            try{
                a = Double.parseDouble(
                SwingGUI.text.getText().substring(SwingGUI.text.getText().length()-1));
            }catch(StringIndexOutOfBoundsException s)
            {
                return;
            }
            if(!isDemical && a != 0)
            {
                total_data += ".";
                isDemical = true;
            }
            else if(!isDemical)
            {
                total_data += ".";
                isDemical = true;
            }
            SwingGUI.text.setText(total_data);
            break;
		default :
			SwingGUI.text.setText(""); 
			break;
		}

        int length = SwingGUI.text.getText().length();

        if(length > 9)
        {
            if(text_length > length)
            {
                if(length >= 14)
                {
                    SwingGUI.text.setFont(new Font("Arial", Font.BOLD, SwingGUI.font_size));
                }
                else
                {
                    SwingGUI.font_size += 2;
                }
                
            }
            else
            {
                if(SwingGUI.font_size > 30)
                    SwingGUI.font_size -= 2;
                
                SwingGUI.text.setFont(new Font("Arial", Font.BOLD, SwingGUI.font_size));
            }
        }
	}

	public static double calc(String input) { 
		int idx; 		
		idx = input.indexOf('+');
					
		if (idx != -1) {		
			return calc(input.substring(0, idx)) + calc(input.substring(idx + 1)); 
		} 
		else { 
			idx = input.indexOf('-'); 
			if (idx != -1) { 
				return calc(input.substring(0, idx)) - calc(input.substring(idx + 1)); 
			} 
			else {
				idx = input.indexOf('×'); 
				if (idx != -1) {
					return calc(input.substring(0, idx)) * calc(input.substring(idx + 1)); 
				} 
				else { 
					idx = input.indexOf('÷'); 
					if (idx != -1) { 
						return calc(input.substring(0, idx)) / calc(input.substring(idx + 1));
					} 
				} 
			} 
		}
				
		String data = input.trim();
		if (data == null || data.isEmpty()) {
			return 0;
		}  
			 			
		try {
            return Double.parseDouble(data); 
        } catch (NumberFormatException e) {
            SwingGUI.TextLabel.setText("");
            return 0;

        }
	} 

    public static String fmt(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%f",d);
    }


}