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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_DOOR_LOCK</b> version <b>3</b>.<br>
 * <p>
 * Command Class Door Lock<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassDoorLockV3 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassDoorLockV3.class);

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


    // Define constants for Operation Type
    private static Map<Integer, String> constantOperationType = new HashMap<Integer, String>();

    // Define constants for Current Door Lock Mode
    private static Map<Integer, String> constantCurrentDoorLockMode = new HashMap<Integer, String>();

    // Define constants for Door Lock Mode
    private static Map<Integer, String> constantDoorLockMode = new HashMap<Integer, String>();

    // Define constants for Duration
    private static Map<Integer, String> constantDuration = new HashMap<Integer, String>();

    // Define constants for Target Door Lock Mode
    private static Map<Integer, String> constantTargetDoorLockMode = new HashMap<Integer, String>();

    static {
        // Constants for Operation Type
        constantOperationType.put(0x01, "CONSTANT_OPERATION");
        constantOperationType.put(0x02, "TIMED_OPERATION");
        // Constants for Current Door Lock Mode
        constantCurrentDoorLockMode.put(0xFE, "DOOR_LOCK_STATE_UNKNOWN");
        constantCurrentDoorLockMode.put(0x11, "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES_WITH_TIMEOUT");
        constantCurrentDoorLockMode.put(0x00, "DOOR_UNSECURED");
        constantCurrentDoorLockMode.put(0xFF, "DOOR_SECURED");
        constantCurrentDoorLockMode.put(0x10, "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES");
        constantCurrentDoorLockMode.put(0x01, "DOOR_UNSECURED_WITH_TIMEOUT");
        constantCurrentDoorLockMode.put(0x20, "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES");
        constantCurrentDoorLockMode.put(0x21, "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES_WITH_TIMEOUT");
        // Constants for Door Lock Mode
        constantDoorLockMode.put(0xFE, "DOOR_LOCK_STATE_UNKNOWN");
        constantDoorLockMode.put(0x11, "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES_WITH_TIMEOUT");
        constantDoorLockMode.put(0x00, "DOOR_UNSECURED");
        constantDoorLockMode.put(0xFF, "DOOR_SECURED");
        constantDoorLockMode.put(0x10, "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES");
        constantDoorLockMode.put(0x01, "DOOR_UNSECURED_WITH_TIMEOUT");
        constantDoorLockMode.put(0x20, "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES");
        constantDoorLockMode.put(0x21, "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES_WITH_TIMEOUT");
        // Constants for Duration
        constantDuration.put(0xFE, "UNKNOWN_DURATION");
        constantDuration.put(0x00, "ALREADY_AT_THE_TARGET_VALUE");
        // Constants for Target Door Lock Mode
        constantTargetDoorLockMode.put(0xFE, "DOOR_LOCK_STATE_UNKNOWN");
        constantTargetDoorLockMode.put(0x11, "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES_WITH_TIMEOUT");
        constantTargetDoorLockMode.put(0x00, "DOOR_UNSECURED");
        constantTargetDoorLockMode.put(0xFF, "DOOR_SECURED");
        constantTargetDoorLockMode.put(0x10, "DOOR_UNSECURED_FOR_INSIDE_DOOR_HANDLES");
        constantTargetDoorLockMode.put(0x01, "DOOR_UNSECURED_WITH_TIMEOUT");
        constantTargetDoorLockMode.put(0x20, "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES");
        constantTargetDoorLockMode.put(0x21, "DOOR_UNSECURED_FOR_OUTSIDE_DOOR_HANDLES_WITH_TIMEOUT");
    }

    /**
     * Creates a new message with the DOOR_LOCK_OPERATION_SET command.<br>
     * <p>
     * Door Lock Operation Set<br>
     *
     * @param doorLockMode {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDoorLockOperationSet(String doorLockMode) {
        logger.debug("Creating command message DOOR_LOCK_OPERATION_SET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DOOR_LOCK_OPERATION_SET);

        // Process 'Door Lock Mode'
        for (Integer entry : constantDoorLockMode.keySet()) {
            if (constantDoorLockMode.get(entry).equals(doorLockMode)) {
                outputData.write(entry);
                break;
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DOOR_LOCK_OPERATION_SET command<br>
     * <p>
     * Door Lock Operation Set<br>
     * <p>
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
        response.put("DOOR_LOCK_MODE", constantDoorLockMode.get(payload[2] & 0xff));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DOOR_LOCK_OPERATION_GET command.<br>
     * <p>
     * Door Lock Operation Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDoorLockOperationGet() {
        logger.debug("Creating command message DOOR_LOCK_OPERATION_GET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DOOR_LOCK_OPERATION_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DOOR_LOCK_OPERATION_GET command<br>
     * <p>
     * Door Lock Operation Get<br>
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
     * <p>
     * Door Lock Operation Report<br>
     *
     * @param currentDoorLockMode {@link String}
     * @param insideDoorHandlesMode {@link Integer}
     * @param outsideDoorHandlesMode {@link Integer}
     * @param doorCondition {@link Integer}
     * @param lockTimeoutMinutes {@link Integer}
     * @param lockTimeoutSeconds {@link Integer}
     * @param targetDoorLockMode {@link String}
     * @param duration {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDoorLockOperationReport(String currentDoorLockMode, Integer insideDoorHandlesMode,
            Integer outsideDoorHandlesMode, Integer doorCondition, Integer lockTimeoutMinutes,
            Integer lockTimeoutSeconds, String targetDoorLockMode, String duration) {
        logger.debug("Creating command message DOOR_LOCK_OPERATION_REPORT version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DOOR_LOCK_OPERATION_REPORT);

        // Process 'Current Door Lock Mode'
        for (Integer entry : constantCurrentDoorLockMode.keySet()) {
            if (constantCurrentDoorLockMode.get(entry).equals(currentDoorLockMode)) {
                outputData.write(entry);
                break;
            }
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

        // Process 'Target Door Lock Mode'
        for (Integer entry : constantTargetDoorLockMode.keySet()) {
            if (constantTargetDoorLockMode.get(entry).equals(targetDoorLockMode)) {
                outputData.write(entry);
                break;
            }
        }

        // Process 'Duration'
        for (Integer entry : constantDuration.keySet()) {
            if (constantDuration.get(entry).equals(duration)) {
                outputData.write(entry);
                break;
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DOOR_LOCK_OPERATION_REPORT command<br>
     * <p>
     * Door Lock Operation Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>CURRENT_DOOR_LOCK_MODE {@link String}
     * <li>INSIDE_DOOR_HANDLES_MODE {@link Integer}
     * <li>OUTSIDE_DOOR_HANDLES_MODE {@link Integer}
     * <li>DOOR_CONDITION {@link Integer}
     * <li>LOCK_TIMEOUT_MINUTES {@link Integer}
     * <li>LOCK_TIMEOUT_SECONDS {@link Integer}
     * <li>TARGET_DOOR_LOCK_MODE {@link String}
     * <li>DURATION {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDoorLockOperationReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Current Door Lock Mode'
        response.put("CURRENT_DOOR_LOCK_MODE", constantCurrentDoorLockMode.get(payload[2] & 0xff));

        // Process 'Properties1'
        response.put("INSIDE_DOOR_HANDLES_MODE", Integer.valueOf(payload[3] & 0x0F));
        response.put("OUTSIDE_DOOR_HANDLES_MODE", Integer.valueOf((payload[3] & 0xF0 >> 4)));

        // Process 'Door Condition'
        response.put("DOOR_CONDITION", Integer.valueOf(payload[4]));

        // Process 'Lock Timeout Minutes'
        response.put("LOCK_TIMEOUT_MINUTES", Integer.valueOf(payload[5]));

        // Process 'Lock Timeout Seconds'
        response.put("LOCK_TIMEOUT_SECONDS", Integer.valueOf(payload[6]));

        // Process 'Target Door Lock Mode'
        response.put("TARGET_DOOR_LOCK_MODE", constantTargetDoorLockMode.get(payload[7] & 0xff));

        // Process 'Duration'
        response.put("DURATION", constantDuration.get(payload[8] & 0xff));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DOOR_LOCK_CONFIGURATION_SET command.<br>
     * <p>
     * Door Lock Configuration Set<br>
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
        logger.debug("Creating command message DOOR_LOCK_CONFIGURATION_SET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DOOR_LOCK_CONFIGURATION_SET);

        // Process 'Operation Type'
        for (Integer entry : constantOperationType.keySet()) {
            if (constantOperationType.get(entry).equals(operationType)) {
                outputData.write(entry);
                break;
            }
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
     * <p>
     * Door Lock Configuration Set<br>
     * <p>
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
        response.put("OPERATION_TYPE", constantOperationType.get(payload[2] & 0xff));

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
     * <p>
     * Door Lock Configuration Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDoorLockConfigurationGet() {
        logger.debug("Creating command message DOOR_LOCK_CONFIGURATION_GET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DOOR_LOCK_CONFIGURATION_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DOOR_LOCK_CONFIGURATION_GET command<br>
     * <p>
     * Door Lock Configuration Get<br>
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
     * <p>
     * Door Lock Configuration Report<br>
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
        logger.debug("Creating command message DOOR_LOCK_CONFIGURATION_REPORT version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DOOR_LOCK_CONFIGURATION_REPORT);

        // Process 'Operation Type'
        for (Integer entry : constantOperationType.keySet()) {
            if (constantOperationType.get(entry).equals(operationType)) {
                outputData.write(entry);
                break;
            }
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
     * <p>
     * Door Lock Configuration Report<br>
     * <p>
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
        response.put("OPERATION_TYPE", constantOperationType.get(payload[2] & 0xff));

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
