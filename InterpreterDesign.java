package Designs;

interface Expression
{
    boolean interpreter(String con);
}

// TerminalExpression class implementing
// the above interface. This interpreter
// just check if the data is same as the
// interpreter data.
class TerminalExpression implements Expression
{
    String data;

    public TerminalExpression(String data)
    {
        this.data = data;
    }

    public boolean interpreter(String con)
    {
        if(con.contains(data))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
// OrExpression class implementing
// the above interface. This interpreter
// just returns the or condition of the
// data is same as the interpreter data.
class OrExpression implements Expression
{
    Expression expr1;
    Expression expr2;

    public OrExpression(Expression expr1, Expression expr2)
    {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    public boolean interpreter(String con)
    {
        return expr1.interpreter(con) || expr2.interpreter(con);
    }
}

// AndExpression class implementing
// the above interface. This interpreter
// just returns the And condition of the
// data is same as the interpreter data.
class AndExpression implements Expression
{
    Expression expr1;
    Expression expr2;

    public AndExpression(Expression expr1, Expression expr2)
    {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    public boolean interpreter(String con)
    {
        return expr1.interpreter(con) && expr2.interpreter(con);
    }
}

// Driver class
public class InterpreterDesign
{

    public static void main(String[] args)
    {
        Expression person1 = new TerminalExpression("Tushar");
        Expression person2 = new TerminalExpression("Sanjeev");
        Expression isSingle = new OrExpression(person1, person2);

        Expression vikram = new TerminalExpression("Vikram");
        Expression committed = new TerminalExpression("Committed");
        Expression isCommitted = new AndExpression(vikram, committed);

        System.out.println(isSingle.interpreter("Tushar"));
        System.out.println(isSingle.interpreter("Sanjeev"));
        System.out.println(isSingle.interpreter("Archit"));

        System.out.println(isCommitted.interpreter("Committed, Tushar"));
        System.out.println(isCommitted.interpreter("Single, Tushar"));

    }
}
