import java.util.Random;

public class Die {

    //TODO make test for this class using MOCKITO
    private Random rand;

    public Die()
    {
        rand = new Random();
    }

    public int roll()
    {
        return rand.nextInt(6)+1;
    }
}
