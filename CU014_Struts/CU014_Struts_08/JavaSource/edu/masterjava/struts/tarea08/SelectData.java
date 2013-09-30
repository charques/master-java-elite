
package edu.masterjava.struts.tarea08;


public class SelectData {

    private String id;

    private String desc;

    public SelectData(String id, String desc)
    {
        this.id = id;
        this.desc = desc;
    }

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
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
    
    

}
