

class Vehicle
{
    protected String brand;
    protected int speed;

    Vehicle(String brand, int speed)
    {
        this.speed = speed;
        this.brand = brand;
    }


    // mrthods in vehical

    protected void starting()
    {
        System.out.println("Starting "+ brand );
    }

    protected void stopping()
    {
        System.out.println("Stoping "+ brand );
    }

    public void display()
    {
        System.out.println("Brand is " + brand + "speed is : " + speed );
    }
}

class Car extends Vehicle
{
    protected int doors;

    Car(String brand, int speed, int doors)
    {
        super(brand,speed);
        this.doors = doors;
    }

    protected void NoOfDoors()
    {
        System.out.println("Number of doors are: "+ doors );
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("Number of doors:  "+ doors );
    }
}

class Bike extends Vehicle
{
    protected boolean carriage;

    Bike(String brand, int speed, boolean carriage)
    {
        super(brand,speed);
        this.carriage = carriage;
    }

    protected void isDeliveryCar()
    {
        if(carriage)
        {
            System.out.println("Not for delivery purpose");
        }
        else
        {
            System.out.println("Can also be used for delivery purpose" );
        }
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("Vehicle can deliver " + carriage );
    }

}

class inheritance {
    public static void main(String[] args) {
        Bike b = new Bike("Honda", 200, false);

        Car c = new Car("Tata", 300, 5);


        b.starting();
        b.stopping();
        b.display();

        c.starting();
        c.stopping();
        c.display();
    }
}