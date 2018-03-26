package com.han.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ZxingQrCodeUtil {
	/*
	 * �����ά��Ŀ��
	 */
	private static int WIDTH=300;
	private static int HEIGHT=300;
	private static String FORMAT="png";//��ά���ʽ
	//���ɶ�ά��
	public static void createZxingqrCode(String content){
		//�����ά�����
		Map hints=new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//���ñ���
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//�����ݴ�ȼ�
		hints.put(EncodeHintType.MARGIN, 2);//���ñ߾�Ĭ����5
		
		try {
			BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
			Path path = new File("E:\\qr.png").toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, FORMAT, path);//д��ָ��·����
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//��ȡ��ά��
	public static void readZxingQrCode(){
		MultiFormatReader reader = new MultiFormatReader();
		File file = new File("E:\\qr.png");
		try {
			BufferedImage image = ImageIO.read(file);
			BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			Map hints=new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//���ñ���
			Result result= reader.decode(binaryBitmap,hints);
			System.out.println("�������:"+result.toString());
			System.out.println("��ά���ʽ:"+result.getBarcodeFormat());
			System.out.println("��ά���ı�����:"+result.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
