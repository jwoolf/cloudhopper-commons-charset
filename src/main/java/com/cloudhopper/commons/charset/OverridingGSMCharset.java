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
 * 
 * @author John Woolf (twitter: @jwoolf330 or <a href="http://twitter.com/jwoolf330" target=window>http://twitter.com/jwoolf330</a>)
 */
public abstract class OverridingGSMCharset extends GSMCharset {

	protected abstract void overrideEncoding(byte[] messageBytes);
	protected abstract byte[] overrideDecoding(byte[] messageBytes);
	
    @Override
    public final byte[] encode(final boolean udh, final CharSequence str0) {
        // since byte values may need to be converted we'll first convert to GSM
        byte[] gsmBytes = super.encode(udh, str0);

        // NOTE: for the future, consider refactoring overrideEncoding to provide indication of whether byte array was modified
        // to prevent unnecessary new byte array creation and copy operations. Alternatively, use a wrapper to operate on subsequence.
        if (udh) { 
            int udhl = getUserDataHeaderLength(str0);
            byte[] messageBytes = new byte[gsmBytes.length - udhl];
            System.arraycopy(gsmBytes, udhl, messageBytes, 0, messageBytes.length);
            overrideEncoding(messageBytes);
            System.arraycopy(messageBytes, 0, gsmBytes, udhl, messageBytes.length);        	
        } else {
        	overrideEncoding(gsmBytes);
        }
        
        return gsmBytes;
    }    

    @Override
    public final void decode(final boolean udh, final byte[] userData, final StringBuilder buffer) {
    	byte[] bytes;
    	byte[] messageBytes = getMessageBytes(udh, userData);
     	byte[] modifiedMessageBytes = overrideDecoding(messageBytes);
    	if (modifiedMessageBytes == null) {
    		bytes = userData;
    	} else {
    		messageBytes = modifiedMessageBytes;
        	if (udh) {
            	bytes = new byte[userData.length];
                System.arraycopy(userData, 0, bytes, 0, userData.length - messageBytes.length); // copy udh into byte array
                System.arraycopy(messageBytes, 0, bytes, userData.length - messageBytes.length, messageBytes.length); // copy message data into byte array
        	} else {
        		bytes = messageBytes;
        	}
    	}
        super.decode(udh, bytes, buffer);
    }

    private byte[] getMessageBytes(boolean udh, byte[] userData) {
    	if (udh) {
    		int udhl = getUserDataHeaderLength(userData);
            byte[] messageBytes = new byte[userData.length - udhl];
            System.arraycopy(userData, udhl, messageBytes, 0, messageBytes.length);
            return messageBytes;
    	} else {
    		return userData;
    	}
    }
    

}
