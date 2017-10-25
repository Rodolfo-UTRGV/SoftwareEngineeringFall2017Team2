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
    private String Calories;
    private String Fats;
    private String Sugars;
    private String Carbs;
    private String Proteins;

	public Nutrition(String Name, String Calories, String Fats, String Sugars, String Carbs, String Proteins) {
		this.Name = Name;
		this.Calories = Calories;
		this.Fats = Fats;
		this.Sugars = Sugars;
		this.Carbs = Carbs;
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
	 * @return the Fats
	 */
	public String getFats() {
		return Fats;
	}

	/**
	 * @param Fats the Fats to set
	 */
	public void setFats(String Fats) {
		this.Fats = Fats;
	}

	/**
	 * @return the Sugars
	 */
	public String getSugars() {
		return Sugars;
	}

	/**
	 * @param Sugars the Sugars to set
	 */
	public void setSugars(String Sugars) {
		this.Sugars = Sugars;
	}

	/**
	 * @return the Carbs
	 */
	public String getCarbs() {
		return Carbs;
	}

	/**
	 * @param Carbs the Carbs to set
	 */
	public void setCarbs(String Carbs) {
		this.Carbs = Carbs;
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

   
}
