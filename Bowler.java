import java.util.*;

public class Bowler
{
    public String name;
    public double overs;
    public double overRunTotal;
    public double maidens;
    public double runs;
    public double wickets;
    public static ArrayList<String> bowlers = new ArrayList<String>(); 

    public Bowler(String x)
    {
        name = x;
        bowlers.add(x);
        overs = 0;
        overRunTotal = 0;
        maidens = 0;
        runs = 0;
        wickets = 0;
    }

    public String getName()
    {
        return name;
    }

    public void addBall()
    {
        if (((overs * 10) % 5) == 0)
        {
            overs = overs + 0.5;
        }

        else
        {
            overs += 0.1;
        }
    }

    public void addMaiden()
    {
        if (overRunTotal == 0)
        {
            maidens++;
        }

        overRunTotal = 0;
    }

    public void addRuns(double x)
    {
        runs += x;
        overRunTotal += x;
    }

    public void addWicket()
    {
        wickets++;
    }

    public static boolean doesBowlerExist(String x)
    {
        if ((bowlers.contains(x)))
        {
            return true;
        }

        else
        {
            return false;
        }
    }

}
