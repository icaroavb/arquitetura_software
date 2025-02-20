# arquitetura_software
Repositório feito para as atividades da meteria de arquitetura de software

|- ViolationOfEncapsulation -|
--------------------------------------------------------------------------------
Foi privado os atribustos para que nao tenha fragilidade no encapsulamento.

    class Person {
    private String name;
     private int age;
     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        }
     }

|- TightCouplingViolation -|
--------------------------------------------------------------------------------
Em vez de instaciar uma classe Engine foi apenas atribuido ela na classe car, ajundando a facilitar a manutenção

    class Engine {
    public void start() {
        System.out.println("Engine started");
    }
    }

    class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();

        }
    }
