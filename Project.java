import java.util.Scanner;

class Centroid {

    
    double cx1;
    double cx2;
    double cx3;
    double cy1;
    double cy2;
    double cy3;
    double ar1;
    double ar2;
    double ar3;
    double gX;
    double gY;
    double b1;
    double b2;
    double b3;
    double h1;
    double h2;
    double h3;

    void r1 (double x11, double x12, double x13 , double x14, double y11 , double y12, double y13 , double y14){
        this.cx1 = (x12-x11)/2;
        this.cy1 = (y14-y11)/2;
        this.ar1 = (x12-x11)*(y14-y11);
        this.b1 = this.cx1*2;
        this.h1 = this.cy1*2;
    }
    void r2 (double x12, double x22, double x23 , double x24, double y12 , double y22, double y23 , double y24 ) {
        this.cx2 = x12 + (x22-x12)/2;
        this.cy2 =(y23 - y22)/2;
        this.ar2 = (x22 - x12)*(y23 - y22);
        this.b2 = (x22-x12);
        this.h2 = this.cy2*2;
    }
    void r3( double x22, double x32, double x33 , double x34, double y22 , double y32, double y33 , double y34) {
        this.cx3 =x22 + (x32 - x22)/2;
        this.cy3 =(y33 - y32)/2;
        this.ar3 = (x32 - x22)*(y33 - y32);
        this.b3 = (x32 - x22);
        this.h3 = this.cy3*2;
    }
    void setX() {
        this.gX = ((this.ar1)*(this.cx1) + (this.ar2)*(this.cx2) + (this.ar3)*(this.cx3))/(this.ar1 + this.ar2 + this.ar3);
        this.gY = ((this.ar1)*(this.cy1) + (this.ar2)*(this.cy2) + (this.ar3)*(this.cy3))/(this.ar1 + this.ar2 + this.ar3);
        System.out.println("X centroid =" + this.gX);
        System.out.println("Y centroid =" + this.gY);    
    }
}
class MomentOI  {
    double Ix;
    double Iy;
    double IxC;
    double IyC;
    double aIx;
    double aIy;

    void moiDefaultAxis(Centroid c) {
        Ix = (c.b1*(Math.pow(c.h1,3)))/3 + (c.b2*(Math.pow(c.h2,3)))/3 + (c.b3*(Math.pow(c.h3 , 3)))/3;
        Iy = (c.h1*(Math.pow(c.b1 , 3)))/3 + (c.h2*(Math.pow(c.b2,3)))/3 + (c.h3*(Math.pow(c.b3 , 3)))/3;
        System.out.println("Moment of Inertia about default x axis is-: "+ Ix);
        System.out.println("Moment of Inertia about default y axis is-: "+ Iy);
    }
    void moiCentroid(Centroid c) {
        IxC = ((c.b1*(Math.pow(c.h1,3)))/3 - c.ar1*(Math.pow(c.gY,2))) + (((c.b2*(Math.pow(c.h2,3)))/3 - c.ar2*(Math.pow(c.gY,2))))+(((c.b3*(Math.pow(c.h3,3)))/3 - c.ar3*(Math.pow(c.gY,2))));
        IyC = ((c.h1*(Math.pow(c.b1,3)))/12 + c.ar1*(Math.pow((c.gX-c.cx1),2)) + ((c.h2*(Math.pow(c.b2,3)))/12 - c.ar2*(Math.pow((c.gX-c.cx2),2)))+((c.h3*(Math.pow(c.b3,3)))/3 - c.ar3*(Math.pow((c.cx3-c.gX),2))));
        System.out.println("Moment of Inertia about centroidal x is-: "+IxC);
        System.out.println("Moment of Inertia about centroidal y is-: "+IyC);
    }
    
    void moiArbAxis(Centroid c) {
        System.out.println("Enter the x coordinate of new axis-:");
        Scanner sc = new Scanner(System.in);
        double xAxis = sc.nextDouble();
        System.out.println("Enter the y coordinate of new axis-:");
        double yAxis = sc.nextDouble();
        double totArea = c.ar1+c.ar2+c.ar3;
        aIx = IxC + totArea*(Math.pow(Math.abs(c.gX-xAxis),2));
        aIy = IyC + totArea*(Math.pow(Math.abs(c.gY-yAxis),2));
        System.out.println("Moment of inertia about given x axis is-: "+aIx);
        System.out.println("Moment of inertia about given y axis is-: "+aIy);

        
    }
    
}

class Project{
    public static void main (String[] args){
        Centroid obj = new Centroid();
        obj.r1(0,1,1,0,0,0,2,2);
        obj.r2(1,2,2,1,0,0,1,1);
        obj.r3(2,3,3,2,0,0,2,2);
        obj.setX();
        MomentOI obj1 = new MomentOI();
        obj1.moiDefaultAxis(obj);
        System.out.println("\n");
        obj1.moiCentroid(obj);
        System.out.println("\n");
        obj1.moiArbAxis(obj);
    }
}



