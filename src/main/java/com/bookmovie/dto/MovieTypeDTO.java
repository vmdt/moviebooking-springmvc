package com.bookmovie.dto;

public class MovieTypeDTO extends AbstractDTO<MovieTypeDTO> {
	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
