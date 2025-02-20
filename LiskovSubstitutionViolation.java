public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        Bird bird = new Sparrow();
        bird.fly();

        FlightlessBird ostrich = new Ostrich();
        ostrich.walk();
    }
}

abstract class Bird {
    public abstract void move();
}

abstract class FlyingBird extends Bird {
    public abstract void fly();

    @Override
    public void move() {
        fly();
    }
}

abstract class FlightlessBird extends Bird {
    public abstract void walk();

    @Override
    public void move() {
        walk();
    }
}

class Sparrow extends FlyingBird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Ostrich extends FlightlessBird {
    @Override
    public void walk() {
        System.out.println("Ostrich is walking");
    }
}
