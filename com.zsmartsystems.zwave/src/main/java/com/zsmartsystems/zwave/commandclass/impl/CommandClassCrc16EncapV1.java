/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_CRC_16_ENCAP</b> version <b>1</b>.<br>
 *
 * Command Class CRC16 Encap<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassCrc16EncapV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassCrc16EncapV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_CRC_16_ENCAP
     */
    public final static int COMMAND_CLASS_KEY = 0x56;

    /**
     * CRC16 Encap Command Constant
     */
    public final static int CRC_16_ENCAP = 0x01;

    /**
     * Creates a new message with the CRC_16_ENCAP command.<br>
     *
     * CRC16 Encap<br>
     *
     *
     * @param commandClass {@link Integer}
     * @param command {@link Integer}
     * @param data {@link int[]}
     * @param checksum {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getCrc16Encap(Integer commandClass, Integer command, int[] data, Integer checksum) {
        logger.debug("Creating command message CRC_16_ENCAP version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(CRC_16_ENCAP);

        // Process 'Command Class'
        outputData.write(commandClass);

        // Process 'Command'
        outputData.write(command);

        // Process 'Data'
        for (int cntData = 0; cntData < data.length; cntData++) {
            outputData.write(data[cntData]);
        }

        // Process 'Checksum'
        outputData.write((checksum >> 8) & 0xff);
        outputData.write(checksum & 0xff);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the CRC_16_ENCAP command<br>
     *
     * CRC16 Encap<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>COMMAND_CLASS {@link Integer}
     * <li>COMMAND {@link Integer}
     * <li>DATA {@link int[]}
     * <li>CHECKSUM {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleCrc16Encap(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Command Class'
        response.put("COMMAND_CLASS", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Command'
        response.put("COMMAND", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Data'
        int lenData = payload.length - msgOffset;
        int[] valData = new int[lenData];
        for (int cntData = 0; cntData < lenData; cntData++) {
            valData[cntData] = payload[cntData + msgOffset];
        }
        response.put("DATA", valData);

        // Process 'Checksum'
        response.put("CHECKSUM", Integer.valueOf(payload[msgOffset] << 8 + payload[msgOffset + 12]));
        msgOffset += 2;

        // Return the map of processed response data;
        return response;
    }

}
