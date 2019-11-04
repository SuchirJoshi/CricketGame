import java.util.*;
public class Runner
{
    public static ArrayList<Bowler> names = new ArrayList<Bowler>();
    public static ArrayList<Batsman> batNames = new ArrayList<Batsman>();
    public static Batsman bat1;
    public static Batsman bat2;
    public static Bowler bowler;
    public static boolean bat1OnStrike = true;
    public static double wides;
    public static double noBalls;
    public static double byes;
    public static double legByes;
    public static double totalRuns;
    public static double totalWickets;
    public static double extra = 0;
    public static String val = "";
    public static double score = 0;
    public static int k = 0;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("1st opening batsman: ");
        String a = scan.nextLine();
        System.out.println("2nd opening batsman: ");
        String b = scan.nextLine();
        Batsman bat1 = new Batsman(a);
        batNames.add(bat1);
        Batsman bat2 = new Batsman(b);
        batNames.add(bat2);
        System.out.println("Key notation: Strike change(*), 1 wide (1w), 1 no-ball (1nb), 1 run-out (1ro), 1 bye (1b), 1 leg bye (1lb)");
        for (int j = 1; j > 0; )
        {
            Bowler bowler;
            System.out.println("Bowler: ");
            String c = scan.nextLine();
            boolean x = Bowler.doesBowlerExist(c);
            if (x)
            {
                for (int i = 0; i < names.size(); i++)
                {
                    String d = names.get(i).getName();
                    if (d.equals(c))
                    {
                        k = i;
                        break;
                    }
                }
                bowler = names.get(k);
            }

            else
            {
                bowler = new Bowler(c);
                names.add(bowler);
            }

            System.out.println("Over: ");
            String over = scan.nextLine();

            for (int i = 0; i < over.length(); i++)
            {
                //regular run-scoring
                if (  (Character.isDigit(over.charAt(i))) && (  (i == over.length() - 1) || (Character.isDigit(over.charAt(i+1)))))
                {
                    if (bat1OnStrike)
                    {
                        val = over.charAt(i) + "";
                        score = (double) (Integer.parseInt(val));
                        bat1.addRuns(score);
                        bat1.addBall();
                        bowler.addBall();
                        bowler.addRuns(score);
                    }
                    else
                    {
                        val = over.charAt(i) + "";
                        score = (double) (Integer.parseInt(val));
                        bat2.addRuns(score);
                        bat2.addBall();
                        bowler.addBall();
                        bowler.addRuns(score);
                    }
                    totalRuns += score;
                    if (score == 1.0 || score == 3.0 || score == 5.0)
                        {
                            if (bat1OnStrike)
                            {
                                bat1OnStrike = false;
                            }
                            else
                            {
                                bat1OnStrike = true;
                            }
                        }
                }

                //strike change
                else if (over.charAt(i) == '*')
                {
                    if (bat1OnStrike = true)
                    {
                        bat1OnStrike = false;
                    }
                    else
                    {
                        bat1OnStrike = true;
                    }
                }

                //regular wicket
                else if (over.charAt(i) == 'W')
                {
                    bowler.addWicket();
                    bowler.addBall();
                    totalWickets++;
                    System.out.println("Mode of Dismissal: ");
                    String out = scan.nextLine();

                    System.out.println("New batsman: ");
                    String value = scan.nextLine();
                    if (bat1OnStrike)
                    {
                        bat1.addBall();
                        bat1.setDismissal(out);                        
                        bat1 = new Batsman(value);
                        batNames.add(bat1);
                        bat1OnStrike = true;
                    }

                    else
                    {
                        bat2.addBall();
                        bat2.setDismissal(out);
                        bat2 = new Batsman(value);
                        batNames.add(bat2);
                        bat1OnStrike = false;
                    }
                }

                //wide
                else if (over.charAt(i) == 'w')
                {
                    extra = (double) (Integer.parseInt(over.charAt(i - 1) + ""));
                    wides += extra;
                    totalRuns += extra;
                }

                //no-ball
                else if (over.charAt(i) == 'n')
                {
                    extra = (double) (Integer.parseInt(over.charAt(i - 1) + ""));
                    wides += extra;
                    totalRuns += extra;
                }

                //byes
                else if (over.charAt(i) == 'b')
                {
                    extra = (double) (Integer.parseInt(over.charAt(i - 1) + ""));
                    byes += extra;
                    totalRuns += extra;
                }

                //leg byes
                else if (over.charAt(i) == 'l')
                {
                    extra = (double) (Integer.parseInt(over.charAt(i - 1) + ""));
                    legByes += extra;
                    totalRuns += extra;
                }

                //run-out
                else if (over.charAt(i) == 'r')
                {   
                    if (bat1OnStrike)
                    {
                        val = over.charAt(i) + "";
                        score = (double) (Integer.parseInt(val));
                        bat1.addRuns(score);
                        bat1.addBall();
                        bowler.addBall();
                        bowler.addRuns(score);
                        if (score == 1 || score == 3 || score == 5)
                        {
                            bat1OnStrike = false;
                        }
                    }
                    else
                    {
                        val = over.charAt(i) + "";
                        score = (double) (Integer.parseInt(val));
                        bat2.addRuns(score);
                        bat2.addBall();
                        bowler.addBall();
                        bowler.addRuns(score);
                        if (score == 1 || score == 3 || score == 5)
                        {
                            bat1OnStrike = true;
                        }
                    }
                    totalRuns += score;

                    bowler.addWicket();
                    totalWickets++;
                    System.out.println("Mode of Dismissal: ");
                    String out = scan.nextLine();

                    System.out.println("New batsman: ");
                    String value = scan.nextLine();
                    if (bat1OnStrike = true)
                    {
                        bat1.addBall();
                        bat1.setDismissal(out);
                        bat1 = new Batsman(value);
                        batNames.add(bat1);
                    }

                    else
                    {
                        bat2.addBall();
                        bat2.setDismissal(out);
                        bat2 = new Batsman(value);
                        batNames.add(bat2);
                    }
                }
                else
                {
                }
            }
            System.out.println(bat1.getName() + ": " + bat1.getScore());
            System.out.println(bat2.getName() + ": " + bat2.getScore());
            if (bat1OnStrike)
            {
                bat1OnStrike = false;
            }
            else
            {
                bat1OnStrike = true;
            }
            bowler.addMaiden();

            //          DO REVIVIONS TOMORROW  
            //             System.out.println("Any revisions? (y/n)");
            //             String ans = scan.nextLine();
            //             if (ans.equals("y"))
            //             {
            //                 System.out.println("Batsman or Bowler?");
            //                 
            //         }

        }
    }

}

