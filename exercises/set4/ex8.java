class Rectangle
{
    // Instance Variables
    double width;
    double hight;

    // Constructor Declaration of Class
    public Rectangle(double width, double hight)
    {
      if (width <= 0 || hight <=0){
        throw new IllegalArgumentException("Invalid length!");
      }
        this.width = width;
        this.hight = hight;
    }

    // method 1
    public double getWidth()
    {
        return width;
    }

    // method 4
    public double getHight()
    {
        return hight;
    }

    public double getArea() {
      return (hight*width);
      }

    public double getPerimeter() {
      return (2*(hight+width));
      }

    @Override
    public String toString()
    {
        return("The area is: "+ this.getArea()+
               ".\nThe perimeter is:" +
               this.getPerimeter());
    }

    public static void main(String[] args)
    {
        Rectangle recOne = new Rectangle(1, 1);
        System.out.println(recOne.toString());
        Rectangle recTwo = new Rectangle(3.5, 12);
        System.out.println(recTwo.toString());
        Rectangle recBad = new Rectangle(0, 0);
        System.out.println(recBad.toString());
    }
}
