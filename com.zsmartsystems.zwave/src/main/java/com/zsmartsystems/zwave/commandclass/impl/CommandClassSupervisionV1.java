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
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SUPERVISION</b> version <b>1</b>.<br>
 *
 * Command Class Supervision<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSupervisionV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSupervisionV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_SUPERVISION
     */
    public final static int COMMAND_CLASS_KEY = 0x6C;

    /**
     * Supervision Get Command Constant
     */
    public final static int SUPERVISION_GET = 0x01;
    /**
     * Supervision Report Command Constant
     */
    public final static int SUPERVISION_REPORT = 0x02;

    /**
     * Creates a new message with the SUPERVISION_GET command.<br>
     *
     * Supervision Get<br>
     *
     *
     * @param sessionId {@link Integer}
     * @param statusUpdates {@link Boolean}
     * @param encapsulatedCommandLength {@link Integer}
     * @param encapsulatedCommand {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSupervisionGet(Integer sessionId, Boolean statusUpdates, Integer encapsulatedCommandLength,
            byte[] encapsulatedCommand) {
        logger.debug("Creating command message SUPERVISION_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SUPERVISION_GET);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= sessionId & 0x3F;
        valProperties1 |= statusUpdates ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Encapsulated Command Length'
        outputData.write(encapsulatedCommandLength);

        // Process 'Encapsulated Command'
        try {
            outputData.write(encapsulatedCommand);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SUPERVISION_GET command<br>
     *
     * Supervision Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SESSION_ID {@link Integer}
     * <li>STATUS_UPDATES {@link Boolean}
     * <li>ENCAPSULATED_COMMAND_LENGTH {@link Integer}
     * <li>ENCAPSULATED_COMMAND {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSupervisionGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        response.put("SESSION_ID", Integer.valueOf(payload[msgOffset] & 0x3F));
        response.put("STATUS_UPDATES", Boolean.valueOf((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'Encapsulated Command Length'
        response.put("ENCAPSULATED_COMMAND_LENGTH", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Encapsulated Command'
        int valEncapsulatedCommand = 0;
        int lenEncapsulatedCommand = payload[msgOffset - 1];
        for (int cntEncapsulatedCommand = 0; cntEncapsulatedCommand < lenEncapsulatedCommand; cntEncapsulatedCommand++) {
            valEncapsulatedCommand = (valEncapsulatedCommand << 8) + payload[msgOffset + cntEncapsulatedCommand];
        }
        response.put("ENCAPSULATED_COMMAND", valEncapsulatedCommand);
        msgOffset += lenEncapsulatedCommand;

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SUPERVISION_REPORT command.<br>
     *
     * Supervision Report<br>
     *
     *
     * @param sessionId {@link Integer}
     * @param moreStatusUpdates {@link Boolean}
     * @param status {@link String}
     * @param duration {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSupervisionReport(Integer sessionId, Boolean moreStatusUpdates, String status,
            Integer duration) {
        logger.debug("Creating command message SUPERVISION_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SUPERVISION_REPORT);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= sessionId & 0x3F;
        valProperties1 |= moreStatusUpdates ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Status'
        switch (status) {
            case "NO_SUPPORT":
                outputData.write(0x00);
                break;
            case "WORKING":
                outputData.write(0x01);
                break;
            case "FAIL":
                outputData.write(0x02);
                break;
            case "BUSY":
                outputData.write(0x03);
                break;
            case "SUCCESS":
                outputData.write(0xFF);
                break;
            default:
                throw new IllegalArgumentException("Unknown constant value for status: " + status);
        }

        // Process 'Duration'
        outputData.write(duration);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SUPERVISION_REPORT command<br>
     *
     * Supervision Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SESSION_ID {@link Integer}
     * <li>MORE_STATUS_UPDATES {@link Boolean}
     * <li>STATUS {@link String}
     * <li>DURATION {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSupervisionReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("SESSION_ID", Integer.valueOf(payload[2] & 0x3F));
        response.put("MORE_STATUS_UPDATES", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Process 'Status'
        switch ((int) payload[3]) {
            case (byte) 0x00:
                response.put("STATUS", "NO_SUPPORT");
                break;
            case (byte) 0x01:
                response.put("STATUS", "WORKING");
                break;
            case (byte) 0x02:
                response.put("STATUS", "FAIL");
                break;
            case (byte) 0x03:
                response.put("STATUS", "BUSY");
                break;
            case (byte) 0xFF:
                response.put("STATUS", "SUCCESS");
                break;
            default:
                logger.debug("Unknown value {} for constant 'STATUS'", String.format("%02X", payload[3]));
                response.put("STATUS", "UNKNOWN_" + String.format("%02X", payload[3]));
                break;
        }

        // Process 'Duration'
        response.put("DURATION", Integer.valueOf(payload[4]));

        // Return the map of processed response data;
        return response;
    }

}
