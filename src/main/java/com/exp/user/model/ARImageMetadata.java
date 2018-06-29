package com.exp.user.model;


import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ARImageMetadata {
	
	@Id
	private String id;
	private String imageFileName;
	private String d3ImageFilename;
	private String videoUrl;
	private String textURL;
	private String text;
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}
	/**
	 * @param imageFileName the imageFileName to set
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	/**
	 * @return the d3ImageFilename
	 */
	public String getD3ImageFilename() {
		return d3ImageFilename;
	}
	/**
	 * @param d3ImageFilename the d3ImageFilename to set
	 */
	public void setD3ImageFilename(String d3ImageFilename) {
		this.d3ImageFilename = d3ImageFilename;
	}
	
	/**
	 * @return the videoUrl
	 */
	public String getVideoUrl() {
		return videoUrl;
	}
	/**
	 * @param videoUrl the videoUrl to set
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	/**
	 * @return the testURL
	 */
	public String getTextURL() {
		return textURL;
	}
	/**
	 * @param testURL the testURL to set
	 */
	public void setTextURL(String textURL) {
		this.textURL = textURL;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((d3ImageFilename == null) ? 0 : d3ImageFilename.hashCode());
		result = prime * result + ((imageFileName == null) ? 0 : imageFileName.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ARImageMetadata other = (ARImageMetadata) obj;
		if (d3ImageFilename == null) {
			if (other.d3ImageFilename != null)
				return false;
		} else if (!d3ImageFilename.equals(other.d3ImageFilename))
			return false;
		if (imageFileName == null) {
			if (other.imageFileName != null)
				return false;
		} else if (!imageFileName.equals(other.imageFileName))
			return false;
		return true;
	}
}
