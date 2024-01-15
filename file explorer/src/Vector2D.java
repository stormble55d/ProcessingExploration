public class Vector2D {
    private float x; 
    private float y;

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;

    }  
    
    public float getX(){
        return x;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public float getY(){
        return y;
    }

    public void sub(Vector2D other){
        this.x = this.x - other.x;
        this.y =  this.y - other.y;    
    }

    public void add(Vector2D other){
        this.x = this.x + other.x;
        this.y =  this.y + other.y;
    }

    public void print(){
        System.out.println(this.x + ", " + this.y);
    }
}
