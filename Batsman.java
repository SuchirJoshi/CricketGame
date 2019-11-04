public class Batsman
{
    public String name;
    public double score;
    public double balls;
    public double fours;
    public double sixes;
    public String modeOfDismissal = "";
    
    public Batsman(String x)
    {
        name = x;
        balls = 0;
        score = 0;
        fours = 0;
        sixes = 0;
    }
    
    public void addRuns(double x)
    {
        score += x;
    }    
    
    public void addBall()
    {
        balls++;
    }
    
    public void addFour()
    {
        fours++;
    }
    
    public void addSix()
    {
        sixes++;
    }
    
    public void setDismissal(String x)
    {
        modeOfDismissal = x;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getScore()
    {
        return score;
    }
}
