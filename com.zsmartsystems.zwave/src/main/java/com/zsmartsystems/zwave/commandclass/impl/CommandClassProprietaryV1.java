/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_PROPRIETARY</b> version <b>1</b>.
 * <p>
 * Command Class Proprietary
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassProprietaryV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassProprietaryV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_PROPRIETARY
     */
    public final static int COMMAND_CLASS_KEY = 0x88;

    /**
     * Proprietary Set Command Constant
     */
    public final static int PROPRIETARY_SET = 0x01;
    /**
     * Proprietary Get Command Constant
     */
    public final static int PROPRIETARY_GET = 0x02;
    /**
     * Proprietary Report Command Constant
     */
    public final static int PROPRIETARY_REPORT = 0x03;


    /**
     * Creates a new message with the PROPRIETARY_SET command.
     * <p>
     * Proprietary Set
     *
     * @param data {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProprietarySet(byte[] data) {
        logger.debug("Creating command message PROPRIETARY_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROPRIETARY_SET);

        // Process 'Data'
        if (data != null) {
            try {
                outputData.write(data);
            } catch (IOException e) {
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROPRIETARY_SET command.
     * <p>
     * Proprietary Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>DATA {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProprietarySet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Data'
        ByteArrayOutputStream valData = new ByteArrayOutputStream();
        while (msgOffset < payload.length) {
            valData.write(payload[msgOffset]);
            msgOffset++;
        }
        response.put("DATA", valData);

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the PROPRIETARY_GET command.
     * <p>
     * Proprietary Get
     *
     * @param data {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProprietaryGet(byte[] data) {
        logger.debug("Creating command message PROPRIETARY_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROPRIETARY_GET);

        // Process 'Data'
        if (data != null) {
            try {
                outputData.write(data);
            } catch (IOException e) {
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROPRIETARY_GET command.
     * <p>
     * Proprietary Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>DATA {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProprietaryGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Data'
        ByteArrayOutputStream valData = new ByteArrayOutputStream();
        while (msgOffset < payload.length) {
            valData.write(payload[msgOffset]);
            msgOffset++;
        }
        response.put("DATA", valData);

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the PROPRIETARY_REPORT command.
     * <p>
     * Proprietary Report
     *
     * @param data {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProprietaryReport(byte[] data) {
        logger.debug("Creating command message PROPRIETARY_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROPRIETARY_REPORT);

        // Process 'Data'
        if (data != null) {
            try {
                outputData.write(data);
            } catch (IOException e) {
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROPRIETARY_REPORT command.
     * <p>
     * Proprietary Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>DATA {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProprietaryReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Data'
        ByteArrayOutputStream valData = new ByteArrayOutputStream();
        while (msgOffset < payload.length) {
            valData.write(payload[msgOffset]);
            msgOffset++;
        }
        response.put("DATA", valData);

        // Return the map of processed response data;
        return response;
    }

}
