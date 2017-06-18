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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_THERMOSTAT_FAN_STATE</b> version <b>2</b>.
 * <p>
 * Command Class Thermostat Fan State
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x45.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassThermostatFanStateV2 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassThermostatFanStateV2.class);

    /**
     * Integer command class key for COMMAND_CLASS_THERMOSTAT_FAN_STATE
     */
    public final static int COMMAND_CLASS_KEY = 0x45;

    /**
     * Thermostat Fan State Get Command Constant
     */
    public final static int THERMOSTAT_FAN_STATE_GET = 0x02;
    /**
     * Thermostat Fan State Report Command Constant
     */
    public final static int THERMOSTAT_FAN_STATE_REPORT = 0x03;

    /**
     * Map holding constants for ThermostatFanStateReportFanOperatingState
     */
    private static Map<Integer, String> constantThermostatFanStateReportFanOperatingState = new HashMap<Integer, String>();

    static {
        // Constants for ThermostatFanStateReportFanOperatingState
        constantThermostatFanStateReportFanOperatingState.put(0x00, "IDLE");
        constantThermostatFanStateReportFanOperatingState.put(0x01, "RUNNING");
        constantThermostatFanStateReportFanOperatingState.put(0x02, "RUNNING_HIGH");
        constantThermostatFanStateReportFanOperatingState.put(0x03, "RUNNING_MEDIUM");
        constantThermostatFanStateReportFanOperatingState.put(0x04, "CIRCULATION");
        constantThermostatFanStateReportFanOperatingState.put(0x05, "HUMIDITY_CIRCULATION");
        constantThermostatFanStateReportFanOperatingState.put(0x06, "RIGHT_LEFT_CIRCULATION");
        constantThermostatFanStateReportFanOperatingState.put(0x07, "UP_DOWN_CIRCULATION");
        constantThermostatFanStateReportFanOperatingState.put(0x08, "QUIET_CIRCULATION");
    }

    /**
     * Creates a new message with the THERMOSTAT_FAN_STATE_GET command.
     * <p>
     * Thermostat Fan State Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanStateGet() {
        logger.debug("Creating command message THERMOSTAT_FAN_STATE_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_STATE_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_STATE_GET command.
     * <p>
     * Thermostat Fan State Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanStateGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the THERMOSTAT_FAN_STATE_REPORT command.
     * <p>
     * Thermostat Fan State Report
     *
     * @param fanOperatingState {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>IDLE
     *            <li>RUNNING
     *            <li>RUNNING_HIGH
     *            <li>RUNNING_MEDIUM
     *            <li>CIRCULATION
     *            <li>HUMIDITY_CIRCULATION
     *            <li>RIGHT_LEFT_CIRCULATION
     *            <li>UP_DOWN_CIRCULATION
     *            <li>QUIET_CIRCULATION
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanStateReport(String fanOperatingState) {
        logger.debug("Creating command message THERMOSTAT_FAN_STATE_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_STATE_REPORT);

        // Process 'Level'
        int varFanOperatingState = Integer.MAX_VALUE;
        for (Integer entry : constantThermostatFanStateReportFanOperatingState.keySet()) {
            if (constantThermostatFanStateReportFanOperatingState.get(entry).equals(fanOperatingState)) {
                varFanOperatingState = entry;
                break;
            }
        }
        if (varFanOperatingState == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Unknown constant value '" + fanOperatingState + "' for fanOperatingState");
        }
        outputData.write(varFanOperatingState & 0x0F);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_STATE_REPORT command.
     * <p>
     * Thermostat Fan State Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>FAN_OPERATING_STATE {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>IDLE
     * <li>RUNNING
     * <li>RUNNING_HIGH
     * <li>RUNNING_MEDIUM
     * <li>CIRCULATION
     * <li>HUMIDITY_CIRCULATION
     * <li>RIGHT_LEFT_CIRCULATION
     * <li>UP_DOWN_CIRCULATION
     * <li>QUIET_CIRCULATION
     * </ul>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanStateReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Level'
        response.put("FAN_OPERATING_STATE", constantThermostatFanStateReportFanOperatingState.get(payload[2] & 0x0F));

        // Return the map of processed response data;
        return response;
    }
}
