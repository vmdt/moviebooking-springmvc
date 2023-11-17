package com.bookmovie.dto;

public class NationDTO extends AbstractDTO<NationDTO> {
	private String nationName;

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	
}
