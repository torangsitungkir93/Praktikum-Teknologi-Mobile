package com.example.responsi_123180122.model.kasus;

import com.google.gson.annotations.SerializedName;

public class Metadata{

	@SerializedName("last_update")
	private String lastUpdate;

	public String getLastUpdate(){
		return lastUpdate;
	}

	@Override
	public String toString(){
		return
				"Metadata{" +
						"last_update = '" + lastUpdate + '\'' +
						"}";
	}
}