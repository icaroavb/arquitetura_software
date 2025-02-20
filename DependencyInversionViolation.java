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