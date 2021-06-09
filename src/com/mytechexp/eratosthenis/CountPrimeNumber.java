package com.mytechexp.eratosthenis;

/*
* You are given A queries.
* For each query (1<=i<=A) you are given a prime number B[i],
* you need to give the count of all numbers in range 1 to 10^6
* inclusive which have minimum prime factor B[i] for each query.
*
* */
public class CountPrimeNumber {
    int limit = 1000000;
    int[] count = new int[limit+1];
    public int[] solve(int A, int[] B) {
        count= customeSieve();

    for(int i=0;i<A;i++)
        B[i]=count[B[i]]+1;

    return B;
    }

   public int[] customeSieve()
    {

        int[] sieve = new int[limit+1];


        for(int i=2;i<=limit;i++)
        {
            if(sieve[i]==0)
            {
                if(i*1l*i>limit)
                    continue;

                for(int j=i*i;j<=limit;j+=i)
                    if(sieve[j]==0)
                    {
                        sieve[j]=1;
                        count[i]++;
                    }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        CountPrimeNumber primeCnt=new CountPrimeNumber();
        int[] B=new int[]{2,11};
        B=primeCnt.solve(2,B);
        System.out.println(B[0]);
        System.out.println(B[1]);
       // System.out.println(B[1]);
    }
}
