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
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_TRANSPORT_SERVICE</b> version <b>2</b>.
 * <p>
 * Command Class Transport Service
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x55.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassTransportServiceV2 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassTransportServiceV2.class);

    /**
     * Integer command class key for COMMAND_CLASS_TRANSPORT_SERVICE
     */
    public final static int COMMAND_CLASS_KEY = 0x55;

    /**
     * First Segment Command Constant
     */
    public final static int COMMAND_FIRST_SEGMENT = 0xC0;
    /**
     * Segment Request Command Constant
     */
    public final static int COMMAND_SEGMENT_REQUEST = 0xC8;
    /**
     * Subsequent Segment Command Constant
     */
    public final static int COMMAND_SUBSEQUENT_SEGMENT = 0xE0;
    /**
     * Segment Complete Command Constant
     */
    public final static int COMMAND_SEGMENT_COMPLETE = 0xE8;
    /**
     * Segment Wait Command Constant
     */
    public final static int COMMAND_SEGMENT_WAIT = 0xF0;

    /**
     * Map holding constants for CommandSubsequentSegmentProperties2
     */
    private static Map<Integer, String> constantCommandSubsequentSegmentProperties2 = new HashMap<Integer, String>();

    /**
     * Map holding constants for CommandFirstSegmentProperties2
     */
    private static Map<Integer, String> constantCommandFirstSegmentProperties2 = new HashMap<Integer, String>();

    static {
        // Constants for CommandSubsequentSegmentProperties2
        constantCommandSubsequentSegmentProperties2.put(0x08, "EXT");

        // Constants for CommandFirstSegmentProperties2
        constantCommandFirstSegmentProperties2.put(0x08, "EXT");
    }

    /**
     * Creates a new message with the COMMAND_FIRST_SEGMENT command.
     * <p>
     * First Segment
     *
     * @param datagramSize1 {@link Integer}
     * @param datagramSize2 {@link Integer}
     * @param ext {@link Boolean}
     * @param sessionId {@link Integer}
     * @param headerExtensionLength {@link Integer}
     * @param headerExtension {@link byte[]}
     * @param payload {@link byte[]}
     * @param frameCheckSequence {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getCommandFirstSegment(Integer datagramSize1, Integer datagramSize2, Boolean ext,
            Integer sessionId, Integer headerExtensionLength, byte[] headerExtension, byte[] payload,
            Integer frameCheckSequence) {
        logger.debug("Creating command message COMMAND_FIRST_SEGMENT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(COMMAND_FIRST_SEGMENT);

        // Process 'Properties1'
        outputData.write(datagramSize1 & 0x07);

        // Process 'datagram_size_2'
        outputData.write(datagramSize2);

        // Process 'Properties2'
        int valProperties2 = 0;
        valProperties2 |= ext ? 0x08 : 0;
        valProperties2 |= ((sessionId << 4) & 0xF0);
        outputData.write(valProperties2);

        // Process 'Header Extension Length'
        outputData.write(headerExtensionLength);

        // Process 'Header Extension'
        if (headerExtension != null) {
            try {
                outputData.write(headerExtension);
            } catch (IOException e) {
            }
        }

        // Process 'Payload'
        if (payload != null) {
            try {
                outputData.write(payload);
            } catch (IOException e) {
            }
        }

        // Process 'Frame Check Sequence'
        outputData.write((frameCheckSequence >> 8) & 0xff);
        outputData.write(frameCheckSequence & 0xff);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the COMMAND_FIRST_SEGMENT command.
     * <p>
     * First Segment
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>DATAGRAM_SIZE_1 {@link Integer}
     * <li>DATAGRAM_SIZE_2 {@link Integer}
     * <li>EXT {@link Boolean}
     * <li>SESSION_ID {@link Integer}
     * <li>HEADER_EXTENSION_LENGTH {@link Integer}
     * <li>HEADER_EXTENSION {@link byte[]}
     * <li>PAYLOAD {@link byte[]}
     * <li>FRAME_CHECK_SEQUENCE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleCommandFirstSegment(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        response.put("DATAGRAM_SIZE_1", Integer.valueOf(payload[msgOffset] & 0x07));
        msgOffset += 1;

        // Process 'datagram_size_2'
        response.put("DATAGRAM_SIZE_2", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Properties2'
        response.put("EXT", Boolean.valueOf((payload[msgOffset] & 0x08) != 0));
        response.put("SESSION_ID", Integer.valueOf(payload[msgOffset] & 0xF0 >> 4));
        msgOffset += 1;

        // Process 'Header Extension Length' (optional)
        if (true) {
            response.put("HEADER_EXTENSION_LENGTH", Integer.valueOf(payload[msgOffset]));
        }
        msgOffset += 1;

        // Process 'Header Extension' (optional)
        if (true) {
            ByteArrayOutputStream valHeaderExtension = new ByteArrayOutputStream();
            int lenHeaderExtension = payload[msgOffset - 1];
            for (int cntHeaderExtension = 0; cntHeaderExtension < lenHeaderExtension; cntHeaderExtension++) {
                valHeaderExtension.write(payload[msgOffset + cntHeaderExtension]);
            }
            response.put("HEADER_EXTENSION", valHeaderExtension.toByteArray());
            msgOffset += lenHeaderExtension;
        }

        // Process 'Payload'
        ByteArrayOutputStream valPayload = new ByteArrayOutputStream();
        while (msgOffset < payload.length - 2) {
            valPayload.write(payload[msgOffset]);
            msgOffset++;
        }
        response.put("PAYLOAD", valPayload);

        // Process 'Frame Check Sequence'
        response.put("FRAME_CHECK_SEQUENCE", Integer.valueOf(((payload[msgOffset] & 0xff) << 8) + (payload[msgOffset + 1] & 0xff)));
        msgOffset += 2;

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the COMMAND_SEGMENT_REQUEST command.
     * <p>
     * Segment Request
     *
     * @param datagramOffset1 {@link Integer}
     * @param sessionId {@link Integer}
     * @param datagramOffset2 {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getCommandSegmentRequest(Integer datagramOffset1, Integer sessionId, Integer datagramOffset2) {
        logger.debug("Creating command message COMMAND_SEGMENT_REQUEST version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(COMMAND_SEGMENT_REQUEST);

        // Process 'Properties1'

        // Process 'Properties2'
        int valProperties2 = 0;
        valProperties2 |= datagramOffset1 & 0x07;
        valProperties2 |= ((sessionId << 4) & 0xF0);
        outputData.write(valProperties2);

        // Process 'datagram_offset_2'
        outputData.write(datagramOffset2);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the COMMAND_SEGMENT_REQUEST command.
     * <p>
     * Segment Request
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>DATAGRAM_OFFSET_1 {@link Integer}
     * <li>SESSION_ID {@link Integer}
     * <li>DATAGRAM_OFFSET_2 {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleCommandSegmentRequest(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'

        // Process 'Properties2'
        response.put("DATAGRAM_OFFSET_1", Integer.valueOf(payload[3] & 0x07));
        response.put("SESSION_ID", Integer.valueOf(payload[3] & 0xF0 >> 4));

        // Process 'datagram_offset_2'
        response.put("DATAGRAM_OFFSET_2", Integer.valueOf(payload[4]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the COMMAND_SUBSEQUENT_SEGMENT command.
     * <p>
     * Subsequent Segment
     *
     * @param datagramSize1 {@link Integer}
     * @param datagramSize2 {@link Integer}
     * @param datagramOffset1 {@link Integer}
     * @param ext {@link Boolean}
     * @param sessionId {@link Integer}
     * @param datagramOffset2 {@link Integer}
     * @param headerExtensionLength {@link Integer}
     * @param headerExtension {@link byte[]}
     * @param payload {@link byte[]}
     * @param frameCheckSequence {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getCommandSubsequentSegment(Integer datagramSize1, Integer datagramSize2,
            Integer datagramOffset1, Boolean ext, Integer sessionId, Integer datagramOffset2,
            Integer headerExtensionLength, byte[] headerExtension, byte[] payload, Integer frameCheckSequence) {
        logger.debug("Creating command message COMMAND_SUBSEQUENT_SEGMENT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(COMMAND_SUBSEQUENT_SEGMENT);

        // Process 'Properties1'
        outputData.write(datagramSize1 & 0x07);

        // Process 'datagram_size_2'
        outputData.write(datagramSize2);

        // Process 'Properties2'
        int valProperties2 = 0;
        valProperties2 |= datagramOffset1 & 0x07;
        valProperties2 |= ext ? 0x08 : 0;
        valProperties2 |= ((sessionId << 4) & 0xF0);
        outputData.write(valProperties2);

        // Process 'datagram_offset_2'
        outputData.write(datagramOffset2);

        // Process 'Header Extension Length'
        outputData.write(headerExtensionLength);

        // Process 'Header Extension'
        if (headerExtension != null) {
            try {
                outputData.write(headerExtension);
            } catch (IOException e) {
            }
        }

        // Process 'Payload'
        if (payload != null) {
            try {
                outputData.write(payload);
            } catch (IOException e) {
            }
        }

        // Process 'Frame Check Sequence'
        outputData.write((frameCheckSequence >> 8) & 0xff);
        outputData.write(frameCheckSequence & 0xff);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the COMMAND_SUBSEQUENT_SEGMENT command.
     * <p>
     * Subsequent Segment
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>DATAGRAM_SIZE_1 {@link Integer}
     * <li>DATAGRAM_SIZE_2 {@link Integer}
     * <li>DATAGRAM_OFFSET_1 {@link Integer}
     * <li>EXT {@link Boolean}
     * <li>SESSION_ID {@link Integer}
     * <li>DATAGRAM_OFFSET_2 {@link Integer}
     * <li>HEADER_EXTENSION_LENGTH {@link Integer}
     * <li>HEADER_EXTENSION {@link byte[]}
     * <li>PAYLOAD {@link byte[]}
     * <li>FRAME_CHECK_SEQUENCE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleCommandSubsequentSegment(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        response.put("DATAGRAM_SIZE_1", Integer.valueOf(payload[msgOffset] & 0x07));
        msgOffset += 1;

        // Process 'datagram_size_2'
        response.put("DATAGRAM_SIZE_2", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Properties2'
        response.put("DATAGRAM_OFFSET_1", Integer.valueOf(payload[msgOffset] & 0x07));
        response.put("EXT", Boolean.valueOf((payload[msgOffset] & 0x08) != 0));
        response.put("SESSION_ID", Integer.valueOf(payload[msgOffset] & 0xF0 >> 4));
        msgOffset += 1;

        // Process 'datagram_offset_2'
        response.put("DATAGRAM_OFFSET_2", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Header Extension Length' (optional)
        if (true) {
            response.put("HEADER_EXTENSION_LENGTH", Integer.valueOf(payload[msgOffset]));
        }
        msgOffset += 1;

        // Process 'Header Extension' (optional)
        if (true) {
            ByteArrayOutputStream valHeaderExtension = new ByteArrayOutputStream();
            int lenHeaderExtension = payload[msgOffset - 1];
            for (int cntHeaderExtension = 0; cntHeaderExtension < lenHeaderExtension; cntHeaderExtension++) {
                valHeaderExtension.write(payload[msgOffset + cntHeaderExtension]);
            }
            response.put("HEADER_EXTENSION", valHeaderExtension.toByteArray());
            msgOffset += lenHeaderExtension;
        }

        // Process 'Payload'
        ByteArrayOutputStream valPayload = new ByteArrayOutputStream();
        while (msgOffset < payload.length - 2) {
            valPayload.write(payload[msgOffset]);
            msgOffset++;
        }
        response.put("PAYLOAD", valPayload);

        // Process 'Frame Check Sequence'
        response.put("FRAME_CHECK_SEQUENCE", Integer.valueOf(((payload[msgOffset] & 0xff) << 8) + (payload[msgOffset + 1] & 0xff)));
        msgOffset += 2;

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the COMMAND_SEGMENT_COMPLETE command.
     * <p>
     * Segment Complete
     *
     * @param sessionId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getCommandSegmentComplete(Integer sessionId) {
        logger.debug("Creating command message COMMAND_SEGMENT_COMPLETE version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(COMMAND_SEGMENT_COMPLETE);

        // Process 'Properties1'

        // Process 'Properties2'
        outputData.write(((sessionId << 4) & 0xF0));

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the COMMAND_SEGMENT_COMPLETE command.
     * <p>
     * Segment Complete
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SESSION_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleCommandSegmentComplete(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'

        // Process 'Properties2'
        response.put("SESSION_ID", Integer.valueOf(payload[3] & 0xF0 >> 4));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the COMMAND_SEGMENT_WAIT command.
     * <p>
     * Segment Wait
     *
     * @param pendingFragments {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getCommandSegmentWait(Integer pendingFragments) {
        logger.debug("Creating command message COMMAND_SEGMENT_WAIT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(COMMAND_SEGMENT_WAIT);

        // Process 'Properties1'

        // Process 'pending_fragments'
        outputData.write(pendingFragments);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the COMMAND_SEGMENT_WAIT command.
     * <p>
     * Segment Wait
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>PENDING_FRAGMENTS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleCommandSegmentWait(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'

        // Process 'pending_fragments'
        response.put("PENDING_FRAGMENTS", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }
}
