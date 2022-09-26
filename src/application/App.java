package application;

import service.Logic2;
import service.Ui;

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

        //Array2 arr = new Array2();
        //int[] entrada = new int[]{1, 2, 2, 6, 99, 99, 7};
        //int saida = arr.sum67(entrada);

        Logic2 logic2 = new Logic2();
        int saida = logic2.makeChocolate(4, 1, 7);

        System.out.println(saida);


        
    }
}
