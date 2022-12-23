public class RandomWalk 
{
    //Look for distance between start and current position
    public static void main(String[]args)
    {
        int deltaX = step();
        int deltaY = step();
        int steps = 0;
        int distance = 0;

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
        while(distance < 100)
        {
            distance = (int)(Math.abs(Math.sqrt(Math.pow(escape.getX()-150, 2) + Math.pow(escape.getY()-150, 2))));
            escape.translate(deltaX, deltaY);
            steps += 1;
            deltaX = step();
            deltaY = step();
            try { Thread.sleep(100);} catch(Exception ex) {};
        }
        System.out.println("Escaped in " + steps + " steps");
        

    }

    public static int step()
    {
        return (int)(Math.random()*21)-10;
    }
}
