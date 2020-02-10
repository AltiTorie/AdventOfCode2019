import java.util.Objects;

public class Coordinates
{

    private int x;
    private int y;
    private int val;

    Coordinates(int X, int Y, int value)
    {
        x = X;
        y = Y;
        val = value;
    }

    public void New(int X, int Y, int value)
    {
        x = X;
        y = Y;
        val = value;
    }

    public int X()
    {
        return x;
    }

    public int Y()
    {
        return y;
    }

    public int Val()
    {
        return val;
    }

    @Override
    public String toString()
    {
        return "(" + x + "," + y + ")=" + val;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }
}
