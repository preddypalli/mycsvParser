package mycsvparser.dto;

import org.apache.commons.csv.CSVRecord;

public class StudentDTO {
    int id_index;
    int name_index;
    int course_id_index;
    int status_index;
    
    int id;
    String name;
    int courseId;
    String status;
 
    public StudentDTO(CSVRecord csvData)
    {
        this.id=Integer.parseInt( csvData.get("student_id")) ;
        this.name=csvData.get("student_name");
        this.courseId=Integer.parseInt( csvData.get("course_id")) ;
        this.status=csvData.get("status");
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
    public void printStudent()
    {
        System.out.println("---------------->Student Info -->Name -->"+getName());
            
    }
    
}
