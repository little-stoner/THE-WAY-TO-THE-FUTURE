package _onjava8._polymorphism.music;

public class Wind extends Instrument {

    @Override
    public void play(Note n) {
        System.out.println(" Wind.play() " + n);
    }

}
