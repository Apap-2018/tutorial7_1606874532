package com.apap.tutorial7.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDetail {
	
	@JsonProperty("model_name")
	private String modelName;
	
	@JsonProperty("model_make_id")
	private String modelMakeId;

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelMakeId() {
		return modelMakeId;
	}

	public void setModelMakeId(String modelMakeId) {
		this.modelMakeId = modelMakeId;
	}
	
	
}