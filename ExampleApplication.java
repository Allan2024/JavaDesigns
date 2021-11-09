import java.util.Scanner;

abstract class Strategy {
        public abstract int execute(int a,int b);
    }
    class ConcreteStrategyadd extends Strategy{

        @Override
        public int execute(int a, int b) {
            return(a+b);
        }
    }
 class ConcreteStrategymulitply extends Strategy{

     @Override
     public int execute(int a, int b) {
         return(a*b);
     }
 }
  class ConcreteStrategysubtract extends Strategy{
    @Override
    public int execute(int a,int b ){
        return(a-b);
    }

}
 class Context{
    public Strategy strategy;
    public void setStrategy(Strategy strategy){
        this.strategy= strategy;

    }
     public int executeStrategy(int a,int b){
         return strategy.execute(a, b);

     }
 }
 public class ExampleApplication {
     public static void main(String[] args) {
         Context context = new Context();
         context.strategy = new ConcreteStrategyadd();
         int add = context.executeStrategy(45, 12);
         System.out.println(add);
         context.strategy = new ConcreteStrategymulitply();
         int multiply = context.executeStrategy(12, 13);
         System.out.println(multiply);
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter an operator:");
         String operator = scanner.nextLine();
         if (operator.equals("*")) {
             ConcreteStrategymulitply obj1 = new ConcreteStrategymulitply();
             context.setStrategy(new ConcreteStrategymulitply());

         }
         else if (operator.equals("+")) {
             ConcreteStrategyadd obj2 = new ConcreteStrategyadd();
             context.setStrategy(new ConcreteStrategyadd());
         }
         else if (operator.equals("-")) {
             ConcreteStrategysubtract obj3 = new ConcreteStrategysubtract();
             context.setStrategy(new ConcreteStrategysubtract());

         }
         int result = context.executeStrategy(12, 10);
         System.out.println(result);
     }
 }



