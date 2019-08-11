package com.assistantteacher.service;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.assistantteacher.dao.StudentDao;
import com.assistantteacher.dto.StudentDTO;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Major;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Student;
import com.assistantteacher.entity.UserInfo;


@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private ServletContext context;
	@Override
	public void saveStudent(StudentDTO student) {
		System.out.println("\n\n\n Stu Major = "+student.getMajorId());
		Student userstudent = new Student();
		userstudent = convertUserInfoBean(student);
		studentDao.saveStudent(userstudent);		
	}
	
private Student convertUserInfoBean(StudentDTO student) {
		Student studentuser = new Student();
		String folder = "/Images/User/";		
		if(student.getId() != null && student.getUserId() != null){
			studentuser.setId(student.getId());
			studentuser.getUser().setId(student.getUserId());
		}
		if (student.getImgfile().getSize() != 0) {
			String imagePath = writeFile(student.getImgfile(), folder);
			studentuser.getUser().setImagePath(imagePath);
		}
		studentuser.getUser().setUserName(student.getEmail());
		studentuser.getUser().setPassword(student.getPassword());
		studentuser.getUser().setPosition("student");
		studentuser.getUser().getRole().setId(student.getAdminRoleId());
		
		//for student
		studentuser.setName(student.getName());
		studentuser.setRollNo(student.getRollNo());
		studentuser.setNrc(student.getNrc());
		studentuser.setAddress(student.getAddress());
		studentuser.setDob(student.getDob());
		studentuser.setPhone(student.getPhone());
		studentuser.setEmail(student.getEmail());
		studentuser.setPassword(student.getPassword());
		studentuser.setRunningYear(student.getRunningYear());
		studentuser.setGender(student.getGender());
		studentuser.setImagepath(student.getImagepath());
		studentuser.setNationality(student.getNationality());
		studentuser.setReligion(student.getReligion());
		studentuser.setCitizen(student.getCitizen());
		studentuser.getMajor().setId(student.getMajorId());
		studentuser.getSection().setId(student.getSectionId());
		studentuser.getClassLevel().setId(student.getClassLevelId());
		//studentuser.setUser(null);
		return studentuser;
	}
	private String writeFile(MultipartFile multipartFile, String filePath1) {
		File directory = new File(context.getRealPath("/resources/upload_images")); // This is the folder of your application
		//directory = directory.getParentFile();
		//File imageFolder = new File(directory + filePath);
		File imageFolder = new File(directory.getAbsolutePath() );
		if (!imageFolder.exists()) {
			imageFolder.mkdirs();
		}
		String imgFolderPath = imageFolder.toString();
		//String folderName = filePath;
		String tempFilePath = imgFolderPath;
		System.err.println("\n\ntempFilePath>>>>>> " + tempFilePath);
		// logger.info("tempFilePath>>>>>> "+tempFilePath);
		String nano_time = String.valueOf(System.nanoTime());
		String fileName = nano_time + "_" + multipartFile.getOriginalFilename();
		File dest = new File(tempFilePath, fileName);
		try {
			multipartFile.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return fileName;
		//return folderName + fileName;
	}

	@Override
	public List<StudentDTO> getStudentList() {
		return studentDao.getStudentList();

	}

	@Override
	public Boolean deleteStudent(long id) {
		return studentDao.deleteStudent(id);

	}
	@Override
	public List<StudentDTO> getClassLevelList() {
		// TODO Auto-generated method stub
		return studentDao.getClassLevelList();
	}
	@Override
	public List<StudentDTO> getMajorList() {
		// TODO Auto-generated method stub
		return studentDao.getMajorList();
	}
	@Override
	public List<StudentDTO> getSectionList() {
		// TODO Auto-generated method stub
		return studentDao.getSectionList();
	}
	@Override
	public List<StudentDTO> getAdminRoleList() {
		// TODO Auto-generated method stub
		return studentDao.getAdminRoleList();
	}
	@Override
	public StudentDTO getStudentById(long id) {
		
		StudentDTO stu = studentDao.getStudentById(id);
		stu.setImagepath(context.getContextPath()+"/resources/upload_images/"+stu.getImagepath());
		return stu;
	}
	@Override
	public void updateStudent(StudentDTO student) {
		Student userstudent = new Student();
		userstudent = convertUserInfoBean(student);
		studentDao.saveStudent(userstudent);		
	}
	

}
