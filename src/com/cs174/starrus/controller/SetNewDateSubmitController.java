package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.model.SysDate;
import com.cs174.starrus.view.SetNewDateView;


public class SetNewDateSubmitController implements IController{
	private boolean 	DEBUG		= true;
	private SetNewDateView	sndV	= SetNewDateView.getView();
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}
	@Override
	public void process(String model) {

		try{
			String pattern 	= "\\d\\d-(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)-\\d\\d";
			
			if(DEBUG == true){
				System.out.println(sndV.getTxtDate().getText().toUpperCase());
				System.out.println(sndV.getTxtDate().getText().toUpperCase().matches(pattern));

			}
			
			if(sndV.getTxtDate().getText().toUpperCase().matches(pattern)){
				if( DEBUG == true){
					System.out.println("SETTING DATE TO: " + sndV.getTxtDate().getText());
				}

				SysDate.setSysDate(new SysDate( sndV.getTxtDate().getText()));
			}else{
				sndV.setLblWarning("Please enter a valid date: \n The correct format is DD-MMM-YY");	
			}
			
			
			sndV.dispose();
									
		}catch (Exception e){
			System.out.println("SQLException in SetPriceController");
			e.printStackTrace();
		}
	}
}

