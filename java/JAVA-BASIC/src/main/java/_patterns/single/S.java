package _patterns.single;

public class S {
    private interface Resource {
        int getValue();
        void setValue(int x);
    }
    private static class Singleton {
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
            private static Resource resource = new ResourceImpl(47);
        }
        public static Resource getResource() {
            return ResourceHolder.resource;
        }
    }

    public static void main(String[] args) {
        Resource r = Singleton.getResource();
        System.out.println(r.getValue());

        Resource r2 = Singleton.getResource();
        r2.setValue(9);
        System.out.println(r.getValue());
        try {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
