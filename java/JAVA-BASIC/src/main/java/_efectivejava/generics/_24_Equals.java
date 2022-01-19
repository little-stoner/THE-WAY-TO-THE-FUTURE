package _efectivejava.generics;

import java.lang.reflect.Method;

public class _24_Equals {

    class Triple<T> implements Cloneable {
        private T fst, snd, trd;

        public Triple(T t1, T t2, T t3) {
            fst = t1;
            snd = t2;
            trd = t3;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null) {
                return false;
            }
            if (this.getClass() != other.getClass()) {
                return false;
            }
            Triple<?> otherTriple = (Triple<?>) other;
            return (this.fst.equals(otherTriple.fst)
                    && this.snd.equals(otherTriple.snd) && this.trd.equals(otherTriple.trd));
        }

        public boolean equals(Triple<T> other) {
            if (this == other) return true;
            if (other == null) return false;
            return (this.fst.equals(other.fst)
                    && this.snd.equals(other.snd) && this.trd.equals(other.trd));
        }

        @Override
        public Triple<T> clone() {
            Triple<T> clon = null;
            try {
                clon = (Triple<T>) super.clone(); // unchecked warning
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
            try {
                Class<?> clzz = this.fst.getClass();
                Method meth = clzz.getMethod("clone", new Class[0]);
                Object dupl = meth.invoke(this.fst, new Object[0]);
                clon.fst = (T) dupl; // unchecked warning
            } catch (Exception e) {

            }
            try {
                Class<?> clzz = this.snd.getClass();
                Method meth = clzz.getMethod("clone", new Class[0]);
                Object dupl = meth.invoke(this.snd, new Object[0]);
                clon.snd = (T) dupl; // unchecked warning
            } catch (Exception e) {

            }
            try {
                Class<?> clzz = this.trd.getClass();
                Method meth = clzz.getMethod("clone", new Class[0]);
                Object dupl = meth.invoke(this.trd, new Object[0]);
                clon.trd = (T) dupl; // unchecked warning
            } catch (Exception e) {

            }
            return clon;
        }

    }
}
