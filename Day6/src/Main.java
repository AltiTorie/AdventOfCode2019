import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Orbits orb = new Orbits();
        System.out.println(orb.simulateShortestPath());
    }
}
