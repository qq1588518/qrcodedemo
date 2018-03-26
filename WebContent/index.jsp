<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jquery.qrcode.min.js"></script>
<script type="text/javascript">
function utf16to8(str) {  
	//JqueryQrcode.js有一个小小的缺点，就是默认不支持中文。
//这跟js的机制有关系，jquery-qrcode这个库是采用 charCodeAt() 这个方式进行编码转换的，
//而这个方法默认会获取它的 Unicode 编码，一般的解码器都是采用UTF-8, ISO-8859-1等方式，
//英文是没有问题，如果是中文，一般情况下Unicode是UTF-16实现，长度2位，而UTF-8编码是3位，这样二维码的编解码就不匹配了。
//解决方式当然是，在二维码编码前把字符串转换成UTF-8，具体代码如下：
    var out, i, len, c;  
    out = "";  
    len = str.length;  
    for(i = 0; i < len; i++) {  
    c = str.charCodeAt(i);  
    if ((c >= 0x0001) && (c <= 0x007F)) {  
        out += str.charAt(i);  
    } else if (c > 0x07FF) {  
        out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));  
        out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));  
        out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));  
    } else {  
        out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));  
        out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));  
    }  
    }  
    return out;  
} 
	$(function(){
		$("#qrcode").qrcode({width: 300,height: 300,text: utf16to8("厉害了我的国")});
	})
</script>
</head>
<body>

<div id="qrcode"></div>
</body>
</html>