package com.example.responsi_123180122.model.kasus;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("content")
	private ArrayList<KasusDataItem> content;

	public Metadata getMetadata(){
		return metadata;
	}

	public ArrayList<KasusDataItem> getContent(){
		return content;
	}

	@Override
	public String toString(){
		return
				"Data{" +
						"metadata = '" + metadata + '\'' +
						",content = '" + content + '\'' +
						"}";
	}
}