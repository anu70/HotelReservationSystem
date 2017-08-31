package com.cognizant.models;

import java.util.ArrayList;

public class Lists {
	public ArrayList<City>  cityList;
	public Lists(){}
	
	public Lists(ArrayList<City> citylist,int countryId){
		cityList = new ArrayList<City>();
		for(int i=0;i<citylist.size();i++){
			if(citylist.get(i).getCountry_id()==countryId){
				cityList.add(citylist.get(i));
			}
		}
	}
}
