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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SCENE_ACTIVATION</b> version <b>1</b>.
 * <p>
 * Command Class Scene Activation
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x2B.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSceneActivationV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSceneActivationV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_SCENE_ACTIVATION
     */
    public final static int COMMAND_CLASS_KEY = 0x2B;

    /**
     * Scene Activation Set Command Constant
     */
    public final static int SCENE_ACTIVATION_SET = 0x01;

    /**
     * Map holding constants for SceneActivationSetDimmingDuration
     */
    private static Map<Integer, String> constantSceneActivationSetDimmingDuration = new HashMap<Integer, String>();

    static {
        // Constants for SceneActivationSetDimmingDuration
        constantSceneActivationSetDimmingDuration.put(0x00, "INSTANTLY");
        constantSceneActivationSetDimmingDuration.put(0xFF, "CONFIGURED_DIMMING_DURATION");
    }

    /**
     * Creates a new message with the SCENE_ACTIVATION_SET command.
     * <p>
     * Scene Activation Set
     *
     * @param sceneId {@link Integer}
     * @param dimmingDuration {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>INSTANTLY
     *            <li>CONFIGURED_DIMMING_DURATION
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSceneActivationSet(Integer sceneId, String dimmingDuration) {
        logger.debug("Creating command message SCENE_ACTIVATION_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCENE_ACTIVATION_SET);

        // Process 'Scene ID'
        outputData.write(sceneId);

        // Process 'Dimming Duration'
        boolean foundDimmingDuration = false;
        for (Integer entry : constantSceneActivationSetDimmingDuration.keySet()) {
            if (constantSceneActivationSetDimmingDuration.get(entry).equals(dimmingDuration)) {
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
     * Processes a received frame with the SCENE_ACTIVATION_SET command.
     * <p>
     * Scene Activation Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SCENE_ID {@link Integer}
     * <li>DIMMING_DURATION {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>INSTANTLY
     * <li>CONFIGURED_DIMMING_DURATION
     * </ul>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSceneActivationSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Scene ID'
        response.put("SCENE_ID", Integer.valueOf(payload[2]));

        // Process 'Dimming Duration'
        response.put("DIMMING_DURATION", constantSceneActivationSetDimmingDuration.get(payload[3] & 0xff));

        // Return the map of processed response data;
        return response;
    }
}
