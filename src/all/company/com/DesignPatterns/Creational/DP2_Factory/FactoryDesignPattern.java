package all.company.com.DesignPatterns.Creational.DP2_Factory;

interface Computer {
    String getHdd();
    String getRam();
    String getType();
}

class PC implements Computer {

    private String hdd;

    private String ram;

    private String type;

    PC(final String hdd, final String ram) {
        this.hdd = hdd;
        this.ram = ram;
        this.type = "PC";
    }

    @Override
    public String getHdd() {
        return hdd;
    }

    void setHdd(final String hdd) {
        this.hdd = hdd;
    }

    public String getRam() {
        return ram;
    }

    void setRam(final String ram) {
        this.ram = ram;
    }

    public String getType() {
        return type;
    }

    void setType(final String type) {
        this.type = type;
    }

    @Override public String toString() {
        return "PC{" +
                "hdd='" + hdd + '\'' +
                ", ram='" + ram + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

class Laptop implements Computer {
    private String hdd;

    private String ram;

    private String type;

    Laptop(final String hdd, final String ram) {
        this.hdd = hdd;
        this.ram = ram;
        this.type = "Laptop";
    }

    @Override public String getHdd() {
        return hdd;
    }

    void setHdd(final String hdd) {
        this.hdd = hdd;
    }

    @Override public String getRam() {
        return ram;
    }

    void setRam(final String ram) {
        this.ram = ram;
    }

    public String getType() {
        return type;
    }

    void setType(final String type) {
        this.type = type;
    }

    @Override public String toString() {
        return "Laptop{" +
                "hdd='" + hdd + '\'' +
                ", ram='" + ram + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

enum ComputerType {
    PC,
    Laptop;
}

class ComputerFactory{

    public static Computer getObject(ComputerType type){
        Computer computer = null;
        switch (type) {
            case PC: {
                computer = new PC("2TB HDD", "8GB DDR4");
                break;
            }
            case Laptop: {
                computer = new Laptop("1TB HDD + 256 SSD", "16GB DDR4");
            }
        }
        return computer;
    }

}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        Computer computer = ComputerFactory.getObject(ComputerType.Laptop);
        System.out.println(computer);
    }
}
