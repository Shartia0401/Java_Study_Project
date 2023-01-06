public class App {

    static CalculatorAction mainActivity;
    public static void main(String[] args)
    {
        mainActivity = new CalculatorAction();
        CalculatorAction.isDemical = false;
        new SwingGUI();
    }
}


