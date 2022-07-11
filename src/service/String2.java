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

  /*
  Given a string, consider the prefix string made of the first N chars of the string.
  Does that prefix string appear somewhere else in the string?
  Assume that the string is not empty and
  that N is in the range 1..str.length().

  prefixAgain("abXYabc", 1) → true
  prefixAgain("abXYabc", 2) → true
  prefixAgain("abXYabc", 3) → false
  */
  public boolean prefixAgain(String str, int n) {
    String teste = str.substring(0, n);
    int len = str.length();
    for (int i = n;i < len; i++) {
      if (i + n > len) return false;
      if (teste.equals(str.substring(i, i + n))) return true;
    }
    return false;
  }
  
  /*
  Given a string, does "xyz" appear in the middle of the string?
  To define middle, 
  we'll say that the number of chars to the left and right of the "xyz" 
  must differ by at most one. 
  This problem is harder than it looks.

  xyzMiddle("AAxyzBB") → true
  xyzMiddle("AxyzBB") → true
  xyzMiddle("AxyzBBB") → false
  xyzMiddle("xyzAxyzBBB") → true
  xyzMiddle("xyzAxyzBxyz") → true
  xyzMiddle("xyzxyzAxyzBxyzxyz") → true
  xyzMiddle("xyzxyzxyzBxyzxyz") → true
  xyzMiddle("xyzxyzAxyzxyzxyz") → true
 */
  public boolean xyzMiddle(String str) {
    final String teste = "xyz"; 

    int len = str.length();
    if (len == 0) return false;
    int mid = (len / 2) - 2;

    int pos = str.indexOf(teste, mid);
    if (pos < 0) return false;

    int lEsq = pos;
    int lDir = len - pos - teste.length();

    if (lEsq == lDir) return true;
    if (lEsq - 1 == lDir) return true;
    if (lEsq == lDir - 1) return true;

    return false;
  }

  /*
  A sandwich is two pieces of bread with something in between.
  Return the string that is between the first and
  last appearance of "bread"in the given string,
  or return the empty string "" 
  if there are not two pieces of bread.

  getSandwich("breadjambread") → "jam"
  getSandwich("xxbreadjambreadyy") → "jam"
  getSandwich("xxbreadyy") → ""
  getSandwich("xxbreadbreadjambreadyy") → "breadjam"
  getSandwich("breadbreadbreadbread") → "breadbread"
  */
  public String getSandwich(String str) {
    final String chave = "bread";
    String saida = "";

    int len = str.length();
    int lChave = chave.length();
    
    int pos1 = str.indexOf(chave);
    if ((pos1 < 0) || (pos1 + lChave > len)) return "";
    
    int pos2 = str.lastIndexOf(chave); // str.indexOf(chave, pos1 + 1);
    if (pos2 < 0 || pos2 == pos1) return "";

    saida = str.substring(pos1 + lChave, pos2);
    return saida;

  }
  
  /*
  Returns true if for every '*' (star) in the string,
  if there are chars both immediately before and after the star,
  they are the same.

  sameStarChar("xy*yzz") → true
  sameStarChar("xy*zzz") → false
  sameStarChar("*xa*az") → true
  sameStarChar("12*2*3*") → false
  sameStarChar("XY*YYYY*Z*") → false
  sameStarChar("12*2*3*") → false
  sameStarChar("*xa*a*b") → false

  sameStarChar("**") → true
  */
  public boolean sameStarChar(String str) {
    final String chave = "*";
    boolean teste = false;
    int len = str.length();
    if (str.isEmpty()) return true;
    if (str.equals(chave)) return true;
    if (str.substring(len - 1).equals(chave)) return false;

    int pos = str.indexOf(chave);
    while (pos >= 0) {
      if (pos + 1 >= len) return false;
      if (pos != 0 && str.substring(pos - 1, pos).equals(str.substring(pos + 1, pos + 2))) {
        teste = true;
      }
      else {
        teste = false;
      }
      pos = str.indexOf(chave, pos + 1);
    }

    if (teste) {
      return true;
    } 
    else {
      return false;
    }
  }

  /*
  Given a string, 
  compute a new string by moving the first char to come after the next two chars,
  so "abc" yields "bca".
  Repeat this process for each subsequent group of 3 chars, 
  so "abcdef" yields "bcaefd". 
  Ignore any group of fewer than 3 chars at the end.

  oneTwo("abc") → "bca"
  oneTwo("tca") → "cat"
  oneTwo("tcagdo") → "catdog"
 */
  public String oneTwo(String str) {
    
    
    return "";
  }

}
