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
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SWITCH_TOGGLE_BINARY</b> version <b>1</b>.
 * <p>
 * Command Class Switch Toggle Binary
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x28.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSwitchToggleBinaryV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSwitchToggleBinaryV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_SWITCH_TOGGLE_BINARY
     */
    public final static int COMMAND_CLASS_KEY = 0x28;

    /**
     * Switch Toggle Binary Set Command Constant
     * SWITCH_TOGGLE_BINARY_SET
     */
    public final static int SWITCH_TOGGLE_BINARY_SET = 0x01;
    /**
     * Switch Toggle Binary Get Command Constant
     */
    public final static int SWITCH_TOGGLE_BINARY_GET = 0x02;
    /**
     * Switch Toggle Binary Report Command Constant
     */
    public final static int SWITCH_TOGGLE_BINARY_REPORT = 0x03;

    /**
     * Map holding constants for SwitchToggleBinaryReportValue
     */
    private static Map<Integer, String> constantSwitchToggleBinaryReportValue = new HashMap<Integer, String>();

    static {
        // Constants for SwitchToggleBinaryReportValue
        constantSwitchToggleBinaryReportValue.put(0x00, "OFF");
        constantSwitchToggleBinaryReportValue.put(0xFF, "ON");
    }

    /**
     * Creates a new message with the SWITCH_TOGGLE_BINARY_SET command.
     * <p>
     * Switch Toggle Binary Set
     * <p>
     * SWITCH_TOGGLE_BINARY_SET
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchToggleBinarySet() {
        logger.debug("Creating command message SWITCH_TOGGLE_BINARY_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_TOGGLE_BINARY_SET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_TOGGLE_BINARY_SET command.
     * <p>
     * Switch Toggle Binary Set
     * <p>
     * SWITCH_TOGGLE_BINARY_SET
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchToggleBinarySet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_TOGGLE_BINARY_GET command.
     * <p>
     * Switch Toggle Binary Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchToggleBinaryGet() {
        logger.debug("Creating command message SWITCH_TOGGLE_BINARY_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_TOGGLE_BINARY_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_TOGGLE_BINARY_GET command.
     * <p>
     * Switch Toggle Binary Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchToggleBinaryGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_TOGGLE_BINARY_REPORT command.
     * <p>
     * Switch Toggle Binary Report
     *
     * @param value {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>OFF
     *            <li>ON
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchToggleBinaryReport(String value) {
        logger.debug("Creating command message SWITCH_TOGGLE_BINARY_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_TOGGLE_BINARY_REPORT);

        // Process 'Value'
        boolean foundValue = false;
        for (Integer entry : constantSwitchToggleBinaryReportValue.keySet()) {
            if (constantSwitchToggleBinaryReportValue.get(entry).equals(value)) {
                outputData.write(entry);
                foundValue = true;
                break;
            }
        }
        if (!foundValue) {
            throw new IllegalArgumentException("Unknown constant value '" + value + "' for value");
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_TOGGLE_BINARY_REPORT command.
     * <p>
     * Switch Toggle Binary Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>VALUE {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>OFF
     * <li>ON
     * </ul>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchToggleBinaryReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Value'
        response.put("VALUE", constantSwitchToggleBinaryReportValue.get(payload[2] & 0xff));

        // Return the map of processed response data;
        return response;
    }
}
