package service;

public class String2 {

  /*
  Return true if the given string contains an appearance of "xyz" 
  where the xyz is not directly preceeded by a period (.). 
  So "xxyz" counts but "x.xyz" does not.
  xyzThere("abcxyz") → true
  xyzThere("abc.xyz") → false
  xyzThere("xyz.abc") → true
  */
  public boolean xyzThere(String str) {
      final String TESTE = "xyz";

      int i = str.lastIndexOf(TESTE);
      if (i == -1) return false;
      if (i == 0) return true;
      if (i >= 1) {
          if (str.substring(i-1,i).equals(".")) {
              return false;
          }
          else {
              return true;
          }
      } 
      return false;
  }
  
  /*
  Return true if the given string contains a "bob" string,
  but where the middle 'o' char can be any char.

  bobThere("abcbob") → true
  bobThere("b9b") → true
  bobThere("bac") → false
  */
  public boolean bobThere(String str) {
      int len = str.length();        
      for (int i = 1; i <= len; i++) {
          if ((i + 2 <= len) &&
              (str.substring(i - 1, i).equals("b")) &&
              (str.substring(i + 1, i + 2).equals("b")) 
          ) return true;
      }
      return false;
  }

  /*
  We'll say that a String is xy-balanced if for all the 'x' chars in the string, 
  there exists a 'y' char somewhere later in the string. 
  So "xxy" is balanced, but "xyx" is not. 
  One 'y' can balance multiple 'x's. 
  Return true if the given string is xy-balanced.

  xyBalance("aaxbby") → true
  xyBalance("aaxbb") → false
  xyBalance("yaaxbb") → false

    */
  public boolean xyBalance(String str) {
      int len = str.length();

      if (str.equals("y")) return true;
      if (str.equals("")) return true;
      if (str.substring(len-1).equals("x")) return false;
      
      boolean achou = true;
      for (int j = 1; j <= len; j++) {
        if (str.substring(j - 1, j).equals("x") ||
            str.substring(j - 1, j).equals("y")
        ) achou = false;
      }
      if (achou) return true;
      
      for (int i = len; i >= 1; i--) {
        if (str.substring(i - 1, i).equals("y")) {
          for (int n = i; n >= 1; n--) {
            if (str.substring(n - 1, n).equals("x")) {
              return true;
            }
          }
        }
      }
  /*
      for (int i = 1; i <= len; i++) {
        if (str.substring(i - 1, i).equals("x")) {
          for (int n = i; n <= len; n++) {
            if (str.substring(n - 1, n).equals("y")) {
              for (int m = n; m <= len; m++) {
                if (str.substring(m - 1, m).equals("x")) {
                    return false;
                }
              }
              return true;
            }
          }
        }
      }
  */
      return false;
  }
  
  /*
  Given two strings, a and b, 
  create a bigger string made of the first char of a, 
  the first char of b, the second char of a, the second char of b, and so on. 
  Any leftover chars go at the end of the result.

  mixString("abc", "xyz") → "axbycz"
  mixString("Hi", "There") → "HTihere"
  mixString("xxxx", "There") → "xTxhxexre"
  */
  public String mixString(String a, String b) {
      String saida = "";
      int lenA = a.length();
      int lenB = b.length();
      int i = 0;
      while (i < lenA || i < lenB){
        if (i < lenA){
          saida = saida + a.substring(i, i + 1);
        }
        if (i < lenB){
          saida = saida + b.substring(i, i + 1);
        }
        i++;
      }
      return saida;
  }

  /*
    Given a string and an int n, 
    return a string made of n repetitions of the last n characters of the string. 
    You may assume that n is between 0 and the length of the string, inclusive.

    repeatEnd("Hello", 3) → "llollollo"
    repeatEnd("Hello", 2) → "lolo"
    repeatEnd("Hello", 1) → "o"
    */
  public String repeatEnd(String str, int n) {
    String saida = "";
    int len = str.length();

    if (n == 0) return "";

    if (n > len) {
      for (int i = 1; i <= len; i++) {
        saida = saida + str;
      }
      return saida;
    }

    saida = "";
    for (int i = 1; i <= n; i++) {
      saida = saida + str.substring(len - n);
    }
    return saida;
  }

  /*
  Given a string and an int n, 
  return a string made of the first n characters of the string, 
  followed by the first n-1 characters of the string, and so on. 
  You may assume that n is between 0 and the length of the string, 
  inclusive (i.e. n >= 0 and n <= str.length()).

  repeatFront("Chocolate", 4) → "ChocChoChC"
  repeatFront("Chocolate", 3) → "ChoChC"
  repeatFront("Ice Cream", 2) → "IcI"
    */
  public String repeatFront(String str, int n) {
    String saida = "";
    int i = 0;
    int j = n;
    int len = str.length();
    if (n > len) return "";

    while (j > 0) {
      saida = saida + str.substring(0, j);
      j--;
      i = i + j;
    }
    return saida;
  }
    
  /*
  Given two strings, word and a separator sep, 
  return a big string made of count occurrences of the word, 
  separated by the separator string.

  repeatSeparator("Word", "X", 3) → "WordXWordXWord"
  repeatSeparator("This", "And", 2) → "ThisAndThis"
  repeatSeparator("This", "And", 1) → "This"
  */
  public String repeatSeparator(String word, String sep, int count) {
    String saida = "";
    if (count <= 0) return "";
    for (int i = 1; i < count; i++) {
      saida = saida + word + sep;
    }
    return saida + word;
  }


}
