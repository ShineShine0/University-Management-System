package com.assistantteacher.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.assistantteacher.dao.AdminDao;
import com.assistantteacher.dto.AdminDTO;
import com.assistantteacher.dto.StudentDTO;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.Student;
import com.assistantteacher.entity.UserInfo;
@Service
public class AdminServiceImpl implements AdminService{
@Autowired
private AdminDao adminDao;
@Autowired
private ServletContext context;
	@Override
	public void save(AdminDTO AdminDTO) {
		// TODO Auto-generated method stub
		Admin admin= convertAdminBean(AdminDTO);
	}
	
	private Admin convertAdminBean(AdminDTO adminDTO){
		Admin admin=new Admin();
		
		UserInfo userInfo=new UserInfo();
		if(adminDTO.getId()!=0){
			admin.setId(adminDTO.getId());
		}
		admin.setName(adminDTO.getName());
		admin.setNrc(adminDTO.getNrc());
		admin.setAddress(adminDTO.getAddress());
		admin.setDob(adminDTO.getDob());
		admin.setMobileNumber(adminDTO.getMobileNumber());
		admin.setEmail(adminDTO.getEmail());
		admin.setPassword(adminDTO.getPassword());
		admin.setPosition(adminDTO.getPosition());
		admin.setGender(adminDTO.getGender());
		admin.setNationality(adminDTO.getNationality());
		admin.getDepartment().setId(adminDTO.getDepartmentId());
		return admin;
	}
	


	@Override
	public List<AdminDTO> getAdminList() {
		// TODO Auto-generated method stub
		return adminDao.getAdminList();
	}

	
	@Override
	public List<AdminDTO> getAdminRoleList() {
		return adminDao.getAdminRoleList();
	}

	@Override
	public void saveAdmin(AdminDTO admin) {
		Admin user = new Admin();
		user = convertUserInfoBean(admin);
		adminDao.saveAdmin(user);
		
	}

	private Admin convertUserInfoBean(AdminDTO admin) {
		Admin adminuser = new Admin();
		String folder = "/Images/User/";
		String folderD = "/Images/User/UserPhotos/";
		
		if(admin.getId() != null && admin.getUserId() != null){
			adminuser.setId(admin.getId());
			adminuser.getUser().setId(admin.getUserId());
		}
		if (admin.getImgfile().getSize() != 0) {
			String imagePath = writeFile(admin.getImgfile(), folder);
			adminuser.getUser().setImagePath(imagePath);
		}
		adminuser.getUser().setUserName(admin.getEmail());
		adminuser.getUser().setPosition(admin.getPosition());
		adminuser.getUser().setPassword(admin.getPassword());
		adminuser.getUser().getRole().setId(admin.getAdminRoleId());
		
		//for admin
		adminuser.setAddress(admin.getAddress());
		adminuser.getDepartment().setId(admin.getDepartmentId());
		adminuser.setDob(admin.getDob());
		adminuser.setMobileNumber(admin.getMobileNumber());
		adminuser.setEmail(admin.getEmail());
		adminuser.setPassword(admin.getPassword());
		adminuser.setPosition(admin.getPosition());
		adminuser.setGender(admin.getGender());
		adminuser.setNationality(admin.getNationality());
		adminuser.setName(admin.getName());
		adminuser.setNrc(admin.getNrc());
		
		return adminuser;
	}
	private String writeFile(MultipartFile multipartFile, String filePath) {
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
		return  fileName;
		//return folderName + fileName;
	}

	@Override
	public String deleteAdmin(long id) {
		return adminDao.deleteAdmin(id);
	}

	@Override
	public AdminDTO getAdminById(long id) {
		AdminDTO ad = adminDao.getAdminById(id);
		ad.setImagePath(context.getContextPath()+"/resources/upload_images/"+ad.getImagePath());
		return ad;
	}

	@Override
	public void updateMember(AdminDTO admin) {
		Admin user = new Admin();
		user = convertUserInfoBean(admin);
		adminDao.saveAdmin(user);
		
	}


	

}
