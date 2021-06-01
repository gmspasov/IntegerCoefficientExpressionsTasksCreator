import java.util.Random;
import java.util.Scanner;

/**
 * Class created by Geuorgi Spasov on 01.06.2021 for automatic creation of mathematical tasks.
 * The class contains only one static function that prints the created tasks to the screen.
 * It can be useful for teachers and students in the 7-th grade (in Bulgarian classification).
 */

public class IntegerCoefficientExpressionsTasksCreator {

    /**
     * This static function prints the created tasks to the screen.
     * @param number_of_tasks The number of the requested tasks.
     * @param limit_of_coefficients The limit of the coefficients.
     * @param limit_of_x_power The limit of the power of the variable (x).
     * @param limit_of_expression_length The limit of the number of the monomials in the expression.
     * @param minimum_expression_length The minimum number of monomials in the expression.
     */

 static void Create_Tasks(int number_of_tasks, int limit_of_coefficients, int limit_of_x_power, int limit_of_expression_length, int minimum_expression_length)
        {
            while(number_of_tasks <=0 || limit_of_coefficients <=0 || limit_of_x_power<0 || limit_of_expression_length <=0)
            {
                if (number_of_tasks <0) number_of_tasks*=-1;
                if (limit_of_coefficients <0) limit_of_coefficients*=-1;
                if (limit_of_x_power <0) limit_of_x_power*=-1;
                if (limit_of_expression_length <0) limit_of_expression_length*=-1;

                if (number_of_tasks ==0)
                {
                    System.out.println("Enter new number of tasks. 0 is selected./n New number of tasks = ");
                    Scanner scan= new Scanner(System.in);
                    number_of_tasks=scan.nextInt();
                }

                if (limit_of_coefficients ==0)
                {
                    System.out.println("Enter new limit of numbers. 0 is selected./n New limit of numbers = ");
                    Scanner scan= new Scanner(System.in);
                    limit_of_coefficients=scan.nextInt();
                }

                if (limit_of_expression_length ==0)
                {
                    System.out.println("Enter new limit of expression length. 0 is selected./n New limit of expression length = ");
                    Scanner scan= new Scanner(System.in);
                    limit_of_expression_length=scan.nextInt();
                }
                if (minimum_expression_length <0 || minimum_expression_length>limit_of_expression_length)
                {
                    System.out.println("Enter new minimum of expression length. It must be smaller that " +(limit_of_expression_length+1) +"/n New minimum of expression length = ");
                    Scanner scan= new Scanner(System.in);
                    minimum_expression_length=scan.nextInt();
                }

            }
            Random rand = new Random();

            for(int i=0;i<number_of_tasks;++i)
            {
                int expression_length= minimum_expression_length+rand.nextInt(limit_of_expression_length-minimum_expression_length);

                StringBuilder expression=new StringBuilder();
                for(int j=0;j<expression_length;++j)
                {
                 int coefficient=rand.nextInt(limit_of_coefficients);
                 int coefficient_sign = rand.nextInt(2);
                 int x_power=rand.nextInt(limit_of_x_power);

                 if(coefficient_sign==0 && coefficient!=0)
                    expression.append(" "+coefficient*(-1));
                 else
                     expression.append("+"+ coefficient+" ");

                 if(x_power>1) expression.append("x^"+x_power + " ");
                 if(x_power==1) expression.append("x ");

                }
                expression.append(" = ");
                System.out.println(expression);
            }
        }

        public static void main(String[] args) {
            IntegerCoefficientExpressionsTasksCreator.Create_Tasks(10,10,3,8,6);
        }
    };

