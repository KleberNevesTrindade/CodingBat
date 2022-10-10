package service;

public class Logic2 {
    
    /* 
    We want make a package of goal kilos of chocolate. 
    We have small bars (1 kilo each) and big bars (5 kilos each). 
    Return the number of small bars to use, 
    assuming we always use big bars before small bars. 
    Return -1 if it can't be done.
    
    makeChocolate(4, 1, 9) → 4
    makeChocolate(4, 1, 10) → -1
    makeChocolate(4, 1, 7) → 2
    -----
    makeChocolate(6, 2, 7) → 2
    makeChocolate(4, 1, 5) → 0
    makeChocolate(5, 4, 9) → 4
    makeChocolate(7, 1, 12) → 7
    --
    makeChocolate(1, 2, 7) → -1
    */
    public int makeChocolate(int small, int big, int goal) {
        
        if (goal > (big * 5) + small) return -1;
        
        do {
            if (goal - 5 == 0) return 0;
            if (goal - 5 > 0) goal = goal - 5;
            big--;
        } while (big > 0);

        goal = goal - small;
        if (goal < 0) return small + goal;
        if (goal > 0) return -1;
        return small;
    }
    
}
