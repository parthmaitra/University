package model;

import java.util.UUID;

public class TeachingStaff extends Employee {

    public TeacherType getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(String teacherType) {
        this.teacherType = TeacherType.valueOf(teacherType);
    }

    public void setTeacherType(TeacherType teacherType) {
        this.teacherType = teacherType;
    }

    TeacherType teacherType;


    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(boolean shouldAutoGenerate) {
       super.setId(UUID.randomUUID().toString());
    }

}
