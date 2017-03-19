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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_THERMOSTAT_FAN_STATE</b> version <b>2</b>.<br>
 * <p>
 * Command Class Thermostat Fan State<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
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
     * Creates a new message with the THERMOSTAT_FAN_STATE_GET command.<br>
     * <p>
     * Thermostat Fan State Get<br>
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
     * Processes a received frame with the THERMOSTAT_FAN_STATE_GET command<br>
     * <p>
     * Thermostat Fan State Get<br>
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
     * Creates a new message with the THERMOSTAT_FAN_STATE_REPORT command.<br>
     * <p>
     * Thermostat Fan State Report<br>
     *
     * @param fanOperatingState {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanStateReport(String fanOperatingState) {
        logger.debug("Creating command message THERMOSTAT_FAN_STATE_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_STATE_REPORT);

        // Process 'Level'
        int valfanOperatingState;
        switch (fanOperatingState) {
            case "IDLE":
                valfanOperatingState = 0;
                break;
            case "RUNNING":
                valfanOperatingState = 1;
                break;
            case "RUNNING_HIGH":
                valfanOperatingState = 2;
                break;
            case "RUNNING_MEDIUM":
                valfanOperatingState = 3;
                break;
            case "CIRCULATION":
                valfanOperatingState = 4;
                break;
            case "HUMIDITY_CIRCULATION":
                valfanOperatingState = 5;
                break;
            case "RIGHT_LEFT_CIRCULATION":
                valfanOperatingState = 6;
                break;
            case "UP_DOWN_CIRCULATION":
                valfanOperatingState = 7;
                break;
            case "QUIET_CIRCULATION":
                valfanOperatingState = 8;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for fanOperatingState: " + fanOperatingState);
        }
        outputData.write(valfanOperatingState & 0x0F);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_STATE_REPORT command<br>
     * <p>
     * Thermostat Fan State Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>FAN_OPERATING_STATE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanStateReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Level'
        switch (payload[2] & 0x0F) {
            case 0x00:
                response.put("FAN_OPERATING_STATE", "IDLE");
                break;
            case 0x01:
                response.put("FAN_OPERATING_STATE", "RUNNING");
                break;
            case 0x02:
                response.put("FAN_OPERATING_STATE", "RUNNING_HIGH");
                break;
            case 0x03:
                response.put("FAN_OPERATING_STATE", "RUNNING_MEDIUM");
                break;
            case 0x04:
                response.put("FAN_OPERATING_STATE", "CIRCULATION");
                break;
            case 0x05:
                response.put("FAN_OPERATING_STATE", "HUMIDITY_CIRCULATION");
                break;
            case 0x06:
                response.put("FAN_OPERATING_STATE", "RIGHT_LEFT_CIRCULATION");
                break;
            case 0x07:
                response.put("FAN_OPERATING_STATE", "UP_DOWN_CIRCULATION");
                break;
            case 0x08:
                response.put("FAN_OPERATING_STATE", "QUIET_CIRCULATION");
                break;
            default:
                logger.debug("Unknown enum value {} for FAN_OPERATING_STATE", String.format("0x%02X", 2));
        }

        // Return the map of processed response data;
        return response;
    }

}
