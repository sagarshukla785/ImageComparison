package com.sapient;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;

public class ImageComparison {

	static void processImage() {

		String file1 = "/Users/sagshukl/desktop/Automation/Sample2.jpg";
		String file2 = "/Users/sagshukl/desktop/Automation/Sample5.jpg";

		// Load the images
		Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
		Image image2 = Toolkit.getDefaultToolkit().getImage(file2);

		try {

			PixelGrabber grabImage1Pixels = new PixelGrabber(image1, 0, 0, -1, -1, false);
			PixelGrabber grabImage2Pixels = new PixelGrabber(image2, 0, 0, -1, -1, false);

			int[] image1Data = null;
			int[] image2Data = null;

			// Verifying if pixels are loaded or not
			if (grabImage1Pixels.grabPixels()) {
				int width = grabImage1Pixels.getWidth();
				int height = grabImage1Pixels.getHeight();
				image1Data = new int[width * height];
				image1Data = (int[]) grabImage1Pixels.getPixels();
			}

			if (grabImage2Pixels.grabPixels()) {
				int width = grabImage2Pixels.getWidth();
				int height = grabImage2Pixels.getHeight();
				image2Data = new int[width * height];
				image2Data = (int[]) grabImage2Pixels.getPixels();
			}

			if(java.util.Arrays.equals(image1Data, image2Data)) {
				System.out.println("Images are equal.");
			}
			else {
				System.out.println("Images are not equal.");
			}

		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String args[]) throws InterruptedException {
		//processImage();
		//ChangeProfilePicture();
		ChangeProfilePicture obj = new ChangeProfilePicture("https://web.whatsapp.com/", "/Users/sagshukl/Desktop/Automation/Sample.jpg");
		obj.changeImage();
	}
}