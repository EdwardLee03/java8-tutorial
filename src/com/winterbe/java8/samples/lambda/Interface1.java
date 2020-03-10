package com.winterbe.java8.samples.lambda;

/**
 * @author Benjamin Winterberg
 */
public class Interface1 {

    interface Formula {
        double calculate(int a);

        // 接口的默认方法
        default double sqrt(int a) {
            return Math.sqrt(positive(a));
        }

        static int positive(int a) {
            return a > 0 ? a : 0;
        }
    }

    public static void main(String[] args) {
        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                // 调用接口的默认方法
                return sqrt(a * 100);
            }
        };

        formula1.calculate(100);     // 100.0
        // 调用接口的默认方法(实例方法)
        formula1.sqrt(-23);          // 0.0
        // 调用接口的静态方法
        Formula.positive(-4);        // 0.0

        // 无法从lambda表达式中访问默认方法
//        Formula formula2 = (a) -> sqrt( a * 100);
    }
}
