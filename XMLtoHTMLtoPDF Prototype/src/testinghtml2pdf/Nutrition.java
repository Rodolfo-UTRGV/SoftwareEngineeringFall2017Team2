/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinghtml2pdf;

/**
 *
 * @author MQ0162246
 */
public class Nutrition {

    private String Name;
    private String Group;
    private String Serving;
    private String Calories;
    private String TotalFats;
    private String Cholesterol;
    private String Sodium;
    private String Potassium;
    private String Carbohydrates;
    private String Proteins;

	public Nutrition(String Name, String Group, String Serving, String Calories, String Fats, String Cholesterol, String Sodium, String Potassium, String Carbs, String Proteins) {
		this.Name = Name;
                this.Group = Group;
                this.Serving = Serving;
		this.Calories = Calories;
		this.TotalFats = Fats;
                this.Cholesterol = Cholesterol;
		this.Sodium = Sodium;
                this.Potassium = Potassium;
		this.Carbohydrates = Carbs;
		this.Proteins = Proteins;
	}


    
	/**
	 * @return the Calories
	 */
	public String getCalories() {
		return Calories;
	}

	/**
	 * @param Calories the Calories to set
	 */
	public void setCalories(String Calories) {
		this.Calories = Calories;
	}

	/**
     * @return the TotalFats
     */
    public String getTotalFats() {
        return TotalFats;
    }

    /**
     * @param TotalFats the TotalFats to set
     */
    public void setTotalFats(String TotalFats) {
        this.TotalFats = TotalFats;
    }

    /**
     * @return the Cholesterol
     */
    public String getCholesterol() {
        return Cholesterol;
    }

    /**
     * @param Cholesterol the Cholesterol to set
     */
    public void setCholesterol(String Cholesterol) {
        this.Cholesterol = Cholesterol;
    }

    /**
     * @return the Sodium
     */
    public String getSodium() {
        return Sodium;
    }

    /**
     * @param Sodium the Sodium to set
     */
    public void setSodium(String Sodium) {
        this.Sodium = Sodium;
    }

    /**
     * @return the Potassium
     */
    public String getPotassium() {
        return Potassium;
    }

    /**
     * @param Potassium the Potassium to set
     */
    public void setPotassium(String Potassium) {
        this.Potassium = Potassium;
    }

    /**
     * @return the Carbohydrates
     */
    public String getCarbohydrates() {
        return Carbohydrates;
    }

    /**
     * @param Carbohydrates the Carbohydrates to set
     */
    public void setCarbohydrates(String Carbohydrates) {
        this.Carbohydrates = Carbohydrates;
    }

	/**
	 * @return the Proteins
	 */
	public String getProteins() {
		return Proteins;
	}

	/**
	 * @param Proteins the Proteins to set
	 */
	public void setProteins(String Proteins) {
		this.Proteins = Proteins;
	}

	/**
	 * @return the Name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param Name the Name to set
	 */
	public void setName(String Name) {
		this.Name = Name;
	}
        
        /**
     * @return the Group
     */
    public String getGroup() {
        return Group;
    }

    /**
     * @param Group the Group to set
     */
    public void setGroup(String Group) {
        this.Group = Group;
    }

    /**
     * @return the Serving
     */
    public String getServing() {
        return Serving;
    }

    /**
     * @param Serving the Serving to set
     */
    public void setServing(String Serving) {
        this.Serving = Serving;
    }

   
}
