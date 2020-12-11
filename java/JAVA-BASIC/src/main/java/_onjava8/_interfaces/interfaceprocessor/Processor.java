package _onjava8._interfaces.interfaceprocessor;

public interface Processor {
    default String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input);
}
