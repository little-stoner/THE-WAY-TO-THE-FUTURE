package _proxy;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.beans.BulkBean;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeanGeneratorDemo {

    public void testBeanGenerator() throws Exception {
        BeanGenerator generator = new BeanGenerator();
        generator.addProperty("value", String.class);
        Object myBean = generator.create();

        Method setter = myBean.getClass().getMethod("setValue", String.class);
        setter.invoke(myBean, "Hello cglib!");
        Method getter = myBean.getClass().getMethod("getValue");
        System.out.println(getter.invoke(myBean));
    }

    static class OtherSampleBean {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public void testBeanCopier() throws Exception {
        BeanCopier copier = BeanCopier.create(ImmutableBean.SampleBean.class, OtherSampleBean.class, false);
        ImmutableBean.SampleBean bean = new ImmutableBean.SampleBean();
        bean.setValue("HHHHHHHHH");
        OtherSampleBean otherBean = new OtherSampleBean();
        copier.copy(bean, otherBean, null);
        System.out.println(otherBean.getValue());
    }

    public void testBulkBean() throws Exception {
        BulkBean bulkBean = BulkBean.create(ImmutableBean.SampleBean.class,
                new String[]{"getValue"},
                new String[]{"setValue"},
                new Class[]{String.class});
        ImmutableBean.SampleBean bean = new ImmutableBean.SampleBean();
        bean.setValue("Hello world!");
        assertEquals(1, bulkBean.getPropertyValues(bean).length);
        assertEquals("Hello world!", bulkBean.getPropertyValues(bean)[0]);
        bulkBean.setPropertyValues(bean, new Object[] {"Hello cglib!"});
        assertEquals("Hello cglib!", bean.getValue());
    }

    public void testBeanGenerateMap() throws Exception {
        ImmutableBean.SampleBean bean = new ImmutableBean.SampleBean();
        BeanMap map = BeanMap.create(bean);
        bean.setValue("KKKKKKKKK");
        System.out.println(map.get("value"));
    }

    public static void main(String[] args) throws Exception {
        new BeanGeneratorDemo().testBeanGenerator();
        System.out.println("==================");
        new BeanGeneratorDemo().testBeanCopier();
        System.out.println("*******************");
        new BeanGeneratorDemo().testBulkBean();
        System.out.println("&&&&&&&&&&&&&&&&&&&&");
        new BeanGeneratorDemo().testBeanGenerateMap();
    }

}
