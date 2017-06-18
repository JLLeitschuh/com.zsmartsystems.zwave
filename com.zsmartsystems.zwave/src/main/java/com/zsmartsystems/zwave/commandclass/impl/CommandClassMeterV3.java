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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_METER</b> version <b>3</b>.
 * <p>
 * Command Class Meter
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x32.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassMeterV3 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassMeterV3.class);

    /**
     * Integer command class key for COMMAND_CLASS_METER
     */
    public final static int COMMAND_CLASS_KEY = 0x32;

    /**
     * Meter Get Command Constant
     */
    public final static int METER_GET = 0x01;
    /**
     * Meter Report Command Constant
     */
    public final static int METER_REPORT = 0x02;
    /**
     * Meter Supported Get Command Constant
     */
    public final static int METER_SUPPORTED_GET = 0x03;
    /**
     * Meter Supported Report Command Constant
     */
    public final static int METER_SUPPORTED_REPORT = 0x04;
    /**
     * Meter Reset Command Constant
     */
    public final static int METER_RESET = 0x05;

    /**
     * Map holding constants for MeterSupportedReportProperties1
     */
    private static Map<Integer, String> constantMeterSupportedReportProperties1 = new HashMap<Integer, String>();

    /**
     * Map holding constants for MeterReportProperties1
     */
    private static Map<Integer, String> constantMeterReportProperties1 = new HashMap<Integer, String>();

    static {
        // Constants for MeterSupportedReportProperties1
        constantMeterSupportedReportProperties1.put(0x80, "METER_RESET");

        // Constants for MeterReportProperties1
        constantMeterReportProperties1.put(0x80, "SCALE_BIT_2");
    }

    /**
     * Creates a new message with the METER_GET command.
     * <p>
     * Meter Get
     *
     * @param scale {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMeterGet(Integer scale) {
        logger.debug("Creating command message METER_GET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(METER_GET);

        // Process 'Properties1'
        outputData.write(((scale << 3) & 0x38));

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the METER_GET command.
     * <p>
     * Meter Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SCALE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMeterGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("SCALE", Integer.valueOf(payload[2] & 0x38 >> 3));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the METER_REPORT command.
     * <p>
     * Meter Report
     *
     * @param meterType {@link Integer}
     * @param rateType {@link Integer}
     * @param scaleBit2 {@link Boolean}
     * @param scaleBits10 {@link Integer}
     * @param precision {@link Integer}
     * @param meterValue {@link byte[]}
     * @param deltaTime {@link Integer}
     * @param previousMeterValue {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMeterReport(Integer meterType, Integer rateType, Boolean scaleBit2, Integer scaleBits10,
            Integer precision, byte[] meterValue, Integer deltaTime, byte[] previousMeterValue) {
        logger.debug("Creating command message METER_REPORT version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(METER_REPORT);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= meterType & 0x1F;
        valProperties1 |= ((rateType << 5) & 0x60);
        valProperties1 |= scaleBit2 ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Properties2'
        // Size is used by 'Meter Value' and 'Previous Meter Value'
        int size = meterValue.length;
        int valProperties2 = 0;
        valProperties2 |= size & 0x07;
        valProperties2 |= ((scaleBits10 << 3) & 0x18);
        valProperties2 |= ((precision << 5) & 0xE0);
        outputData.write(valProperties2);

        // Process 'Meter Value'
        if (meterValue != null) {
            try {
                outputData.write(meterValue);
            } catch (IOException e) {
            }
        }

        // Process 'Delta Time'
        outputData.write((deltaTime >> 8) & 0xff);
        outputData.write(deltaTime & 0xff);

        // Process 'Previous Meter Value'
        if (previousMeterValue != null) {
            try {
                outputData.write(previousMeterValue);
            } catch (IOException e) {
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the METER_REPORT command.
     * <p>
     * Meter Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>METER_TYPE {@link Integer}
     * <li>RATE_TYPE {@link Integer}
     * <li>SCALE_BIT_2 {@link Boolean}
     * <li>SCALE_BITS_10 {@link Integer}
     * <li>PRECISION {@link Integer}
     * <li>METER_VALUE {@link byte[]}
     * <li>DELTA_TIME {@link Integer}
     * <li>PREVIOUS_METER_VALUE {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMeterReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        response.put("METER_TYPE", Integer.valueOf(payload[msgOffset] & 0x1F));
        response.put("RATE_TYPE", Integer.valueOf(payload[msgOffset] & 0x60 >> 5));
        response.put("SCALE_BIT_2", Boolean.valueOf((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'Properties2'
        // Size is used by 'Meter Value' and 'Previous Meter Value'
        int varSize = payload[msgOffset] & 0x07;
        response.put("SCALE_BITS_10", Integer.valueOf(payload[msgOffset] & 0x18 >> 3));
        response.put("PRECISION", Integer.valueOf(payload[msgOffset] & 0xE0 >> 5));
        msgOffset += 1;

        // Process 'Meter Value'
        ByteArrayOutputStream valMeterValue = new ByteArrayOutputStream();
        for (int cntMeterValue = 0; cntMeterValue < varSize; cntMeterValue++) {
            valMeterValue.write(payload[msgOffset + cntMeterValue]);
        }
        response.put("METER_VALUE", valMeterValue.toByteArray());
        msgOffset += varSize;

        // Process 'Delta Time'
        response.put("DELTA_TIME", Integer.valueOf(((payload[msgOffset] & 0xff) << 8) + (payload[msgOffset + 1] & 0xff)));
        msgOffset += 2;

        // Process 'Previous Meter Value' (optional)
        if (true) {
            ByteArrayOutputStream valPreviousMeterValue = new ByteArrayOutputStream();
            for (int cntPreviousMeterValue = 0; cntPreviousMeterValue < varSize; cntPreviousMeterValue++) {
                valPreviousMeterValue.write(payload[msgOffset + cntPreviousMeterValue]);
            }
            response.put("PREVIOUS_METER_VALUE", valPreviousMeterValue.toByteArray());
            msgOffset += varSize;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the METER_SUPPORTED_GET command.
     * <p>
     * Meter Supported Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMeterSupportedGet() {
        logger.debug("Creating command message METER_SUPPORTED_GET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(METER_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the METER_SUPPORTED_GET command.
     * <p>
     * Meter Supported Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMeterSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the METER_SUPPORTED_REPORT command.
     * <p>
     * Meter Supported Report
     *
     * @param meterType {@link Integer}
     * @param meterReset {@link Boolean}
     * @param scaleSupported {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMeterSupportedReport(Integer meterType, Boolean meterReset, Integer scaleSupported) {
        logger.debug("Creating command message METER_SUPPORTED_REPORT version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(METER_SUPPORTED_REPORT);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= meterType & 0x1F;
        valProperties1 |= meterReset ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Scale Supported'
        outputData.write(scaleSupported);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the METER_SUPPORTED_REPORT command.
     * <p>
     * Meter Supported Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>METER_TYPE {@link Integer}
     * <li>METER_RESET {@link Boolean}
     * <li>SCALE_SUPPORTED {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMeterSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("METER_TYPE", Integer.valueOf(payload[2] & 0x1F));
        response.put("METER_RESET", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Process 'Scale Supported'
        response.put("SCALE_SUPPORTED", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the METER_RESET command.
     * <p>
     * Meter Reset
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMeterReset() {
        logger.debug("Creating command message METER_RESET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(METER_RESET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the METER_RESET command.
     * <p>
     * Meter Reset
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMeterReset(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }
}
