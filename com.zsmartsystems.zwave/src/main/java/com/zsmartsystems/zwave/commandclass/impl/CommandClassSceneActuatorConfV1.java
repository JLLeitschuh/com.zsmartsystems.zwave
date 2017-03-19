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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SCENE_ACTUATOR_CONF</b> version <b>1</b>.
 * <p>
 * Command Class Scene Actuator Conf
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSceneActuatorConfV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSceneActuatorConfV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_SCENE_ACTUATOR_CONF
     */
    public final static int COMMAND_CLASS_KEY = 0x2C;

    /**
     * Scene Actuator Conf Set Command Constant
     */
    public final static int SCENE_ACTUATOR_CONF_SET = 0x01;
    /**
     * Scene Actuator Conf Get Command Constant
     */
    public final static int SCENE_ACTUATOR_CONF_GET = 0x02;
    /**
     * Scene Actuator Conf Report Command Constant
     */
    public final static int SCENE_ACTUATOR_CONF_REPORT = 0x03;


    /**
     * Map holding constants for Level2
     */
    private static Map<Integer, String> constantLevel2 = new HashMap<Integer, String>();

    /**
     * Map holding constants for Dimming Duration
     */
    private static Map<Integer, String> constantDimmingDuration = new HashMap<Integer, String>();
    static {

        // Constants for Level2
        constantLevel2.put(0x80, "OVERRIDE");

        // Constants for Dimming Duration
        constantDimmingDuration.put(0x00, "SPECIFY_INSTANTLY");
        constantDimmingDuration.put(0xFF, "FACTORY_DEFAULT");
    }

    /**
     * Creates a new message with the SCENE_ACTUATOR_CONF_SET command.
     * <p>
     * Scene Actuator Conf Set
     *
     * @param sceneId {@link Integer}
     * @param dimmingDuration {@link String}
     * @param override {@link Boolean}
     * @param level {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSceneActuatorConfSet(Integer sceneId, String dimmingDuration, Boolean override,
            Integer level) {
        logger.debug("Creating command message SCENE_ACTUATOR_CONF_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCENE_ACTUATOR_CONF_SET);

        // Process 'Scene ID'
        outputData.write(sceneId);

        // Process 'Dimming Duration'
        boolean foundDimmingDuration = false;
        for (Integer entry : constantDimmingDuration.keySet()) {
            if (constantDimmingDuration.get(entry).equals(dimmingDuration)) {
                outputData.write(entry);
                foundDimmingDuration = true;
                break;
            }
        }
        if (!foundDimmingDuration) {
            throw new IllegalArgumentException("Unknown constant value '" + dimmingDuration + "' for dimmingDuration");
        }

        // Process 'Level2'
        outputData.write(override ? 0x80 : 0);

        // Process 'Level'
        outputData.write(level);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCENE_ACTUATOR_CONF_SET command.
     * <p>
     * Scene Actuator Conf Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SCENE_ID {@link Integer}
     * <li>DIMMING_DURATION {@link String}
     * <li>OVERRIDE {@link Boolean}
     * <li>LEVEL {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSceneActuatorConfSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Scene ID'
        response.put("SCENE_ID", Integer.valueOf(payload[2]));

        // Process 'Dimming Duration'
        response.put("DIMMING_DURATION", constantDimmingDuration.get(payload[3] & 0xff));

        // Process 'Level2'
        response.put("OVERRIDE", Boolean.valueOf((payload[4] & 0x80) != 0));

        // Process 'Level'
        response.put("LEVEL", Integer.valueOf(payload[5]));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the SCENE_ACTUATOR_CONF_GET command.
     * <p>
     * Scene Actuator Conf Get
     *
     * @param sceneId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSceneActuatorConfGet(Integer sceneId) {
        logger.debug("Creating command message SCENE_ACTUATOR_CONF_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCENE_ACTUATOR_CONF_GET);

        // Process 'Scene ID'
        outputData.write(sceneId);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCENE_ACTUATOR_CONF_GET command.
     * <p>
     * Scene Actuator Conf Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SCENE_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSceneActuatorConfGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Scene ID'
        response.put("SCENE_ID", Integer.valueOf(payload[2]));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the SCENE_ACTUATOR_CONF_REPORT command.
     * <p>
     * Scene Actuator Conf Report
     *
     * @param sceneId {@link Integer}
     * @param level {@link Integer}
     * @param dimmingDuration {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSceneActuatorConfReport(Integer sceneId, Integer level, String dimmingDuration) {
        logger.debug("Creating command message SCENE_ACTUATOR_CONF_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCENE_ACTUATOR_CONF_REPORT);

        // Process 'Scene ID'
        outputData.write(sceneId);

        // Process 'Level'
        outputData.write(level);

        // Process 'Dimming Duration'
        boolean foundDimmingDuration = false;
        for (Integer entry : constantDimmingDuration.keySet()) {
            if (constantDimmingDuration.get(entry).equals(dimmingDuration)) {
                outputData.write(entry);
                foundDimmingDuration = true;
                break;
            }
        }
        if (!foundDimmingDuration) {
            throw new IllegalArgumentException("Unknown constant value '" + dimmingDuration + "' for dimmingDuration");
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCENE_ACTUATOR_CONF_REPORT command.
     * <p>
     * Scene Actuator Conf Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SCENE_ID {@link Integer}
     * <li>LEVEL {@link Integer}
     * <li>DIMMING_DURATION {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSceneActuatorConfReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Scene ID'
        response.put("SCENE_ID", Integer.valueOf(payload[2]));

        // Process 'Level'
        response.put("LEVEL", Integer.valueOf(payload[3]));

        // Process 'Dimming Duration'
        response.put("DIMMING_DURATION", constantDimmingDuration.get(payload[4] & 0xff));

        // Return the map of processed response data;
        return response;
    }

}
