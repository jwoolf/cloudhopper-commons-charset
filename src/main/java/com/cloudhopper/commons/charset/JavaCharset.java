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

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 *
 * @author joelauer
 * @author John Woolf (twitter: @jwoolf330 or <a href="http://twitter.com/jwoolf330" target=window>http://twitter.com/jwoolf330</a>)
 */
public abstract class JavaCharset extends BaseCharset {
    private static final Logger logger = Logger.getLogger(JavaCharset.class);

    private final java.nio.charset.Charset charset;

    public JavaCharset(String charsetName) {
        try {
            this.charset = java.nio.charset.Charset.forName(charsetName);
        } catch (UnsupportedCharsetException e) {
            throw new IllegalArgumentException("Unsupported Java charset [" + charsetName + "]");
        }
    }

    @Override
    protected final byte[] encodeCharSequence(CharSequence str0) {
        return str0.toString().getBytes(charset);        	    	
    }
    
    @Override
    protected final void decodeToBuffer(byte[] bytes, StringBuilder buffer) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        CharBuffer charBuffer = charset.decode(byteBuffer);
        buffer.append(charBuffer);        
    }
    

}