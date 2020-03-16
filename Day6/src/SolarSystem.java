import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SolarSystem
{
    ArrayList<Planet> satellites;

    public SolarSystem()
    {
        satellites = new ArrayList<>();
    }


    public void addSatellite(Planet _newSatellite)
    {
        if(!satellites.contains(_newSatellite))
        {
            satellites.add(_newSatellite);
        }
    }

    public Planet findPlanet(Planet planet){
        if(satellites.contains(planet)){
            return satellites.get(satellites.indexOf(planet));
        }else{
            return null;
        }
    }

    @Override
    public String toString()
    {
        return "SolarSystem{" +
                Arrays.toString(satellites.toArray()) +
                "} \n with total: " + satellites.size() + " planets";
    }
}
