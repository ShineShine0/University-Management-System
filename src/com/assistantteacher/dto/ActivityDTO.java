package com.assistantteacher.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.assistantteacher.entity.UserInfo;

public class ActivityDTO {
		private Long id;
		private String name;
		private Date date;
		private String description;
		private String teacherName;
		private String teacherMail;
		private Long teacherId;
		private Long classLevelId;
		private Long sectionId;
		private String title;
		private String studentMail;
		private String studentName;
		private String rollNo;
		private Boolean status;
		private String email;
		/*private String imagepath;
		private Long userId;
		private String imgfile;
		*/
		
		/*public String getImgfile() {
			return imgfile;
		}

		public void setImgfile(String imgfile) {
			this.imgfile = imgfile;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getImagepath() {
			return imagepath;
		}

		public void setImagepath(String imagepath) {
			this.imagepath = imagepath;
		}*/

		private List<ActivityDTO> mailUserList = new ArrayList<>();
		

		public Long getClassLevelId() {
			return classLevelId;
		}

		public void setClassLevelId(Long classLevelId) {
			this.classLevelId = classLevelId;
		}

		public Long getSectionId() {
			return sectionId;
		}

		public void setSectionId(Long sectionId) {
			this.sectionId = sectionId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getStudentMail() {
			return studentMail;
		}

		public void setStudentMail(String studentMail) {
			this.studentMail = studentMail;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public Boolean getStatus() {
			return status;
		}

		public void setStatus(Boolean status) {
			this.status = status;
		}

		public List<ActivityDTO> getMailUserList() {
			return mailUserList;
		}

		public void setMailUserList(List<ActivityDTO> mailUserList) {
			this.mailUserList = mailUserList;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getTeacherName() {
			return teacherName;
		}

		public void setTeacherName(String teacherName) {
			this.teacherName = teacherName;
		}

		public String getTeacherMail() {
			return teacherMail;
		}

		public void setTeacherMail(String teacherMail) {
			this.teacherMail = teacherMail;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRollNo() {
			return rollNo;
		}

		public void setRollNo(String rollNo) {
			this.rollNo = rollNo;
		}

		public Long getTeacherId() {
			return teacherId;
		}

		public void setTeacherId(Long teacherId) {
			this.teacherId = teacherId;
		}


}
