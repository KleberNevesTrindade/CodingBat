package application;

import service.Array2;
import service.String2;
import service.Ui;
import service.Testes;

public class App {
    public static void main(String[] args) {
        
        Ui.clearScreen();

        

        //Testes tt = new Testes();
        //int ii = tt.teste02();
        //System.out.println(ii);

        //String2 strC = new String2(); 
        //String str = "xyz";
        //int n = 1;
        
        //boolean saida = strC.xyzThere(str);
        //boolean saida = strC.bobThere(str);
        //boolean saida = strC.xyBalance(str);
        //String saida = strC.mixString(a,b);
        //String saida = strC.repeatEnd(str, n);
        //String saida = strC.repeatFront(str, n);
        //String saida = strC.repeatSeparator("This", "And", 1);
        //boolean saida = strC.prefixAgain(str, n);
        //boolean saida = strC.xyzMiddle(str);    
        //String saida = strC.getSandwich("breadbreadbreadbread");
        //boolean saida = strC.sameStarChar("*");
        //String saida = strC.oneTwo(str);

        Array2 arr = new Array2();
        int[] entrada = new int[]{1, 2, 3, 4, 100};
        int saida = arr.centeredAverage(entrada);

        System.out.println(saida);


        
    }
}
