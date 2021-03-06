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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_MULTI_CMD</b> version <b>1</b>.
 * <p>
 * Command Class Multi Cmd
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x8F.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassMultiCmdV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassMultiCmdV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_MULTI_CMD
     */
    public final static int COMMAND_CLASS_KEY = 0x8F;

    /**
     * Multi Cmd Encap Command Constant
     */
    public final static int MULTI_CMD_ENCAP = 0x01;


    /**
     * Creates a new message with the MULTI_CMD_ENCAP command.
     * <p>
     * Multi Cmd Encap
     *
     * @param numberOfCommands {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMultiCmdEncap(Integer numberOfCommands) {
        logger.debug("Creating command message MULTI_CMD_ENCAP version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MULTI_CMD_ENCAP);

        // Process 'Number of Commands'
        outputData.write(numberOfCommands);

        // Process 'Encapsulated_Command'

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MULTI_CMD_ENCAP command.
     * <p>
     * Multi Cmd Encap
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>NUMBER_OF_COMMANDS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMultiCmdEncap(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Number of Commands'
        response.put("NUMBER_OF_COMMANDS", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Encapsulated_Command'

        // Create a list to hold the group Encapsulated_Command
        List<Map<String, Object>> variantList = new ArrayList<Map<String, Object>>();

        int offset = msgOffset;
        while (offset < payload.length) {
            // Create a map to hold the members of this variant
            Map<String, Object> variant = new HashMap<String, Object>();

            // Process 'Command Length'
            variant.put("COMMAND_LENGTH", Integer.valueOf(payload[msgOffset]));
            msgOffset += 1;

            // Process 'Command Class'
            variant.put("COMMAND_CLASS", Integer.valueOf(payload[msgOffset]));
            msgOffset += 1;

            // Process 'Command'
            variant.put("COMMAND", Integer.valueOf(payload[msgOffset]));
            msgOffset += 1;

            // Process 'Data'
            variant.put("DATA", Integer.valueOf(payload[msgOffset]));
            msgOffset += payload[msgOffset - 3];

            // Add to the list
            variantList.add(variant);

            // Add the length of this variant
            offset += (payload[offset + 0] & 0xFF) >> 0;
        }

        // Add the variant list to the response
        response.put("ENCAPSULATED_COMMAND", variantList);

        // Return the map of processed response data;
        return response;
    }
}
