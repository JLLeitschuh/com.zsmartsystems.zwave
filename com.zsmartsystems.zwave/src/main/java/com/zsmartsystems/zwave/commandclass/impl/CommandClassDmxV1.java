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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_DMX</b> version <b>1</b>.
 * <p>
 * Command Class DMX
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x65.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassDmxV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassDmxV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_DMX
     */
    public final static int COMMAND_CLASS_KEY = 0x65;

    /**
     * DMX Address Set Command Constant
     */
    public final static int DMX_ADDRESS_SET = 0x01;
    /**
     * DMX Address Get Command Constant
     */
    public final static int DMX_ADDRESS_GET = 0x02;
    /**
     * DMX Address Report Command Constant
     */
    public final static int DMX_ADDRESS_REPORT = 0x03;
    /**
     * DMX Capability Get Command Constant
     */
    public final static int DMX_CAPABILITY_GET = 0x04;
    /**
     * DMX Capability Report Command Constant
     */
    public final static int DMX_CAPABILITY_REPORT = 0x05;
    /**
     * DMX Data Command Constant
     */
    public final static int DMX_DATA = 0x06;


    /**
     * Creates a new message with the DMX_ADDRESS_SET command.
     * <p>
     * DMX Address Set
     *
     * @param pageId {@link Integer}
     * @param channelId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDmxAddressSet(Integer pageId, Integer channelId) {
        logger.debug("Creating command message DMX_ADDRESS_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DMX_ADDRESS_SET);

        // Process 'Properties1'
        outputData.write(pageId & 0x0F);

        // Process 'Channel ID'
        outputData.write(channelId);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DMX_ADDRESS_SET command.
     * <p>
     * DMX Address Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>PAGE_ID {@link Integer}
     * <li>CHANNEL_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDmxAddressSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("PAGE_ID", Integer.valueOf(payload[2] & 0x0F));

        // Process 'Channel ID'
        response.put("CHANNEL_ID", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DMX_ADDRESS_GET command.
     * <p>
     * DMX Address Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDmxAddressGet() {
        logger.debug("Creating command message DMX_ADDRESS_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DMX_ADDRESS_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DMX_ADDRESS_GET command.
     * <p>
     * DMX Address Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDmxAddressGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DMX_ADDRESS_REPORT command.
     * <p>
     * DMX Address Report
     *
     * @param pageId {@link Integer}
     * @param channelId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDmxAddressReport(Integer pageId, Integer channelId) {
        logger.debug("Creating command message DMX_ADDRESS_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DMX_ADDRESS_REPORT);

        // Process 'Properties1'
        outputData.write(pageId & 0x0F);

        // Process 'Channel ID'
        outputData.write(channelId);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DMX_ADDRESS_REPORT command.
     * <p>
     * DMX Address Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>PAGE_ID {@link Integer}
     * <li>CHANNEL_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDmxAddressReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("PAGE_ID", Integer.valueOf(payload[2] & 0x0F));

        // Process 'Channel ID'
        response.put("CHANNEL_ID", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DMX_CAPABILITY_GET command.
     * <p>
     * DMX Capability Get
     *
     * @param channelId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDmxCapabilityGet(Integer channelId) {
        logger.debug("Creating command message DMX_CAPABILITY_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DMX_CAPABILITY_GET);

        // Process 'Channel ID'
        outputData.write(channelId);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DMX_CAPABILITY_GET command.
     * <p>
     * DMX Capability Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>CHANNEL_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDmxCapabilityGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Channel ID'
        response.put("CHANNEL_ID", Integer.valueOf(payload[2]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DMX_CAPABILITY_REPORT command.
     * <p>
     * DMX Capability Report
     *
     * @param channelId {@link Integer}
     * @param propertyId {@link Integer}
     * @param deviceChannels {@link Integer}
     * @param maxChannels {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDmxCapabilityReport(Integer channelId, Integer propertyId, Integer deviceChannels,
            Integer maxChannels) {
        logger.debug("Creating command message DMX_CAPABILITY_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DMX_CAPABILITY_REPORT);

        // Process 'Channel ID'
        outputData.write(channelId);

        // Process 'Property ID'
        outputData.write((propertyId >> 8) & 0xff);
        outputData.write(propertyId & 0xff);

        // Process 'Device Channels'
        outputData.write(deviceChannels);

        // Process 'Max Channels'
        outputData.write(maxChannels);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DMX_CAPABILITY_REPORT command.
     * <p>
     * DMX Capability Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>CHANNEL_ID {@link Integer}
     * <li>PROPERTY_ID {@link Integer}
     * <li>DEVICE_CHANNELS {@link Integer}
     * <li>MAX_CHANNELS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDmxCapabilityReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Channel ID'
        response.put("CHANNEL_ID", Integer.valueOf(payload[2]));

        // Process 'Property ID'
        response.put("PROPERTY_ID", Integer.valueOf(((payload[3] & 0xff) << 8) + (payload[4] & 0xff)));

        // Process 'Device Channels'
        response.put("DEVICE_CHANNELS", Integer.valueOf(payload[5]));

        // Process 'Max Channels'
        response.put("MAX_CHANNELS", Integer.valueOf(payload[6]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DMX_DATA command.
     * <p>
     * DMX Data
     *
     * @param source {@link Integer}
     * @param page {@link Integer}
     * @param sequenceNo {@link Integer}
     * @param dmxChannel {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDmxData(Integer source, Integer page, Integer sequenceNo, byte[] dmxChannel) {
        logger.debug("Creating command message DMX_DATA version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DMX_DATA);

        // Process 'Source'
        outputData.write(source);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= page & 0x0F;
        valProperties1 |= ((sequenceNo << 4) & 0x30);
        outputData.write(valProperties1);

        // Process 'DMX channel'
        if (dmxChannel != null) {
            try {
                outputData.write(dmxChannel);
            } catch (IOException e) {
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DMX_DATA command.
     * <p>
     * DMX Data
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SOURCE {@link Integer}
     * <li>PAGE {@link Integer}
     * <li>SEQUENCE_NO {@link Integer}
     * <li>DMX_CHANNEL {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDmxData(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Source'
        response.put("SOURCE", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Properties1'
        response.put("PAGE", Integer.valueOf(payload[msgOffset] & 0x0F));
        response.put("SEQUENCE_NO", Integer.valueOf(payload[msgOffset] & 0x30 >> 4));
        msgOffset += 1;

        // Process 'DMX channel'
        ByteArrayOutputStream valDmxChannel = new ByteArrayOutputStream();
        while (msgOffset < payload.length) {
            valDmxChannel.write(payload[msgOffset]);
            msgOffset++;
        }
        response.put("DMX_CHANNEL", valDmxChannel);

        // Return the map of processed response data;
        return response;
    }
}
