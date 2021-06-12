package com.mytechexp.eratosthenis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
* Groot has an array A of size N. Boring right? Groot thought so too, so he decided to construct another array B of the same size and defined elements of B as:

B[i] = factorial of A[i] for every i such that 1<= i <= N.

factorial of a number X denotes (1 x 2 x 3 x 4......(X-1) x (X)).
Now Groot is interested in the total number of non-empty subsequences of array B such that every element in the subsequence has the same non empty set of prime factors.

Since the number can be very large, return it modulo 109 + 7.

NOTE: A set is a data structure having only distinct elements. Eg : the set of prime factors of Y=12 will be {2,3} and not {2,2,3}
* A = [2, 3, 2, 3]
*
* Array B will be : [2, 6, 2, 6]
 The total possible subsequences are 6 : [2], [2], [2, 2], [6], [6], [6, 6]
*
* Ans:No need to find the prime factorials of the array elements , just find the prime factors and follow the
*
* 2^1-1+2^1-1+3^
* */
public class FactorialArray {
    int mod=1000*1000*1000+7;
    public int solve(ArrayList<Integer> A) {


        int result=0;
        Collections.sort(A);
        int max=A.get(A.size()-1);

        List<Integer> primeFactorial=findSeivePrime(max);
        long ans = 0;
        int j = 0, i = 0, itr=primeFactorial.size();
        while(i < A.size() && j < itr) {
            int cnt = 0;
            if (A.get(i) == 1) {
                i++;
                continue;
            }
            while (i < A.size() && A.get(i) < primeFactorial.get(j)) {
                i++;
                cnt++;
            }
            long temp = power(2, cnt) - 1;
            temp += mod;
            temp %= mod;
            ans += temp;
            ans %= mod;
            j++;
        }
        if(i < A.size()){
            long temp = power(2, A.size() - i) -1;
            temp += mod;
            temp %= mod;
            ans += temp;
            ans %= mod;
        }
        return (int)ans;
    }
    public int power(int a,int b)
    {
        int result=1;
        while(b!=0)
        {
            if(b%2==1)
               result=(a*result)%mod;
            b=b/2;
            a=(a*a)%mod;

        }
        return result;
    }


    private List<Integer> findSeivePrime(int max) {
        List<Integer>primelis=new ArrayList<>();
        List<Integer>sieveFactorial=new ArrayList<>();

        for(int i=0;i<=max;i++)
            primelis.add(i);
        for(int i=2;i<=max;i++)
        {
            if(primelis.get(i)==i)
                sieveFactorial.add(i);
            if(i*1l*i>max)
                continue;
            for(int j=i*i;j<=max;j+=i)
            {

                if(primelis.get(j)==j)
                    primelis.set(j,i);
            }
        }

        return sieveFactorial;
    }

    public static void main(String[] args)
    {
        FactorialArray factorialArray=new FactorialArray();
        Integer[] a=new Integer[]{2,3,2,3};
        //List<Integer>value=Arrays.asList(a);
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(a));
       System.out.println(factorialArray.solve(input));
    }
}
