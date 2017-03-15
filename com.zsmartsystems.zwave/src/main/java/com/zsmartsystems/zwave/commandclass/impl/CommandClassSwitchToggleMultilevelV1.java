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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SWITCH_TOGGLE_MULTILEVEL</b> version <b>1</b>.<br>
 *
 * Command Class Switch Toggle Multilevel<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSwitchToggleMultilevelV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSwitchToggleMultilevelV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_SWITCH_TOGGLE_MULTILEVEL
     */
    public final static int COMMAND_CLASS_KEY = 0x29;

    /**
     * Switch Toggle Multilevel Set Command Constant
     * SWITCH_TOGGLE_MULTILEVEL_SET
     */
    public final static int SWITCH_TOGGLE_MULTILEVEL_SET = 0x01;
    /**
     * Switch Toggle Multilevel Get Command Constant
     */
    public final static int SWITCH_TOGGLE_MULTILEVEL_GET = 0x02;
    /**
     * Switch Toggle Multilevel Report Command Constant
     */
    public final static int SWITCH_TOGGLE_MULTILEVEL_REPORT = 0x03;
    /**
     * Switch Toggle Multilevel Start Level Change Command Constant
     */
    public final static int SWITCH_TOGGLE_MULTILEVEL_START_LEVEL_CHANGE = 0x04;
    /**
     * Switch Toggle Multilevel Stop Level Change Command Constant
     */
    public final static int SWITCH_TOGGLE_MULTILEVEL_STOP_LEVEL_CHANGE = 0x05;

    /**
     * Creates a new message with the SWITCH_TOGGLE_MULTILEVEL_SET command.<br>
     *
     * Switch Toggle Multilevel Set<br>
     *
     * SWITCH_TOGGLE_MULTILEVEL_SET<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchToggleMultilevelSet() {
        logger.debug("Creating command message SWITCH_TOGGLE_MULTILEVEL_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_TOGGLE_MULTILEVEL_SET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_TOGGLE_MULTILEVEL_SET command<br>
     *
     * Switch Toggle Multilevel Set<br>
     *
     * SWITCH_TOGGLE_MULTILEVEL_SET<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchToggleMultilevelSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_TOGGLE_MULTILEVEL_GET command.<br>
     *
     * Switch Toggle Multilevel Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchToggleMultilevelGet() {
        logger.debug("Creating command message SWITCH_TOGGLE_MULTILEVEL_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_TOGGLE_MULTILEVEL_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_TOGGLE_MULTILEVEL_GET command<br>
     *
     * Switch Toggle Multilevel Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchToggleMultilevelGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_TOGGLE_MULTILEVEL_REPORT command.<br>
     *
     * Switch Toggle Multilevel Report<br>
     *
     *
     * @param value {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchToggleMultilevelReport(Integer value) {
        logger.debug("Creating command message SWITCH_TOGGLE_MULTILEVEL_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_TOGGLE_MULTILEVEL_REPORT);

        // Process 'Value'
        outputData.write(value);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_TOGGLE_MULTILEVEL_REPORT command<br>
     *
     * Switch Toggle Multilevel Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>VALUE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchToggleMultilevelReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Value'
        switch ((int) payload[2]) {
            case 0x00:
                response.put("VALUE", "OFF_DISABLE");
                break;
            case 0xFF:
                response.put("VALUE", "ON_ENABLE");
                break;
            default:
                logger.debug("");
                break;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_TOGGLE_MULTILEVEL_START_LEVEL_CHANGE command.<br>
     *
     * Switch Toggle Multilevel Start Level Change<br>
     *
     *
     * @param ignoreStartLevel {@link Boolean}
     * @param rollOver {@link Boolean}
     * @param startLevel {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchToggleMultilevelStartLevelChange(Boolean ignoreStartLevel, Boolean rollOver,
            Integer startLevel) {
        logger.debug("Creating command message SWITCH_TOGGLE_MULTILEVEL_START_LEVEL_CHANGE version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_TOGGLE_MULTILEVEL_START_LEVEL_CHANGE);

        // Process 'Level'
        int valLevel = 0;
        valLevel |= ignoreStartLevel ? 0x20 : 0;
        valLevel |= rollOver ? 0x80 : 0;
        outputData.write(valLevel);

        // Process 'Start Level'
        outputData.write(startLevel);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_TOGGLE_MULTILEVEL_START_LEVEL_CHANGE command<br>
     *
     * Switch Toggle Multilevel Start Level Change<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>IGNORE_START_LEVEL {@link Boolean}
     * <li>ROLL_OVER {@link Boolean}
     * <li>START_LEVEL {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchToggleMultilevelStartLevelChange(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Level'
        response.put("IGNORE_START_LEVEL", Boolean.valueOf((payload[2] & 0x20) != 0));
        response.put("ROLL_OVER", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Process 'Start Level'
        response.put("START_LEVEL", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_TOGGLE_MULTILEVEL_STOP_LEVEL_CHANGE command.<br>
     *
     * Switch Toggle Multilevel Stop Level Change<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchToggleMultilevelStopLevelChange() {
        logger.debug("Creating command message SWITCH_TOGGLE_MULTILEVEL_STOP_LEVEL_CHANGE version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_TOGGLE_MULTILEVEL_STOP_LEVEL_CHANGE);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_TOGGLE_MULTILEVEL_STOP_LEVEL_CHANGE command<br>
     *
     * Switch Toggle Multilevel Stop Level Change<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchToggleMultilevelStopLevelChange(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

}
