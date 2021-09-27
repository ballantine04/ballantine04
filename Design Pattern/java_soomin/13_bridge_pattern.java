abstract class Shape {
    abstract public void draw();
    private Drawing _dp;
    Shape (Drawing dp) {
        _dp = dp;
    }
    public void drawLine (double x1, double y1, double x2, double y2){
        _dp.drawLine(x1,y1,x2,y2);
    }
    public void drawCircle (double x, double y, double r){
        _dp.drawCircle(x,y,r);
    }
}
class Rectangle extends Shape {
    private double _x1,_x2,_y1,_y2;
    public Rectangle (Drawing dp, double x1, double y1, double x2, double y2){
        super(dp);
        _x1 = x1; _x2 = x2; _y1 = y1; _y2 = y2;
    }
    public void draw(){
        System.out.println("[Drawing Rectangle...]");
        drawLine(_x1,_y1,_x2,_y1);
        drawLine(_x2,_y1,_x2,_y2);
        drawLine(_x2,_y2,_x1,_y2);
        drawLine(_x1,_y2,_x1,_y1);
    }
}
class Circle extends Shape {
    private double _x,_y,_r;
    public Circle (Drawing dp, double x, double y, double r){
        super(dp);
        _x = x; _y = y; _r = r;
    }
    public void draw(){
        System.out.println("[Drawing Circle...]");
        drawCircle(_x, _y, _r);
    }
}



abstract class Drawing{
    abstract public void drawLine(double x1, double y1, double x2, double y2);
    abstract public void drawCircle(double x, double y, double r);
}
class V1Drawing extends Drawing{
    public void drawLine(double x1, double y1, double x2, double y2){
        System.out.println("DP1 - draw_a_line : "+x1+" "+y1+" "+x2+" "+y2);
    }
    public void drawCircle(double x, double y, double r){
        System.out.println("DP1 - draw_a_circle : "+x+" "+y+" "+r);
    }
}
class V2Drawing extends Drawing{
    public void drawLine(double x1, double y1, double x2, double y2){
        System.out.println("DP2 - drawLine : "+x1+" "+y1+" "+x2+" "+y2);
    }
    public void drawCircle(double x, double y, double r){
        System.out.println("DP2 - drawCircle : "+x+" "+y+" "+r);
    }
}

public class adapter_pattern{
    public static void main(String[] args) {
        
        // Shape 와 Drawing 을 구분하여 Shape가 Drawing 종류(DP1/DB2) 를 결정하도록 함.
        
        Drawing dpv1 = new V1Drawing();
        Shape ractangle = new Rectangle(dpv1, 1, 1, 3, 3);
        ractangle.draw();

        Drawing dpv2 = new V2Drawing();
        Shape circle = new Circle(dpv2, 1, 1, 5);
        circle.draw();

    }
}


[output]

[Drawing Rectangle...]
DP1 - draw_a_line : 1.0 1.0 3.0 1.0
DP1 - draw_a_line : 3.0 1.0 3.0 3.0
DP1 - draw_a_line : 3.0 3.0 1.0 3.0
DP1 - draw_a_line : 1.0 3.0 1.0 1.0
  
[Drawing Circle...]
DP2 - drawCircle : 1.0 1.0 5.0
