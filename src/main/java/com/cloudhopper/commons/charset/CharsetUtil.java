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

import java.util.HashMap;

/**
 *
 * @author joelauer
 * @author John Woolf (twitter: @jwoolf330 or <a href="http://twitter.com/jwoolf330" target=window>http://twitter.com/jwoolf330</a>)
 */
public class CharsetUtil {
    public static final HashMap<String,Charset> charsets;

    public static final String NAME_ISO_8859_1 = "ISO-8859-1";
    public static final String NAME_ISO_8859_15 = "ISO-8859-15";
    public static final String NAME_GSM = "GSM";
    public static final String NAME_PACKED_GSM = "PACKED-GSM";
    public static final String NAME_UCS_2 = "UCS-2";
    public static final String NAME_UTF_8 = "UTF-8";
    // special charset for "Airwide SMSCs" that have a unique GSM mapping
    public static final String NAME_AIRWIDE_IA5 = "AIRWIDE-IA5";
    // special charset for "Vodafone M2" SMSC that has a unique GSM mapping
    public static final String NAME_VFD2_GSM = "VFD2-GSM";
    // special charset for "Vodafone Turkey" SMSC that has a unique GSM mapping
    public static final String NAME_VFTR_GSM = "VFTR-GSM";
    /** Alias for "PACKED-GSM" */
    public static final String NAME_GSM7 = "GSM7";
    /** Alias for "GSM" */
    public static final String NAME_GSM8 = "GSM8";
    /** Alias for "AIRWIDE-IA5" */
    public static final String NAME_AIRWIDE_GSM = "AIRWIDE-GSM";


    public static final Charset CHARSET_ISO_8859_1 = new ISO88591Charset();
    public static final Charset CHARSET_ISO_8859_15 = new ISO885915Charset();
    public static final Charset CHARSET_GSM = new GSMCharset();
    public static final Charset CHARSET_PACKED_GSM = new PackedGSMCharset();
    public static final Charset CHARSET_UCS_2 = new UCS2Charset();
    public static final Charset CHARSET_UTF_8 = new UTF8Charset();
    public static final Charset CHARSET_AIRWIDE_IA5 = new AirwideIA5Charset();
    public static final Charset CHARSET_VFD2_GSM = new VFD2GSMCharset();
    public static final Charset CHARSET_VFTR_GSM = new VFTRGSMCharset();
    /** Alias for "PACKED-GSM" */
    public static final Charset CHARSET_GSM7 = CHARSET_PACKED_GSM;
    /** Alias for "GSM" */
    public static final Charset CHARSET_GSM8 = CHARSET_GSM;
    /** Alias for "AIRWIDE-IA5" */
    public static final Charset CHARSET_AIRWIDE_GSM = CHARSET_AIRWIDE_IA5;


    static {
        charsets = new HashMap<String,Charset>();
        charsets.put(NAME_ISO_8859_1, CHARSET_ISO_8859_1);
        charsets.put(NAME_ISO_8859_15, CHARSET_ISO_8859_15);
        charsets.put(NAME_GSM, CHARSET_GSM);
        charsets.put(NAME_PACKED_GSM, CHARSET_PACKED_GSM);
        charsets.put(NAME_UCS_2, CHARSET_UCS_2);
        charsets.put(NAME_UTF_8, CHARSET_UTF_8);
        charsets.put(NAME_AIRWIDE_IA5, CHARSET_AIRWIDE_IA5);
        charsets.put(NAME_VFD2_GSM, CHARSET_VFD2_GSM);
        charsets.put(NAME_VFTR_GSM, CHARSET_VFTR_GSM);
        charsets.put(NAME_GSM7, CHARSET_GSM7);
        charsets.put(NAME_GSM8, CHARSET_GSM8);
        charsets.put(NAME_AIRWIDE_GSM, CHARSET_AIRWIDE_GSM);
    }

    static public HashMap<String,Charset> getCharsetMap() {
        return charsets;
    }

    static public Charset map(String charsetName) {
        String upperCharsetName = charsetName.toUpperCase();
        return charsets.get(upperCharsetName);
    }

    /** @deprecated Use {@link #encode(boolean, CharSequence, String)} instead. */
    @Deprecated
    static public byte[] encode(CharSequence str0, String charsetName) {
        return encode(false, str0, charsetName);
    }

    /**
     * @param udh Whether the <code>CharSequence</code> contains a <tt>UDH</tt>
     * @param str0 The user data <code>CharSequence</code>
     * @param charsetName The character encoding name
     * 
     * @return The encoded byte array 
     * @see #encode(boolean, CharSequence, Charset)
     */
    static public byte[] encode(boolean udh, CharSequence str0, String charsetName) {
        Charset charset = map(charsetName);
        if (charset == null) {
            return null;
        }
        return encode(udh, str0, charset);
    }

    /** @deprecated Use {@link #encode(boolean, CharSequence, Charset)} instead. */
    @Deprecated
    static public byte[] encode(CharSequence str0, Charset charset) {
        return encode(false, str0, charset);
    }

    /**
     * @param udh Whether the <code>CharSequence</code> contains a <tt>UDH</tt>
     * @param str0 The user data <code>CharSequence</code>
     * @param charset The character encoding
     * 
     * @return The encoded byte array 
     * @see Charset#encode(boolean, CharSequence)
     */
    static public byte[] encode(boolean udh, CharSequence str0, Charset charset) {
        return charset.encode(udh, str0);
    }

    /** @deprecated Use {@link #decode(boolean, byte[], StringBuilder, String)} instead. */
    @Deprecated
    static public void decode(byte[] bytes, StringBuilder buffer, String charsetName) {
        decode(false, bytes, buffer, charsetName);
    }

    /** 
     * @param udh Whether the bytes contain a <tt>UDH</tt>
     * @param bytes The user data bytes
     * @param buffer The buffer where the decoded data is copied
     * @param charsetName The character encoding name
     * 
     * @see #decode(boolean, byte[], StringBuilder, Charset)
     */
    static public void decode(boolean udh, byte[] bytes, StringBuilder buffer, String charsetName) {
        Charset charset = map(charsetName);
        if (charset == null) {
            // do nothing
            return;
        }
        decode(udh, bytes, buffer, charset);
    }

    /** @deprecated Use {@link #decode(boolean, byte[], StringBuilder, Charset)} instead. */
    @Deprecated
    static public void decode(byte[] bytes, StringBuilder buffer, Charset charset) {
        decode(false, bytes, buffer, charset);
    }

    /** 
     * @param udh Whether the bytes contain a <tt>UDH</tt>
     * @param bytes The user data bytes
     * @param buffer The buffer where the decoded data is copied
     * @param charset The character encoding
     * 
     * @see Charset#decode(boolean, byte[], StringBuilder)
     */
    static public void decode(boolean udh, byte[] bytes, StringBuilder buffer, Charset charset) {
        charset.decode(udh, bytes, buffer);
    }

    /** @deprecated Use {@link #decode(boolean, byte[], String)} instead. */
    @Deprecated
    static public String decode(byte[] bytes, String charsetName) {
        return decode(false, bytes, charsetName);
    }

    /**
     * @param udh Whether the bytes contain a <tt>UDH</tt>
     * @param bytes The user data bytes
     * @param charsetName The character encoding name
     * 
     * @return The decoded user data as a string
     * @see #decode(boolean, byte[], Charset)
     */
    static public String decode(boolean udh, byte[] bytes, String charsetName) {
        Charset charset = map(charsetName);
        if (charset == null) {
            return null;
        }
        return decode(udh, bytes, charset);
    }

    /** @deprecated Use {@link #decode(boolean, byte[], Charset)} instead. */
    @Deprecated
    static public String decode(byte[] bytes, Charset charset) {
        return decode(false, bytes, charset);
    }

    /** 
     * @param udh Whether the bytes contain a <tt>UDH</tt>
     * @param bytes The user data bytes
     * @param charset The character encoding
     * 
     * @return The decoded user data as a string
     * @see Charset#decode(boolean, byte[], StringBuilder)
     */
    static public String decode(boolean udh, byte[] bytes, Charset charset) {
        StringBuilder buffer = new StringBuilder(charset.estimateDecodeCharLength(bytes));
        charset.decode(udh, bytes, buffer);
        return buffer.toString();
    }

    /** @deprecated Use {@link #normalize(boolean, CharSequence, String) instead. */
    @Deprecated
    static public String normalize(CharSequence str0, String charsetName) {
        return normalize(false, str0, charsetName);
    }

    /**
     * @param udh Whether the bytes contain a <tt>UDH</tt>
     * @param str0 The user data <code>CharSequence</code>
     * @param charsetName The character encoding name
     * 
     * @return The normalized string
     * @see Charset#normalize(boolean, CharSequence)
     */
    static public String normalize(boolean udh, CharSequence str0, String charsetName) {
        Charset charset = map(charsetName);
        if (charset == null) {
            throw new IllegalArgumentException("Unsupported charset [" + charsetName + "]");
        }
        return normalize(udh, str0, charset);
    }

    /** @deprecated Use {@link #normalize(boolean, CharSequence, Charset) instead. */
    @Deprecated
    static public String normalize(CharSequence str0, Charset charset) {
        return normalize(false, str0, charset);
    }

    /**
     * @param udh Whether the bytes contain a <tt>UDH</tt>
     * @param str0 The user data <code>CharSequence</code>
     * @param charset The character encoding
     * 
     * @return The normalized string
     * @see Charset#normalize(boolean, CharSequence)
     */
    static public String normalize(boolean udh, CharSequence str0, Charset charset) {
        return charset.normalize(udh, str0);
    }

}
