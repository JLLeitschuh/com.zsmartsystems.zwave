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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_ENERGY_PRODUCTION</b> version <b>1</b>.<br>
 * <p>
 * Command Class Energy Production<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassEnergyProductionV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassEnergyProductionV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_ENERGY_PRODUCTION
     */
    public final static int COMMAND_CLASS_KEY = 0x90;

    /**
     * Energy Production Get Command Constant
     */
    public final static int ENERGY_PRODUCTION_GET = 0x02;
    /**
     * Energy Production Report Command Constant
     */
    public final static int ENERGY_PRODUCTION_REPORT = 0x03;


    // Define constants for Parameter Number
    private static Map<Integer, String> constantParameterNumber = new HashMap<Integer, String>();

    static {
        // Constants for Parameter Number
        constantParameterNumber.put(0x00, "INSTANT_ENERGY_PRODUCTION");
        constantParameterNumber.put(0x01, "TOTAL_ENERGY_PRODUCTION");
        constantParameterNumber.put(0x02, "ENERGY_PRODUCTION_TODAY");
        constantParameterNumber.put(0x03, "TOTAL_PRODUCTION_TIME");
    }

    /**
     * Creates a new message with the ENERGY_PRODUCTION_GET command.<br>
     * <p>
     * Energy Production Get<br>
     *
     * @param parameterNumber {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getEnergyProductionGet(String parameterNumber) {
        logger.debug("Creating command message ENERGY_PRODUCTION_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ENERGY_PRODUCTION_GET);

        // Process 'Parameter Number'
        for (Integer entry : constantParameterNumber.keySet()) {
            if (constantParameterNumber.get(entry).equals(parameterNumber)) {
                outputData.write(entry);
                break;
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ENERGY_PRODUCTION_GET command<br>
     * <p>
     * Energy Production Get<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>PARAMETER_NUMBER {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleEnergyProductionGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Parameter Number'
        response.put("PARAMETER_NUMBER", constantParameterNumber.get(payload[2] & 0xff));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ENERGY_PRODUCTION_REPORT command.<br>
     * <p>
     * Energy Production Report<br>
     *
     * @param parameterNumber {@link String}
     * @param size {@link Integer}
     * @param scale {@link Integer}
     * @param precision {@link Integer}
     * @param value {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getEnergyProductionReport(String parameterNumber, Integer size, Integer scale,
            Integer precision, byte[] value) {
        logger.debug("Creating command message ENERGY_PRODUCTION_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ENERGY_PRODUCTION_REPORT);

        // Process 'Parameter Number'
        for (Integer entry : constantParameterNumber.keySet()) {
            if (constantParameterNumber.get(entry).equals(parameterNumber)) {
                outputData.write(entry);
                break;
            }
        }

        // Process 'Level'
        int valLevel = 0;
        valLevel |= size & 0x07;
        valLevel |= ((scale << 3) & 0x18);
        valLevel |= ((precision << 5) & 0xE0);
        outputData.write(valLevel);

        // Process 'Value'
        try {
            outputData.write(value);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ENERGY_PRODUCTION_REPORT command<br>
     * <p>
     * Energy Production Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>PARAMETER_NUMBER {@link String}
     * <li>SIZE {@link Integer}
     * <li>SCALE {@link Integer}
     * <li>PRECISION {@link Integer}
     * <li>VALUE {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleEnergyProductionReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Parameter Number'
        response.put("PARAMETER_NUMBER", constantParameterNumber.get(payload[msgOffset] & 0xff));
        msgOffset += 1;

        // Process 'Level'
        response.put("SIZE", Integer.valueOf(payload[msgOffset] & 0x07));
        response.put("SCALE", Integer.valueOf((payload[msgOffset] & 0x18 >> 3)));
        response.put("PRECISION", Integer.valueOf((payload[msgOffset] & 0xE0 >> 5)));
        msgOffset += 1;

        // Process 'Value'
        int valValue = 0;
        int lenValue = payload[3] & 0x07;
        for (int cntValue = 0; cntValue < lenValue; cntValue++) {
            valValue = (valValue << 8) + payload[msgOffset + cntValue];
        }
        response.put("VALUE", valValue);
        msgOffset += lenValue;

        // Return the map of processed response data;
        return response;
    }

}
