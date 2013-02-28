package com.cs174.starrus.view;

import javax.swing.JFrame;
import java.awt.Point;
import java.awt.Dimension;


@SuppressWarnings("serial")
public class View extends JFrame implements IView{
	
	private static View view = null;
	
	private View(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("StarRus");
		this.setSize(new Dimension(800, 600));
		this.setLocation(new Point(100, 100));
		this.getContentPane().setLayout(null);
	}

	public static View getWindow() {
		if(view == null)
			view = new View();
		return view;
	}
	
	public void displayView() {this.setVisible(true);}
	
	public void loadLoginView(){
		this.frameInit();
		this.getContentPane().add(new LoginView());
		this.displayView();
	}
	
	public void loadMainView() {
		this.frameInit();
		this.getContentPane().add(new MainView());
		this.displayView();
	}
	
	@Override
	public void present(String model) {
		// TODO Auto-generated method stub
		
	}
}
