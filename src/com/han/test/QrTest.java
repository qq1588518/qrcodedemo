package com.han.test;

import com.han.utils.QrCodeUtils;

public class QrTest {
	public static void main(String[] args) {
		QrCodeUtils.createCode("�����ˣ�����");
		QrCodeUtils.readQrCode();
	}
}
