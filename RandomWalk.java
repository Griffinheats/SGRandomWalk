public class RandomWalk 
{
    //Look for distance between start and current position
    public static void main(String[]args)
    {
        int deltaX = step();
        int deltaY = step();
        int steps = 0;
        int distanceX = 0;
        int distanceY = 0;

        Line t = new Line(50, 50, 250, 50);
        Line t1 = new Line(50, 50, 50, 250);
        Line t2 = new Line(250, 50, 250, 250);
        Line t3 = new Line(50, 250, 250, 250);

        Rectangle bg = new Rectangle(0, 0, 300, 300);
        bg.setColor(Color.BLUE);
        Ellipse circle = new Ellipse(50, 50, 200, 200);
        Ellipse escape = new Ellipse(150, 150, 10, 10);
        circle.setColor(Color.BLACK);
        escape.setColor(Color.RED);
        bg.draw();
        bg.fill();
        circle.draw();
        escape.draw();
        escape.fill();
        t.draw();
        t1.draw();
        t2.draw();
        t3.draw();

        while(((int)Math.sqrt(Math.pow((double)distanceX, 2) + Math.pow((double)distanceY, 2)) != 100) && (escape.getX() > circle.getX() && escape.getY() > circle.getY() && escape.getX() < 250 && escape.getY() < 250))
        {
            System.out.println("" + (int)Math.sqrt(Math.pow((double)distanceX, 2) + Math.pow((double)distanceY, 2)));
            escape.translate(deltaX, deltaY);
            steps += 1;
            deltaX = step();
            deltaY = step();
            distanceX += deltaX;
            distanceY += deltaY;
            try { Thread.sleep(50);} catch(Exception ex) {};
        }
        System.out.println("" + (int)Math.sqrt(Math.pow((double)distanceX, 2) + Math.pow((double)distanceY, 2)));
        System.out.println("Escaped in " + steps + " steps");
        System.out.println("" + (int)Math.sqrt(Math.pow((double)distanceX, 2) + Math.pow((double)distanceY, 2)));
        

    }

    public static int step()
    {
        return (int)(Math.random()*21)-10;
    }
}
