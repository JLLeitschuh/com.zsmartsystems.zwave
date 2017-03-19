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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_LOCK</b> version <b>1</b>.<br>
 * <p>
 * Command Class Lock<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassLockV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassLockV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_LOCK
     */
    public final static int COMMAND_CLASS_KEY = 0x76;

    /**
     * Lock Set Command Constant
     */
    public final static int LOCK_SET = 0x01;
    /**
     * Lock Get Command Constant
     */
    public final static int LOCK_GET = 0x02;
    /**
     * Lock Report Command Constant
     */
    public final static int LOCK_REPORT = 0x03;

    /**
     * Creates a new message with the LOCK_SET command.<br>
     * <p>
     * Lock Set<br>
     *
     * @param lockState {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getLockSet(Integer lockState) {
        logger.debug("Creating command message LOCK_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(LOCK_SET);

        // Process 'Lock State'
        outputData.write(lockState);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the LOCK_SET command<br>
     * <p>
     * Lock Set<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>LOCK_STATE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleLockSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Lock State'
        switch (payload[2] & 0xff) {
            case 0x00:
                response.put("LOCK_STATE", "UNLOCKED");
                break;
            case 0x01:
                response.put("LOCK_STATE", "LOCKED");
                break;
            default:
                response.put("LOCK_STATE", String.format("%02X", payload[2] & 0xff));
                logger.debug("Unknown value {}", payload[2] & 0xff);
                break;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the LOCK_GET command.<br>
     * <p>
     * Lock Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getLockGet() {
        logger.debug("Creating command message LOCK_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(LOCK_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the LOCK_GET command<br>
     * <p>
     * Lock Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleLockGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the LOCK_REPORT command.<br>
     * <p>
     * Lock Report<br>
     *
     * @param lockState {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getLockReport(Integer lockState) {
        logger.debug("Creating command message LOCK_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(LOCK_REPORT);

        // Process 'Lock State'
        outputData.write(lockState);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the LOCK_REPORT command<br>
     * <p>
     * Lock Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>LOCK_STATE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleLockReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Lock State'
        switch (payload[2] & 0xff) {
            case 0x00:
                response.put("LOCK_STATE", "UNLOCKED");
                break;
            case 0x01:
                response.put("LOCK_STATE", "LOCKED");
                break;
            default:
                response.put("LOCK_STATE", String.format("%02X", payload[2] & 0xff));
                logger.debug("Unknown value {}", payload[2] & 0xff);
                break;
        }

        // Return the map of processed response data;
        return response;
    }

}
