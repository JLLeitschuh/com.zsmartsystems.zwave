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
import com.zsmartsystems.zwave.commandclass.impl.CommandClassTariffConfigV1;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_TARIFF_CONFIG</b> version <b>1</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassTariffConfigV1LoopbackTest {
    /**
     * Performs an in/out test of the TARIFF_TBL_SUPPLIER_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param year {@link Integer}
     * @param month {@link Integer}
     * @param day {@link Integer}
     * @param hourLocalTime {@link Integer}
     * @param minuteLocalTime {@link Integer}
     * @param secondLocalTime {@link Integer}
     * @param standingChargePeriod {@link Integer}
     * @param standingChargePrecision {@link Integer}
     * @param standingChargeValue {@link Long}
     * @param supplierCharacter {@link byte[]}
     */
    public static void testTariffTblSupplierSetLoopback(Integer year, Integer month, Integer day, Integer hourLocalTime,
            Integer minuteLocalTime, Integer secondLocalTime, Integer standingChargePeriod,
            Integer standingChargePrecision, Long standingChargeValue, byte[] supplierCharacter) {
        byte[] testPayload = CommandClassTariffConfigV1.getTariffTblSupplierSet(year, month, day, hourLocalTime,
                minuteLocalTime, secondLocalTime, standingChargePeriod, standingChargePrecision, standingChargeValue,
                supplierCharacter);

        Map<String, Object> response = CommandClassTariffConfigV1.handleTariffTblSupplierSet(testPayload);
        assertEquals(year, (Integer) response.get("YEAR"));
        assertEquals(month, (Integer) response.get("MONTH"));
        assertEquals(day, (Integer) response.get("DAY"));
        assertEquals(hourLocalTime, (Integer) response.get("HOUR_LOCAL_TIME"));
        assertEquals(minuteLocalTime, (Integer) response.get("MINUTE_LOCAL_TIME"));
        assertEquals(secondLocalTime, (Integer) response.get("SECOND_LOCAL_TIME"));
        assertEquals(standingChargePeriod, (Integer) response.get("STANDING_CHARGE_PERIOD"));
        assertEquals(standingChargePrecision, (Integer) response.get("STANDING_CHARGE_PRECISION"));
        assertEquals(standingChargeValue, (Long) response.get("STANDING_CHARGE_VALUE"));
        assertEquals(supplierCharacter, (byte[]) response.get("SUPPLIER_CHARACTER"));
    }

    /**
     * Performs an in/out test of the TARIFF_TBL_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param rateParameterSetId {@link Integer}
     * @param tariffPrecision {@link Integer}
     * @param tariffValue {@link Long}
     */
    public static void testTariffTblSetLoopback(Integer rateParameterSetId, Integer tariffPrecision, Long tariffValue) {
        byte[] testPayload = CommandClassTariffConfigV1.getTariffTblSet(rateParameterSetId, tariffPrecision, tariffValue);

        Map<String, Object> response = CommandClassTariffConfigV1.handleTariffTblSet(testPayload);
        assertEquals(rateParameterSetId, (Integer) response.get("RATE_PARAMETER_SET_ID"));
        assertEquals(tariffPrecision, (Integer) response.get("TARIFF_PRECISION"));
        assertEquals(tariffValue, (Long) response.get("TARIFF_VALUE"));
    }

    /**
     * Performs an in/out test of the TARIFF_TBL_REMOVE command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param rateParameterSetId {@link byte[]}
     */
    public static void testTariffTblRemoveLoopback(byte[] rateParameterSetId) {
        byte[] testPayload = CommandClassTariffConfigV1.getTariffTblRemove(rateParameterSetId);

        Map<String, Object> response = CommandClassTariffConfigV1.handleTariffTblRemove(testPayload);
        assertEquals(rateParameterSetId, (byte[]) response.get("RATE_PARAMETER_SET_ID"));
    }

}
