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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_MULTI_CHANNEL</b> version <b>4</b>.
 * <p>
 * Command Class Multi Channel
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassMultiChannelV4 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassMultiChannelV4.class);

    /**
     * Integer command class key for COMMAND_CLASS_MULTI_CHANNEL
     */
    public final static int COMMAND_CLASS_KEY = 0x60;

    /**
     * Multi Instance Get Command Constant
     */
    public final static int MULTI_INSTANCE_GET = 0x04;
    /**
     * Multi Instance Report Command Constant
     */
    public final static int MULTI_INSTANCE_REPORT = 0x05;
    /**
     * Multi Instance Cmd Encap Command Constant
     */
    public final static int MULTI_INSTANCE_CMD_ENCAP = 0x06;
    /**
     * Multi Channel End Point Get Command Constant
     */
    public final static int MULTI_CHANNEL_END_POINT_GET = 0x07;
    /**
     * Multi Channel End Point Report Command Constant
     */
    public final static int MULTI_CHANNEL_END_POINT_REPORT = 0x08;
    /**
     * Multi Channel Capability Get Command Constant
     */
    public final static int MULTI_CHANNEL_CAPABILITY_GET = 0x09;
    /**
     * Multi Channel Capability Report Command Constant
     */
    public final static int MULTI_CHANNEL_CAPABILITY_REPORT = 0x0A;
    /**
     * Multi Channel End Point Find Command Constant
     */
    public final static int MULTI_CHANNEL_END_POINT_FIND = 0x0B;
    /**
     * Multi Channel End Point Find Report Command Constant
     */
    public final static int MULTI_CHANNEL_END_POINT_FIND_REPORT = 0x0C;
    /**
     * Multi Channel Command Encapsulation Command Constant
     */
    public final static int MULTI_CHANNEL_CMD_ENCAP = 0x0D;
    /**
     * Multi Channel Aggregated Members Get Command Constant
     */
    public final static int MULTI_CHANNEL_AGGREGATED_MEMBERS_GET = 0x0E;
    /**
     * Multi Channel Aggregated Members Report Command Constant
     */
    public final static int MULTI_CHANNEL_AGGREGATED_MEMBERS_REPORT = 0x0F;


    /**
     * Map holding constants for Properties2
     */
    private static Map<Integer, String> constantProperties2 = new HashMap<Integer, String>();

    /**
     * Map holding constants for Properties1
     */
    private static Map<Integer, String> constantProperties1 = new HashMap<Integer, String>();

    /**
     * Map holding constants for Properties3
     */
    private static Map<Integer, String> constantProperties3 = new HashMap<Integer, String>();
    static {

        // Constants for Properties2
        constantProperties2.put(0x80, "RES2");

        // Constants for Properties1
        constantProperties1.put(0x80, "RES");

        // Constants for Properties3
        constantProperties3.put(0x80, "RES3");
    }

    /**
     * Creates a new message with the MULTI_INSTANCE_GET command.
     * <p>
     * Multi Instance Get
     *
     * @param commandClass {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMultiInstanceGet(Integer commandClass) {
        logger.debug("Creating command message MULTI_INSTANCE_GET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MULTI_INSTANCE_GET);

        // Process 'Command Class'
        outputData.write(commandClass);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MULTI_INSTANCE_GET command.
     * <p>
     * Multi Instance Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>COMMAND_CLASS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMultiInstanceGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Command Class'
        response.put("COMMAND_CLASS", Integer.valueOf(payload[2]));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the MULTI_INSTANCE_REPORT command.
     * <p>
     * Multi Instance Report
     *
     * @param commandClass {@link Integer}
     * @param instances {@link Integer}
     * @param res {@link Boolean}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMultiInstanceReport(Integer commandClass, Integer instances, Boolean res) {
        logger.debug("Creating command message MULTI_INSTANCE_REPORT version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MULTI_INSTANCE_REPORT);

        // Process 'Command Class'
        outputData.write(commandClass);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= instances & 0x7F;
        valProperties1 |= res ? 0x80 : 0;
        outputData.write(valProperties1);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MULTI_INSTANCE_REPORT command.
     * <p>
     * Multi Instance Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>COMMAND_CLASS {@link Integer}
     * <li>INSTANCES {@link Integer}
     * <li>RES {@link Boolean}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMultiInstanceReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Command Class'
        response.put("COMMAND_CLASS", Integer.valueOf(payload[2]));

        // Process 'Properties1'
        response.put("INSTANCES", Integer.valueOf(payload[3] & 0x7F));
        response.put("RES", Boolean.valueOf((payload[3] & 0x80) != 0));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the MULTI_INSTANCE_CMD_ENCAP command.
     * <p>
     * Multi Instance Cmd Encap
     *
     * @param instance {@link Integer}
     * @param res {@link Boolean}
     * @param commandClass {@link Integer}
     * @param command {@link Integer}
     * @param parameter {@link int[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMultiInstanceCmdEncap(Integer instance, Boolean res, Integer commandClass, Integer command,
            int[] parameter) {
        logger.debug("Creating command message MULTI_INSTANCE_CMD_ENCAP version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MULTI_INSTANCE_CMD_ENCAP);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= instance & 0x7F;
        valProperties1 |= res ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Command Class'
        outputData.write(commandClass);

        // Process 'Command'
        outputData.write(command);

        // Process 'Parameter'
        for (int cntParameter = 0; cntParameter < parameter.length; cntParameter++) {
            outputData.write(parameter[cntParameter]);
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MULTI_INSTANCE_CMD_ENCAP command.
     * <p>
     * Multi Instance Cmd Encap
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>INSTANCE {@link Integer}
     * <li>RES {@link Boolean}
     * <li>COMMAND_CLASS {@link Integer}
     * <li>COMMAND {@link Integer}
     * <li>PARAMETER {@link int[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMultiInstanceCmdEncap(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        response.put("INSTANCE", Integer.valueOf(payload[msgOffset] & 0x7F));
        response.put("RES", Boolean.valueOf((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'Command Class'
        response.put("COMMAND_CLASS", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Command'
        response.put("COMMAND", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Parameter'
        int lenParameter = payload.length - msgOffset;
        int[] valParameter = new int[lenParameter];
        for (int cntParameter = 0; cntParameter < lenParameter; cntParameter++) {
            valParameter[cntParameter] = payload[cntParameter + msgOffset];
        }
        response.put("PARAMETER", valParameter);

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the MULTI_CHANNEL_END_POINT_GET command.
     * <p>
     * Multi Channel End Point Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMultiChannelEndPointGet() {
        logger.debug("Creating command message MULTI_CHANNEL_END_POINT_GET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MULTI_CHANNEL_END_POINT_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MULTI_CHANNEL_END_POINT_GET command.
     * <p>
     * Multi Channel End Point Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMultiChannelEndPointGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the MULTI_CHANNEL_END_POINT_REPORT command.
     * <p>
     * Multi Channel End Point Report
     *
     * @param res1 {@link Integer}
     * @param identical {@link Boolean}
     * @param dynamic {@link Boolean}
     * @param individualEndPoints {@link Integer}
     * @param res2 {@link Boolean}
     * @param aggregatedEndPoints {@link Integer}
     * @param res3 {@link Boolean}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMultiChannelEndPointReport(Integer res1, Boolean identical, Boolean dynamic,
            Integer individualEndPoints, Boolean res2, Integer aggregatedEndPoints, Boolean res3) {
        logger.debug("Creating command message MULTI_CHANNEL_END_POINT_REPORT version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MULTI_CHANNEL_END_POINT_REPORT);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= res1 & 0x3F;
        valProperties1 |= identical ? 0x40 : 0;
        valProperties1 |= dynamic ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Properties2'
        int valProperties2 = 0;
        valProperties2 |= individualEndPoints & 0x7F;
        valProperties2 |= res2 ? 0x80 : 0;
        outputData.write(valProperties2);

        // Process 'Properties3'
        int valProperties3 = 0;
        valProperties3 |= aggregatedEndPoints & 0x7F;
        valProperties3 |= res3 ? 0x80 : 0;
        outputData.write(valProperties3);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MULTI_CHANNEL_END_POINT_REPORT command.
     * <p>
     * Multi Channel End Point Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>RES1 {@link Integer}
     * <li>IDENTICAL {@link Boolean}
     * <li>DYNAMIC {@link Boolean}
     * <li>INDIVIDUAL_END_POINTS {@link Integer}
     * <li>RES2 {@link Boolean}
     * <li>AGGREGATED_END_POINTS {@link Integer}
     * <li>RES3 {@link Boolean}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMultiChannelEndPointReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("RES1", Integer.valueOf(payload[2] & 0x3F));
        response.put("IDENTICAL", Boolean.valueOf((payload[2] & 0x40) != 0));
        response.put("DYNAMIC", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Process 'Properties2'
        response.put("INDIVIDUAL_END_POINTS", Integer.valueOf(payload[3] & 0x7F));
        response.put("RES2", Boolean.valueOf((payload[3] & 0x80) != 0));

        // Process 'Properties3'
        response.put("AGGREGATED_END_POINTS", Integer.valueOf(payload[4] & 0x7F));
        response.put("RES3", Boolean.valueOf((payload[4] & 0x80) != 0));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the MULTI_CHANNEL_CAPABILITY_GET command.
     * <p>
     * Multi Channel Capability Get
     *
     * @param endPoint {@link Integer}
     * @param res {@link Boolean}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMultiChannelCapabilityGet(Integer endPoint, Boolean res) {
        logger.debug("Creating command message MULTI_CHANNEL_CAPABILITY_GET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MULTI_CHANNEL_CAPABILITY_GET);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= endPoint & 0x7F;
        valProperties1 |= res ? 0x80 : 0;
        outputData.write(valProperties1);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MULTI_CHANNEL_CAPABILITY_GET command.
     * <p>
     * Multi Channel Capability Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>END_POINT {@link Integer}
     * <li>RES {@link Boolean}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMultiChannelCapabilityGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("END_POINT", Integer.valueOf(payload[2] & 0x7F));
        response.put("RES", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the MULTI_CHANNEL_CAPABILITY_REPORT command.
     * <p>
     * Multi Channel Capability Report
     *
     * @param endPoint {@link Integer}
     * @param dynamic {@link Boolean}
     * @param genericDeviceClass {@link Integer}
     * @param specificDeviceClass {@link Integer}
     * @param commandClass {@link List<Integer>}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMultiChannelCapabilityReport(Integer endPoint, Boolean dynamic, Integer genericDeviceClass,
            Integer specificDeviceClass, List<Integer> commandClass) {
        logger.debug("Creating command message MULTI_CHANNEL_CAPABILITY_REPORT version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MULTI_CHANNEL_CAPABILITY_REPORT);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= endPoint & 0x7F;
        valProperties1 |= dynamic ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Generic Device Class'
        outputData.write(genericDeviceClass);

        // Process 'Specific Device Class'
        outputData.write(specificDeviceClass);

        // Process 'Command Class'
        for (Integer valCommandClass : commandClass) {
            outputData.write(valCommandClass);
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MULTI_CHANNEL_CAPABILITY_REPORT command.
     * <p>
     * Multi Channel Capability Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>END_POINT {@link Integer}
     * <li>DYNAMIC {@link Boolean}
     * <li>GENERIC_DEVICE_CLASS {@link Integer}
     * <li>SPECIFIC_DEVICE_CLASS {@link Integer}
     * <li>COMMAND_CLASS {@link List}<{@link Integer}>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMultiChannelCapabilityReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        response.put("END_POINT", Integer.valueOf(payload[msgOffset] & 0x7F));
        response.put("DYNAMIC", Boolean.valueOf((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'Generic Device Class'
        response.put("GENERIC_DEVICE_CLASS", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Specific Device Class'
        response.put("SPECIFIC_DEVICE_CLASS", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Command Class'
        List<Integer> valCommandClass = new ArrayList<Integer>();
        while (msgOffset < payload.length) {
            valCommandClass.add(payload[msgOffset] & 0xFF);
            msgOffset++;
        }
        response.put("COMMAND_CLASS", valCommandClass);

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the MULTI_CHANNEL_END_POINT_FIND command.
     * <p>
     * Multi Channel End Point Find
     *
     * @param genericDeviceClass {@link Integer}
     * @param specificDeviceClass {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMultiChannelEndPointFind(Integer genericDeviceClass, Integer specificDeviceClass) {
        logger.debug("Creating command message MULTI_CHANNEL_END_POINT_FIND version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MULTI_CHANNEL_END_POINT_FIND);

        // Process 'Generic Device Class'
        outputData.write(genericDeviceClass);

        // Process 'Specific Device Class'
        outputData.write(specificDeviceClass);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MULTI_CHANNEL_END_POINT_FIND command.
     * <p>
     * Multi Channel End Point Find
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>GENERIC_DEVICE_CLASS {@link Integer}
     * <li>SPECIFIC_DEVICE_CLASS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMultiChannelEndPointFind(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Generic Device Class'
        response.put("GENERIC_DEVICE_CLASS", Integer.valueOf(payload[2]));

        // Process 'Specific Device Class'
        response.put("SPECIFIC_DEVICE_CLASS", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the MULTI_CHANNEL_END_POINT_FIND_REPORT command.
     * <p>
     * Multi Channel End Point Find Report
     *
     * @param reportsToFollow {@link Integer}
     * @param genericDeviceClass {@link Integer}
     * @param specificDeviceClass {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMultiChannelEndPointFindReport(Integer reportsToFollow, Integer genericDeviceClass,
            Integer specificDeviceClass) {
        logger.debug("Creating command message MULTI_CHANNEL_END_POINT_FIND_REPORT version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MULTI_CHANNEL_END_POINT_FIND_REPORT);

        // Process 'Reports to Follow'
        outputData.write(reportsToFollow);

        // Process 'Generic Device Class'
        outputData.write(genericDeviceClass);

        // Process 'Specific Device Class'
        outputData.write(specificDeviceClass);

        // Process 'vg'

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MULTI_CHANNEL_END_POINT_FIND_REPORT command.
     * <p>
     * Multi Channel End Point Find Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>REPORTS_TO_FOLLOW {@link Integer}
     * <li>GENERIC_DEVICE_CLASS {@link Integer}
     * <li>SPECIFIC_DEVICE_CLASS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMultiChannelEndPointFindReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Reports to Follow'
        response.put("REPORTS_TO_FOLLOW", Integer.valueOf(payload[2]));

        // Process 'Generic Device Class'
        response.put("GENERIC_DEVICE_CLASS", Integer.valueOf(payload[3]));

        // Process 'Specific Device Class'
        response.put("SPECIFIC_DEVICE_CLASS", Integer.valueOf(payload[4]));

        // Process 'vg'

        // Create a list to hold the group vg
        List<Map<String, Object>> variantList = new ArrayList<Map<String, Object>>();

        int offset = 5;
        while (offset < payload.length) {
            // Create a map to hold the members of this variant
            Map<String, Object> variant = new HashMap<String, Object>();

            // Process 'Properties1'
            variant.put("END_POINT", Integer.valueOf(payload[5] & 0x7F));
            variant.put("RES", Boolean.valueOf((payload[5] & 0x80) != 0));

            // Add to the list
            variantList.add(variant);

            // Add the length of this variant
            offset += (payload[offset + 0] & 0xFF) >> 0;
        }

        // Add the variant list to the response
        response.put("VG", variantList);

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the MULTI_CHANNEL_CMD_ENCAP command.
     * <p>
     * Multi Channel Command Encapsulation
     *
     * @param sourceEndPoint {@link Integer}
     * @param res {@link Boolean}
     * @param destinationEndPoint {@link Integer}
     * @param bitAddress {@link Boolean}
     * @param commandClass {@link Integer}
     * @param command {@link Integer}
     * @param parameter {@link int[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMultiChannelCmdEncap(Integer sourceEndPoint, Boolean res, Integer destinationEndPoint,
            Boolean bitAddress, Integer commandClass, Integer command, int[] parameter) {
        logger.debug("Creating command message MULTI_CHANNEL_CMD_ENCAP version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MULTI_CHANNEL_CMD_ENCAP);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= sourceEndPoint & 0x7F;
        valProperties1 |= res ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Properties2'
        int valProperties2 = 0;
        valProperties2 |= destinationEndPoint & 0x7F;
        valProperties2 |= bitAddress ? 0x80 : 0;
        outputData.write(valProperties2);

        // Process 'Command Class'
        outputData.write(commandClass);

        // Process 'Command'
        outputData.write(command);

        // Process 'Parameter'
        for (int cntParameter = 0; cntParameter < parameter.length; cntParameter++) {
            outputData.write(parameter[cntParameter]);
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MULTI_CHANNEL_CMD_ENCAP command.
     * <p>
     * Multi Channel Command Encapsulation
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SOURCE_END_POINT {@link Integer}
     * <li>RES {@link Boolean}
     * <li>DESTINATION_END_POINT {@link Integer}
     * <li>BIT_ADDRESS {@link Boolean}
     * <li>COMMAND_CLASS {@link Integer}
     * <li>COMMAND {@link Integer}
     * <li>PARAMETER {@link int[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMultiChannelCmdEncap(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        response.put("SOURCE_END_POINT", Integer.valueOf(payload[msgOffset] & 0x7F));
        response.put("RES", Boolean.valueOf((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'Properties2'
        response.put("DESTINATION_END_POINT", Integer.valueOf(payload[msgOffset] & 0x7F));
        response.put("BIT_ADDRESS", Boolean.valueOf((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'Command Class'
        response.put("COMMAND_CLASS", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Command'
        response.put("COMMAND", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Parameter'
        int lenParameter = payload.length - msgOffset;
        int[] valParameter = new int[lenParameter];
        for (int cntParameter = 0; cntParameter < lenParameter; cntParameter++) {
            valParameter[cntParameter] = payload[cntParameter + msgOffset];
        }
        response.put("PARAMETER", valParameter);

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the MULTI_CHANNEL_AGGREGATED_MEMBERS_GET command.
     * <p>
     * Multi Channel Aggregated Members Get
     *
     * @param aggregatedEndPoint {@link Integer}
     * @param res {@link Boolean}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMultiChannelAggregatedMembersGet(Integer aggregatedEndPoint, Boolean res) {
        logger.debug("Creating command message MULTI_CHANNEL_AGGREGATED_MEMBERS_GET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MULTI_CHANNEL_AGGREGATED_MEMBERS_GET);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= aggregatedEndPoint & 0x7F;
        valProperties1 |= res ? 0x80 : 0;
        outputData.write(valProperties1);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MULTI_CHANNEL_AGGREGATED_MEMBERS_GET command.
     * <p>
     * Multi Channel Aggregated Members Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>AGGREGATED_END_POINT {@link Integer}
     * <li>RES {@link Boolean}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMultiChannelAggregatedMembersGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("AGGREGATED_END_POINT", Integer.valueOf(payload[2] & 0x7F));
        response.put("RES", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the MULTI_CHANNEL_AGGREGATED_MEMBERS_REPORT command.
     * <p>
     * Multi Channel Aggregated Members Report
     *
     * @param res {@link Boolean}
     * @param numberOfBitMasks {@link Integer}
     * @param aggregatedMembersBitMask {@link List<Integer>}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMultiChannelAggregatedMembersReport(Boolean res, Integer numberOfBitMasks,
            List<Integer> aggregatedMembersBitMask) {
        logger.debug("Creating command message MULTI_CHANNEL_AGGREGATED_MEMBERS_REPORT version 4");

        Collections.sort(aggregatedMembersBitMask);
        int lenAggregatedMembersBitMask = (aggregatedMembersBitMask.get(aggregatedMembersBitMask.size() - 1) / 8) + 1;

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MULTI_CHANNEL_AGGREGATED_MEMBERS_REPORT);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= lenAggregatedMembersBitMask;
        valProperties1 |= res ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Number of Bit Masks'
        outputData.write(numberOfBitMasks);

        // Process 'Aggregated Members Bit Mask'
        int valAggregatedMembersBitMask = 0;
        for (int cntAggregatedMembersBitMask = 1 ; cntAggregatedMembersBitMask < lenAggregatedMembersBitMask * 8 ; cntAggregatedMembersBitMask++) {
            valAggregatedMembersBitMask |= aggregatedMembersBitMask.contains(valAggregatedMembersBitMask) ? (1 << cntAggregatedMembersBitMask % 8) : 0;
            if (cntAggregatedMembersBitMask % 8 == 0) {
                outputData.write(valAggregatedMembersBitMask);
                valAggregatedMembersBitMask = 0;
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MULTI_CHANNEL_AGGREGATED_MEMBERS_REPORT command.
     * <p>
     * Multi Channel Aggregated Members Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>RES {@link Boolean}
     * <li>NUMBER_OF_BIT_MASKS {@link Integer}
     * <li>AGGREGATED_MEMBERS_BIT_MASK {@link List}<{@link Integer}>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMultiChannelAggregatedMembersReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("AGGREGATED_END_POINT", Integer.valueOf(payload[2] & 0x7F));
        response.put("RES", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Process 'Number of Bit Masks'
        response.put("NUMBER_OF_BIT_MASKS", Integer.valueOf(payload[3]));

        // Process 'Aggregated Members Bit Mask'
        List<Integer> responseAggregatedMembersBitMask = new ArrayList<Integer>();
        int lenAggregatedMembersBitMask = (payload[3] & 0xFF) * 8;
        for (int cntAggregatedMembersBitMask = 0; cntAggregatedMembersBitMask < lenAggregatedMembersBitMask; cntAggregatedMembersBitMask++) {
            if ((payload[4 + (cntAggregatedMembersBitMask / 8)] & (1 << cntAggregatedMembersBitMask % 8)) == 0) {
                continue;
            }
            responseAggregatedMembersBitMask.add(cntAggregatedMembersBitMask);
        }
        response.put("AGGREGATED_MEMBERS_BIT_MASK", responseAggregatedMembersBitMask);

        // Return the map of processed response data;
        return response;
    }

}
