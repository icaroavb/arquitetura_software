//dependency inversion principle (DIP) emphazies decoupling and abstraction.
//the principle consists of two core concepts: high-level modules should not depend on low-level
//modules, and both should depend on abstractions.
public class DependencyInversionViolation {
    public static void main(String[] args) {
        LightBulb bulb = new LightBulb();
        Switch lightSwitch = new Switch(bulb);
        lightSwitch.turnOn();
        lightSwitch.turnOff();
    }
}

class LightBulb implements Switchable {
    public void turnOn() {
        System.out.println("LightBulb is ON");
    }
    public void turnOff() {
        System.out.println("LightBulb is OFF");
    }
}

interface Switchable {
    //criacao de uma interface de algo que liga e desliga
    public void turnOn();
    public void turnOff();
}//fim da interface


class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void turnOn() {
        this.device.turnOn();
    }

    public void turnOff() {
        this.device.turnOff();
    }
}
