package _generics.faq.entity;

interface GenericType<T> {
    void method(T arg);

    Class<T> getTypeArgument();
}

class TypeArgument {
}

class ConcreteType implements GenericType<TypeArgument> {
    public void method(TypeArgument arg) {
    }

    public Class<TypeArgument> getTypeArgument() {
        return TypeArgument.class;
    }
}

class GenericUsage {
    private GenericType<?> reference;

    //public void method(Object arg) {
    //     reference.method(arg); // error
    //}

    public void method(Object arg) {
        _helper(reference, arg);
    }

    private static <T> void _helper(GenericType<T> reference, Object arg) {
        reference.method(reference.getTypeArgument().cast(arg));
    }

}

public class RecoverTypeArgument {


}
