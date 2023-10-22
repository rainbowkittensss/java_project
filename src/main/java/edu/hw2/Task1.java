package edu.hw2;

public class Task1 {
    public sealed interface Expr {
        double evaluate();

         record Constant(double value) implements Expr {
            @Override
            public double evaluate() {
                return this.value();
            }
        }
         record Negate(Expr arg) implements Expr {
            @Override
            public double evaluate() {
                return -arg.evaluate();
            }
        }

        record Exponent(Expr arg, double degree) implements Expr {
            @Override
            public double evaluate() {
                return Math.pow(arg.evaluate(),degree);
            }
        }
        record Addition(Expr term_1,Expr term_2) implements Expr {
            @Override
            public double evaluate() {
                return term_1().evaluate()+term_2.evaluate();
            }
        }
        record Multiplication(Expr factor_1, Expr factor_2) implements Expr {
            @Override
            public double evaluate() {
                return factor_1.evaluate()*factor_2.evaluate();
            }
        }
    }
}
