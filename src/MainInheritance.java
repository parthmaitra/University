import model.Employee;
import model.TeachingStaff;

public class MainInheritance {
    public static void main(String[] args) {
        Employee e = new TeachingStaff();
        e.setId(true);
        System.out.println(e.getId());
    }
}
