import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hier leben Hörnchen. Die sammeln Eicheln.
 * 
 * @author Momtessori-Schule 
 * @version 0.5
 * 
 * NAchempfunden der Wombats-World von Michael Kölling
 */
public class HoernchenWelt extends World
{

    /**
     * Constructor für Objekte der Klasse hoernchenwelt.
     * 
     */
    public HoernchenWelt()
    {    
        super(8, 8, 60);        
        setBackground("cell.jpg");
        setPaintOrder(Hoernchen.class, Eichel.class);
    }
    
    /**
     * Bevölkert die Welt mit einem vorgegebenen Szenario von
     * Hörnchen und Eicheln
     */
    public void populate()
    {
        Hoernchen h1 = new Hoernchen();
        addObject(h1, 3, 3);
        
        Hoernchen h2 = new Hoernchen();
        addObject(h2, 1, 7);
        
        Eichel e1 = new Eichel();
        addObject(e1, 5, 3);
        
        Eichel e2 = new Eichel();
        addObject(e2, 0, 2);
        
        Eichel e3 = new Eichel();
        addObject(e3, 7, 5);

        Eichel e4 = new Eichel();
        addObject(e4, 2, 6);

        Eichel e5 = new Eichel();
        addObject(e5, 5, 0);
        
        Eichel e6 = new Eichel();
        addObject(e6, 4, 7);

    }
    
    /*
     * Platziert eine Anzahl von Eicheln an beliebigen Positionen
     * in der Welt. Die Anzahl der Eicheln kann angegeben werden.
     */
    public void randomEicheln(int howMany)
    {
        for(int i=0; i<howMany; i++) 
        {
            Eichel eichel = new Eichel();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(eichel, x, y);
        }
    }
}
