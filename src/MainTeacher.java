import model.TeacherType;
import model.TeachingStaff;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainTeacher {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TeachingStaff teachingStaff = new TeachingStaff();
        teachingStaff.setTeacherType(TeacherType.ADJUNCT);
        switch (teachingStaff.getTeacherType()) {
            case ADJUNCT:
                System.out.println("Adjunct Faculty");
                break;
            case FULL_TIME_ASSISTANT:
                System.out.println("FULL TIME ASSISTANT Faculty");
                break;
            case FULL_TIME_ASSOCIATE:
                System.out.println("FULL TIME ASSOCIATE Faculty");
                break;

        }
    }
}
