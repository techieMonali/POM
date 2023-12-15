package com.irctc.util;

import com.irctc.base.testBase;

public class testUtil extends testBase{

	public void switchToFrame(String frmNM) {
		driver.switchTo().frame(frmNM);
	}
}
