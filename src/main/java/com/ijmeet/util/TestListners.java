package com.ijmeet.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ijmeet.keyword.UIKeyword;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class TestListners implements ITestListener {
	private static final Logger LOG = Logger.getLogger(TestListners.class);

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method
		LOG.info("Test is failed so taking the screenshot");
		AShot ashot = new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000));
		Screenshot sc = ashot.takeScreenshot(UIKeyword.getInstance().driver);
		BufferedImage image = sc.getImage();
		String dir = System.getProperty("user.dir");
//		File outputFile = new File(dir + "\\Screenshots\\" + result.getName());
		try {
			ImageIO.write(image, "png", new File(dir +"\\Screenshots\\" + result.getName()+ ".png"));
			LOG.info("Screenshot is taken");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.info("Unable to take a screenshot");
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
