package com.han.test;

import com.han.utils.ZxingQrCodeUtil;

public class Zxingtest {
	public static void main(String[] args) {
		ZxingQrCodeUtil.createZxingqrCode("厉害了，我的国");
		ZxingQrCodeUtil.readZxingQrCode();
	}
}
