package ru.ac.uniyar.mf.vl;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

public class Rational {

    private BigInteger num;
    private BigInteger den;

    Rational(String s)
    {
        if (s.contains("/"))
        {
            String [] nd = s.split("/");
            num=new BigInteger(nd[0]);
            den=new BigInteger(nd[1]);

            BigInteger g = num.gcd(den);
            num = num.divide(g);
            den = den.divide(g);
        }
        else
        {
            num=new BigInteger(s);
            den=BigInteger.ONE;
        }
    }
    public Rational(String n, String d)
    {
        BigInteger tmp=new BigInteger(n);
        if (tmp.intValue()==0)
        {
            num=BigInteger.ZERO;
            den =BigInteger.ONE;
        }
        else
        {
            num=new BigInteger(n);
            den=new BigInteger(d);

            BigInteger g = num.gcd(den);
            num = num.divide(g);
            den = den.divide(g);
        }
    }
    Rational(BigInteger n, BigInteger d)
    {
        num=n;
        den=d;

        BigInteger g = num.gcd(den);
        num = num.divide(g);
        den = den.divide(g);

    }
    Rational(BigInteger n)
    {
        num=n;
        den= BigInteger.ONE;
    }

    public Rational add(Rational a) {
        BigInteger n1,d1,n2,d2,nn1,nn2,nn,dd,g;
        n1=num;
        d1=den;
        n2=a.num;
        d2=a.den;
        nn1=n1.multiply(d2);
        nn2=n2.multiply(d1);
        nn =nn2.add(nn1);
        dd =d1.multiply(d2);
        g  =nn.gcd(dd);
        nn =nn.divide(g);
        dd =dd.divide(g);
        Rational r=new Rational(nn,dd);
        return r;
    }
    public Rational sub(Rational a) {
        BigInteger n1,d1,n2,d2,nn1,nn2,nn,dd,g;
        n1=num;
        d1=den;
        n2=a.num;
        d2=a.den;
        nn1=n1.multiply(d2);
        nn2=n2.multiply(d1);
        nn =nn2.subtract(nn1);
        dd =d1.multiply(d2);
        g  =nn.gcd(dd);
        nn =nn.divide(g);
        dd =dd.divide(g);
        Rational r=new Rational(nn,dd);
        return r;
    }
    public Rational mul(Rational a) {
        BigInteger n1,d1,n2,d2,nn1,nn2,nn,dd,g;
        n1=num;
        d1=den;
        n2=a.num;
        d2=a.den;
        nn1=n1.multiply(n2);
        dd =d1.multiply(d2);
        g  =nn1.gcd(dd);
        nn =nn1.divide(g);
        dd =dd.divide(g);
        Rational r=new Rational(nn,dd);
        return r;
    }

    public Rational div(Rational a) {
        BigInteger n1,d1,n2,d2,nn1,nn2,nn,dd,g;
        n1=num;
        d1=den;
        n2=a.den;
        d2=a.num;
        nn1=n1.multiply(n2);
        dd =d1.multiply(d2);
        g  =nn1.gcd(dd);
        nn =nn1.divide(g);
        dd =dd.divide(g);
        Rational r=new Rational(dd,nn);
        return r;

    }

    public String toString() {
        if (num.compareTo(den)==0)
            return "1";
        else if (num.compareTo(BigInteger.ZERO)==0)
            return "0";
        else if (den.compareTo(BigInteger.ONE)==0)
            return num.toString();
        else if (den.compareTo(BigInteger.ZERO)==0)
            return "#INF";
        else
            return num.toString()+"/"+den.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return Objects.equals(num, rational.num) && Objects.equals(den, rational.den);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, den);
    }
}
class Main {
    public static void main(String [] args)
    {
        String a1,a2;

        Scanner in = new Scanner(System.in);
        System.out.print("a1=");
        a1=in.next();
        System.out.print("a2=");
        a2=in.next();

        Rational r1 = new Rational(a1);
        Rational r2 = new Rational(a2);
        System.out.println("add="+(r2.add(r1)).toString());
        System.out.println("sub="+(r2.sub(r1)).toString());
        System.out.println("mul="+(r2.mul(r1)).toString());
        System.out.println("div="+(r2.div(r1)).toString());
    }
}
