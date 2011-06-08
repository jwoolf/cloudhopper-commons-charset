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

import java.util.Arrays;

/**
 * Base Charset class implementing common functionality.
 *
 * @author jlauer
 * @author John Woolf (twitter: @jwoolf330 or <a href="http://twitter.com/jwoolf330" target=window>http://twitter.com/jwoolf330</a>)
*/
public abstract class BaseCharset implements Charset {
	
	protected abstract byte[] encodeCharSequence(CharSequence str0);
	protected abstract void decodeToBuffer(byte[] bytes, StringBuilder buffer);

    @Override
    public String normalize(CharSequence str0) {
        byte[] bytes = this.encode(str0);
        // normalizing a string should never be result in a longer string
        StringBuilder buf = new StringBuilder(str0.length());
        this.decode(bytes, buf);
        return buf.toString();
    }
    
    /** {@inheritDoc} */
    @Deprecated
    @Override
    public final void decode(byte[] bytes, StringBuilder buffer) {
    	decode(false, bytes, buffer);
    }

    /** {@inheritDoc} */
    @Override
    public void decode(boolean udh, byte[] bytes, StringBuilder buffer) {
        if (bytes == null) {
            // append nothing
            return;
        }        
        
        if (udh) { 
            int udhl = bytes[0] + 1;
            buffer.append(new String(Arrays.copyOfRange(bytes, 0, udhl)));
            byte[] messageBytes = new byte[bytes.length - udhl];
            System.arraycopy(bytes, udhl, messageBytes, 0, messageBytes.length);
        	decodeToBuffer(messageBytes, buffer);
        } else {
        	decodeToBuffer(bytes, buffer);
        }
    }

    /** {@inheritDoc} */
    @Deprecated
    @Override
    public final byte[] encode(CharSequence str0) {
    	return encode(false, str0);
    }


    /** {@inheritDoc} */
    @Override
    public byte[] encode(boolean udh, CharSequence str0) {
    //public final byte[] encode(boolean udh, CharSequence str0) {
        if (str0 == null) {
            return null;
        }
        
        if (udh) {
        	int udhl = str0.charAt(0) + 1;
        	CharSequence udhChars = str0.subSequence(0, udhl);
        	byte[] udhBytes = udhChars.toString().getBytes();
        	CharSequence message = str0.subSequence(udhl, str0.length());
        	byte[] messageBytes = encodeCharSequence(message);
        	byte[] bytes = concatByteArrays(udhBytes, messageBytes);
        	return bytes;
        } else {
            return encodeCharSequence(str0);        	
        }
    }
    
    private byte[] concatByteArrays(byte[] udhBytes, byte[] messageBytes) {
    	byte[] bytes = new byte[udhBytes.length + messageBytes.length];
    	System.arraycopy(udhBytes, 0, bytes, 0, udhBytes.length);
    	System.arraycopy(messageBytes, 0, bytes, udhBytes.length, messageBytes.length);
    	return bytes;
    }
    

}
