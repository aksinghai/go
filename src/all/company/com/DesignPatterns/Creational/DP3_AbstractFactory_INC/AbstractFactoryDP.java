package all.company.com.DesignPatterns.Creational.DP3_AbstractFactory_INC;

interface Computer {
    String getRam();
    String getHdd();
    String getCpu();
}

class PC implements Computer {
    String ram;
    String hdd;
    String cpu;

    PC(final String ram, final String hdd, final String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override public String getRam() {
        return ram;
    }

    void setRam(final String ram) {
        this.ram = ram;
    }

    @Override public String getHdd() {
        return hdd;
    }

    void setHdd(final String hdd) {
        this.hdd = hdd;
    }

    @Override public String getCpu() {
        return cpu;
    }

    void setCpu(final String cpu) {
        this.cpu = cpu;
    }

    @Override public String toString() {
        return "PC{" +
                "ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", cpu='" + cpu + '\'' +
                '}';
    }
}

class Server implements Computer {

    String ram;
    String hdd;
    String cpu;

    Server(final String ram, final String hdd, final String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override public String getRam() {
        return ram;
    }

    void setRam(final String ram) {
        this.ram = ram;
    }

    @Override public String getHdd() {
        return hdd;
    }

    void setHdd(final String hdd) {
        this.hdd = hdd;
    }

    @Override public String getCpu() {
        return cpu;
    }

    void setCpu(final String cpu) {
        this.cpu = cpu;
    }

    @Override public String toString() {
        return "Server{" +
                "ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", cpu='" + cpu + '\'' +
                '}';
    }
}

interface ComputerAbstractFactory {
    Computer createComputer(String ram, String hdd, String cpu);
}

class PCFactory implements ComputerAbstractFactory {
    @Override public Computer createComputer(final String ram, final String hdd, final String cpu) {
        return new PC(ram, hdd, cpu);
    }
}

class ServerFactory implements ComputerAbstractFactory {
    @Override public Computer createComputer(final String ram, final String hdd, final String cpu) {
        return new Server(ram, hdd, cpu);
    }
}

enum ComputerType {
    PC, SERVER;
}

class ComputerFactory {
    Computer getComputer(ComputerAbstractFactory computerAbstractFactory){
        Computer computer = null;
        return null;
    }
}

public class AbstractFactoryDP {

}
