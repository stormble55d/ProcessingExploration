import processing.core.*;


public class Application extends PApplet{
    Dot[] dotArray;
    public void settings() {
        size(600, 600);
    }

    public void setup() {
        background(255);
        dotArray = new Dot[10000];
        for(int i = 0; i < dotArray.length; i++){
            Vector2D position = new Vector2D(random(0, this.width), random(0, this.height));
            Vector2D acceleration = new Vector2D(0, 0);
            Vector2D velocity = new Vector2D(0, 0);
            dotArray[i] = new Dot(this, position, acceleration, velocity, 10);
        }
         //dot = new Dot(this, new Vector2D(300,300), 
          //  new Vector2D(0f,0),new Vector2D(0, 0), 10);
    }

    public void draw() {
        //dot.draw();
        background(255);
        for(int i = 0; i < dotArray.length; i++){
            dotArray[i].draw();
        }
        
    }

    public static void main(String[] args) {
        PApplet.main("Application");
        
    }
}
