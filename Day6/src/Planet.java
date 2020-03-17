import scala.reflect.api.Trees;

import java.util.ArrayList;
import java.util.Objects;

public class Planet
{
    private SolarSystem solar;
    private Planet parent;


    private String name;

    public ArrayList<Planet> getChildren()
    {
        return children;
    }

    private ArrayList<Planet> children = new ArrayList<>();


    public Planet(SolarSystem solar, String name)
    {
        this.solar = solar;
        this.name = name;
    }

    public void addSatellite(Planet planet)
    {
        if (!children.contains(planet))
            children.add(planet);
    }

    public int countOrbits()
    {
        int count = 0;
        if (children.size() == 0)
        {
            return count;
        }
        for (Planet p : children)
        {
            count += p.countOrbits();
        }
        count += children.size();
        return count;
    }

    public int searchPathTo(String target, Planet previous, int current_counter)
    {
        int counter = current_counter;
        int x;
        if ((x = lookThroughChildren(target, previous, current_counter)) == counter-1)
        {
            previous = this;
            return parent.searchPathTo(target, previous, current_counter + 1);
        }
        return x;
    }

    private int lookThroughChildren(String target, Planet prev, int counter)
    {
        if (name.equals(target))
        {
            return counter;
        }
        if (name.equals(prev.getName()))
        {
            return counter - 1;
        }
        int x;
        for (Planet p : children)
        {
            if(!((x = p.lookThroughChildren(target, prev,counter + 1)) == counter)){
                return x;
            }
        }
        return counter - 1;
    }

    public void setParent(Planet parent)
    {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return name.equals(planet.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }

    @Override
    public String toString()
    {
        StringBuilder out = new StringBuilder(name + " is orbited by: ");
        for (Planet p : children)
        {
            out.append(" ").append(p.name).append(",");
        }
        return out.toString();
    }

    public Planet getParent()
    {
        return parent;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
