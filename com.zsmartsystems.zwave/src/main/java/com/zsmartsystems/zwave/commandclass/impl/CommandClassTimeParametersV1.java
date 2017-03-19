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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_TIME_PARAMETERS</b> version <b>1</b>.
 * <p>
 * Command Class Time Parameters
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassTimeParametersV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassTimeParametersV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_TIME_PARAMETERS
     */
    public final static int COMMAND_CLASS_KEY = 0x8B;

    /**
     * Time Parameters Set Command Constant
     */
    public final static int TIME_PARAMETERS_SET = 0x01;
    /**
     * Time Parameters Get Command Constant
     */
    public final static int TIME_PARAMETERS_GET = 0x02;
    /**
     * Time Parameters Report Command Constant
     */
    public final static int TIME_PARAMETERS_REPORT = 0x03;


    /**
     * Creates a new message with the TIME_PARAMETERS_SET command.
     * <p>
     * Time Parameters Set
     *
     * @param year {@link Integer}
     * @param month {@link Integer}
     * @param day {@link Integer}
     * @param hourUtc {@link Integer}
     * @param minuteUtc {@link Integer}
     * @param secondUtc {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getTimeParametersSet(Integer year, Integer month, Integer day, Integer hourUtc,
            Integer minuteUtc, Integer secondUtc) {
        logger.debug("Creating command message TIME_PARAMETERS_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(TIME_PARAMETERS_SET);

        // Process 'Year'
        outputData.write((year >> 8) & 0xff);
        outputData.write(year & 0xff);

        // Process 'Month'
        outputData.write(month);

        // Process 'Day'
        outputData.write(day);

        // Process 'Hour UTC'
        outputData.write(hourUtc);

        // Process 'Minute UTC'
        outputData.write(minuteUtc);

        // Process 'Second UTC'
        outputData.write(secondUtc);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the TIME_PARAMETERS_SET command.
     * <p>
     * Time Parameters Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>YEAR {@link Integer}
     * <li>MONTH {@link Integer}
     * <li>DAY {@link Integer}
     * <li>HOUR_UTC {@link Integer}
     * <li>MINUTE_UTC {@link Integer}
     * <li>SECOND_UTC {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleTimeParametersSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Year'
        response.put("YEAR", Integer.valueOf(((payload[2] & 0xff) << 8) + (payload[3] & 0xff)));

        // Process 'Month'
        response.put("MONTH", Integer.valueOf(payload[4]));

        // Process 'Day'
        response.put("DAY", Integer.valueOf(payload[5]));

        // Process 'Hour UTC'
        response.put("HOUR_UTC", Integer.valueOf(payload[6]));

        // Process 'Minute UTC'
        response.put("MINUTE_UTC", Integer.valueOf(payload[7]));

        // Process 'Second UTC'
        response.put("SECOND_UTC", Integer.valueOf(payload[8]));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the TIME_PARAMETERS_GET command.
     * <p>
     * Time Parameters Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getTimeParametersGet() {
        logger.debug("Creating command message TIME_PARAMETERS_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(TIME_PARAMETERS_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the TIME_PARAMETERS_GET command.
     * <p>
     * Time Parameters Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleTimeParametersGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the TIME_PARAMETERS_REPORT command.
     * <p>
     * Time Parameters Report
     *
     * @param year {@link Integer}
     * @param month {@link Integer}
     * @param day {@link Integer}
     * @param hourUtc {@link Integer}
     * @param minuteUtc {@link Integer}
     * @param secondUtc {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getTimeParametersReport(Integer year, Integer month, Integer day, Integer hourUtc,
            Integer minuteUtc, Integer secondUtc) {
        logger.debug("Creating command message TIME_PARAMETERS_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(TIME_PARAMETERS_REPORT);

        // Process 'Year'
        outputData.write((year >> 8) & 0xff);
        outputData.write(year & 0xff);

        // Process 'Month'
        outputData.write(month);

        // Process 'Day'
        outputData.write(day);

        // Process 'Hour UTC'
        outputData.write(hourUtc);

        // Process 'Minute UTC'
        outputData.write(minuteUtc);

        // Process 'Second UTC'
        outputData.write(secondUtc);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the TIME_PARAMETERS_REPORT command.
     * <p>
     * Time Parameters Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>YEAR {@link Integer}
     * <li>MONTH {@link Integer}
     * <li>DAY {@link Integer}
     * <li>HOUR_UTC {@link Integer}
     * <li>MINUTE_UTC {@link Integer}
     * <li>SECOND_UTC {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleTimeParametersReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Year'
        response.put("YEAR", Integer.valueOf(((payload[2] & 0xff) << 8) + (payload[3] & 0xff)));

        // Process 'Month'
        response.put("MONTH", Integer.valueOf(payload[4]));

        // Process 'Day'
        response.put("DAY", Integer.valueOf(payload[5]));

        // Process 'Hour UTC'
        response.put("HOUR_UTC", Integer.valueOf(payload[6]));

        // Process 'Minute UTC'
        response.put("MINUTE_UTC", Integer.valueOf(payload[7]));

        // Process 'Second UTC'
        response.put("SECOND_UTC", Integer.valueOf(payload[8]));

        // Return the map of processed response data;
        return response;
    }

}
