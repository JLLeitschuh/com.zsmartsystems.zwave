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
import com.zsmartsystems.zwave.commandclass.impl.CommandClassTariffTblMonitorV1;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_TARIFF_TBL_MONITOR</b> version <b>1</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassTariffTblMonitorV1LoopbackTest {
    /**
     * Performs an in/out test of the TARIFF_TBL_SUPPLIER_REPORT command.
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
    public static void testTariffTblSupplierReportLoopback(Integer year, Integer month, Integer day,
            Integer hourLocalTime, Integer minuteLocalTime, Integer secondLocalTime, Integer standingChargePeriod,
            Integer standingChargePrecision, Long standingChargeValue, byte[] supplierCharacter) {
        byte[] testPayload = CommandClassTariffTblMonitorV1.getTariffTblSupplierReport(year, month, day, hourLocalTime,
                minuteLocalTime, secondLocalTime, standingChargePeriod, standingChargePrecision, standingChargeValue,
                supplierCharacter);

        Map<String, Object> response = CommandClassTariffTblMonitorV1.handleTariffTblSupplierReport(testPayload);
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
     * Performs an in/out test of the TARIFF_TBL_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param rateParameterSetId {@link Integer}
     */
    public static void testTariffTblGetLoopback(Integer rateParameterSetId) {
        byte[] testPayload = CommandClassTariffTblMonitorV1.getTariffTblGet(rateParameterSetId);

        Map<String, Object> response = CommandClassTariffTblMonitorV1.handleTariffTblGet(testPayload);
        assertEquals(rateParameterSetId, (Integer) response.get("RATE_PARAMETER_SET_ID"));
    }

    /**
     * Performs an in/out test of the TARIFF_TBL_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param rateParameterSetId {@link Integer}
     * @param tariffPrecision {@link Integer}
     * @param tariffValue {@link Long}
     */
    public static void testTariffTblReportLoopback(Integer rateParameterSetId, Integer tariffPrecision, Long tariffValue) {
        byte[] testPayload = CommandClassTariffTblMonitorV1.getTariffTblReport(rateParameterSetId, tariffPrecision,
                tariffValue);

        Map<String, Object> response = CommandClassTariffTblMonitorV1.handleTariffTblReport(testPayload);
        assertEquals(rateParameterSetId, (Integer) response.get("RATE_PARAMETER_SET_ID"));
        assertEquals(tariffPrecision, (Integer) response.get("TARIFF_PRECISION"));
        assertEquals(tariffValue, (Long) response.get("TARIFF_VALUE"));
    }

    /**
     * Performs an in/out test of the TARIFF_TBL_COST_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param rateParameterSetId {@link Integer}
     * @param startYear {@link Integer}
     * @param startMonth {@link Integer}
     * @param startDay {@link Integer}
     * @param startHourLocalTime {@link Integer}
     * @param startMinuteLocalTime {@link Integer}
     * @param stopYear {@link Integer}
     * @param stopMonth {@link Integer}
     * @param stopDay {@link Integer}
     * @param stopHourLocalTime {@link Integer}
     * @param stopMinuteLocalTime {@link Integer}
     */
    public static void testTariffTblCostGetLoopback(Integer rateParameterSetId, Integer startYear, Integer startMonth,
            Integer startDay, Integer startHourLocalTime, Integer startMinuteLocalTime, Integer stopYear,
            Integer stopMonth, Integer stopDay, Integer stopHourLocalTime, Integer stopMinuteLocalTime) {
        byte[] testPayload = CommandClassTariffTblMonitorV1.getTariffTblCostGet(rateParameterSetId, startYear,
                startMonth, startDay, startHourLocalTime, startMinuteLocalTime, stopYear, stopMonth, stopDay,
                stopHourLocalTime, stopMinuteLocalTime);

        Map<String, Object> response = CommandClassTariffTblMonitorV1.handleTariffTblCostGet(testPayload);
        assertEquals(rateParameterSetId, (Integer) response.get("RATE_PARAMETER_SET_ID"));
        assertEquals(startYear, (Integer) response.get("START_YEAR"));
        assertEquals(startMonth, (Integer) response.get("START_MONTH"));
        assertEquals(startDay, (Integer) response.get("START_DAY"));
        assertEquals(startHourLocalTime, (Integer) response.get("START_HOUR_LOCAL_TIME"));
        assertEquals(startMinuteLocalTime, (Integer) response.get("START_MINUTE_LOCAL_TIME"));
        assertEquals(stopYear, (Integer) response.get("STOP_YEAR"));
        assertEquals(stopMonth, (Integer) response.get("STOP_MONTH"));
        assertEquals(stopDay, (Integer) response.get("STOP_DAY"));
        assertEquals(stopHourLocalTime, (Integer) response.get("STOP_HOUR_LOCAL_TIME"));
        assertEquals(stopMinuteLocalTime, (Integer) response.get("STOP_MINUTE_LOCAL_TIME"));
    }

    /**
     * Performs an in/out test of the TARIFF_TBL_COST_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param rateParameterSetId {@link Integer}
     * @param rateType {@link Integer}
     * @param startYear {@link Integer}
     * @param startMonth {@link Integer}
     * @param startDay {@link Integer}
     * @param startHourLocalTime {@link Integer}
     * @param startMinuteLocalTime {@link Integer}
     * @param stopYear {@link Integer}
     * @param stopMonth {@link Integer}
     * @param stopDay {@link Integer}
     * @param stopHourLocalTime {@link Integer}
     * @param stopMinuteLocalTime {@link Integer}
     * @param costPrecision {@link Integer}
     * @param costValue {@link Long}
     */
    public static void testTariffTblCostReportLoopback(Integer rateParameterSetId, Integer rateType, Integer startYear,
            Integer startMonth, Integer startDay, Integer startHourLocalTime, Integer startMinuteLocalTime,
            Integer stopYear, Integer stopMonth, Integer stopDay, Integer stopHourLocalTime, Integer stopMinuteLocalTime,
            Integer costPrecision, Long costValue) {
        byte[] testPayload = CommandClassTariffTblMonitorV1.getTariffTblCostReport(rateParameterSetId, rateType,
                startYear, startMonth, startDay, startHourLocalTime, startMinuteLocalTime, stopYear, stopMonth, stopDay,
                stopHourLocalTime, stopMinuteLocalTime, costPrecision, costValue);

        Map<String, Object> response = CommandClassTariffTblMonitorV1.handleTariffTblCostReport(testPayload);
        assertEquals(rateParameterSetId, (Integer) response.get("RATE_PARAMETER_SET_ID"));
        assertEquals(rateType, (Integer) response.get("RATE_TYPE"));
        assertEquals(startYear, (Integer) response.get("START_YEAR"));
        assertEquals(startMonth, (Integer) response.get("START_MONTH"));
        assertEquals(startDay, (Integer) response.get("START_DAY"));
        assertEquals(startHourLocalTime, (Integer) response.get("START_HOUR_LOCAL_TIME"));
        assertEquals(startMinuteLocalTime, (Integer) response.get("START_MINUTE_LOCAL_TIME"));
        assertEquals(stopYear, (Integer) response.get("STOP_YEAR"));
        assertEquals(stopMonth, (Integer) response.get("STOP_MONTH"));
        assertEquals(stopDay, (Integer) response.get("STOP_DAY"));
        assertEquals(stopHourLocalTime, (Integer) response.get("STOP_HOUR_LOCAL_TIME"));
        assertEquals(stopMinuteLocalTime, (Integer) response.get("STOP_MINUTE_LOCAL_TIME"));
        assertEquals(costPrecision, (Integer) response.get("COST_PRECISION"));
        assertEquals(costValue, (Long) response.get("COST_VALUE"));
    }

}
