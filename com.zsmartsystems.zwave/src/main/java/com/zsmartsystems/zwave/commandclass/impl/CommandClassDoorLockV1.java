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
import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_DOOR_LOCK</b> version <b>1</b>.<br>
 *
 * Command Class Door Lock<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassDoorLockV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassDoorLockV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_DOOR_LOCK
     */
    public final static int COMMAND_CLASS_KEY = 0x62;

    /**
     * Door Lock Operation Set Command Constant
     */
    public final static int DOOR_LOCK_OPERATION_SET = 0x01;
    /**
     * Door Lock Operation Get Command Constant
     */
    public final static int DOOR_LOCK_OPERATION_GET = 0x02;
    /**
     * Door Lock Operation Report Command Constant
     */
    public final static int DOOR_LOCK_OPERATION_REPORT = 0x03;
    /**
     * Door Lock Configuration Set Command Constant
     */
    public final static int DOOR_LOCK_CONFIGURATION_SET = 0x04;
    /**
     * Door Lock Configuration Get Command Constant
     */
    public final static int DOOR_LOCK_CONFIGURATION_GET = 0x05;
    /**
     * Door Lock Configuration Report Command Constant
     */
    public final static int DOOR_LOCK_CONFIGURATION_REPORT = 0x06;

    /**
     * Creates a new message with the DOOR_LOCK_OPERATION_SET command.<br>
     *
     * Door Lock Operation Set<br>
     *
     *
     * @param doorLockMode {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDoorLockOperationSet(String doorLockMode) {
        logger.debug("Creating command message DOOR_LOCK_OPERATION_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DOOR_LOCK_OPERATION_SET);

        // Process 'Door Lock Mode'
        switch (doorLockMode) {
            case "DOOR_UNSECURED":
                outputData.write(0x00);
                break;
            case "DOOR_UNSECURED_WITH_TIMEOUT":
                outputData.write(0x01);
                break;
            case "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES":
                outputData.write(0x10);
                break;
            case "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES_WITH_TIMEOUT":
                outputData.write(0x11);
                break;
            case "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES":
                outputData.write(0x20);
                break;
            case "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES_WITH_TIMEOUT":
                outputData.write(0x21);
                break;
            case "DOOR_SECURED":
                outputData.write(0xFF);
                break;
            default:
                throw new IllegalArgumentException("Unknown constant value for doorLockMode: " + doorLockMode);
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DOOR_LOCK_OPERATION_SET command<br>
     *
     * Door Lock Operation Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>DOOR_LOCK_MODE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDoorLockOperationSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Door Lock Mode'
        switch ((int) payload[2]) {
            case (byte) 0x00:
                response.put("DOOR_LOCK_MODE", "DOOR_UNSECURED");
                break;
            case (byte) 0x01:
                response.put("DOOR_LOCK_MODE", "DOOR_UNSECURED_WITH_TIMEOUT");
                break;
            case (byte) 0x10:
                response.put("DOOR_LOCK_MODE", "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES");
                break;
            case (byte) 0x11:
                response.put("DOOR_LOCK_MODE", "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES_WITH_TIMEOUT");
                break;
            case (byte) 0x20:
                response.put("DOOR_LOCK_MODE", "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES");
                break;
            case (byte) 0x21:
                response.put("DOOR_LOCK_MODE", "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES_WITH_TIMEOUT");
                break;
            case (byte) 0xFF:
                response.put("DOOR_LOCK_MODE", "DOOR_SECURED");
                break;
            default:
                logger.debug("Unknown value {} for constant 'DOOR_LOCK_MODE'", String.format("%02X", payload[2]));
                response.put("DOOR_LOCK_MODE", "UNKNOWN_" + String.format("%02X", payload[2]));
                break;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DOOR_LOCK_OPERATION_GET command.<br>
     *
     * Door Lock Operation Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDoorLockOperationGet() {
        logger.debug("Creating command message DOOR_LOCK_OPERATION_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DOOR_LOCK_OPERATION_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DOOR_LOCK_OPERATION_GET command<br>
     *
     * Door Lock Operation Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDoorLockOperationGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DOOR_LOCK_OPERATION_REPORT command.<br>
     *
     * Door Lock Operation Report<br>
     *
     *
     * @param doorLockMode {@link String}
     * @param insideDoorHandlesMode {@link Integer}
     * @param outsideDoorHandlesMode {@link Integer}
     * @param doorCondition {@link Integer}
     * @param lockTimeoutMinutes {@link Integer}
     * @param lockTimeoutSeconds {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDoorLockOperationReport(String doorLockMode, Integer insideDoorHandlesMode,
            Integer outsideDoorHandlesMode, Integer doorCondition, Integer lockTimeoutMinutes,
            Integer lockTimeoutSeconds) {
        logger.debug("Creating command message DOOR_LOCK_OPERATION_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DOOR_LOCK_OPERATION_REPORT);

        // Process 'Door Lock Mode'
        switch (doorLockMode) {
            case "DOOR_UNSECURED":
                outputData.write(0x00);
                break;
            case "DOOR_UNSECURED_WITH_TIMEOUT":
                outputData.write(0x01);
                break;
            case "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES":
                outputData.write(0x10);
                break;
            case "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES_WITH_TIMEOUT":
                outputData.write(0x11);
                break;
            case "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES":
                outputData.write(0x20);
                break;
            case "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES_WITH_TIMEOUT":
                outputData.write(0x21);
                break;
            case "DOOR_SECURED":
                outputData.write(0xFF);
                break;
            default:
                throw new IllegalArgumentException("Unknown constant value for doorLockMode: " + doorLockMode);
        }

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= insideDoorHandlesMode & 0x0F;
        valProperties1 |= ((outsideDoorHandlesMode << 4) & 0xF0);
        outputData.write(valProperties1);

        // Process 'Door Condition'
        outputData.write(doorCondition);

        // Process 'Lock Timeout Minutes'
        outputData.write(lockTimeoutMinutes);

        // Process 'Lock Timeout Seconds'
        outputData.write(lockTimeoutSeconds);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DOOR_LOCK_OPERATION_REPORT command<br>
     *
     * Door Lock Operation Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>DOOR_LOCK_MODE {@link String}
     * <li>INSIDE_DOOR_HANDLES_MODE {@link Integer}
     * <li>OUTSIDE_DOOR_HANDLES_MODE {@link Integer}
     * <li>DOOR_CONDITION {@link Integer}
     * <li>LOCK_TIMEOUT_MINUTES {@link Integer}
     * <li>LOCK_TIMEOUT_SECONDS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDoorLockOperationReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Door Lock Mode'
        switch ((int) payload[2]) {
            case (byte) 0x00:
                response.put("DOOR_LOCK_MODE", "DOOR_UNSECURED");
                break;
            case (byte) 0x01:
                response.put("DOOR_LOCK_MODE", "DOOR_UNSECURED_WITH_TIMEOUT");
                break;
            case (byte) 0x10:
                response.put("DOOR_LOCK_MODE", "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES");
                break;
            case (byte) 0x11:
                response.put("DOOR_LOCK_MODE", "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES_WITH_TIMEOUT");
                break;
            case (byte) 0x20:
                response.put("DOOR_LOCK_MODE", "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES");
                break;
            case (byte) 0x21:
                response.put("DOOR_LOCK_MODE", "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES_WITH_TIMEOUT");
                break;
            case (byte) 0xFF:
                response.put("DOOR_LOCK_MODE", "DOOR_SECURED");
                break;
            default:
                logger.debug("Unknown value {} for constant 'DOOR_LOCK_MODE'", String.format("%02X", payload[2]));
                response.put("DOOR_LOCK_MODE", "UNKNOWN_" + String.format("%02X", payload[2]));
                break;
        }

        // Process 'Properties1'
        response.put("INSIDE_DOOR_HANDLES_MODE", Integer.valueOf(payload[3] & 0x0F));
        response.put("OUTSIDE_DOOR_HANDLES_MODE", Integer.valueOf((payload[3] & 0xF0 >> 4)));

        // Process 'Door Condition'
        response.put("DOOR_CONDITION", Integer.valueOf(payload[4]));

        // Process 'Lock Timeout Minutes'
        response.put("LOCK_TIMEOUT_MINUTES", Integer.valueOf(payload[5]));

        // Process 'Lock Timeout Seconds'
        response.put("LOCK_TIMEOUT_SECONDS", Integer.valueOf(payload[6]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DOOR_LOCK_CONFIGURATION_SET command.<br>
     *
     * Door Lock Configuration Set<br>
     *
     *
     * @param operationType {@link String}
     * @param insideDoorHandlesState {@link Integer}
     * @param outsideDoorHandlesState {@link Integer}
     * @param lockTimeoutMinutes {@link Integer}
     * @param lockTimeoutSeconds {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDoorLockConfigurationSet(String operationType, Integer insideDoorHandlesState,
            Integer outsideDoorHandlesState, Integer lockTimeoutMinutes, Integer lockTimeoutSeconds) {
        logger.debug("Creating command message DOOR_LOCK_CONFIGURATION_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DOOR_LOCK_CONFIGURATION_SET);

        // Process 'Operation Type'
        switch (operationType) {
            case "CONSTANT_OPERATION":
                outputData.write(0x01);
                break;
            case "TIMED_OPERATION":
                outputData.write(0x02);
                break;
            default:
                throw new IllegalArgumentException("Unknown constant value for operationType: " + operationType);
        }

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= insideDoorHandlesState & 0x0F;
        valProperties1 |= ((outsideDoorHandlesState << 4) & 0xF0);
        outputData.write(valProperties1);

        // Process 'Lock Timeout Minutes'
        outputData.write(lockTimeoutMinutes);

        // Process 'Lock Timeout Seconds'
        outputData.write(lockTimeoutSeconds);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DOOR_LOCK_CONFIGURATION_SET command<br>
     *
     * Door Lock Configuration Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>OPERATION_TYPE {@link String}
     * <li>INSIDE_DOOR_HANDLES_STATE {@link Integer}
     * <li>OUTSIDE_DOOR_HANDLES_STATE {@link Integer}
     * <li>LOCK_TIMEOUT_MINUTES {@link Integer}
     * <li>LOCK_TIMEOUT_SECONDS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDoorLockConfigurationSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Operation Type'
        switch ((int) payload[2]) {
            case (byte) 0x01:
                response.put("OPERATION_TYPE", "CONSTANT_OPERATION");
                break;
            case (byte) 0x02:
                response.put("OPERATION_TYPE", "TIMED_OPERATION");
                break;
            default:
                logger.debug("Unknown value {} for constant 'OPERATION_TYPE'", String.format("%02X", payload[2]));
                response.put("OPERATION_TYPE", "UNKNOWN_" + String.format("%02X", payload[2]));
                break;
        }

        // Process 'Properties1'
        response.put("INSIDE_DOOR_HANDLES_STATE", Integer.valueOf(payload[3] & 0x0F));
        response.put("OUTSIDE_DOOR_HANDLES_STATE", Integer.valueOf((payload[3] & 0xF0 >> 4)));

        // Process 'Lock Timeout Minutes'
        response.put("LOCK_TIMEOUT_MINUTES", Integer.valueOf(payload[4]));

        // Process 'Lock Timeout Seconds'
        response.put("LOCK_TIMEOUT_SECONDS", Integer.valueOf(payload[5]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DOOR_LOCK_CONFIGURATION_GET command.<br>
     *
     * Door Lock Configuration Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDoorLockConfigurationGet() {
        logger.debug("Creating command message DOOR_LOCK_CONFIGURATION_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DOOR_LOCK_CONFIGURATION_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DOOR_LOCK_CONFIGURATION_GET command<br>
     *
     * Door Lock Configuration Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDoorLockConfigurationGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DOOR_LOCK_CONFIGURATION_REPORT command.<br>
     *
     * Door Lock Configuration Report<br>
     *
     *
     * @param operationType {@link String}
     * @param insideDoorHandlesState {@link Integer}
     * @param outsideDoorHandlesState {@link Integer}
     * @param lockTimeoutMinutes {@link Integer}
     * @param lockTimeoutSeconds {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDoorLockConfigurationReport(String operationType, Integer insideDoorHandlesState,
            Integer outsideDoorHandlesState, Integer lockTimeoutMinutes, Integer lockTimeoutSeconds) {
        logger.debug("Creating command message DOOR_LOCK_CONFIGURATION_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DOOR_LOCK_CONFIGURATION_REPORT);

        // Process 'Operation Type'
        switch (operationType) {
            case "CONSTANT_OPERATION":
                outputData.write(0x01);
                break;
            case "TIMED_OPERATION":
                outputData.write(0x02);
                break;
            default:
                throw new IllegalArgumentException("Unknown constant value for operationType: " + operationType);
        }

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= insideDoorHandlesState & 0x0F;
        valProperties1 |= ((outsideDoorHandlesState << 4) & 0xF0);
        outputData.write(valProperties1);

        // Process 'Lock Timeout Minutes'
        outputData.write(lockTimeoutMinutes);

        // Process 'Lock Timeout Seconds'
        outputData.write(lockTimeoutSeconds);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DOOR_LOCK_CONFIGURATION_REPORT command<br>
     *
     * Door Lock Configuration Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>OPERATION_TYPE {@link String}
     * <li>INSIDE_DOOR_HANDLES_STATE {@link Integer}
     * <li>OUTSIDE_DOOR_HANDLES_STATE {@link Integer}
     * <li>LOCK_TIMEOUT_MINUTES {@link Integer}
     * <li>LOCK_TIMEOUT_SECONDS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDoorLockConfigurationReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Operation Type'
        switch ((int) payload[2]) {
            case (byte) 0x01:
                response.put("OPERATION_TYPE", "CONSTANT_OPERATION");
                break;
            case (byte) 0x02:
                response.put("OPERATION_TYPE", "TIMED_OPERATION");
                break;
            default:
                logger.debug("Unknown value {} for constant 'OPERATION_TYPE'", String.format("%02X", payload[2]));
                response.put("OPERATION_TYPE", "UNKNOWN_" + String.format("%02X", payload[2]));
                break;
        }

        // Process 'Properties1'
        response.put("INSIDE_DOOR_HANDLES_STATE", Integer.valueOf(payload[3] & 0x0F));
        response.put("OUTSIDE_DOOR_HANDLES_STATE", Integer.valueOf((payload[3] & 0xF0 >> 4)));

        // Process 'Lock Timeout Minutes'
        response.put("LOCK_TIMEOUT_MINUTES", Integer.valueOf(payload[4]));

        // Process 'Lock Timeout Seconds'
        response.put("LOCK_TIMEOUT_SECONDS", Integer.valueOf(payload[5]));

        // Return the map of processed response data;
        return response;
    }

}
