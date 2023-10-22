package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("task1_testing")
    void Task_1Testing(){
        var two = new Task1.Expr.Constant(2.1235);
        assertThat(two.evaluate()).isEqualTo(2.1235);


        var negOne = new Task1.Expr.Negate(new Task1.Expr.Constant(1));
        assertThat(negOne.evaluate()).isEqualTo(-1);

        var four = new Task1.Expr.Constant(4);
        var sumTwoFour = new Task1.Expr.Addition(two, four);
        assertThat(sumTwoFour.evaluate()).isEqualTo(6.1235);

        var mult = new Task1.Expr.Multiplication(sumTwoFour, negOne);
        assertThat(mult.evaluate()).isEqualTo(-6.1235);

        var exp = new Task1.Expr.Exponent(mult, 2);
        assertThat(exp.evaluate()).isEqualTo(6.1235*6.1235);

        var res = new Task1.Expr.Addition(exp, new Task1.Expr.Constant(1));
        assertThat(res.evaluate()).isEqualTo(6.1235*6.1235+1);
        System.out.println(res + " = " + res.evaluate());
    }
}
