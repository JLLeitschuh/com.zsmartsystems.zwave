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
import com.zsmartsystems.zwave.commandclass.impl.CommandClassMeterV3;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_METER</b> version <b>3</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassMeterV3LoopbackTest {
    /**
     * Performs an in/out test of the METER_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param scale {@link Integer}
     */
    public static void testMeterGetLoopback(Integer scale) {
        byte[] testPayload = CommandClassMeterV3.getMeterGet(scale);

        Map<String, Object> response = CommandClassMeterV3.handleMeterGet(testPayload);
        assertEquals(scale, (Integer) response.get("SCALE"));
    }

    /**
     * Performs an in/out test of the METER_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param meterType {@link Integer}
     * @param rateType {@link Integer}
     * @param scaleBit2 {@link Boolean}
     * @param scaleBits10 {@link Integer}
     * @param precision {@link Integer}
     * @param meterValue {@link byte[]}
     * @param deltaTime {@link Integer}
     * @param previousMeterValue {@link byte[]}
     */
    public static void testMeterReportLoopback(Integer meterType, Integer rateType, Boolean scaleBit2,
            Integer scaleBits10, Integer precision, byte[] meterValue, Integer deltaTime, byte[] previousMeterValue) {
        byte[] testPayload = CommandClassMeterV3.getMeterReport(meterType, rateType, scaleBit2, scaleBits10, precision,
                meterValue, deltaTime, previousMeterValue);

        Map<String, Object> response = CommandClassMeterV3.handleMeterReport(testPayload);
        assertEquals(meterType, (Integer) response.get("METER_TYPE"));
        assertEquals(rateType, (Integer) response.get("RATE_TYPE"));
        assertEquals(scaleBit2, (Boolean) response.get("SCALE_BIT2"));
        assertEquals(scaleBits10, (Integer) response.get("SCALE_BITS10"));
        assertEquals(precision, (Integer) response.get("PRECISION"));
        assertEquals(meterValue, (byte[]) response.get("METER_VALUE"));
        assertEquals(deltaTime, (Integer) response.get("DELTA_TIME"));
        assertEquals(previousMeterValue, (byte[]) response.get("PREVIOUS_METER_VALUE"));
    }

    /**
     * Performs an in/out test of the METER_SUPPORTED_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param meterType {@link Integer}
     * @param meterReset {@link Boolean}
     * @param scaleSupported {@link Integer}
     */
    public static void testMeterSupportedReportLoopback(Integer meterType, Boolean meterReset, Integer scaleSupported) {
        byte[] testPayload = CommandClassMeterV3.getMeterSupportedReport(meterType, meterReset, scaleSupported);

        Map<String, Object> response = CommandClassMeterV3.handleMeterSupportedReport(testPayload);
        assertEquals(meterType, (Integer) response.get("METER_TYPE"));
        assertEquals(meterReset, (Boolean) response.get("METER_RESET"));
        assertEquals(scaleSupported, (Integer) response.get("SCALE_SUPPORTED"));
    }

}
