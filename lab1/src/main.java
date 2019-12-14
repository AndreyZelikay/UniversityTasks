import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
       /* Scanner in = new Scanner(System.in);
        System.out.println("Input x:");
        BigDecimal x = in.nextBigDecimal();
        if (x.abs().compareTo(BigDecimal.valueOf(1)) > 0){
           System.out.println("x out of range!");
           System.exit(0);
        }
        System.out.println("Input k:");
        BigInteger k = in.nextBigInteger();
        BigDecimal ten = new BigDecimal("10");
        BigDecimal E = ten.pow((-1)*k.intValue(), MathContext.DECIMAL32);
        BigDecimal buffer = new BigDecimal("0");
        buffer.setScale(k.intValue()*3,RoundingMode.HALF_UP);
        buffer = x;
        BigDecimal result = new BigDecimal("0");
        result.setScale(k.intValue()*3,RoundingMode.HALF_UP);
        BigDecimal koeff = new BigDecimal("0");
        koeff.setScale(k.intValue()*3,RoundingMode.HALF_UP);
        koeff = BigDecimal.valueOf(0.5);
        int i = 3;
        while (buffer.abs().compareTo(E) >= 0) {
            result = result.add(buffer);
            buffer = koeff.multiply(x.pow(i)).divide(BigDecimal.valueOf(i),RoundingMode.HALF_UP);
            koeff = koeff.multiply(BigDecimal.valueOf(i)).divide(BigDecimal.valueOf(i+1));
            i += 2;
        }
        k.add(BigInteger.valueOf(1));
        System.out.format("%."+ k +"f%n",result);
        System.out.println(Math.asin(x.doubleValue()));*/
        System.out.println("Восьмеричный вид числа");
        System.out.format("%o%n",500000);
        System.out.println("Шестнадцатиричный вид числа");
        System.out.format("%x%n%n",500000);

        System.out.println("Значения с плавающей точкой");
        System.out.format("%f%n%n",500.000);

        System.out.println("Спецификатор минимальной ширины поля");
        System.out.format("%05d%n%n",500);

        System.out.println("Спецификатор минимальной точности");
        System.out.format("%.4f%n%n",5.5);

        System.out.println("Флаги:" + "\n");
        System.out.println("Пробел");
        System.out.format("% d%n",5);
        System.out.println("Запятая");
        System.out.format("%,.1f%n",555555555.5);
        System.out.println("Флаг #");
        System.out.format("%#x%n",5);
        System.out.println("Флаг +");
        System.out.format("%+d%n",5);
        System.out.println("Флаг (");
        System.out.format("% (d%n%n",-5);

        System.out.println("Порядковый номер аргумента");
        System.out.format("%2$d %3$d %1$ d", 5, 4, 10);


    }
}
