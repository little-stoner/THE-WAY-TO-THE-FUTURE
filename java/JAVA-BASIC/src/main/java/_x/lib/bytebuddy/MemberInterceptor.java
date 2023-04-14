package _x.lib.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.asm.MemberSubstitution;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.InvocationTargetException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class MemberInterceptor {

    private int i;

    public int log() {
        System.out.println(">>>>>>>>>>>> access [i] <<<<<<<<<<<<<");
        return i;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MemberInterceptor m = (MemberInterceptor) new ByteBuddy().redefine(MemberInterceptor.class)
                .visit(MemberSubstitution.relaxed()
                        .field(ElementMatchers.named("i"))
                        .replaceWith(MemberInterceptor.class.getMethod("log"))
                        .on(ElementMatchers.any()))
                .make();
                // .load(MemberSubstitution.class.getClassLoader());
                //.getLoaded()
                //.getConstructor().newInstance();
        System.out.println(m.i);
    }

}
