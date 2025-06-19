interface Car {
    void assemble();
}

class Sedan implements Car {
    public void assemble() {
        System.out.println("Assembling a Sedan Car");
    }
}

class SUV implements Car {
    public void assemble() {
        System.out.println("Assembling an SUV Car");
    }
}

abstract class CarFactory {
    public abstract Car createCar();
}


class SedanFactory extends CarFactory {
    public Car createCar() {
        return new Sedan();
    }
}

class SUVFactory extends CarFactory {
    public Car createCar() {
        return new SUV();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        CarFactory sedanFactory = new SedanFactory();
        Car sedan = sedanFactory.createCar();
        sedan.assemble();

        CarFactory suvFactory = new SUVFactory();
        Car suv = suvFactory.createCar();
        suv.assemble();
    }
}




