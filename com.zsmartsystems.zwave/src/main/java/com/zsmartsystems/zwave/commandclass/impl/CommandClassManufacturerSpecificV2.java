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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_MANUFACTURER_SPECIFIC</b> version <b>2</b>.
 * <p>
 * Command Class Manufacturer Specific
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x72.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassManufacturerSpecificV2 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassManufacturerSpecificV2.class);

    /**
     * Integer command class key for COMMAND_CLASS_MANUFACTURER_SPECIFIC
     */
    public final static int COMMAND_CLASS_KEY = 0x72;

    /**
     * Manufacturer Specific Get Command Constant
     */
    public final static int MANUFACTURER_SPECIFIC_GET = 0x04;
    /**
     * Manufacturer Specific Report Command Constant
     */
    public final static int MANUFACTURER_SPECIFIC_REPORT = 0x05;
    /**
     * Device Specific Get Command Constant
     */
    public final static int DEVICE_SPECIFIC_GET = 0x06;
    /**
     * Device Specific Report Command Constant
     */
    public final static int DEVICE_SPECIFIC_REPORT = 0x07;

    /**
     * Map holding constants for DeviceSpecificReportDeviceIdDataFormat
     */
    private static Map<Integer, String> constantDeviceSpecificReportDeviceIdDataFormat = new HashMap<Integer, String>();

    /**
     * Map holding constants for DeviceSpecificGetDeviceIdType
     */
    private static Map<Integer, String> constantDeviceSpecificGetDeviceIdType = new HashMap<Integer, String>();

    /**
     * Map holding constants for DeviceSpecificReportDeviceIdType
     */
    private static Map<Integer, String> constantDeviceSpecificReportDeviceIdType = new HashMap<Integer, String>();

    static {
        // Constants for DeviceSpecificReportDeviceIdDataFormat
        constantDeviceSpecificReportDeviceIdDataFormat.put(0x00, "BINARY");

        // Constants for DeviceSpecificGetDeviceIdType
        constantDeviceSpecificGetDeviceIdType.put(0x00, "SERIAL_NUMBER");

        // Constants for DeviceSpecificReportDeviceIdType
        constantDeviceSpecificReportDeviceIdType.put(0x00, "SERIAL_NUMBER");
    }

    /**
     * Creates a new message with the MANUFACTURER_SPECIFIC_GET command.
     * <p>
     * Manufacturer Specific Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getManufacturerSpecificGet() {
        logger.debug("Creating command message MANUFACTURER_SPECIFIC_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MANUFACTURER_SPECIFIC_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MANUFACTURER_SPECIFIC_GET command.
     * <p>
     * Manufacturer Specific Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleManufacturerSpecificGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the MANUFACTURER_SPECIFIC_REPORT command.
     * <p>
     * Manufacturer Specific Report
     *
     * @param manufacturerId {@link Integer}
     * @param productTypeId {@link Integer}
     * @param productId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getManufacturerSpecificReport(Integer manufacturerId, Integer productTypeId, Integer productId) {
        logger.debug("Creating command message MANUFACTURER_SPECIFIC_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MANUFACTURER_SPECIFIC_REPORT);

        // Process 'Manufacturer ID'
        outputData.write((manufacturerId >> 8) & 0xff);
        outputData.write(manufacturerId & 0xff);

        // Process 'Product Type ID'
        outputData.write((productTypeId >> 8) & 0xff);
        outputData.write(productTypeId & 0xff);

        // Process 'Product ID'
        outputData.write((productId >> 8) & 0xff);
        outputData.write(productId & 0xff);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MANUFACTURER_SPECIFIC_REPORT command.
     * <p>
     * Manufacturer Specific Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>MANUFACTURER_ID {@link Integer}
     * <li>PRODUCT_TYPE_ID {@link Integer}
     * <li>PRODUCT_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleManufacturerSpecificReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Manufacturer ID'
        response.put("MANUFACTURER_ID", Integer.valueOf(((payload[2] & 0xff) << 8) + (payload[3] & 0xff)));

        // Process 'Product Type ID'
        response.put("PRODUCT_TYPE_ID", Integer.valueOf(((payload[4] & 0xff) << 8) + (payload[5] & 0xff)));

        // Process 'Product ID'
        response.put("PRODUCT_ID", Integer.valueOf(((payload[6] & 0xff) << 8) + (payload[7] & 0xff)));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DEVICE_SPECIFIC_GET command.
     * <p>
     * Device Specific Get
     *
     * @param deviceIdType {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>SERIAL_NUMBER
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDeviceSpecificGet(String deviceIdType) {
        logger.debug("Creating command message DEVICE_SPECIFIC_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DEVICE_SPECIFIC_GET);

        // Process 'Properties1'
        int varDeviceIdType = Integer.MAX_VALUE;
        for (Integer entry : constantDeviceSpecificGetDeviceIdType.keySet()) {
            if (constantDeviceSpecificGetDeviceIdType.get(entry).equals(deviceIdType)) {
                varDeviceIdType = entry;
                break;
            }
        }
        if (varDeviceIdType == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Unknown constant value '" + deviceIdType + "' for deviceIdType");
        }
        outputData.write(varDeviceIdType & 0x07);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DEVICE_SPECIFIC_GET command.
     * <p>
     * Device Specific Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>DEVICE_ID_TYPE {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>SERIAL_NUMBER
     * </ul>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDeviceSpecificGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("DEVICE_ID_TYPE", constantDeviceSpecificGetDeviceIdType.get(payload[2] & 0x07));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DEVICE_SPECIFIC_REPORT command.
     * <p>
     * Device Specific Report
     *
     * @param deviceIdType {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>SERIAL_NUMBER
     *            </ul>
     * @param deviceIdDataFormat {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>BINARY
     *            </ul>
     * @param deviceIdData {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDeviceSpecificReport(String deviceIdType, String deviceIdDataFormat, byte[] deviceIdData) {
        logger.debug("Creating command message DEVICE_SPECIFIC_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DEVICE_SPECIFIC_REPORT);

        // Process 'Properties1'
        int varDeviceIdType = Integer.MAX_VALUE;
        for (Integer entry : constantDeviceSpecificReportDeviceIdType.keySet()) {
            if (constantDeviceSpecificReportDeviceIdType.get(entry).equals(deviceIdType)) {
                varDeviceIdType = entry;
                break;
            }
        }
        if (varDeviceIdType == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Unknown constant value '" + deviceIdType + "' for deviceIdType");
        }
        outputData.write(varDeviceIdType & 0x07);

        // Process 'Properties2'
        // Device ID Data Length Indicator is used by 'Device ID Data'
        int deviceIdDataLengthIndicator = deviceIdData.length;
        int valProperties2 = 0;
        valProperties2 |= deviceIdDataLengthIndicator & 0x1F;
        int varDeviceIdDataFormat = Integer.MAX_VALUE;
        for (Integer entry : constantDeviceSpecificReportDeviceIdDataFormat.keySet()) {
            if (constantDeviceSpecificReportDeviceIdDataFormat.get(entry).equals(deviceIdDataFormat)) {
                varDeviceIdDataFormat = entry;
                break;
            }
        }
        if (varDeviceIdDataFormat == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Unknown constant value '" + deviceIdDataFormat + "' for deviceIdDataFormat");
        }
        valProperties2 |= varDeviceIdDataFormat << 5 & 0xE0;
        outputData.write(valProperties2);

        // Process 'Device ID Data'
        if (deviceIdData != null) {
            try {
                outputData.write(deviceIdData);
            } catch (IOException e) {
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DEVICE_SPECIFIC_REPORT command.
     * <p>
     * Device Specific Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>DEVICE_ID_TYPE {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>SERIAL_NUMBER
     * </ul>
     * <li>DEVICE_ID_DATA_FORMAT {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>BINARY
     * </ul>
     * <li>DEVICE_ID_DATA {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDeviceSpecificReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        response.put("DEVICE_ID_TYPE", constantDeviceSpecificReportDeviceIdType.get(payload[msgOffset] & 0x07));
        msgOffset += 1;

        // Process 'Properties2'
        // Device ID Data Length Indicator is used by 'Device ID Data'
        int varDeviceIdDataLengthIndicator = payload[msgOffset] & 0x1F;
        response.put("DEVICE_ID_DATA_FORMAT", constantDeviceSpecificReportDeviceIdDataFormat.get((payload[msgOffset] & 0xE0) >> 5));
        msgOffset += 1;

        // Process 'Device ID Data'
        ByteArrayOutputStream valDeviceIdData = new ByteArrayOutputStream();
        for (int cntDeviceIdData = 0; cntDeviceIdData < varDeviceIdDataLengthIndicator; cntDeviceIdData++) {
            valDeviceIdData.write(payload[msgOffset + cntDeviceIdData]);
        }
        response.put("DEVICE_ID_DATA", valDeviceIdData.toByteArray());
        msgOffset += varDeviceIdDataLengthIndicator;

        // Return the map of processed response data;
        return response;
    }
}
