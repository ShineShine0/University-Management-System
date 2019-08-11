package com.assistantteacher.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.assistantteacher.dao.DocumentDao;
import com.assistantteacher.dto.DocumentDTO;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Document;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Subject;
import com.assistantteacher.entity.UserInfo;
import com.assistantteacher.util.SecurityUtil;

@Service
public class DocumentServiceImpl implements DocumentService{
	@Autowired
	private DocumentDao documentDAO;
	@Autowired
	private ServletContext context;
	@Override
	public List<Subject> getSubjectList() {
		return documentDAO.getSubjectList();
	}
    public List<ClassLevel>getClassLevelList(){
    	return documentDAO.getClassLevelList();
    }
    public List<Section>getSectionList(){
    	return documentDAO.getSectionList();
    }
	@Override
	public List<Subject> retrieveSubjectByclassLevelId(Long classLevelId) {
		return documentDAO.getSubjectListByClassLevel(classLevelId);
	}
	@Override
	public List<Section> retrieveSectionByclassLevelId(Long classLevelId) {
		// TODO Auto-generated method stub
		return documentDAO.getSectionListByClassLevel(classLevelId);
	}
	@Override
	public void saveDocument(DocumentDTO document) {
		Document d = new Document();
		d = convertDocument(document);
		documentDAO.saveDocument(d);
	}
	private Document convertDocument(DocumentDTO document) {
		
		String imgPath = "/resources/Images/Document/documentPhotos";
		String filePath = "/resources/Images/Document/filePhotos";
		Document d = new Document();
		d.getClassLevel().setId(document.getClassLevelId());
		d.getSection().setId(document.getSectionId());
		d.getUser().setId(SecurityUtil.getCurrentLoginAdminUser().getId());
		d.getSubject().setId(document.getSubjectId());
		d.setTitle(document.getTitle());
		d.setName(document.getName());
		d.setDate(document.getDate());
		if(document.getId()!= null){
			d.setId(document.getId());
			//d.getSection().setId(document.getSubjectId());
		}
		if (document.getImgfile().getSize()!= 0){
			d.setImagePath(writeFile(document.getImgfile(), imgPath));
		}
		if (document.getTextfile().getSize() !=0 ){
			d.setDataPath(writeFile(document.getTextfile(), filePath));
		}
		return d;
	}
	private String writeFile(MultipartFile multipartFile, String filePath) {
		File directory = new File(context.getRealPath("/")); // This is the folder of your application
		//directory = directory.getParentFile();
		File imageFolder = new File(directory + filePath);
		if (!imageFolder.exists()) {
			imageFolder.mkdirs();
		}
		String imgFolderPath = imageFolder.toString();
		String folderName = filePath;
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
		return folderName +"/"+ fileName;
	}
	@Override
	public void save(DocumentDTO documentDto) {
		// TODO Auto-generated method stub
		Document document=convertDocumentBean(documentDto);
	}
	
		private Document convertDocumentBean(DocumentDTO documentDto){
			Document d=new Document();
			UserInfo u=new UserInfo();
			ClassLevel c=new ClassLevel();
			Section s=new Section();
			Subject sb=new Subject();
			if(documentDto.getId()!=0){
				d.setId(documentDto.getId());
				}
			d.setName(documentDto.getName());
			d.setDate(documentDto.getDate());
			d.setDataPath(documentDto.getDataPath());
			d.setImagePath(documentDto.getImagePath());
			d.getClassLevel().setId(documentDto.getClassLevelId());
			d.getUser().setId(documentDto.getUserId());
			d.getSection().setId(documentDto.getSectionId());
			d.getSubject().setId(documentDto.getSubjectId());
			return d;
		}
		@Override
		public List<DocumentDTO> getDocumentListByUser(Long userId) {
			return documentDAO.getDocumentListByUser(userId);
		}
		@Override
		public DocumentDTO getDocumentListById(Long id) {
			DocumentDTO doc = new DocumentDTO();
			doc=  documentDAO.getDocumentListById(id);
			System.out.println("\n\n\n Image  = "+doc.getImagePath());
			doc.setImagePath(context.getContextPath()+doc.getImagePath());
			doc.setDataPath(context.getContextPath()+ doc.getDataPath());
			return doc;
		}
		@Override
		public List<DocumentDTO> getDocumentListByTeacherId(Long userId) {
			// TODO Auto-generated method stub
			return documentDAO.getDocumentListByTeacherId(userId);
		}
		@Override
		public Boolean delete(long id) {
			// TODO Auto-generated method stub
			return documentDAO.delete(id);
		}
		@Override
		public void updateDocument(DocumentDTO document) {
			// TODO Auto-generated method stub
			Document document1=new Document();
			document1=convertDocumentBean(document);
			documentDAO.saveDocument(document1);
			
		}
		@Override
		public DocumentDTO getDocumentById(long id) {
			// TODO Auto-generated method stub
			DocumentDTO ddto=documentDAO.getDocumentListById(id);
			ddto.setImagePath(context.getContextPath()+ddto.getImagePath());
			ddto.setDataPath(context.getContextPath()+ddto.getDataPath());
			return ddto;
		}
		
}

