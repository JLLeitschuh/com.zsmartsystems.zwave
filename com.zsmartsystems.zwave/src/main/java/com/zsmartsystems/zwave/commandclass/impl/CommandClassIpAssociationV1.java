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
import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_IP_ASSOCIATION</b> version <b>1</b>.
 * <p>
 * Command Class Ip Association
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x5C.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassIpAssociationV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassIpAssociationV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_IP_ASSOCIATION
     */
    public final static int COMMAND_CLASS_KEY = 0x5C;

    /**
     * IP Association Set Command Constant
     */
    public final static int IP_ASSOCIATION_SET = 0x01;
    /**
     * IP Association Get Command Constant
     */
    public final static int IP_ASSOCIATION_GET = 0x02;
    /**
     * IP Association Report Command Constant
     */
    public final static int IP_ASSOCIATION_REPORT = 0x03;
    /**
     * IP Association Remove Command Constant
     */
    public final static int IP_ASSOCIATION_REMOVE = 0x04;


    /**
     * Creates a new message with the IP_ASSOCIATION_SET command.
     * <p>
     * IP Association Set
     *
     * @param groupingIdentifier {@link Integer}
     * @param ipv6Address {@link byte[]}
     * @param endPoint {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getIpAssociationSet(Integer groupingIdentifier, byte[] ipv6Address, Integer endPoint) {
        logger.debug("Creating command message IP_ASSOCIATION_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(IP_ASSOCIATION_SET);

        // Process 'Grouping Identifier'
        outputData.write(groupingIdentifier);

        // Process 'IPv6 Address'
        if (ipv6Address != null) {
            if (ipv6Address.length > 16) {
                throw new IllegalArgumentException("Length of array ipv6Address exceeds maximum length of 16 bytes");
            }
            try {
                outputData.write(ipv6Address);
            } catch (IOException e) {
            }
        }

        // Process 'End Point'
        outputData.write(endPoint);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the IP_ASSOCIATION_SET command.
     * <p>
     * IP Association Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>GROUPING_IDENTIFIER {@link Integer}
     * <li>IPV6_ADDRESS {@link byte[]}
     * <li>END_POINT {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleIpAssociationSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Grouping Identifier'
        response.put("GROUPING_IDENTIFIER", Integer.valueOf(payload[2]));

        // Process 'IPv6 Address'
        int lenIpv6Address = Math.min(16, payload.length - 3);
        byte[] valIpv6Address = new byte[lenIpv6Address];
        for (int cntIpv6Address = 0; cntIpv6Address < lenIpv6Address; cntIpv6Address++) {
            valIpv6Address[cntIpv6Address] = payload[3 + cntIpv6Address];
        }
        response.put("IPV6_ADDRESS", valIpv6Address);

        // Process 'End Point'
        response.put("END_POINT", Integer.valueOf(payload[19]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the IP_ASSOCIATION_GET command.
     * <p>
     * IP Association Get
     *
     * @param groupingIdentifier {@link Integer}
     * @param index {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getIpAssociationGet(Integer groupingIdentifier, Integer index) {
        logger.debug("Creating command message IP_ASSOCIATION_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(IP_ASSOCIATION_GET);

        // Process 'Grouping Identifier'
        outputData.write(groupingIdentifier);

        // Process 'Index'
        outputData.write(index);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the IP_ASSOCIATION_GET command.
     * <p>
     * IP Association Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>GROUPING_IDENTIFIER {@link Integer}
     * <li>INDEX {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleIpAssociationGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Grouping Identifier'
        response.put("GROUPING_IDENTIFIER", Integer.valueOf(payload[2]));

        // Process 'Index'
        response.put("INDEX", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the IP_ASSOCIATION_REPORT command.
     * <p>
     * IP Association Report
     *
     * @param groupingIdentifier {@link Integer}
     * @param index {@link Integer}
     * @param actualNodes {@link Integer}
     * @param ipv6Address {@link byte[]}
     * @param endPoint {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getIpAssociationReport(Integer groupingIdentifier, Integer index, Integer actualNodes,
            byte[] ipv6Address, Integer endPoint) {
        logger.debug("Creating command message IP_ASSOCIATION_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(IP_ASSOCIATION_REPORT);

        // Process 'Grouping Identifier'
        outputData.write(groupingIdentifier);

        // Process 'Index'
        outputData.write(index);

        // Process 'Actual Nodes'
        outputData.write(actualNodes);

        // Process 'IPv6 Address'
        if (ipv6Address != null) {
            if (ipv6Address.length > 16) {
                throw new IllegalArgumentException("Length of array ipv6Address exceeds maximum length of 16 bytes");
            }
            try {
                outputData.write(ipv6Address);
            } catch (IOException e) {
            }
        }

        // Process 'End Point'
        outputData.write(endPoint);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the IP_ASSOCIATION_REPORT command.
     * <p>
     * IP Association Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>GROUPING_IDENTIFIER {@link Integer}
     * <li>INDEX {@link Integer}
     * <li>ACTUAL_NODES {@link Integer}
     * <li>IPV6_ADDRESS {@link byte[]}
     * <li>END_POINT {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleIpAssociationReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Grouping Identifier'
        response.put("GROUPING_IDENTIFIER", Integer.valueOf(payload[2]));

        // Process 'Index'
        response.put("INDEX", Integer.valueOf(payload[3]));

        // Process 'Actual Nodes'
        response.put("ACTUAL_NODES", Integer.valueOf(payload[4]));

        // Process 'IPv6 Address'
        int lenIpv6Address = Math.min(16, payload.length - 5);
        byte[] valIpv6Address = new byte[lenIpv6Address];
        for (int cntIpv6Address = 0; cntIpv6Address < lenIpv6Address; cntIpv6Address++) {
            valIpv6Address[cntIpv6Address] = payload[5 + cntIpv6Address];
        }
        response.put("IPV6_ADDRESS", valIpv6Address);

        // Process 'End Point'
        response.put("END_POINT", Integer.valueOf(payload[21]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the IP_ASSOCIATION_REMOVE command.
     * <p>
     * IP Association Remove
     *
     * @param groupingIdentifier {@link Integer}
     * @param ipv6Address {@link byte[]}
     * @param endPoint {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getIpAssociationRemove(Integer groupingIdentifier, byte[] ipv6Address, Integer endPoint) {
        logger.debug("Creating command message IP_ASSOCIATION_REMOVE version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(IP_ASSOCIATION_REMOVE);

        // Process 'Grouping Identifier'
        outputData.write(groupingIdentifier);

        // Process 'IPv6 Address'
        if (ipv6Address != null) {
            if (ipv6Address.length > 16) {
                throw new IllegalArgumentException("Length of array ipv6Address exceeds maximum length of 16 bytes");
            }
            try {
                outputData.write(ipv6Address);
            } catch (IOException e) {
            }
        }

        // Process 'End Point'
        outputData.write(endPoint);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the IP_ASSOCIATION_REMOVE command.
     * <p>
     * IP Association Remove
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>GROUPING_IDENTIFIER {@link Integer}
     * <li>IPV6_ADDRESS {@link byte[]}
     * <li>END_POINT {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleIpAssociationRemove(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Grouping Identifier'
        response.put("GROUPING_IDENTIFIER", Integer.valueOf(payload[2]));

        // Process 'IPv6 Address'
        int lenIpv6Address = Math.min(16, payload.length - 3);
        byte[] valIpv6Address = new byte[lenIpv6Address];
        for (int cntIpv6Address = 0; cntIpv6Address < lenIpv6Address; cntIpv6Address++) {
            valIpv6Address[cntIpv6Address] = payload[3 + cntIpv6Address];
        }
        response.put("IPV6_ADDRESS", valIpv6Address);

        // Process 'End Point'
        response.put("END_POINT", Integer.valueOf(payload[19]));

        // Return the map of processed response data;
        return response;
    }
}
