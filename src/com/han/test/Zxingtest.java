package com.han.test;

import com.han.utils.ZxingQrCodeUtil;

public class Zxingtest {
	public static void main(String[] args) {
		ZxingQrCodeUtil.createZxingqrCode("�����ˣ��ҵĹ�");
		ZxingQrCodeUtil.readZxingQrCode();
	}
}
