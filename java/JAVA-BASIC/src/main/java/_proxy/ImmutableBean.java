package _proxy;

public class ImmutableBean {
    public static class SampleBean {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public void testImmutableBean() throws Exception {
        SampleBean bean = new SampleBean();
        bean.setValue("---------");
        SampleBean immutableBean = (SampleBean) net.sf.cglib.beans.ImmutableBean.create(bean);
        System.out.println(immutableBean.getValue());
        bean.setValue("$$");
        immutableBean.setValue("*****");
    }

    public static void main(String[] args) throws Exception {
        new ImmutableBean().testImmutableBean();
    }
}
