package refactor.java.ch010;

public class PreserveWholeObject {
    class Room {
        boolean withinPlan(HeatingPlan plan) {
            int low = daysTempRange().getLow();
            int high = daysTempRange().getHigh();
            return plan.withinRange(low, high);
        }
    }

    class HeatingPlan {
        boolean withinRange(int low, int high) {
            return (low >= _range.getLow() && high <= _range.getHigh());
        }

        boolean withinRange(TempRange roomRange) {
            return (_range.includes(roomRange));
        }

        private TempRange _range;
    }

    class TempRange {
        boolean includes(TempRange arg) {
            return arg.getLow() >= this.getLow() && arg.getHigh() <= this.getHigh();
        }
    }

}
