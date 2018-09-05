package com.chandler.exp.interview.bridge;

/**
 * This is not a good example, almost same with visitor but emphasize structure
 * @author demon
 *
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XHTML xhtml = new XHTML();
		JPEG jpeg = new JPEG();
		xhtml.setImage(jpeg);
		xhtml.construct();
		xhtml.setImage(new BMP());
		xhtml.construct();
		
		//now we add a new abstraction/structure, we do not affect the "implementation"
		HTML5 h5 = new HTML5();
		h5.setImage(jpeg);
		h5.construct();
		h5.setImage(new BMP());
		h5.construct();
	}

}
