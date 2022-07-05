package refactor.java.ch08;

public class MovingBehaviorIntoTheClass {
    class Person {
        int numberOfAdvancedCourses() {
            Iterator iter = getCourse().iterator();
            int count = 0;
            while (iter.hasNext()) {
                Course course = (Course) iter.next();
                if (course.isAdvanced()) {
                    count++;
                }
            }
            return count;
        }
    }
}
