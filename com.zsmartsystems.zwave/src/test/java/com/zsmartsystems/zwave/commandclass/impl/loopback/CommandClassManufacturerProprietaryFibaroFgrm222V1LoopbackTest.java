/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl.loopback;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import com.zsmartsystems.zwave.commandclass.impl.CommandClassManufacturerProprietaryFibaroFgrm222V1;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_MANUFACTURER_PROPRIETARY_FIBARO_FGRM222</b> version <b>1</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassManufacturerProprietaryFibaroFgrm222V1LoopbackTest {
    /**
     * Performs an in/out test of the FGRM222_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param command {@link String}
     * @param shutterPosition {@link Integer}
     * @param lamellaPosition {@link Integer}
     */
    public static void testFgrm222SetLoopback(String command, Integer shutterPosition, Integer lamellaPosition) {
        byte[] testPayload = CommandClassManufacturerProprietaryFibaroFgrm222V1.getFgrm222Set(command, shutterPosition,
                lamellaPosition);

        Map<String, Object> response = CommandClassManufacturerProprietaryFibaroFgrm222V1.handleFgrm222Set(testPayload);
        assertEquals(command, (String) response.get("COMMAND"));
        assertEquals(shutterPosition, (Integer) response.get("SHUTTER_POSITION"));
        assertEquals(lamellaPosition, (Integer) response.get("LAMELLA_POSITION"));
    }

    /**
     * Performs an in/out test of the FGRM222_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param shutterPosition {@link Integer}
     * @param lamellaPosition {@link Integer}
     */
    public static void testFgrm222ReportLoopback(Integer shutterPosition, Integer lamellaPosition) {
        byte[] testPayload = CommandClassManufacturerProprietaryFibaroFgrm222V1.getFgrm222Report(shutterPosition,
                lamellaPosition);

        Map<String, Object> response = CommandClassManufacturerProprietaryFibaroFgrm222V1.handleFgrm222Report(testPayload);
        assertEquals(shutterPosition, (Integer) response.get("SHUTTER_POSITION"));
        assertEquals(lamellaPosition, (Integer) response.get("LAMELLA_POSITION"));
    }

}
