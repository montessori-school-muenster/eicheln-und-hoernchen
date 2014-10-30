import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Hoernchen. Ein Hörnchen bewegt sich vorwärts, bis es nicht mehr weitergeht, und dreht 
 * sich dann nach links. Wenn ein Hörnchen eine Eichel findet, frisst er sie.
 * 
 * @author Montessori-Schule 
 * @version (a version number or a date)
 */
public class Hoernchen extends Actor
{
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;

    private int direction;
    private int eichelnEaten;
    
    public Hoernchen()
    {
        setDirection(EAST);
        eichelnEaten = 0;
    }
        
    /**
     * Tut das, was das Hörnchen tun muss. Diese Methode wird immer aufgerufen,
     * wenn der 'Act' oder 'Run'-Button gedrückt wird.
     */
    public void act() 
    {
        if(foundEichel()) 
        {
            eatEichel();
        }
        else if(canMove()) 
        {
            move();
        }
        else 
        {
            turnLeft();
        }
    }
    
    /**
     * Prüft, ob in der Zelle, in der wir uns befinden, eine Eichel ist-
     */
    public boolean foundEichel()
    {
        Actor eichel = getOneObjectAtOffset(0, 0, Eichel.class);
        if(eichel != null) 
        {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    /**
     * Frisst eine Eichel.
     */
        public void eatEichel()
    {
        Actor eichel = getOneObjectAtOffset(0, 0, Eichel.class);
        if(eichel != null) 
        {
            // frisst das Blatt ...
            getWorld().removeObject(eichel);
            eichelnEaten = eichelnEaten + 1; 
        }
    }

    /**
     * Rückt eine Zelle vorwärts in die aktuelle Richtung.
     */
    public void move()
    {
        if (!canMove()) 
        {
            return;
        }
        switch(direction) 
        {
            case SOUTH :
                setLocation(getX(), getY() + 1);
                break;
            case EAST :
                setLocation(getX() + 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() - 1);
                break;
            case WEST :
                setLocation(getX() - 1, getY());
                break;
        }
    }

    /**
     * Prüft, ob wir uns vorwärts bewegen können. Wenn ja, 
     * liefert die Methode true zurück, andernfalls false.
     */
    public boolean canMove()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        switch(direction) 
        {
            case SOUTH :
                y++;
                break;
            case EAST :
                x++;
                break;
            case NORTH :
                y--;
                break;
            case WEST :
                x--;
                break;
        }
        // testet, ob der Außenrand erreicht wurde
        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) 
        {
            return false;
        }
        else if (x < 0 || y < 0) 
        {
            return false;
        }
        return true;
    }

    /**
     * Wendet sich nach links.
     */
    public void turnLeft()
    {
        switch(direction) 
        {
            case SOUTH :
                setDirection(EAST);
                break;
            case EAST :
                setDirection(NORTH);
                break;
            case NORTH :
                setDirection(WEST);
                break;
            case WEST :
                setDirection(SOUTH);
                break;
        }
    }

    /**
     * Setzt die Richtung, in die wir uns bewegen. Der Parameter 'direction' 
     * muss im Bereich[0..3] liegen.
     */
    public void setDirection(int direction)
    {
        if ((direction >= 0) && (direction <= 3)) 
        {
            this.direction = direction;
        }
        switch(direction) 
        {
            case SOUTH :
                setRotation(90);
                break;
            case EAST :
                setRotation(0);
                break;
            case NORTH :
                setRotation(270);
                break;
            case WEST :
                setRotation(180);
                break;
            default :
                break;
        }
    }

    /**
     * Ermittelt, wie viele Eicheln wir gefressen haben.
     */
    public int getEichelnEaten()
    {
        return eichelnEaten;
    }    
}
