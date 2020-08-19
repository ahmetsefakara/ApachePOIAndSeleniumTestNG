package com.ask.ApachePOIAndSeleniumTestNG.mode;

public class Phone {
	private String name;
	private String model;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String toString(boolean isForSearch) {
		if (isForSearch)
			return model + " " + name;
		else {
			return "Phone [name=" + name + ", model=" + model + "]";
		}
	}
}
