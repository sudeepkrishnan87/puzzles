package com.mytechexp.eratosthenis;

public class LuckyNumber {
    public int solve(int A)
    {
        int[] spf =new int[A+1];
        for(int i=0;i<=A;i++)
            spf[i]=i;
        for(int i=2;i<=A;i++)
        {

            for(int j=i*i;j<=A;j+=i)
            {
                if(spf[j]==j)
                    spf[j]=i;
            }
        }
        int luckyCount=0;
        for(int i=2;i<=A;i++)
        {
            int ans=1;
            int temp=i;
            int divisor=spf[temp];
            while(temp!=1)
            {

                if(divisor==spf[temp])
                    temp/=divisor;
                else
                {
                    divisor=spf[temp];
                    temp/=divisor;
                    ans++;
                }

            }
            if(ans==2)
                luckyCount++;
        }
        return luckyCount;
    }

    public static void main(String[] arg)
    {
        LuckyNumber lucky=new LuckyNumber();
        System.out.println(lucky.solve(40));
    }
}
