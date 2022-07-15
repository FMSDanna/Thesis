package it.polito.tdp.NationalGallery.model;

public class Opera {
	
	int objectid;
	int accessioned;
	String accessionNum;
	String locationId;
	String title;
	String displayDate;
	String beginYear;
	String endYear;
	String visualBrowserTimespan;
	String medium;
	String dimensions;
	String inscriptions;
	String markings;
	String attributionInverted;
	String attribution;
	String provenanceText;
	String creditLine;
	String classification;
	String subClassification;
	String visualBrowserClassification;
	String parentId;
	int isVirtual;
	String departmentAbbr;
	String portfolio;
	String series;
	String volume;
	String watermarks;
	String lastDetectedModification;
	String customPrintUrl;
	Stanza room;
	public Opera(int objectid, int accessioned, String accessionNum, String locationId, String title,
			String displayDate, String beginYear, String endYear, String visualBrowserTimespan, String medium,
			String dimensions, String inscriptions, String markings, String attributionInverted, String attribution,
			String provenanceText, String creditLine, String classification, String subClassification,
			String visualBrowserClassification, String parentId, int isVirtual, String departmentAbbr, String portfolio,
			String series, String volume, String watermarks, String lastDetectedModification, String customPrintUrl) {
		super();
		this.objectid = objectid;
		this.accessioned = accessioned;
		this.accessionNum = accessionNum;
		this.locationId = locationId;
		this.title = title;
		this.displayDate = displayDate;
		this.beginYear = beginYear;
		this.endYear = endYear;
		this.visualBrowserTimespan = visualBrowserTimespan;
		this.medium = medium;
		this.dimensions = dimensions;
		this.inscriptions = inscriptions;
		this.markings = markings;
		this.attributionInverted = attributionInverted;
		this.attribution = attribution;
		this.provenanceText = provenanceText;
		this.creditLine = creditLine;
		this.classification = classification;
		this.subClassification = subClassification;
		this.visualBrowserClassification = visualBrowserClassification;
		this.parentId = parentId;
		this.isVirtual = isVirtual;
		this.departmentAbbr = departmentAbbr;
		this.portfolio = portfolio;
		this.series = series;
		this.volume = volume;
		this.watermarks = watermarks;
		this.lastDetectedModification = lastDetectedModification;
		this.customPrintUrl = customPrintUrl;
	}
	
	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(String inscriptions) {
		this.inscriptions = inscriptions;
	}

	public String getProvenanceText() {
		return provenanceText;
	}

	public void setProvenanceText(String provenanceText) {
		this.provenanceText = provenanceText;
	}

	public String getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(String creditLine) {
		this.creditLine = creditLine;
	}

	public int getObjectid() {
		return objectid;
	}
	public void setObjectid(int objectid) {
		this.objectid = objectid;
	}
	public int getAccessioned() {
		return accessioned;
	}
	public void setAccessioned(int accessioned) {
		this.accessioned = accessioned;
	}
	public String getAccessionNum() {
		return accessionNum;
	}
	public void setAccessionNum(String accessionNum) {
		this.accessionNum = accessionNum;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDisplayDate() {
		return displayDate;
	}
	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}
	public String getBeginYear() {
		return beginYear;
	}
	public void setBeginYear(String beginYear) {
		this.beginYear = beginYear;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	public String getAttribution() {
		return attribution;
	}
	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getSubClassification() {
		return subClassification;
	}
	public void setSubClassification(String subClassification) {
		this.subClassification = subClassification;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getDepartmentAbbr() {
		return departmentAbbr;
	}
	public void setDepartmentAbbr(String departmentAbbr) {
		this.departmentAbbr = departmentAbbr;
	}
	
	public Stanza getRoom() {
		return room;
	}

	public void setRoom(Stanza room) {
		this.room = room;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + objectid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Opera other = (Opera) obj;
		if (objectid != other.objectid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return title ;
	}
	
	
	
}

