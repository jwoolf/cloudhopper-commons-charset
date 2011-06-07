package com.cloudhopper.commons.charset;

import static com.cloudhopper.commons.charset.CharsetUtil.CHARSET_ISO_8859_1;
import static com.cloudhopper.commons.charset.CharsetUtil.CHARSET_ISO_8859_15;
import static com.cloudhopper.commons.charset.CharsetUtil.CHARSET_UCS_2;
import static com.cloudhopper.commons.charset.CharsetUtil.CHARSET_UTF_8;
import static com.cloudhopper.commons.charset.CharsetUtil.NAME_ISO_8859_1;
import static com.cloudhopper.commons.charset.CharsetUtil.NAME_ISO_8859_15;
import static com.cloudhopper.commons.charset.CharsetUtil.NAME_UTF_8;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.cloudhopper.commons.util.ByteBuffer;
import com.cloudhopper.commons.util.HexString;

public class MessageBodyWithUdhTest {
	
	private static final byte[] UDH_BYTES = new byte[] {(byte) 0x05, (byte) 0x00, (byte) 0x03, (byte) 0xCC, (byte) 0x02, (byte) 0x01};
	private static final String UDH_HEX = "050003CC0201";
	private static final String HELLO_AT_WORLD = "Hello @ World";
	private static final String HELLO_AT_WORLD_UTF8_HEX = "48656C6C6F204020576F726C64"; // 'Hello @ World' in UTF-8 as hex
	private static final String HELLO_AT_WORLD_LATIN1_HEX = "48656C6C6F204020576F726C64"; // 'Hello @ World' in Latin-1 as hex
	private static final String HELLO_EURO_WORLD = "Hello \u20AC World"; // 'Hello Û World'
	private static final String HELLO_EURO_WORLD_LATIN9_HEX = "48656C6C6F20A420576F726C64"; // 'Hello Û World' in Latin-1 as hex
	
	private static final String HELLO_AT_WORLD_UCS2 = "\u0048\u0065\u006C\u006C\u006F\u0020\u0040\u0020\u0057\u006F\u0072\u006C\u0064"; // 'Hello @ World' in UCS-2
	private static final String HELLO_AT_WORLD_UCS2_HEX = "00480065006C006C006F0020004000200057006F0072006C0064"; // 'Hello @ World' in UCS-2 as hex
	
    //
    // UTF-8
    //    
    @Test
    public void testUtf8DecodeEncodeNoUdh() throws Exception {
    	testDecodeEncode(HELLO_AT_WORLD_UTF8_HEX, CHARSET_UTF_8);
    }
	
    @Test
    public void testUtf8DecodeWithUdh() throws Exception {
    	testDecode(UDH_HEX + HELLO_AT_WORLD_UTF8_HEX, true, CHARSET_UTF_8, NAME_UTF_8);
    }
	
    @Test
    public void testUtf8EncodeWithUdh() throws Exception { 
    	byte[] bytes = createMessageByteArray(UDH_BYTES, HELLO_AT_WORLD, NAME_UTF_8);
    	testEncode(bytes, true, CHARSET_UTF_8, NAME_UTF_8);
    }
		
    @Test
    public void testUtf8DecodeEncodeWithUdh() throws Exception {
    	testDecodeEncodeWithUdh(UDH_HEX + HELLO_AT_WORLD_UTF8_HEX, CHARSET_UTF_8);
    }
    
    //
    // Latin-1
    //   
    @Test
    public void testLatin1DecodeEncodeNoUdh() throws Exception {
    	testDecodeEncode(HELLO_AT_WORLD_LATIN1_HEX, CHARSET_ISO_8859_1); 
    }
	
    @Test
    public void testLatin1DecodeWithUdh() throws Exception {
    	testDecode(UDH_HEX + HELLO_AT_WORLD_LATIN1_HEX, true, CHARSET_ISO_8859_1, NAME_ISO_8859_1);
    }
	
    @Test
    public void testLatin1EncodeWithUdh() throws Exception { 
    	byte[] bytes = createMessageByteArray(UDH_BYTES, HELLO_AT_WORLD, NAME_ISO_8859_1);
    	testEncode(bytes, true, CHARSET_ISO_8859_1, NAME_ISO_8859_1);
    }
		
    @Test
    public void testLatin1DecodeEncodeWithUdh() throws Exception {
    	testDecodeEncodeWithUdh(UDH_HEX + HELLO_AT_WORLD_LATIN1_HEX, CHARSET_ISO_8859_1);
    }

    //
    // Latin-9
    //   
    @Test
    public void testLatin9DecodeEncodeNoUdh() throws Exception {
    	testDecodeEncode(HELLO_EURO_WORLD_LATIN9_HEX, CHARSET_ISO_8859_15); 
    }
	
    @Test
    public void testLatin9DecodeWithUdh() throws Exception {
    	testDecode(UDH_HEX + HELLO_EURO_WORLD_LATIN9_HEX, true, CHARSET_ISO_8859_15, NAME_ISO_8859_15);
    }
	
    @Test
    public void testLatin9EncodeWithUdh() throws Exception { 
    	byte[] bytes = createMessageByteArray(UDH_BYTES, HELLO_EURO_WORLD, NAME_ISO_8859_15);
    	testEncode(bytes, true, CHARSET_ISO_8859_15, NAME_ISO_8859_15);
    }
		
    @Test
    public void testLatin9DecodeEncodeWithUdh() throws Exception {
    	testDecodeEncodeWithUdh(UDH_HEX + HELLO_EURO_WORLD_LATIN9_HEX, CHARSET_ISO_8859_15);
    }

    //
    // UCS-2
    //   
    @Test
    public void testUcs2DecodeEncodeNoUdh() throws Exception {
    	testDecodeEncode(HELLO_AT_WORLD_UCS2_HEX, CHARSET_UCS_2); 
    }
	
    @Test
    public void testUcs2DecodeWithUdh() throws Exception {
    	testDecode(UDH_HEX + HELLO_AT_WORLD_UCS2_HEX, true, CHARSET_UCS_2, "UTF-16BE");
    }
	
    @Test
    public void testUcs2EncodeWithUdh() throws Exception { 
    	byte[] bytes = createMessageByteArray(UDH_BYTES, HELLO_AT_WORLD_UCS2, "UTF-16BE");
    	testEncode(bytes, true, CHARSET_UCS_2, "UTF-16BE");
    }
		
    @Test
    public void testUcs2DecodeEncodeWithUdh() throws Exception {
    	testDecodeEncodeWithUdh(UDH_HEX + HELLO_AT_WORLD_UCS2_HEX, CHARSET_UCS_2);
    }

    
    private void testDecodeEncodeWithUdh(String messageHex, Charset charset) throws Exception {
    	testDecodeEncode(messageHex, true, charset);
    }
    
    private void testDecodeEncode(String messageHex, Charset charset) throws Exception {
    	testDecodeEncode(messageHex, false, charset);
    }
    
    private void testDecodeEncode(String messageHex, boolean hasUdh, Charset charset) throws Exception {
    	HexString pre = HexString.valueOf(messageHex);      
    	byte[] messageBytes = pre.asBytes();
    	String decodedString = CharsetUtil.decode(hasUdh, messageBytes, charset);
    	byte[] encodedBytes = CharsetUtil.encode(hasUdh, decodedString, charset);
    	HexString post = HexString.valueOf(encodedBytes);
    	assertEquals(pre.asString(), post.asString());            	
    }
    
    private void testDecode(String messageHex, boolean hasUdh, Charset charset, String charsetName) throws Exception {
    	HexString message = HexString.valueOf(messageHex); 
    	testDecode(message, hasUdh, charset, charsetName);
    }
    
    private void testDecode(HexString message, boolean hasUdh, Charset charset, String charsetName) throws Exception {
    	byte[] bytes = message.asBytes();
    	String decodedString = CharsetUtil.decode(hasUdh, bytes, charset);
    	byte[] decodedUdhBytes = decodedString.subSequence(0, bytes[0] + 1).toString().getBytes();
    	byte[] decodedMessageBytes = decodedString.subSequence(bytes[0] + 1, decodedString.length()).toString().getBytes(charsetName);
    	ByteBuffer buffer = new ByteBuffer(decodedUdhBytes.length + decodedMessageBytes.length);
    	buffer.add(decodedUdhBytes);
    	buffer.add(decodedMessageBytes);
    	HexString decodedMessage = HexString.valueOf(buffer.toArray());
    	assertEquals(message.asString(), decodedMessage.asString());            	
    }
    
    private void testEncode(byte[] bytes, boolean hasUdh, Charset charset, String charsetName) throws Exception {
    	HexString message = HexString.valueOf(bytes);
    	testEncode(message, hasUdh, charset, charsetName);
    }
    
    private void testEncode(HexString message, boolean hasUdh, Charset charset, String charsetName) throws Exception {
    	byte[] bytes = message.asBytes();
    	String string;
    	if (hasUdh) {
    		byte[] udhBytes = Arrays.copyOfRange(bytes, 0, bytes[0] + 1);
        	string = new String(udhBytes) + new String(Arrays.copyOfRange(bytes, udhBytes.length, bytes.length), charsetName);    	
    	} else {
        	string = new String(bytes, charsetName);    	
    		
    	}
    	byte[] encodedBytes = CharsetUtil.encode(hasUdh, string, charset);
    	HexString encodedMessage = HexString.valueOf(encodedBytes);
    	assertEquals(message.asString(), encodedMessage.asString());        
    }
    
    private byte[] createMessageByteArray(byte[] udhBytes, String message, String charsetName) throws Exception {
    	if (udhBytes == null)
    		udhBytes = new byte[0];
    	byte[] messageBytes = message.getBytes(charsetName);
    	ByteBuffer buffer = new ByteBuffer(udhBytes.length + messageBytes.length);
    	buffer.add(udhBytes);
    	buffer.add(messageBytes);
    	byte[] bytes = buffer.toArray();
    	return bytes;
    }
    

}