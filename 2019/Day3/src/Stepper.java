import java.util.Objects;

public class Stepper
{

    private int x;
    private int y;
    private int firstLength;
    private int secondLength;

    Stepper(int X, int Y, int firstLength,int secondLength)
    {
        x = X;
        y = Y;
        this.firstLength = firstLength;
        this.secondLength = secondLength;
    }

    public int X()
    {
        return x;
    }

    public int Y()
    {
        return y;
    }

    public int getFirstLength()
    {
        return firstLength;
    }


    public int getSecondLength()
    {
        return secondLength;
    }

    @Override
    public String toString()
    {
        return "("+x+","+y+")["+firstLength+","+secondLength+"]";
    }
}
