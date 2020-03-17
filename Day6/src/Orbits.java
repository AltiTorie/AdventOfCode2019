import scala.concurrent.impl.FutureConvertersImpl;

import java.io.*;

public class Orbits
{
    File f = new File("Input.txt");
    SolarSystem solarSystem = new SolarSystem();

    Orbits()throws IOException{
        BufferedReader inputReader;
        inputReader = new BufferedReader(new FileReader(f));
        String line;
        solarSystem.addSatellite(new Planet(solarSystem, "COM"));
        while ((line = inputReader.readLine()) != null)
        {
            addPlanets(line);
        }
    }
    int simulateNumberOfOrbits()
    {
        int counter = 0;
        for (Planet p : solarSystem.satellites)
        {
            counter += p.countOrbits();
        }
//        System.out.println(counter);
        return counter;
    }

    int simulateShortestPath()
    {
        Planet pointer = solarSystem.findPlanet(new Planet(solarSystem,"YOU"));
        Planet previous = pointer;
        pointer = pointer.getParent();
        return pointer.searchPathTo("SAN",previous,1)-2;
    }

    void addPlanets(String input)
    {
        String[] par_child = input.split("\\)");
        Planet parent = new Planet(solarSystem, par_child[0]);
        Planet child = new Planet(solarSystem, par_child[1]);
        Planet solParent = solarSystem.findPlanet(parent);
        Planet solChild = solarSystem.findPlanet(child);
        if (solParent == null && solChild == null)
        {
            parent.addSatellite(child);
            child.setParent(parent);
            solarSystem.addSatellite(parent);
            solarSystem.addSatellite(child);
        } else if (solParent == null /*&& solChild != null*/)
        {
            child = solChild;
            parent.addSatellite(child);
            child.setParent(parent);
            solarSystem.addSatellite(parent);
        } else if (solChild == null /*&& solParent != null*/)
        {
            parent = solParent;
            child.setParent(parent);
            parent.addSatellite(child);
            solarSystem.addSatellite(child);
        } else
        {
            parent = solParent;
            child = solChild;
            child.setParent(parent);
            parent.addSatellite(child);
        }
    }


}
