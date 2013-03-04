package com.cs174.starrus.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.AbstractButton;


public class ButtonListener implements ActionListener{

	//map a button to a listener
	private Hashtable<AbstractButton, IController> ControllerMap;
	
	public ButtonListener() {
		ControllerMap = new Hashtable<AbstractButton, IController>();
	}

	public void associate(AbstractButton button, IController controller) {
		button.addActionListener(this);
		ControllerMap.put(button, controller);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		IController controller = ControllerMap.get(ae.getSource());
		//System.out.println(ae.getActionCommand() + " is being pressed!");
		if(null != controller) {
			controller.process(ae.getActionCommand());
		}
	}
}
