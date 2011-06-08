package com.cloudhopper.commons.charset;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.cloudhopper.commons.util.HexString;

import static org.junit.Assert.*;

public class GsmPackedCharsetWithUdhTest {
	
//	private static final String GSM_8_BIT_HELLO_WORLD = "68656C6C6F20776F726C64"; // 'hello world' in 8 bit encoded (data encoded) GSM 03.38 alphabet
//	private static final String GSM_7_BIT_HELLO_WORLD_0_OFFSET = "E8329BFD06DDDF723619"; // 'hello world' in 7 bit encoded (default encoded) GSM 03.38 alphabet w/ no septet padding
//	private static final String GSM_7_BIT_HELLO_WORLD_1_OFFSET = "D06536FB0DBABFE56C32"; // 'hello world' in 7 bit encoded (default encoded) GSM 03.38 alphabet w/ 1 septet padding
//	private static final String GSM_7_BIT_HELLO_WORLD_2_OFFSET = "A0CB6CF61B747FCBD964"; // 'hello world' in 7 bit encoded (default encoded) GSM 03.38 alphabet w/ 2 septet padding
//	private static final String GSM_7_BIT_HELLO_WORLD_6_OFFSET = "00BACC66BF41F7B79C4D06"; // 'hello world' in 7 bit encoded (default encoded) GSM 03.38 alphabet w/ 6 septet padding
        
	/*
	 * Unpacking:
	 * There are 3 loop counters to test for around their boundaries:
	 *   - the packed byte array index
	 *   - the unpacked byte array index
	 *   - and the bitshift value (0 to 7)
	 */
	
//	public void testGenerate() throws Exception {
//		for (int i=0; i < 9; i++) {
//			String name = "GSM_8_BIT_HELLO_WORLD".substring(0, "GSM_8_BIT_HELLO_WORLD".length() - i);
//			String value = GSM_8_BIT_HELLO_WORLD.substring(0, GSM_8_BIT_HELLO_WORLD.length() - (2*i));
//			System.out.println("\tprivate static final String " + name + " = \"" + value + "\";");
//			for (int j=0; j < 7; j++) {
//				String packName = "GSM_7_BIT_" + name.substring(10) + "_" + j + "_OFFSET";
//				String packValue = new String(Hex.encodeHex(GSM_8_TO_7_BIT_PACK.convert(j, Hex.decodeHex(value.toCharArray())))).toUpperCase();
//				System.out.println("\tprivate static final String " + packName + " = \"" + packValue + "\";");
//				System.out.println(
//					"\tpublic void testUnpack7BitGsmTo8Bit_" + name + "_" + j + "_UdhOffset() throws Exception {" +
//    	            "\n\t\ttestUnpack7BitTo8bit(" + packName+ ", " + name + ", " + j + ");" +
//                    "\n\t}"	
//				);
//			}
//			System.out.println("");
//			System.out.println("");
//			
//		}
//		assertTrue(true);
//	}
	
	// -- START GENERATED TESTS -- //

	private static final String GSM_8_BIT_HELLO_WORLD = "68656C6C6F20776F726C64";
	private static final String GSM_7_BIT_HELLO_WORLD_0_OFFSET = "E8329BFD06DDDF723619";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORLD_0_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORLD_0_OFFSET, GSM_8_BIT_HELLO_WORLD, 0);
	}
	private static final String GSM_7_BIT_HELLO_WORLD_1_OFFSET = "D06536FB0DBABFE56C32";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORLD_1_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORLD_1_OFFSET, GSM_8_BIT_HELLO_WORLD, 1);
	}
	private static final String GSM_7_BIT_HELLO_WORLD_2_OFFSET = "A0CB6CF61B747FCBD964";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORLD_2_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORLD_2_OFFSET, GSM_8_BIT_HELLO_WORLD, 2);
	}
	private static final String GSM_7_BIT_HELLO_WORLD_3_OFFSET = "4097D9EC37E8FE96B3C9";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORLD_3_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORLD_3_OFFSET, GSM_8_BIT_HELLO_WORLD, 3);
	}
	private static final String GSM_7_BIT_HELLO_WORLD_4_OFFSET = "802EB3D96FD0FD2D679301";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORLD_4_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORLD_4_OFFSET, GSM_8_BIT_HELLO_WORLD, 4);
	}
	private static final String GSM_7_BIT_HELLO_WORLD_5_OFFSET = "005D66B3DFA0FB5BCE2603";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORLD_5_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORLD_5_OFFSET, GSM_8_BIT_HELLO_WORLD, 5);
	}
	private static final String GSM_7_BIT_HELLO_WORLD_6_OFFSET = "00BACC66BF41F7B79C4D06";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORLD_6_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORLD_6_OFFSET, GSM_8_BIT_HELLO_WORLD, 6);
	}


	private static final String GSM_8_BIT_HELLO_WORL = "68656C6C6F20776F726C";
	private static final String GSM_7_BIT_HELLO_WORL_0_OFFSET = "E8329BFD06DDDF7236";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORL_0_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORL_0_OFFSET, GSM_8_BIT_HELLO_WORL, 0);
	}
	private static final String GSM_7_BIT_HELLO_WORL_1_OFFSET = "D06536FB0DBABFE56C";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORL_1_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORL_1_OFFSET, GSM_8_BIT_HELLO_WORL, 1);
	}
	private static final String GSM_7_BIT_HELLO_WORL_2_OFFSET = "A0CB6CF61B747FCBD9";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORL_2_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORL_2_OFFSET, GSM_8_BIT_HELLO_WORL, 2);
	}
	private static final String GSM_7_BIT_HELLO_WORL_3_OFFSET = "4097D9EC37E8FE96B301";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORL_3_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORL_3_OFFSET, GSM_8_BIT_HELLO_WORL, 3);
	}
	private static final String GSM_7_BIT_HELLO_WORL_4_OFFSET = "802EB3D96FD0FD2D6703";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORL_4_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORL_4_OFFSET, GSM_8_BIT_HELLO_WORL, 4);
	}
	private static final String GSM_7_BIT_HELLO_WORL_5_OFFSET = "005D66B3DFA0FB5BCE06";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORL_5_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORL_5_OFFSET, GSM_8_BIT_HELLO_WORL, 5);
	}
	private static final String GSM_7_BIT_HELLO_WORL_6_OFFSET = "00BACC66BF41F7B79C0D";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WORL_6_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORL_6_OFFSET, GSM_8_BIT_HELLO_WORL, 6);
	}


	private static final String GSM_8_BIT_HELLO_WOR = "68656C6C6F20776F72";
	private static final String GSM_7_BIT_HELLO_WOR_0_OFFSET = "E8329BFD06DDDF72";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WOR_0_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WOR_0_OFFSET, GSM_8_BIT_HELLO_WOR, 0);
	}
	private static final String GSM_7_BIT_HELLO_WOR_1_OFFSET = "D06536FB0DBABFE5";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WOR_1_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WOR_1_OFFSET, GSM_8_BIT_HELLO_WOR, 1);
	}
	private static final String GSM_7_BIT_HELLO_WOR_2_OFFSET = "A0CB6CF61B747FCB01";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WOR_2_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WOR_2_OFFSET, GSM_8_BIT_HELLO_WOR, 2);
	}
	private static final String GSM_7_BIT_HELLO_WOR_3_OFFSET = "4097D9EC37E8FE9603";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WOR_3_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WOR_3_OFFSET, GSM_8_BIT_HELLO_WOR, 3);
	}
	private static final String GSM_7_BIT_HELLO_WOR_4_OFFSET = "802EB3D96FD0FD2D07";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WOR_4_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WOR_4_OFFSET, GSM_8_BIT_HELLO_WOR, 4);
	}
	private static final String GSM_7_BIT_HELLO_WOR_5_OFFSET = "005D66B3DFA0FB5B0E";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WOR_5_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WOR_5_OFFSET, GSM_8_BIT_HELLO_WOR, 5);
	}
	private static final String GSM_7_BIT_HELLO_WOR_6_OFFSET = "00BACC66BF41F7B71C";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WOR_6_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WOR_6_OFFSET, GSM_8_BIT_HELLO_WOR, 6);
	}


	private static final String GSM_8_BIT_HELLO_WO = "68656C6C6F20776F";
	private static final String GSM_7_BIT_HELLO_WO_0_OFFSET = "E8329BFD06DDDF";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WO_0_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WO_0_OFFSET, GSM_8_BIT_HELLO_WO, 0);
	}
	private static final String GSM_7_BIT_HELLO_WO_1_OFFSET = "D06536FB0DBABF01";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WO_1_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WO_1_OFFSET, GSM_8_BIT_HELLO_WO, 1);
	}
	private static final String GSM_7_BIT_HELLO_WO_2_OFFSET = "A0CB6CF61B747F03";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WO_2_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WO_2_OFFSET, GSM_8_BIT_HELLO_WO, 2);
	}
	private static final String GSM_7_BIT_HELLO_WO_3_OFFSET = "4097D9EC37E8FE06";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WO_3_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WO_3_OFFSET, GSM_8_BIT_HELLO_WO, 3);
	}
	private static final String GSM_7_BIT_HELLO_WO_4_OFFSET = "802EB3D96FD0FD0D";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WO_4_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WO_4_OFFSET, GSM_8_BIT_HELLO_WO, 4);
	}
	private static final String GSM_7_BIT_HELLO_WO_5_OFFSET = "005D66B3DFA0FB1B";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WO_5_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WO_5_OFFSET, GSM_8_BIT_HELLO_WO, 5);
	}
	private static final String GSM_7_BIT_HELLO_WO_6_OFFSET = "00BACC66BF41F737";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_WO_6_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WO_6_OFFSET, GSM_8_BIT_HELLO_WO, 6);
	}


	private static final String GSM_8_BIT_HELLO_W = "68656C6C6F2077";
	private static final String GSM_7_BIT_HELLO_W_0_OFFSET = "E8329BFD06DD01";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_W_0_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_W_0_OFFSET, GSM_8_BIT_HELLO_W, 0);
	}
	private static final String GSM_7_BIT_HELLO_W_1_OFFSET = "D06536FB0DBA03";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_W_1_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_W_1_OFFSET, GSM_8_BIT_HELLO_W, 1);
	}
	private static final String GSM_7_BIT_HELLO_W_2_OFFSET = "A0CB6CF61B7407";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_W_2_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_W_2_OFFSET, GSM_8_BIT_HELLO_W, 2);
	}
	private static final String GSM_7_BIT_HELLO_W_3_OFFSET = "4097D9EC37E80E";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_W_3_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_W_3_OFFSET, GSM_8_BIT_HELLO_W, 3);
	}
	private static final String GSM_7_BIT_HELLO_W_4_OFFSET = "802EB3D96FD01D";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_W_4_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_W_4_OFFSET, GSM_8_BIT_HELLO_W, 4);
	}
	private static final String GSM_7_BIT_HELLO_W_5_OFFSET = "005D66B3DFA03B";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_W_5_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_W_5_OFFSET, GSM_8_BIT_HELLO_W, 5);
	}
	private static final String GSM_7_BIT_HELLO_W_6_OFFSET = "00BACC66BF4177";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_W_6_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_W_6_OFFSET, GSM_8_BIT_HELLO_W, 6);
	}


	private static final String GSM_8_BIT_HELLO_ = "68656C6C6F20";
	private static final String GSM_7_BIT_HELLO__0_OFFSET = "E8329BFD0601";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO__0_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO__0_OFFSET, GSM_8_BIT_HELLO_, 0);
	}
	private static final String GSM_7_BIT_HELLO__1_OFFSET = "D06536FB0D02";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO__1_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO__1_OFFSET, GSM_8_BIT_HELLO_, 1);
	}
	private static final String GSM_7_BIT_HELLO__2_OFFSET = "A0CB6CF61B04";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO__2_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO__2_OFFSET, GSM_8_BIT_HELLO_, 2);
	}
	private static final String GSM_7_BIT_HELLO__3_OFFSET = "4097D9EC3708";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO__3_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO__3_OFFSET, GSM_8_BIT_HELLO_, 3);
	}
	private static final String GSM_7_BIT_HELLO__4_OFFSET = "802EB3D96F10";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO__4_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO__4_OFFSET, GSM_8_BIT_HELLO_, 4);
	}
	private static final String GSM_7_BIT_HELLO__5_OFFSET = "005D66B3DF20";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO__5_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO__5_OFFSET, GSM_8_BIT_HELLO_, 5);
	}
	private static final String GSM_7_BIT_HELLO__6_OFFSET = "00BACC66BF41";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO__6_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO__6_OFFSET, GSM_8_BIT_HELLO_, 6);
	}


	private static final String GSM_8_BIT_HELLO = "68656C6C6F";
	private static final String GSM_7_BIT_HELLO_0_OFFSET = "E8329BFD06";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_0_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_0_OFFSET, GSM_8_BIT_HELLO, 0);
	}
	private static final String GSM_7_BIT_HELLO_1_OFFSET = "D06536FB0D";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_1_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_1_OFFSET, GSM_8_BIT_HELLO, 1);
	}
	private static final String GSM_7_BIT_HELLO_2_OFFSET = "A0CB6CF61B";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_2_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_2_OFFSET, GSM_8_BIT_HELLO, 2);
	}
	private static final String GSM_7_BIT_HELLO_3_OFFSET = "4097D9EC37";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_3_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_3_OFFSET, GSM_8_BIT_HELLO, 3);
	}
	private static final String GSM_7_BIT_HELLO_4_OFFSET = "802EB3D96F";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_4_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_4_OFFSET, GSM_8_BIT_HELLO, 4);
	}
	private static final String GSM_7_BIT_HELLO_5_OFFSET = "005D66B3DF";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_5_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_5_OFFSET, GSM_8_BIT_HELLO, 5);
	}
	private static final String GSM_7_BIT_HELLO_6_OFFSET = "00BACC66BF01";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELLO_6_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELLO_6_OFFSET, GSM_8_BIT_HELLO, 6);
	}


	private static final String GSM_8_BIT_HELL = "68656C6C";
	private static final String GSM_7_BIT_HELL_0_OFFSET = "E8329B0D";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELL_0_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELL_0_OFFSET, GSM_8_BIT_HELL, 0);
	}
	private static final String GSM_7_BIT_HELL_1_OFFSET = "D065361B";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELL_1_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELL_1_OFFSET, GSM_8_BIT_HELL, 1);
	}
	private static final String GSM_7_BIT_HELL_2_OFFSET = "A0CB6C36";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELL_2_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELL_2_OFFSET, GSM_8_BIT_HELL, 2);
	}
	private static final String GSM_7_BIT_HELL_3_OFFSET = "4097D96C";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELL_3_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELL_3_OFFSET, GSM_8_BIT_HELL, 3);
	}
	private static final String GSM_7_BIT_HELL_4_OFFSET = "802EB3D9";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELL_4_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELL_4_OFFSET, GSM_8_BIT_HELL, 4);
	}
	private static final String GSM_7_BIT_HELL_5_OFFSET = "005D66B301";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELL_5_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELL_5_OFFSET, GSM_8_BIT_HELL, 5);
	}
	private static final String GSM_7_BIT_HELL_6_OFFSET = "00BACC6603";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HELL_6_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HELL_6_OFFSET, GSM_8_BIT_HELL, 6);
	}


	private static final String GSM_8_BIT_HEL = "68656C";
	private static final String GSM_7_BIT_HEL_0_OFFSET = "E8321B";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HEL_0_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HEL_0_OFFSET, GSM_8_BIT_HEL, 0);
	}
	private static final String GSM_7_BIT_HEL_1_OFFSET = "D06536";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HEL_1_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HEL_1_OFFSET, GSM_8_BIT_HEL, 1);
	}
	private static final String GSM_7_BIT_HEL_2_OFFSET = "A0CB6C";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HEL_2_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HEL_2_OFFSET, GSM_8_BIT_HEL, 2);
	}
	private static final String GSM_7_BIT_HEL_3_OFFSET = "4097D9";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HEL_3_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HEL_3_OFFSET, GSM_8_BIT_HEL, 3);
	}
	private static final String GSM_7_BIT_HEL_4_OFFSET = "802EB301";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HEL_4_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HEL_4_OFFSET, GSM_8_BIT_HEL, 4);
	}
	private static final String GSM_7_BIT_HEL_5_OFFSET = "005D6603";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HEL_5_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HEL_5_OFFSET, GSM_8_BIT_HEL, 5);
	}
	private static final String GSM_7_BIT_HEL_6_OFFSET = "00BACC06";
	@Test
	public void testUnpack7BitGsmTo8Bit_GSM_8_BIT_HEL_6_UdhOffset() throws Exception {
		testUnpack7BitTo8bit(GSM_7_BIT_HEL_6_OFFSET, GSM_8_BIT_HEL, 6);
	}

	// -- END GENERATED TESTS -- //
	
	@Test
	public void testConvertTo7BitPackingHelloWorldNoUdhOffset() throws Exception {
    	testPack8BitTo7bit(GSM_8_BIT_HELLO_WORLD, GSM_7_BIT_HELLO_WORLD_0_OFFSET, 0);
    }
    
	@Test
    public void testUnpack7BitGsmTo8BitHelloWorldNoUdhOffset() throws Exception {
        testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORLD_0_OFFSET, GSM_8_BIT_HELLO_WORLD, 0);
    }
        
	@Test
    public void testConvertTo7BitPackingHelloWorldOneUdhOffset() throws Exception {
    	testPack8BitTo7bit(GSM_8_BIT_HELLO_WORLD, GSM_7_BIT_HELLO_WORLD_1_OFFSET, 1);
    }
    
	@Test
    public void testUnpack7BitGsmTo8BitHelloWorldOneUdhOffset() throws Exception {
        testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORLD_1_OFFSET, GSM_8_BIT_HELLO_WORLD, 1);
    }
            
	@Test
    public void testConvertTo7BitPackingHelloWorldTwoUdhOffset() throws Exception {
    	testPack8BitTo7bit(GSM_8_BIT_HELLO_WORLD, GSM_7_BIT_HELLO_WORLD_2_OFFSET, 2);
    }
    
	@Test
    public void testUnpack7BitGsmTo8BitHelloWorldTwoUdhOffset() throws Exception {
        testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORLD_2_OFFSET, GSM_8_BIT_HELLO_WORLD, 2);
    }
                
	@Test
    public void testConvertTo7BitPackingHelloWorldSixUdhOffset() throws Exception {
    	testPack8BitTo7bit(GSM_8_BIT_HELLO_WORLD, GSM_7_BIT_HELLO_WORLD_6_OFFSET, 6);
    }
    
	@Test
    public void testUnpack7BitGsmTo8BitHelloWorldSixUdhOffset() throws Exception {
        testUnpack7BitTo8bit(GSM_7_BIT_HELLO_WORLD_6_OFFSET, GSM_8_BIT_HELLO_WORLD, 6);
    }
                                
	@Test
    public void testConvertTo7BitPackingLongNonsenseMessageNoUdhOffset() throws Exception {
    	testPack8BitTo7bit("486F776479207927486F776479207927486F776479207927616C6C21", "C8F79D9C07E54FC8F79D9C07E54FC8F79D9C07E54F61363B04", 0);
    }

	@Test
    public void testUnpack7BitGsmTo8BitLongNonsenseMessageNoUdhOffset() throws Exception {
        testUnpack7BitTo8bit("C8F79D9C07E54FC8F79D9C07E54FC8F79D9C07E54F61363B04", "486F776479207927486F776479207927486F776479207927616C6C21", 0);
    }
                
	@Test
    public void testConvertTo7BitPackingLongNonsenseMessageFourUdhOffset() throws Exception {
    	testPack8BitTo7bit("486F776479207927486F776479207927486F776479207927616C6C21", "807CDFC97950FE847CDFC97950FE847CDFC97950FE1466B343", 4);
    }
    
	@Test
    public void testUnpack7BitGsmTo8BitLongNonsenseMessageFourUdhOffset() throws Exception {
        testUnpack7BitTo8bit("807CDFC97950FE847CDFC97950FE847CDFC97950FE1466B343", "486F776479207927486F776479207927486F776479207927616C6C21", 4);
    }
             
	@Test
    public void testConvertTo7BitPackingLoremIpsumOneUdhOffset() throws Exception {
    	testPack8BitTo7bit(LOREM_IPSUM_8_BIT_GSM, LOREM_IPSUM_GSM_7_BIT_1_OFFSET, 1);
    }
    
	@Test
    public void testUnpack7BitGsmTo8BitLoremIpsumOneUdhOffset() throws Exception {
        testUnpack7BitTo8bit(LOREM_IPSUM_GSM_7_BIT_1_OFFSET, LOREM_IPSUM_8_BIT_GSM, 1);
    }
                
	@Test
    public void testConvertTo7BitPackingLoremIpsumTwoUdhOffset() throws Exception {
    	testPack8BitTo7bit(LOREM_IPSUM_8_BIT_GSM, LOREM_IPSUM_GSM_7_BIT_2_OFFSET, 2);
    }
    
	@Test
    public void testUnpack7BitGsmTo8BitLoremIpsumTwoUdhOffset() throws Exception {
        testUnpack7BitTo8bit(LOREM_IPSUM_GSM_7_BIT_2_OFFSET, LOREM_IPSUM_8_BIT_GSM, 2);
    }
                
	@Test
    public void testConvertTo7BitPackingLoremIpsumThreeUdhOffset() throws Exception {
    	testPack8BitTo7bit(LOREM_IPSUM_8_BIT_GSM, LOREM_IPSUM_GSM_7_BIT_3_OFFSET, 3);
    }
    
	@Test
    public void testUnpack7BitGsmTo8BitLoremIpsumThreeUdhOffset() throws Exception {
        testUnpack7BitTo8bit(LOREM_IPSUM_GSM_7_BIT_3_OFFSET, LOREM_IPSUM_8_BIT_GSM, 3);
    }
                
	@Test
    public void testConvertTo7BitPackingLoremIpsumFourUdhOffset() throws Exception {
    	testPack8BitTo7bit(LOREM_IPSUM_8_BIT_GSM, LOREM_IPSUM_GSM_7_BIT_4_OFFSET, 4);
    }
    
	@Test
    public void testUnpack7BitGsmTo8BitLoremIpsumFourUdhOffset() throws Exception {
        testUnpack7BitTo8bit(LOREM_IPSUM_GSM_7_BIT_4_OFFSET, LOREM_IPSUM_8_BIT_GSM, 4);
    }
                
	@Test
    public void testConvertTo7BitPackingLoremIpsumFiveUdhOffset() throws Exception {
    	testPack8BitTo7bit(LOREM_IPSUM_8_BIT_GSM, LOREM_IPSUM_GSM_7_BIT_5_OFFSET, 5);
    }
    
	@Test
    public void testUnpack7BitGsmTo8BitLoremIpsumFiveUdhOffset() throws Exception {
        testUnpack7BitTo8bit(LOREM_IPSUM_GSM_7_BIT_5_OFFSET, LOREM_IPSUM_8_BIT_GSM, 5);
    }
                
	@Test
    public void testConvertTo7BitPackingLoremIpsumSixUdhOffset() throws Exception {
    	testPack8BitTo7bit(LOREM_IPSUM_8_BIT_GSM, LOREM_IPSUM_GSM_7_BIT_6_OFFSET, 6);
    }
    
	@Test
    public void testUnpack7BitGsmTo8BitLoremIpsumSixUdhOffset() throws Exception {
        testUnpack7BitTo8bit(LOREM_IPSUM_GSM_7_BIT_6_OFFSET, LOREM_IPSUM_8_BIT_GSM, 6);
    }
                
	@Test
    public void testConvertTo7BitPackingLoremIpsumNoUdhOffset() throws Exception {
    	testPack8BitTo7bit(LOREM_IPSUM_8_BIT_GSM, LOREM_IPSUM_GSM_7_BIT_0_OFFSET, 0);
    }
    
	@Test
    public void testUnpack7BitGsmTo8BitLoremIpsumNoUdhOffset() throws Exception {
        testUnpack7BitTo8bit(LOREM_IPSUM_GSM_7_BIT_0_OFFSET, LOREM_IPSUM_8_BIT_GSM, 0);
    }
                

	// tests to ensure no UDH encodes/decodes accurately 
	
	@Test
    public void testUnpack7BitGsmTo8BitLoremIpsumWithNoUdh() throws Exception {
        testUnpack7BitTo8bit(LOREM_IPSUM_GSM_7_BIT_0_OFFSET, LOREM_IPSUM_8_BIT_GSM, false);
    }
                
	@Test
    public void testConvertTo7BitPackingLoremIpsumWithNoUdh() throws Exception {
    	testPack8BitTo7bit(LOREM_IPSUM_8_BIT_GSM, LOREM_IPSUM_GSM_7_BIT_0_OFFSET, false);
    }
    
	// end tests to ensure no UDH encodes/decodes accurately 

	@Test
    public void testConvertTo7BitPackingNullBuffer() throws Exception {
        byte[] buffer = null;
        byte[] packed = GSMBitPacker.pack(true, buffer); // 6 offset specified
        HexString packedHex = HexString.valueOf(packed);
        String expectedOutput = "";
        assertEquals(expectedOutput, packedHex.asString());
    }

	@Test
    public void testUnpack7BitGsmTo8BitLoremIpsumSixUdh() throws Exception {
        testUnpack7BitTo8bit(UDH_REQUIRING_6_BIT_OFFSET + LOREM_IPSUM_GSM_7_BIT_6_OFFSET, UDH_REQUIRING_6_BIT_OFFSET + LOREM_IPSUM_8_BIT_GSM, true);
    }
      
	@Test
    public void testConvertTo7BitPackingLoremIpsumWithUdhAndSixOffset() throws Exception {
    	testPack8BitTo7bit(UDH_REQUIRING_6_BIT_OFFSET + LOREM_IPSUM_8_BIT_GSM, UDH_REQUIRING_6_BIT_OFFSET + LOREM_IPSUM_GSM_7_BIT_6_OFFSET, true);
    }
    

    private void testPack8BitTo7bit(String input, String expected, boolean udh) throws Exception {
    	testGsmMessageConversion(input, expected, udh, GSM_8_TO_7_BIT_PACK);
    }
    
    // the orignial implementation took the offset as a parameter, this method is a work-around 
    // to avoid having to refactor all the above test cases. It takes the offeset and looks up the
    // UDH hex in udhMap then prepends it to the input and expected parameters.
    private void testPack8BitTo7bit(String input, String expected, int septetOffset) throws Exception {
    	//testGsmMessageConversion(input, expected, septetOffset, GSM_8_TO_7_BIT_PACK);
    	String udh = udhMap.get(septetOffset);
    	testPack8BitTo7bit(udh + input, udh + expected, true);
    }
    
    private void testUnpack7BitTo8bit(String input, String expected, boolean udh) throws Exception {
    	testGsmMessageConversion(input, expected, udh, GSM_7_TO_8_BIT_UNPACK);
    }
    
    // the orignial implementation took the offset as a parameter, this method is a work-around 
    // to avoid having to refactor all the above test cases. It takes the offeset and looks up the
    // UDH hex in udhMap then prepends it to the input and expected parameters.
    private void testUnpack7BitTo8bit(String input, String expected, int septetOffset) throws Exception {
    	//testGsmMessageConversion(input, expected, septetOffset, GSM_7_TO_8_BIT_UNPACK);
    	String udh = udhMap.get(septetOffset);
    	testUnpack7BitTo8bit(udh + input, udh + expected, true);
    }
    
    private void testGsmMessageConversion(String input, String expected, boolean hasUdh, GsmMessageConversionStrategy messageConverter) throws Exception {
    	HexString inputHexString = HexString.valueOf(input);
        byte[] convertedMessageBytes = messageConverter.convert(hasUdh, inputHexString.asBytes());
    	HexString outputHexString = HexString.valueOf(convertedMessageBytes);
        assertEquals(expected, outputHexString.asString());
    }
    
    private interface GsmMessageConversionStrategy {
    	byte[] convert(boolean hasUdh, byte[] messageBytes);
    }
    
    private static final GsmMessageConversionStrategy GSM_7_TO_8_BIT_UNPACK = new GsmMessageConversionStrategy() {
		@Override
		public byte[] convert(boolean hasUdh, byte[] messageBytes) {
			return GSMBitPacker.unpack(hasUdh, messageBytes);
		}    	
    };
    
    private static final GsmMessageConversionStrategy GSM_8_TO_7_BIT_PACK = new GsmMessageConversionStrategy() {
		@Override
		public byte[] convert(boolean hasUdh, byte[] messageBytes) {			
			return GSMBitPacker.pack(hasUdh, messageBytes);
		}    	
    };
            
    @Test
    public void testLoremIpsum() throws Exception {
    	byte[] packed = GSM_8_TO_7_BIT_PACK.convert(false, HexString.valueOf(LOREM_IPSUM_8_BIT_GSM).asBytes());
    	byte[] unpacked = GSM_7_TO_8_BIT_UNPACK.convert(false, packed);
    	assertEquals(LOREM_IPSUM_8_BIT_GSM, HexString.valueOf(unpacked).asString());
    }

    public static final String LOREM_IPSUM_TEXT = 
    	"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
    	"exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla " +
    	"pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static final String LOREM_IPSUM_8_BIT_GSM =
    "4C6F72656D20697073756D20646F6C6F722073697420616D65742C20636F6E7365637465747572206164697069736963696E6720656C69742C2073656420646F20656975736D6F642074656D706F7220" +
    "696E6369646964756E74207574206C61626F726520657420646F6C6F7265206D61676E6120616C697175612E20557420656E696D206164206D696E696D2076656E69616D2C2071756973206E6F737472" +
    "756420657865726369746174696F6E20756C6C616D636F206C61626F726973206E69736920757420616C697175697020657820656120636F6D6D6F646F20636F6E7365717561742E2044756973206175" +
    "746520697275726520646F6C6F7220696E20726570726568656E646572697420696E20766F6C7570746174652076656C697420657373652063696C6C756D20646F6C6F72652065752066756769617420" +
    "6E756C6C612070617269617475722E204578636570746575722073696E74206F6363616563617420637570696461746174206E6F6E2070726F6964656E742C2073756E7420696E2063756C7061207175" +
    "69206F666669636961206465736572756E74206D6F6C6C697420616E696D20696420657374206C61626F72756D2E";

    public static final String LOREM_IPSUM_GSM_7_BIT_0_OFFSET = 
    "CCB7BCDC06A5E1F37A1B447EB3DF72D03C4D0785DB653A0B347EBBE7E531BD4CAFCB4161721A9E9EA7C769F7195466A7E92CD0BC4C0691DFA072BA3E6FBFC9207AB90D7FCB4169F7384D4E93EB6E3AA8" + 
    "4E07B1C3E2B7BC0C2AD341E437FB2D2F83DAE1B33B0C0AB3D3F17AD805AAD2416577BA0D0A9341EDB43BDD06D9CBEE74B8CD02C5EBE939C8FD9ED3E57532A88C2FCBC7697A989E7EBB4175363BDC1EBF" +
    "41ECB0F82D4FCF41EEF43C0DAAD34161763A5E4FC341653CA81C068DDFEDF69BFC068DDFEE79395E0FD35D20623D3D0785EBF432282DAFCBCB20F29BFD9683D26E90BC0C9797D16537B92C4FD3416937" +
    "C8FE66D7E1F430BD0CB297D9693AA83C9F9741E3349B5D6F83C86FF65B5E0695EB2073FD9C0ED341EE3A9B1D06C1C3F274985E97BB4045FCB80CA797EB72D03CEDA683DEE371B83C0ED341E33A3C4D0E" +
    "D3C37490FBED06C1E5EF34B9ECA6B340F3BA9B0E4ABB41E33A1B1E06C5EB69D0DB6C4E8FD36110B93C2FCBEB6E3AA8FD66B3D37450D89D6E83D26450794E07B1C3E2B7BCDE7601";
    
    public static final String LOREM_IPSUM_GSM_7_BIT_1_OFFSET = 
    "986F79B90D4AC3E7F53688FC66BFE5A0799A0E0AB7CB741668FC76CFCB637A995E9783C2E4343C3D4F8FD3EE33A8CC4ED359A079990C22BF41E5747DDE7E9341F4721BFE9683D2EE719A9C26D7DD7450" +
    "9D0E6287C56F791954A683C86FF65B5E06B5C36777181466A7E3F5B00B54A583CAEE741B142683DA6977BA0DB297DDE9709B058AD7D37390FB3DA7CBEB6450195F968FD3F4303DFD7683EA6C76B83D7E" +
    "83D861F15B9E9E83DCE9791A54A783C2EC74BC9E8683CA7850390C1ABFDBED37F90D1ABFDDF372BC1EA6BB40C47A7A0E0AD7E965505A5E979741E437FB2D07A5DD2079192E2FA3CB6E72599EA683D26E" +
    "90FDCDAEC3E9617A19642FB3D37450793E2F83C66936BBDE0691DFECB7BC0C2AD741E6FA391DA683DC75363B0C8287E5E930BD2E77818AF871194E2FD7E5A079DA4D07BDC7E370791CA683C675789A1C" +
    "A687E920F7DB0D82CBDF6972D94D6781E675371D947683C675363C0C8AD7D3A0B7D99C1EA7C32072795E96D7DD7450FBCD66A7E9A0B03BDD06A5C9A0F29C0E6287C56F79BDED02";
    
    public static final String LOREM_IPSUM_GSM_7_BIT_2_OFFSET = 
    "30DFF2721B9486CFEB6D10F9CD7ECB41F3341D146E97E92CD0F8ED9E97C7F432BD2E0785C969787A9E1EA7DD6750999DA6B340F33219447E83CAE9FABCFD2683E8E536FC2D07A5DDE334394DAEBBE9A0" +
    "3A1DC40E8BDFF232A84C0791DFECB7BC0C6A87CFEE3028CC4EC7EB6117A84A0795DDE936284C06B5D3EE741B642FBBD3E1360B14AFA7E720F77B4E97D7C9A032BE2C1FA7E9617AFAED06D5D9EC707BFC" +
    "06B1C3E2B73C3D07B9D3F334A84E0785D9E9783D0D0795F1A07218347EB7DB6FF21B347EBBE7E5783D4C778188F5F41C14AED3CBA0B4BC2E2F83C86FF65B0E4ABB41F2325C5E4697DDE4B23C4D07A5DD" +
    "20FB9B5D87D3C3F432C85E66A7E9A0F27C5E068DD36C76BD0D22BFD96F791954AE83CCF5733A4C07B9EB6C7618040FCBD3617A5DEE0215F1E3329C5EAECB41F3B49B0E7A8FC7E1F2384C078DEBF03439" +
    "4C0FD341EEB71B0497BFD3E4B29BCE02CDEB6E3A28ED068DEB6C781814AFA7416FB3393D4E8741E4F2BC2CAFBBE9A0F69BCD4ED3416177BA0D4A9341E5391DC40E8BDFF27ADB05";
    
    public static final String LOREM_IPSUM_GSM_7_BIT_3_OFFSET = 
    "60BEE5E536280D9FD7DB20F29BFD9683E6693A28DC2ED359A0F1DB3D2F8FE9657A5D0E0A93D3F0F43C3D4EBBCFA0323B4D6781E6653288FC0695D3F579FB4D06D1CB6DF85B0E4ABBC769729A5C77D341" +
    "753A881D16BFE56550990E22BFD96F7919D40E9FDD6150989D8ED7C32E50950E2ABBD36D50980C6AA7DDE936C85E76A7C36D16285E4FCF41EEF79C2EAF9341657C593E4ED3C3F4F4DB0DAAB3D9E1F6F8" +
    "0D6287C56F797A0E72A7E769509D0E0AB3D3F17A1A0E2AE341E53068FC6EB7DFE43768FC76CFCBF17A98EE0211EBE939285CA7974169795D5E0691DFECB71C947683E465B8BC8C2EBBC965799A0E4ABB" +
    "41F637BB0EA787E96590BDCC4ED341E5F9BC0C1AA7D9EC7A1B447EB3DFF232A85C0799EBE774980E72D7D9EC30081E96A7C3F4BADC052AE2C76538BD5C9783E669371DF41E8FC3E571980E1AD7E16972" +
    "981EA683DC6F37082E7FA7C965379D059AD7DD7450DA0D1AD7D9F030285E4F83DE66737A9C0E83C8E579595E77D341ED379B9DA683C2EE741B942683CA733A881D16BFE5F5B60B";
    
    public static final String LOREM_IPSUM_GSM_7_BIT_4_OFFSET = 
    "C07CCBCB6D501A3EAFB741E437FB2D07CDD37450B85DA6B340E3B77B5E1ED3CBF4BA1C1426A7E1E9797A9C769F4165769ACE02CDCB6410F90D2AA7EBF3F69B0CA297DBF0B71C94768FD3E434B9EEA683" +
    "EA74103B2C7ECBCBA0321D447EB3DFF232A81D3EBBC3A0303B1DAF875DA02A1D5476A7DBA03019D44EBBD36D90BDEC4E87DB2C50BC9E9E83DCEF395D5E2783CAF8B27C9CA687E9E9B71B5467B3C3EDF1" +
    "1BC40E8BDFF2F41CE44ECFD3A03A1D1466A7E3F5341C54C683CA61D0F8DD6EBFC96FD0F8ED9E97E3F530DD0522D6D37350B84E2F83D2F2BABC0C22BFD96F3928ED06C9CB7079195D7693CBF2341D9476" +
    "83EC6F761D4E0FD3CB207B999DA683CAF37919344EB3D9F53688FC66BFE56550B90E32D7CFE9301DE4AEB3D961103C2C4F87E975B90B54C48FCB707AB92E07CDD36E3AE83D1E87CBE3301D34AEC3D3E4" +
    "303D4C07B9DF6E105CFE4E93CB6E3A0B34AFBBE9A0B41B34AEB3E16150BC9E06BDCDE6F4381D0691CBF3B2BCEEA683DA6F363B4D0785DDE936284D0695E774103B2C7ECBEB6D17";
    
    public static final String LOREM_IPSUM_GSM_7_BIT_5_OFFSET = 
    "80F99697DBA0347C5E6F83C86FF65B0E9AA7E9A070BB4C6781C66FF7BC3CA697E97539284C4EC3D3F3F438ED3E83CAEC349D059A97C920F21B544ED7E7ED3719442FB7E16F3928ED1EA7C96972DD4D07" +
    "D5E9207658FC969741653A88FC66BFE565503B7C76874161763A5E0FBB40553AA8EC4EB7416132A89D76A7DB207BD99D0EB759A0783D3D07B9DF73BABC4E0695F165F9384D0FD3D36F37A8CE6687DBE3" +
    "37881D16BFE5E939C89D9EA741753A28CC4EC7EB6938A88C0795C3A0F1BBDD7E93DFA0F1DB3D2FC7EB61BA0B44ACA7E7A0709D5E06A5E5757919447EB3DF7250DA0D9297E1F232BAEC2697E5693A28ED" +
    "06D9DFEC3A9C1EA69741F6323B4D0795E7F332689C66B3EB6D10F9CD7ECBCBA0721D64AE9FD3613AC85D67B3C32078589E0ED3EB7217A8881F97E1F4725D0E9AA7DD74D07B3C0E97C7613A685C87A7C9" +
    "617A980E72BFDD20B8FC9D2697DD7416685E77D3416937685C67C3C3A0783D0D7A9BCDE9713A0C2297E76579DD4D07B5DF6C769A0E0ABBD36D509A0C2ACFE9207658FC96D7DB2E";
    
    public static final String LOREM_IPSUM_GSM_7_BIT_6_OFFSET = 
    "00F32D2FB74169F8BCDE0691DFECB71C344FD341E17699CE028DDFEE79794C2FD3EB7250989C86A7E7E971DA7D0695D9693A0B342F9341E437A89CAECFDB6F32885E6EC3DF7250DA3D4E93D3E4BA9B0E" +
    "AAD341ECB0F82D2F83CA7410F9CD7ECBCBA076F8EC0E83C2EC74BC1E7681AA7450D99D6E83C264503BED4EB741F6B23B1D6EB340F17A7A0E72BFE774799D0C2AE3CBF2719A1EA6A7DF6E509DCD0EB7C7" +
    "6F103B2C7ECBD373903B3D4F83EA7450989D8ED7D37050190F2A8741E377BBFD26BF41E3B77B5E8ED7C3741788584FCF41E13ABD0C4ACBEBF23288FC66BFE5A0B41B242FC3E56574D94D2ECBD37450DA" +
    "0DB2BFD975383D4C2F83EC65769A0E2ACFE765D038CD66D7DB20F29BFD969741E53AC85C3FA7C37490BBCE668741F0B03C1DA6D7E52E50113F2EC3E9E5BA1C344FBBE9A0F7781C2E8FC374D0B80E4F93" +
    "C3F4301DE47EBB4170F93B4D2EBBE92CD0BCEEA683D26ED0B8CE868741F17A1AF4369BD3E37418442ECFCBF2BA9B0E6ABFD9EC341D1476A7DBA03419549ED341ECB0F82DAFB75D";

    public static final String UDH_REQUIRING_6_BIT_OFFSET = "07060504030201AA";
    public static final String UDH_REQUIRING_5_BIT_OFFSET = "0807060504030201AA";
    public static final String UDH_REQUIRING_4_BIT_OFFSET = "090807060504030201AA";
    public static final String UDH_REQUIRING_3_BIT_OFFSET = "030201AA";
    public static final String UDH_REQUIRING_2_BIT_OFFSET = "04030201AA";
    public static final String UDH_REQUIRING_1_BIT_OFFSET = "0504030201AA";
    public static final String UDH_REQUIRING_0_BIT_OFFSET = "060504030201AA";
    
    private static Map<Integer, String> udhMap = new HashMap<Integer, String>();
    
    static {
    	udhMap.put(6, UDH_REQUIRING_6_BIT_OFFSET);
    	udhMap.put(5, UDH_REQUIRING_5_BIT_OFFSET);
    	udhMap.put(4, UDH_REQUIRING_4_BIT_OFFSET);
    	udhMap.put(3, UDH_REQUIRING_3_BIT_OFFSET);
    	udhMap.put(2, UDH_REQUIRING_2_BIT_OFFSET);
    	udhMap.put(1, UDH_REQUIRING_1_BIT_OFFSET);
    	udhMap.put(0, UDH_REQUIRING_0_BIT_OFFSET);
    }
    
    
}