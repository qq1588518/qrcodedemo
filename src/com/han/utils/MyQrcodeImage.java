package com.han.utils;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

public class MyQrcodeImage implements QRCodeImage{
	BufferedImage bufferImage;
	
	
	public MyQrcodeImage(BufferedImage bufferImage) {
		super();
		this.bufferImage = bufferImage;
	}

	public BufferedImage getBufferImage() {
		return bufferImage;
	}

	public void setBufferImage(BufferedImage bufferImage) {
		this.bufferImage = bufferImage;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return bufferImage.getHeight();
	}

	@Override
	public int getPixel(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return bufferImage.getRGB(arg0, arg1);
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return bufferImage.getWidth();
	}

}
