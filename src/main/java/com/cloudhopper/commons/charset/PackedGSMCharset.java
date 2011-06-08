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
 * The <b>PackedGSMCharset</b> class handles the encoding and decoding of the
 * GSM default encoding charset, with packing as per GSM 03.38 spec.
 *
 * The encoding and decoding are based on the mapping at
 * http://www.unicode.org/Public/MAPPINGS/ETSI/GSM0338.TXT
 * 
 * @author joelauer
 */
public class PackedGSMCharset extends GSMCharset {

    @Override
    public byte[] encode(boolean udh, CharSequence str0) {
        // delegate to parent first
        byte[] unpacked = super.encode(udh, str0);
        // return a "packed" version of it
        return GSMBitPacker.pack(udh, unpacked);
    }
    
    @Override
    public void decode(boolean udh, byte[] bytes, StringBuilder buffer) {
        // unpack the byte array first
        byte[] unpacked = GSMBitPacker.unpack(udh, bytes);
        // delegate to parent
        super.decode(udh, unpacked, buffer);
    }

}
