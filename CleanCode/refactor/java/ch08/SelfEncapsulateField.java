package refactor.java.ch08;

public class SelfEncapsulateField {
    class IntRange {
        private int _low, _high;

        boolean includes(int arg) {
            return arg >= _low && arg <= _high;
        }

        boolean includes0(int arg) {
            return arg >= getLow() && arg <= getHigh();
        }

        void grow(int factor) {
            _high = _high * factor;
        }

        IntRange(int low, int high) {
            _low = low;
            _high = high;
        }

        public int getLow() {
            return _low;
        }

        public void setLow(int low) {
            _low = low;
        }

        public int getHigh() {
            return _high;
        }

        public void setHigh(int high) {
            _high = high;
        }
    }

    class CappedRange extends IntRange {
        CappedRange(int low, int high, int cap) {
            super(low, high);
            _cap = cap;
        }

        private int _cap;

        public int getCap() {
            return _cap;
        }

        @Override
        public int getHigh() {
            return Math.min(super.getHigh(), getCap());
        }
    }

}
