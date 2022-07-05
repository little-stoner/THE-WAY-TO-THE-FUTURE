package refactor.java.ch010;

public class ReplaceExceptionWithTest {
    double getValueForPeriod(int periodNumber) {
        try {
            return _values[periodNumber];
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    double getValueForPeriod(int periodNumber) {
        if (periodNumber >= _values.length)
            return 0;
        return _values[periodNumber];
    }

    class ResourcePool {
        Resource getResource() {
            Resource result;
            try {
                result = (Resource) _available.pop();
                _allocated.push(result);
                return result;
            } catch (EmptyStackException e) {
                result = new Resource();
                _allocated.push(result);
                return result;
            }
        }

        Resource getResource() {
            if (_available.isEmpty()) {
                result = new Resource();
                _allocated.push(result);
                return result;
            } else {
                result = (Resource) _available.pop();
                _allocated.push(result);
                return result;
            }
        }

        Stack _available;
        Stack _allocated;
    }
}
