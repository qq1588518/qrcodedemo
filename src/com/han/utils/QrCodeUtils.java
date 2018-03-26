package com.han.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;

public class QrCodeUtils {
	//这个qrCode原理：依托java JUI画图方式
	//生成二维码
	public static void createCode(String content){
		int width=67+12*(7-1);//7指版本号
		int height=67+12*(7-1);
		Qrcode x=new Qrcode();
		x.setQrcodeErrorCorrect('M');//纠错等级
		x.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z,B代表其他字符
		x.setQrcodeVersion(7);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D gs =bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.setColor(Color.BLACK);
		gs.clearRect(0, 0, width, height);
		int pixoff=2;//偏移量如果不加可能会导致解析出错
		byte[] bytes;
		try {
			bytes = content.getBytes("utf-8");
			if(bytes.length>0&&bytes.length<120){
				boolean[][] s = x.calQrcode(bytes);
				for (int i=0;i<s.length;i++){
					for (int j=0;j<s.length;j++){
					    if (s[j][i]) {
					    	gs.fillRect(j*3+pixoff,i*3+pixoff,3,3);
					    }
					}
				   }
			}
			gs.dispose();
			bufferedImage.flush();
			ImageIO.write(bufferedImage, "png", new File("E:\\qr.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void readQrCode(){
		File file = new File("E:\\qr.png");
		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			QRCodeDecoder codeDecoder=new QRCodeDecoder();
			byte[] decode = codeDecoder.decode(new MyQrcodeImage(bufferedImage));
			String result=new String(decode,"utf-8");
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
