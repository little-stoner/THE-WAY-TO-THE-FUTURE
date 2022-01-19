package _concurrency.jcip;

import java.util.EventListener;

public class ThisEscape {
    static class EventSource {
        public void registerListener(EventListener eventListener) {

        }
    }
    public ThisEscape(EventSource source) {
        source.registerListener(
                new EventListener() {

                }
        );
    }
}
