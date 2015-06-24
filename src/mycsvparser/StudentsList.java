package mycsvparser;

import java.util.ArrayList;
import java.util.List;

import mycsvparser.dto.StudentDTO;

public class StudentsList {
    List<StudentDTO> studentsList = new ArrayList<StudentDTO>();
    
   
    public void addStudent(StudentDTO newStudent) {
        boolean studentFound = false, courseFound = false, activeCourseExists =false;
        boolean deactive = false;
        List<StudentDTO> studCourseLst = new ArrayList<StudentDTO>();
        int courseIndx = -1, indx = 0;
        for (StudentDTO student : studentsList) {
            if (student.getId() == newStudent.getId()) {
                studentFound = true;
                studCourseLst.add(student);
                if (student.getCourseId() == newStudent.getCourseId()) {
                    courseIndx = indx;
                    courseFound = true;
                    break;
                }
            }
            indx++;
		}
        if (!studentFound) {
            studentsList.add(newStudent);
		} else if (studentFound) {
				if (courseFound) {
					if ("inactive".equalsIgnoreCase(newStudent.getStatus())) {
						studentsList.add(courseIndx, newStudent);
					} else if ("active".equalsIgnoreCase(newStudent.getStatus())) {
                    for (StudentDTO tmpStudent : studCourseLst) {
                        if ("active".equalsIgnoreCase(tmpStudent.getStatus())) {
                            activeCourseExists = true;
                        }
                    }
                    if (!activeCourseExists) {
                        studentsList.add(newStudent);
                    } else {
                        System.out.println("Active course exists ..Hence no more courses allowed");
                    }
                }
            } else {
                studentsList.add(newStudent);
            }
        }
    }
    
    public void printList()
    {
        for (StudentDTO student : studentsList) {
            student.printStudent();
        }
    }

    public void setStudentsList(List<StudentDTO> studentsList) {
        this.studentsList = studentsList;
    }

    public List<StudentDTO> getStudentsList() {
        return studentsList;
    }
}
