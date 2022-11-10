package org.practice.recursion;

import java.math.BigDecimal;

public class TailRecursion {

    public static void main(String[] args) {

        TailRecursion rec = new TailRecursion();
        long time1 = System.currentTimeMillis();
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(rec.recFactorial(new BigDecimal(3000)));
        System.out.println(Runtime.getRuntime().freeMemory());
        long time2 = System.currentTimeMillis();
        System.out.println(rec.tailFactorial(new BigDecimal(3000), new BigDecimal(1)));
        System.out.println(Runtime.getRuntime().freeMemory());
        long time3 = System.currentTimeMillis();

        System.out.println(time2 - time1);
        System.out.println(time3 - time2);
    }

    public BigDecimal recFactorial(BigDecimal num) {
        if (num.longValue() <= 1) {
            return new BigDecimal(1);
        } else {
            System.out.println(Runtime.getRuntime().freeMemory());
            return num.multiply(recFactorial(num.add(new BigDecimal(-1))));
        }
    }

    public BigDecimal tailFactorial(BigDecimal num, BigDecimal totalSoFar) {
        if (num.longValue() == 0) {
            return totalSoFar;
        } else {
            return tailFactorial(num.add(new BigDecimal(-1)), totalSoFar.multiply(num));
        }
    }
}
