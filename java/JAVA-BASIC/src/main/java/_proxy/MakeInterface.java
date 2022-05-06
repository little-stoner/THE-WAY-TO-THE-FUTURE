package _proxy;

import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.InterfaceMaker;
import org.objectweb.asm.Type;

public class MakeInterface {

    public static void main(String[] args) {
        Signature signature = new Signature("foo", Type.DOUBLE_TYPE, new Type[]{Type.INT_TYPE});
        InterfaceMaker interfaceMaker = new InterfaceMaker();
        interfaceMaker.add(signature, new Type[0]);
        Class<?> iface = interfaceMaker.create();
        System.out.println(iface.getMethods().length);
        System.out.println(iface.getMethods()[0].getName());
        System.out.println(iface.getMethods()[0].getReturnType());
    }

}
