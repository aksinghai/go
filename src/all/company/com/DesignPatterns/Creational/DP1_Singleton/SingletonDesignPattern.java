package all.company.com.DesignPatterns.Creational.DP1_Singleton;

class Resource {
    private static Resource resource;
    private int item;

    private Resource() {
        System.out.println("Constructor");
    }

    public static Resource getInstance(){
        if(resource == null) {
            synchronized (SingletonDesignPattern.class) {
                if (resource == null) {
                    resource = new Resource();
                }
            }
        }
        return resource;
    }

    public int getItem() {
        return item;
    }

    public void setItem(final int item) {
        this.item = item;
    }
}

public class SingletonDesignPattern {
    public static void main(String[] args) {
        Resource resource = Resource.getInstance();
        resource.setItem(10);
        System.out.println(resource.getItem());

        Resource resource1 = Resource.getInstance();
        System.out.println(resource1.getItem());
    }
}
