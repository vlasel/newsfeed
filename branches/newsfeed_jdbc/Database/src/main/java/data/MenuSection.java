package data;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuSection implements Serializable{
	
	private String id;
	private String value;
	private ArrayList<MenuSection> subsectionsList;
	
	public MenuSection(){
		
	}


	
	public void setId(String section) {
		this.id = section;
	}

	public String getId() {
		return this.id;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	
	public void setSubsectionsList(ArrayList<MenuSection> subsectionsList) {
		this.subsectionsList = subsectionsList;
	}
	
	public ArrayList<MenuSection> getSubsectionsList() {
		return this.subsectionsList;
	}

	public void addSubsection (String subsectionId, String subsectionValue) {
		//next condition need to not create instances of ArrayList<MenuSection> in the MenuSection.subsectionsList[]
		//because used only MenuSection.subsectionsList[].id and MenuSection.subsectionsList[].value
		if (subsectionsList == null)						
			subsectionsList = new ArrayList<MenuSection>();
		MenuSection menuSubSection = new MenuSection();
		menuSubSection.setId(subsectionId);
		menuSubSection.setValue(subsectionValue);
		this.subsectionsList.add(menuSubSection);
	}


	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MenuSection)
		{
			MenuSection menuSection = (MenuSection)obj;
			if(	this.id.equals(menuSection.getId()) 
				&& this.value.equals(menuSection.getValue()) 
				&& this.subsectionsList.equals(menuSection.getSubsectionsList())
				) 
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String result = null;
		result = "Menu Section: \n{";
		result += "\nid = \""+ this.id+ "\"; ";
		result += "\nvalue = \""+ this.value+ "\"";
		result += "\nSubsection List:";
		for (int i=0; i < subsectionsList.size(); i++) {
			result += ( "\n[id="+subsectionsList.get(i).getId()+"; value="+subsectionsList.get(i).getValue()+"]");
		}
		result += "\n}";
		
		return result;
	}
	
	
}
