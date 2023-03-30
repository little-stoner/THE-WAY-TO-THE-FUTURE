package _patterns.adapter;

public class A {

    private static class WhatIHave {
        public void g() {}
        public void h() {}
    }
    private interface WhatIWant {
        void f();
    }

    private static class ProxyAdapter implements WhatIWant {
        WhatIHave whatIHave;
        ProxyAdapter(WhatIHave wih) {
            whatIHave = wih;
        }

        @Override
        public void f() {
            whatIHave.g();
            whatIHave.h();
        }
    }

    private static class WhatIUse {
        public void op(WhatIWant wiw) {
            wiw.f();
        }
    }
    private static class WhatIUse2 extends WhatIUse {
        public void op(WhatIHave wih) {
            new ProxyAdapter(wih).f();
        }
    }
    private static class WhatIHave2 extends WhatIHave
        implements WhatIWant {
        @Override
        public void f() {
            g();
            h();
        }
    }
    private static class WhatIHave3 extends WhatIHave {
        private class InnerAdapter implements WhatIWant {
            @Override
            public void f() {
                g();
                h();
            }
        }
        public WhatIWant whatIWant() {
            return new InnerAdapter();
        }
    }
}
