package _patterns;

interface Resource {
    int getValue();
    void setValue(int x);
}

final class Singleton {
    private static final class ResourceImpl implements Resource {
        private int i;
        private ResourceImpl(int i) {
            this.i = i;
        }
        public synchronized int getValue() {
            return i;
        }
        public synchronized void setValue(int x) {
            i = x;
        }
    }
    private static class ResourceHolder {
        private static Resource resource = new ResourceImpl(1);
    }
    public static Resource getResource() {
        return ResourceHolder.resource;
    }
}

public class
SingletonPattern {

    public static void main(String[] args) {

        Resource r = Singleton.getResource();
        System.out.println(r.getValue());

        Resource s2 = Singleton.getResource();
        s2.setValue(9);
        try {
            // Singleton s3 = (Singleton)s2.close()
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
