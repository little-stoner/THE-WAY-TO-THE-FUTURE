package _onjava8._exceptions;

class BaseballException extends Exception {}
class Foul extends BaseException {}
class Strike extends BaseException {}

abstract class Inning {
    Inning() throws BaseException {}
    public void event() throws BaseException {}
    public abstract void atBat() throws Strike, Foul;
    public void walk() {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    void event() throws RainedOut;
    void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {

    // OK to add new exceptions for constructors, but you
    // must deal with the base constructor exceptions.
    public StormyInning() throws RainedOut, BaseException {}
    public StormyInning(String s) throws BaseException {}

    public void walk() {}
    // Interface CANNOT add exceptions to existing
    // methods from the base class:
    // public void event() throws RainedOut {}

    // If the method doesn't already exist in
    // the base class, the exception is ok:
    @Override
    public void rainHard() throws RainedOut {}

    // You can choose to not throw any exceptions,
    // even if the base version does:
    @Override
    public void event() {}

    // Overridden methods can throw inherited exceptions:
    @Override
    public void atBat() throws PopFoul {}

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println(" Pop foul ");
        } catch (RainedOut e) {
            System.out.println(" Rained out ");
        } catch (BaseException e) {
            System.out.println(" Generic baseball exception ");
        }
        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Strike e) {
            System.out.println(" Strike");
        } catch (Foul e) {
            System.out.println(" Foul ");
        } catch (RainedOut e) {
            System.out.println(" Rained out ");
        } catch (BaseException e) {
            System.out.println(" Generic baseball exception ");
        }
    }

}
