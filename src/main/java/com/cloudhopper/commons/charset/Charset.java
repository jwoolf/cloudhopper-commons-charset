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
 * Interface for any charset.
 * 
 * @author joelauer
 * @author John Woolf (twitter: @jwoolf330 or <a href="http://twitter.com/jwoolf330" target=window>http://twitter.com/jwoolf330</a>)
 */
public interface Charset {

    public int estimateEncodeByteLength(CharSequence str0);

    /**
     * @deprecated WARNING: method does not account for existence of a <tt>UDH</tt>
     * in the <code>CharSequence</code>.</p>
     * Use {@link #encode(boolean, CharSequence)} instead.</p>
     * 
     * Encode the Java string into a byte array.
     * 
     * @param str0 The Java string to convert into a byte array
     * @return A new byte array
     */
    public byte[] encode(CharSequence str0);

    /**
     * Encode the Java string into a byte array.</p> 
     * If <tt>udh == true</tt>, implementations should preserve (i.e. not encode) 
     * the <tt>UDH</tt> bytes while encoding the remaining message bytes accordingly. 
     * 
     * @param udh Whether or not the CharSequence contains bytes representing a <tt>UDH</tt>
     * @param str0 The Java string to convert into a byte array
     * 
     * @return A new byte array
     */
    public byte[] encode(boolean udh, CharSequence str0);

    public int estimateDecodeCharLength(byte[] bytes);

    /**
     * @deprecated WARNING: method does not account for existence of a <tt>UDH</tt>
     * in the byte array.</p>
     * Use {@link #decode(boolean, byte[], StringBuilder)} instead.</p>
     * 
     * Decode the byte array to a Java string that is appended to the buffer.
     * Implementations of this method will not change any of the byte values
     * contained in the byte array.
     * 
     * @param bytes The array of bytes to decode
     * @param buffer The String buffer to append chars to
     */
    public void decode(final byte[] bytes, StringBuilder buffer);

    /**
     * Decode the byte array to a Java string that is appended to the buffer.
     * Implementations of this method will not change any of the byte values
     * contained in the byte array.</p>
     * If <tt>udh == true</tt>, implementations should preserve (i.e. not decode) 
     * the <tt>UDH</tt> bytes while decoding the remaining message 
     * bytes accordingly. 
     * 
     * @param udh Whether or not the byte array contains bytes representing a <tt>UDH</tt>
     * @param bytes The array of bytes to decode
     * @param buffer The String buffer to append chars to
     */
    public void decode(boolean udh, final byte[] bytes, StringBuilder buffer);

    /**
     * Normalize the characters of the source string to characters that can be
     * represented by this charset. Any characters in the input String that
     * cannot be represented by this charset are replaced with a '?' (question
     * mark character).<br><br>
     * The default implementation of this method is partially inefficient by
     * first encoding the input String to a byte array representing this charset
     * followed by decoding the byte array back into a Java String. During this
     * double conversion, any characters in the original Java String that don't
     * exist in this charset are replaced with '?' (question mark characters)
     * and then decoded back into a new Java String.<br><br>
     * Some charsets may choose to override this default behavior to achieve a
     * more efficient implementation.
     *
     * @param str0 The source string to normalize
     * @return The normalized string
     */
    public String normalize(CharSequence str0);

}
