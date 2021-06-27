package com.mytechexp.binarysearch;

/*given a string representing A, you should return the smallest good base of A in string format.
 Input 1:
    A = "13"
Output 1:
    "3"     (13 in base 3 is 111)

Input 2:
    A = "4681"
Output 2:
    "8"     (4681 in base 8 is 11111).
 * */
public class GoodBase {
    public static void main(String[] arg) {
        GoodBase goodBase = new GoodBase();
        System.out.println(goodBase.solve("13"));
    }

    public String solve(String A) {

        final long num = (Long.valueOf(A).longValue());
        //longest length 60 base 2
        for (int len = 60; len != 1; len--) {
            long cand = can(num, len);
            if (cand != -1l)
                return Long.toString(cand);
        }

        return Long.toString(num - 1);

    }

    private long can(long num, int len) {
        long l=2l;
        long h=(long)Math.pow(num,1d/(len-1));
        //X^len-1+x^len-2...=num
        //so h would be not more than num^(1/(len-1))
        while(l<=h) {
            long m = (l + h) / 2l;
            if (compare(m,len,num) == 1)
                h = m - 1l;
            else
                l = m + 1l;
        }
        long res=(h!=1l && compare(h,len,num)==0?h:-1l);
        return res;
        }

    private int compare(long base, int len, long num) {
        long would=1l;//base 0;
        long dbase=base;
        for(int i=1;i!=len;i++)
        {
            would+=dbase;
            dbase*=base;
        }
       return Long.compare((long)would,num);
    }

    }