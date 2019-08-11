
	@Override
	public List<ActivityDTO> retrieveActivityListForReport(Long sectionId,String year) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT s.name as name,st.rollNo as rollNo,s.id as studentId,se.id as sectionId,st.rollCall as rollCall,st.discipline as discipline,st.helping as helping,st.cultivation as cultivation,st.development as development,st.jobForce as jobForce,st.helpParent as helpParent,st.sport as sport,st.history as history,st.literature as literature,st.society as society,year as yearName");
		sb.append(" FROM StudentActivity st");
		sb.append(" inner join Student s on s.id = st.studentId");
		sb.append(" inner join Section se on st.sectionId= se.id");
		sb.append(" where se.id=:sectionId and st.year=:year");
		//sb.append(" group by s.name");
		sb.append(" order by st.rollNo");
		
		SQLQuery query=getCurrentSession().createSQLQuery(sb.toString());
		query.addScalar("name",StandardBasicTypes.STRING);
		query.addScalar("rollNo",StandardBasicTypes.STRING);
		query.addScalar("studentId",StandardBasicTypes.LONG);
		query.addScalar("sectionId",StandardBasicTypes.LONG);
		query.addScalar("yearName",StandardBasicTypes.STRING);
		query.addScalar("rollCall",StandardBasicTypes.STRING);
		query.addScalar("discipline",StandardBasicTypes.STRING);
		query.addScalar("helping",StandardBasicTypes.STRING);
		query.addScalar("cultivation",StandardBasicTypes.STRING);
		query.addScalar("development",StandardBasicTypes.STRING);
		query.addScalar("jobForce",StandardBasicTypes.STRING);
		query.addScalar("helpParent",StandardBasicTypes.STRING);
		query.addScalar("sport",StandardBasicTypes.STRING);
		query.addScalar("history",StandardBasicTypes.STRING);
		query.addScalar("literature",StandardBasicTypes.STRING);
		query.addScalar("society",StandardBasicTypes.STRING);
		query.setParameter("sectionId", sectionId);
		query.setParameter("year", year);
		query.setResultTransformer(Transformers.aliasToBean(ActivityDTO.class));
		 
		 return query.list();
	}
