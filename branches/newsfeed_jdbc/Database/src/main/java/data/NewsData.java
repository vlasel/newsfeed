package data;

import java.io.Serializable;

public class NewsData implements Serializable {
	
	public NewsData() {
		
	}

	
	public String getId() {
        return id;
    }
	public void setId(String id) {
        this.id = id;
    }
	public String getIdcat() {
		return idcat;
	}
	public void setIdcat(String idcat) {
		this.idcat = idcat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAnnotation() {
		return annotation;
	}
	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	public String getMaintext() {
		return maintext;
	}
	public void setMaintext(String maintext) {
		this.maintext = maintext;
	}
	
	
	String id;
	String idcat;
	String name;
	String author;
	String date;
	String time;
	String annotation;
	String maintext;
	
	
	
	
	@Override
	public int hashCode() {
		return ((id == null) ? 0 : id.hashCode());
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;

		if ( obj != null && obj instanceof NewsData ) {
			NewsData nd = (NewsData) obj;
			
			if (annotation == null && nd.annotation != null){ return false;
			} else if (!annotation.equals(nd.annotation)) return false;
			
			else if (author == null && nd.author != null){ return false;
			} else if (!author.equals(nd.author)) return false;
			
			else if (date == null && nd.date != null) { return false;
			} else if (!date.equals(nd.date)) return false;
			
			else if (idcat == null && nd.idcat != null) { return false;
			} else if (!idcat.equals(nd.idcat)) return false;
			
			else if (maintext == null && nd.maintext != null) {return false;
			} else if (!maintext.equals(nd.maintext)) return false;
			
			else if (name == null && nd.name != null) { return false;
			} else if (!name.equals(nd.name)) return false;
			
			else return true;
		}
		else return false;

	}


	@Override
	public String toString() {
		return "NewsData [id=" + id + ", idcat=" + idcat + ", name=" + name
				+ ", author=" + author + ", date=" + date + ", time=" + time
				+ ", annotation=" + annotation + ", maintext=" + maintext + "]";
	}
	
	
	
}
