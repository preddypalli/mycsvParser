package mycsvparser.dto;

import org.apache.commons.csv.CSVRecord;

public class CourseDTO {
    int id_index;
    int name_index;
    int status_index;

    int courseId;
    String courseName;
    String courseStatus;

    public CourseDTO(CSVRecord csvData) {
        this.courseId = Integer.parseInt(csvData.get("course_id"));
        this.courseName = csvData.get("course_name");
        this.courseStatus = csvData.get("course_state");
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public boolean isAcive() {
        if ("active".equalsIgnoreCase(this.getCourseStatus())) {
            return true;
        }
        return false;
    }
}
