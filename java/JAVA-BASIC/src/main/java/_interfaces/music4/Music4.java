package _interfaces.music4;


import _onjava8._polymorphism.music.Note;

public  class Music4 {




}

abstract class Instrument {
    private int i;
    public abstract void play(Note n);
    public String what() { return "Instrument"; }
    public abstract void adjust();
}

class Wind extends Instrument {
    @Override
    public void play(Note n) {

    }

    @Override
    public String what() {
        return super.what();
    }

    @Override
    public void adjust() {

    }
}

class Percussion extends Instrument {
    @Override
    public void play(Note n) {

    }

    @Override
    public String what() {
        return super.what();
    }

    @Override
    public void adjust() {

    }
}


class Stringed extends Instrument {
    @Override
    public void play(Note n) {

    }

    @Override
    public String what() {
        return super.what();
    }

    @Override
    public void adjust() {

    }
}