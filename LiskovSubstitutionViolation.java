
public class LiskovSubstitutionViolation {
    public static void main(String[] args) {
        Bird bird = new Ostrich();
        bird.fly();
    }
}

class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}
