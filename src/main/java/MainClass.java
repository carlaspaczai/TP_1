import controller.PCController;
import model.Polynom;
import view.PCView;

public class MainClass {
    public static void main (String[] args) {
        PCView V = new PCView();
        Polynom P = new Polynom();
        PCController C = new PCController(V, P);
    }
}
