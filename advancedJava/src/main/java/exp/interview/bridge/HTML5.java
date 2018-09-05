package com.chandler.exp.interview.bridge;

public class HTML5 implements HTML{

private Image image;
	

	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	@Override
	public void construct() {
		// TODO Auto-generated method stub
		System.out.println("Structure start!");
		this.image.draw();
		System.out.println("Structure end!");
	}

}
