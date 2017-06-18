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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_THERMOSTAT_FAN_MODE</b> version <b>1</b>.
 * <p>
 * Command Class Thermostat Fan Mode
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x44.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassThermostatFanModeV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassThermostatFanModeV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_THERMOSTAT_FAN_MODE
     */
    public final static int COMMAND_CLASS_KEY = 0x44;

    /**
     * Thermostat Fan Mode Set Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_SET = 0x01;
    /**
     * Thermostat Fan Mode Get Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_GET = 0x02;
    /**
     * Thermostat Fan Mode Report Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_REPORT = 0x03;
    /**
     * Thermostat Fan Mode Supported Get Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_SUPPORTED_GET = 0x04;
    /**
     * Thermostat Fan Mode Supported Report Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_SUPPORTED_REPORT = 0x05;

    /**
     * Map holding constants for ThermostatFanModeSetFanMode
     */
    private static Map<Integer, String> constantThermostatFanModeSetFanMode = new HashMap<Integer, String>();

    /**
     * Map holding constants for ThermostatFanModeSupportedReportBitMask
     */
    private static Map<Integer, String> constantThermostatFanModeSupportedReportBitMask = new HashMap<Integer, String>();

    /**
     * Map holding constants for ThermostatFanModeReportFanMode
     */
    private static Map<Integer, String> constantThermostatFanModeReportFanMode = new HashMap<Integer, String>();

    static {
        // Constants for ThermostatFanModeSetFanMode
        constantThermostatFanModeSetFanMode.put(0x00, "AUTO_LOW");
        constantThermostatFanModeSetFanMode.put(0x01, "LOW");
        constantThermostatFanModeSetFanMode.put(0x02, "AUTO_HIGH");
        constantThermostatFanModeSetFanMode.put(0x03, "HIGH");

        // Constants for ThermostatFanModeSupportedReportBitMask
        constantThermostatFanModeSupportedReportBitMask.put(0x00, "AUTO");
        constantThermostatFanModeSupportedReportBitMask.put(0x01, "ON");
        constantThermostatFanModeSupportedReportBitMask.put(0x02, "AUTO_HIGH");
        constantThermostatFanModeSupportedReportBitMask.put(0x03, "ON_HIGH");

        // Constants for ThermostatFanModeReportFanMode
        constantThermostatFanModeReportFanMode.put(0x00, "AUTO_LOW");
        constantThermostatFanModeReportFanMode.put(0x01, "LOW");
        constantThermostatFanModeReportFanMode.put(0x02, "AUTO_HIGH");
        constantThermostatFanModeReportFanMode.put(0x03, "HIGH");
    }

    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_SET command.
     * <p>
     * Thermostat Fan Mode Set
     *
     * @param fanMode {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>AUTO_LOW
     *            <li>LOW
     *            <li>AUTO_HIGH
     *            <li>HIGH
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeSet(String fanMode) {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_SET);

        // Process 'Level'
        int varFanMode = Integer.MAX_VALUE;
        for (Integer entry : constantThermostatFanModeSetFanMode.keySet()) {
            if (constantThermostatFanModeSetFanMode.get(entry).equals(fanMode)) {
                varFanMode = entry;
                break;
            }
        }
        if (varFanMode == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Unknown constant value '" + fanMode + "' for fanMode");
        }
        outputData.write(varFanMode & 0x0F);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_SET command.
     * <p>
     * Thermostat Fan Mode Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>FAN_MODE {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>AUTO_LOW
     * <li>LOW
     * <li>AUTO_HIGH
     * <li>HIGH
     * </ul>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Level'
        response.put("FAN_MODE", constantThermostatFanModeSetFanMode.get(payload[2] & 0x0F));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_GET command.
     * <p>
     * Thermostat Fan Mode Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeGet() {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_GET command.
     * <p>
     * Thermostat Fan Mode Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_REPORT command.
     * <p>
     * Thermostat Fan Mode Report
     *
     * @param fanMode {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>AUTO_LOW
     *            <li>LOW
     *            <li>AUTO_HIGH
     *            <li>HIGH
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeReport(String fanMode) {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_REPORT);

        // Process 'Level'
        int varFanMode = Integer.MAX_VALUE;
        for (Integer entry : constantThermostatFanModeReportFanMode.keySet()) {
            if (constantThermostatFanModeReportFanMode.get(entry).equals(fanMode)) {
                varFanMode = entry;
                break;
            }
        }
        if (varFanMode == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Unknown constant value '" + fanMode + "' for fanMode");
        }
        outputData.write(varFanMode & 0x0F);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_REPORT command.
     * <p>
     * Thermostat Fan Mode Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>FAN_MODE {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>AUTO_LOW
     * <li>LOW
     * <li>AUTO_HIGH
     * <li>HIGH
     * </ul>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Level'
        response.put("FAN_MODE", constantThermostatFanModeReportFanMode.get(payload[2] & 0x0F));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_SUPPORTED_GET command.
     * <p>
     * Thermostat Fan Mode Supported Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeSupportedGet() {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_SUPPORTED_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_SUPPORTED_GET command.
     * <p>
     * Thermostat Fan Mode Supported Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_SUPPORTED_REPORT command.
     * <p>
     * Thermostat Fan Mode Supported Report
     *
     * @param bitMask {@link List<String>}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>AUTO
     *            <li>ON
     *            <li>AUTO_HIGH
     *            <li>ON_HIGH
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeSupportedReport(List<String> bitMask) {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_SUPPORTED_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_SUPPORTED_REPORT);

        // Process 'Bit Mask'
        int valBitMask = 0;
        for (String value : bitMask) {
            boolean foundBitMask = false;
            for (Integer entry : constantThermostatFanModeSupportedReportBitMask.keySet()) {
                if (constantThermostatFanModeSupportedReportBitMask.get(entry).equals(value)) {
                    foundBitMask = true;
                    valBitMask += entry;
                    break;
                }
            }
            if (!foundBitMask) {
                throw new IllegalArgumentException("Unknown constant value '" + bitMask + "' for bitMask");
            }
        }
        outputData.write(valBitMask);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_SUPPORTED_REPORT command.
     * <p>
     * Thermostat Fan Mode Supported Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>BIT_MASK {@link List}<{@link String}>
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>AUTO
     * <li>ON
     * <li>AUTO_HIGH
     * <li>ON_HIGH
     * </ul>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Bit Mask'
        List<String> responseBitMask = new ArrayList<String>();
        for (int cntBitMask = 0; cntBitMask < (payload.length - 2) * 8; cntBitMask++) {
            if ((payload[2 + (cntBitMask / 8)] & (1 << cntBitMask % 8)) == 0) {
                continue;
            }
            responseBitMask.add(constantThermostatFanModeSupportedReportBitMask.get(cntBitMask));
        }
        response.put("BIT_MASK", responseBitMask);

        // Return the map of processed response data;
        return response;
    }
}
