package _proxy;

import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

import java.lang.reflect.InvocationTargetException;

public class FastClassDemo {

    static class MyBean {
        String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException {
        FastClass fastClass = FastClass.create(ImmutableBean.SampleBean.class);
        FastMethod fastMethod = fastClass.getMethod(ImmutableBean.SampleBean.class.getMethod("getValue"));
        MyBean myBean = new MyBean();
        myBean.setValue("-------------");
        System.out.println(fastMethod.invoke(myBean, new Object[0]));
    }

}
