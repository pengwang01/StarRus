package com.cs174.starrus.view;

import com.cs174.starrus.controller.ButtonListener;

public interface IView {
	ButtonListener listeners = new ButtonListener();
	public void present(String model);
}
