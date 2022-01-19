package _efectivejava.generics;

import java.util.ArrayList;
import java.util.List;

public class _18_GetThis {

    static abstract class Node<N extends Node<N>>  {
        protected final List<N> children = new ArrayList<>();
        private final N parent;
        protected Node(N parent) {
            this.parent = parent;
            parent.children.add(getThis());
        }
        public N getParent() {
            return parent;
        }
        public List<N> getChildren() {
            return children;
        }
        protected abstract N getThis();
    }
    static class SpecialNode extends Node<SpecialNode> {
        public SpecialNode(SpecialNode parent) {
            super(parent);
            parent.children.add(this);
        }

        @Override
        protected SpecialNode getThis() {
            return this;
        }
    }

    //
    public abstract class SelfReferentialType<T extends SelfReferentialType<T>> {
        private SomeOtherType<T> ref;
        protected abstract T getThis();
        public void aMethod() { ref.m(getThis()); } // error: incompatible types
    }
    public interface SomeOtherType<E> {
        void m(E arg);
    }
    public class Subtype extends SelfReferentialType<Subtype> {
        @Override
        protected Subtype getThis() {
            return this;
        }
    }


}
