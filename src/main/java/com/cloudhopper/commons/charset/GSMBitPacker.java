/**
 * Copyright (C) 2011 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.cloudhopper.commons.charset;

/**
 * Utility for packing and unpacking 8-bit to/from 7-bit byte arrays.
 *
 * @author joelauer
 * @author John Woolf (twitter: @jwoolf330 or <a href="http://twitter.com/jwoolf330" target=window>http://twitter.com/jwoolf330</a>)
 */
public class GSMBitPacker {
	
	private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    /** @deprecated Use {@link #pack(boolean, byte[])} instead. */
	@Deprecated
    public static byte[] pack(byte[] unpacked) {
    	return pack(false, unpacked);
    }
 
    /**
     * Pack a byte array according to the GSM bit-packing algorithm.
     * The GSM specification defines a simple compression mechanism for its
     * default alphabet to pack more message characters into a smaller space.
     * Since the alphabet only contains 128 symbols, each one can be represented
     * in 7 bits. The packing algorithm squeezes the bits for each symbol
     * "down" into the preceeding byte (so bit 7 of the first byte actually
     * contains bit 0 of the second symbol in a default alphabet string, bits
     * 6 and 7 in the second byte contain bits 0 and 1 of the third symbol etc.)
     * Since the maximum short message length is 140 <b>bytes</b>, you save
     * one bit per byte using the default alphabet giving you a total of
     * 140 + (140 / 8) = 160 characters to use. This is where the 160 character
     * limit comes from in SMPP packets.
     * <p>
     * Having said all that, most SMSCs do <b>NOT</b> use the packing
     * algorithm when communicating over TCP/IP. They either use a full
     * 8-bit alphabet such as ASCII or Latin-1, or they accept the default
     * alphabet in its unpacked form. As such, you will be unlikely to
     * need this method.
     * </o>
     * @param unpacked The unpacked byte array.
     * @param udh Whether the <code>CharSequence</code> contains a <tt>UDH</tt>
     * @return A new byte array containing the bytes in their packed form.
     */
    public static byte[] pack(boolean udh, byte[] unpacked) {
    	return convertGsmBytes(udh, unpacked, PACK);
    }
    
    /** @deprecated Use {@link #unpack(boolean, byte[])} instead. */
    @Deprecated
    static public byte[] unpack(byte[] packed) {
        return unpack(false, packed);
    }

    /**
     * Unpack a byte array according to the GSM bit-packing algorithm.
     * Read the full description in the documentation of the
     * <code>pack</code> method.
     * @see #pack(boolean, byte[])
     * @param udh Whether the user data bytes contain a <tt>UDH</tt>
     * @param packed The packed byte array.
     * @return A new byte array containing the unpacked bytes.
     */
    static public byte[] unpack(boolean udh, byte[] packed) {
    	return convertGsmBytes(udh, packed, UNPACK);
    }
    
    private static byte[] convertGsmBytes(boolean udh, byte[] gsmBytes, GsmMessageConversionStrategy messageConverter) {
        if (gsmBytes == null) {
//          return EMPTY_BYTE_ARRAY;
          return null;
      }
      if (udh) {
          int offset = calculateOffset(gsmBytes);
          int udhl = getUdhLength(gsmBytes);
          byte[] udhBytes = new byte[udhl];
          System.arraycopy(gsmBytes, 0, udhBytes, 0, udhBytes.length);
          byte[] messageBytes = new byte[gsmBytes.length - udhl];
          System.arraycopy(gsmBytes, udhBytes.length, messageBytes, 0, messageBytes.length);
          byte[] convertedMessage = messageConverter.convert(offset, messageBytes);
          byte[] bytes = new  byte[udhBytes.length + convertedMessage.length];
          System.arraycopy(udhBytes, 0, bytes, 0, udhBytes.length);
          System.arraycopy(convertedMessage, 0, bytes, udhBytes.length, convertedMessage.length);
      	return bytes;
      } else {
          return messageConverter.convert(0, gsmBytes);        	
      }
    }

    private interface GsmMessageConversionStrategy {
    	byte[] convert(int offset, byte[] messageBytes);
    }
    
    private static final GsmMessageConversionStrategy UNPACK = new GsmMessageConversionStrategy() {
		@Override
		public byte[] convert(int offset, byte[] messageBytes) {
			return GSMBitPacker.unpackBytes(offset, messageBytes);
		}    	
    };
    
    private static final GsmMessageConversionStrategy PACK = new GsmMessageConversionStrategy() {
		@Override
		public byte[] convert(int offset, byte[] messageBytes) {			
			return GSMBitPacker.packBytes(offset, messageBytes);
		}    	
    };
            
    private static byte[] packBytes(int offset, byte[] unpacked) {
        int bitLen = (unpacked.length * 7) + offset; // total length of bits needing to be stored (message and septet offset padding)
        int packedLen = (int) Math.ceil(bitLen/8f); 
        byte[] packed = new byte[packedLen];

        int current = 0;
        int bitpos = offset;
        for (int i = 0; i < unpacked.length; i++) {
            byte b = (byte)(unpacked[i] & 0x7F); // remove 7 bit where bits are ordered as 7 6 5 4 3 2 1 0
            // assign first half of partial bits
            packed[current] |= (byte) ((b & 0xFF) << bitpos);
            // assign second half of partial bits (if exist)            
            if (bitpos >= 2)
                packed[++current] |= (b >> (8 - bitpos));
            bitpos = (bitpos + 7) % 8;
            if (bitpos == 0)
                current++;
        }
        return packed;
    	
    }

    private static byte[] unpackBytes(int offset, byte[] packed) {    	
        int unpackedLen = ((packed.length * 8) - offset) / 7;
        byte[] unpacked = new byte[unpackedLen];
        int len = unpacked.length;
        int current = 0;
        //int bitpos = 0;
        int bitpos = offset;
        for (int i = 0; i < len; i++) {
            // remove top bit and assign first half of partial bits
            unpacked[i] = (byte)(((packed[current] & 0xFF) >> bitpos) & 0x7F);
            // remove top bit and assign second half of partial bits (if exist)
            if (bitpos >= 2)
                unpacked[i] |= (byte)((packed[++current] << (8 - bitpos)) & 0x7F);
            bitpos = (bitpos + 7) % 8;
            if (bitpos == 0)
                current++;
        }
        // this fixes an ambiguity bug in the specs
        // where the last of 8 packed bytes is 0
        // and it's impossible to distinguish whether it is a
        // trailing '@' character (which is mapped to 0)
        // or extra zero-bit padding for 7 actual data bytes.
        //
        // we opt for the latter, since it's far more likely,
        // at the cost of losing a trailing '@' character
        // in strings whose unpacked size modulo 8 equals the septet offset,
        // and whose last character is '@'.
        //
        // an application that wishes to handle this rare case
        // properly must disambiguate this case externally, such
        // as by obtaining the original string length, and
        // appending the trailing '@' if the length
        // shows that there is one character missing.
        if (len % 8 == offset && len > 0 && unpacked[len-1] == 0) {
            //System.err.println("Hit special case...");
            byte[] fixed = new byte[len-1];
            System.arraycopy(unpacked, 0, fixed, 0, len-1);
            unpacked = fixed;
        }
        return unpacked;    	
    }

    private static int getUdhLength(byte[] userData) {
    	int udhl = userData[0];
    	if (udhl < 1)
    		throw new RuntimeException("UDH indicated in user data (message) bytes but non-positive UDHL value in userData[0]: " + udhl);
    	return udhl + 1;
    }
    
    private static int calculateOffset(byte[] userData) {
    	int totalUdhLength = getUdhLength(userData);
    	int udhLenMod7 = (totalUdhLength * 8) % 7;
    	return udhLenMod7 != 0 ? 7 - udhLenMod7 : 0;
    }

    
}