package application;

import service.String2;
import service.Ui;

public class App {
    public static void main(String[] args) {
        
        Ui.clearScreen();

        String2 strC = new String2(); 
        String str = "Java";
        int n = 4;

        //boolean saida = strC.xyzThere(str);
        //boolean saida = strC.bobThere(str);
        //boolean saida = strC.xyBalance(str);
        //String saida = strC.mixString(a,b);
        //String saida = strC.repeatEnd(str, n);
        String saida = strC.repeatFront(str, n);

        System.out.println(saida);

    }
}
