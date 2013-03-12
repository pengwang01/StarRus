
package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.SetNewDateView;


public class SetNewDateController implements IController{

	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}
	@Override
	public void process(String model) {
		//System.out.println("do some shit after clicking");
		SetNewDateView sndV= SetNewDateView.getView();
		//depo.setView();
		sndV.setVisible(true);
	}
}


