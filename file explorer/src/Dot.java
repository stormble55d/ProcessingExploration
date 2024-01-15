import processing.core.*;

public class Dot{
    private PApplet p;
    private Vector2D position;
    private Vector2D acceleration; 
    private Vector2D velocity; 
    private double mass;

    private static final float G = 25;
    public Dot(PApplet p, Vector2D position, 
        Vector2D acceleration, Vector2D velocity, double mass){
        
        this.p = p;
        this.position = position;
        this.acceleration = acceleration;
        this.velocity = velocity;
        this.mass = mass;
    }

    public void edgeControl(){
        if (this.position.getX() > p.width) {
            this.position.setX(0);
            //this.velocity.setX(this.velocity.getX() * -1);
          } else if (this.position.getX() < 0) {
            //this.velocity.setX(this.velocity.getX() * -1);
            this.position.setX(p.width);
          }      
      
          if (this.position.getY() > p.height) {
            //this.velocity.setY(this.velocity.getY() * -1); 
            this.position.setY(0);
          }
          else if(this.position.getY() < 0){
            this.position.setY(p.height);
          }
    }

    public void draw(){
        edgeControl();
        moveToMouse();
        show();
    }

    public void show(){
        p.fill(0);
        p.stroke(100);
        p.ellipse(position.getX(), position.getY(), 1, 1);
    }

    public void moveToMouse(){
        this.acceleration = forceToMouse(p.mouseX, p.mouseY);
        this.velocity.add(this.acceleration);
        this.velocity.setX(this.velocity.getX() * 0.98f);
        this.velocity.setY(this.velocity.getY() * 0.98f);
        this.position.add(this.velocity);        
    }

    public Vector2D forceToMouse(float mouseX, float mouseY){
        float d = PApplet.dist(mouseX, mouseY, this.position.getX(), this.position.getY());
        if(d >= 25){
            Vector2D mouseVector = new Vector2D(mouseX, mouseY);
            mouseVector.sub(this.position);
            Vector2D normalizedToMouse = new Vector2D(mouseVector.getX()/d
                , mouseVector.getY()/d);
            float c = (float)(G * ((this.mass * 1)/Math.pow(d, 2)));
            Vector2D res = new Vector2D(normalizedToMouse.getX() * c, 
                        normalizedToMouse.getY() * c);
            return res;
        }else{
            return new Vector2D(0, 0);
        }
    }
    
}
