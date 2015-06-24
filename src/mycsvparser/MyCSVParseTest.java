package mycsvparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mycsvparser.dto.CourseDTO;
import mycsvparser.dto.StudentDTO;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class MyCSVParseTest {

	public static void main(String[] args) throws IOException {
		MyCSVParseTest inst = new MyCSVParseTest();
		inst.test();
	}

	public void test() throws FileNotFoundException,
			UnsupportedEncodingException, IOException {
		
		File csvData = new File("c:\\Users\\prreddy\\workspace\\mycsvParser\\student.csv");
		// CSVParser parser = CSVParser.parse(csvData, CSVFormat.EXCEL);
		InputStream is = new FileInputStream(csvData);
		Reader in = new InputStreamReader(is, "UTF-8");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);

		File csvDataCourses = new File("c:\\Users\\prreddy\\workspace\\mycsvParser\\course.csv");
		InputStream isCourses = new FileInputStream(csvDataCourses);
		Reader inCourses = new InputStreamReader(isCourses, "UTF-8");
		Iterable<CSVRecord> coursesRecords = CSVFormat.EXCEL.withHeader()
				.parse(inCourses);

		StudentsList students = new StudentsList();

		for (CSVRecord csvRecord : records) {
			StudentDTO student = new StudentDTO(csvRecord);
			students.addStudent(student);
		}

		List<StudentDTO> stdsTmp = students.getStudentsList();
		
		//Printing Active Courses and respective Active Students from List
		for (CSVRecord coursesRecord : coursesRecords) {
			CourseDTO course = new CourseDTO(coursesRecord);
			if (course.isAcive()) {
				for (StudentDTO student : stdsTmp) {
					if (course.getCourseId() == student.getCourseId()
							&& "active".equalsIgnoreCase(student.getStatus())) {
						System.out.println("Course Nane -->"
								+ course.getCourseName());

						student.printStudent();
					}

				}
			}

		}
	}

}
