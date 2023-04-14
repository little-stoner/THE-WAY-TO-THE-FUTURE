package _generics.faq;

import java.util.ArrayList;
import java.util.List;

public class RecoverThis {


    public abstract class Node<N extends Node<N>> {
        private final List<N> children = new ArrayList<>();
        private final N parent;

        protected Node(N parent) {
            this.parent = parent;
            // parent.getChildren().add(this); // error: incompatible types
        }

        public N getParent() {
            return parent;
        }

        public List<N> getChildren() {
            return children;
        }

    }

    public class SpecialNode extends Node<SpecialNode> {
        public SpecialNode(SpecialNode parent) {
            super(parent);
        }
    }

    // ====================================================================================

    public static abstract class Node0<N extends Node0<N>> {
        private final List<Node0<?>> children = new ArrayList<>();
        private final N parent;

        protected Node0(N parent) {
            this.parent = parent;
            parent.getChildren().add(this);
        }

        public N getParent() {
            return parent;
        }

        public List<Node0<?>> getChildren() {
            return children;
        }
    }

    public class SpecialNode0 extends Node0<SpecialNode0> {
        public SpecialNode0(SpecialNode0 parent) {
            super(parent);
        }
    }

    // ============================================================================
    public abstract class Node1<N extends Node1<N>> {
        protected final List<N> children = new ArrayList<N>();
        private final N parent;

        protected Node1(N parent) {
            this.parent = parent;
        }

        public N getParent() {
            return parent;
        }

        public List<N> getChildren() {
            return children;
        }
    }

    public class SpecialNode1 extends Node<SpecialNode1> {
        public SpecialNode1(SpecialNode1 parent) {
            super(parent);
            parent.getChildren().add(this); // fine
        }
    }

    // =======================================================================

    public abstract class Node2<N extends Node2<N>> {
        private final List<N> children = new ArrayList<N>();
        private final N parent;

        protected abstract N getThis();

        protected Node2(N parent) {
            this.parent = parent;
            parent.getChildren().add(getThis()); // fine
        }

        public N getParent() {
            return parent;
        }

        public List<N> getChildren() {
            return children;
        }
    }

    public class SpecialNode2 extends Node<SpecialNode2> {
        public SpecialNode2(SpecialNode2 parent) {
            super(parent);
        }

        protected SpecialNode2 getThis() {
            return this;
        }
    }
}
