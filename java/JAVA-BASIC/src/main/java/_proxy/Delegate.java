package _proxy;

import net.sf.cglib.reflect.ConstructorDelegate;
import net.sf.cglib.reflect.MethodDelegate;
import net.sf.cglib.reflect.MulticastDelegate;

public class Delegate {

    interface BeanDelegate {
        String getValueFromDelegate();
    }
    public void testMethodDelegate() {
        ImmutableBean.SampleBean bean = new ImmutableBean.SampleBean();
        bean.setValue("HHHHHHHHHHH");
        BeanDelegate delegate = (BeanDelegate) MethodDelegate.create(bean, "getValue", BeanDelegate.class);
        System.out.println(delegate.getValueFromDelegate());
    }

    interface DelegatationProvider {
        void setValue(String value);
    }
    static class SimpleMulticastBean implements DelegatationProvider {
        private String value;

        public String getValue() {
            return value;
        }

        @Override
        public void setValue(String value) {
            this.value = value;
        }
    }

    public void testMulticastDelegate() throws Exception {
        MulticastDelegate multicastDelegate = MulticastDelegate.create(
                DelegatationProvider.class);
        SimpleMulticastBean first = new SimpleMulticastBean();
        SimpleMulticastBean second = new SimpleMulticastBean();
        multicastDelegate = multicastDelegate.add(first);
        multicastDelegate = multicastDelegate.add(second);

        DelegatationProvider provider = (DelegatationProvider)multicastDelegate;
        provider.setValue("Hello world!");

        System.out.println(first.getValue());
        System.out.println(second.getValue());
    }

    public interface SampleBeanConstructorDelegate {
        Object newInstance();
    }

    public void testConstructorDelegate() throws Exception {
        SampleBeanConstructorDelegate constructorDelegate = (SampleBeanConstructorDelegate) ConstructorDelegate.create(
                ImmutableBean.SampleBean.class, SampleBeanConstructorDelegate.class);
        ImmutableBean.SampleBean bean = (ImmutableBean.SampleBean) constructorDelegate.newInstance();
        System.out.println(ImmutableBean.SampleBean.class.isAssignableFrom(bean.getClass()));
    }

    public static void main(String[] args) {
        new Delegate().testMethodDelegate();
        System.out.println("==========================");
    }

}
