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
import java.util.List;
import com.zsmartsystems.zwave.commandclass.impl.CommandClassNetworkManagementInclusionV1;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_NETWORK_MANAGEMENT_INCLUSION</b> version <b>1</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassNetworkManagementInclusionV1LoopbackTest {
    /**
     * Performs an in/out test of the NODE_ADD command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param mode {@link String}
     * @param txOptions {@link List<String>}
     */
    public static void testNodeAddLoopback(Integer seqNo, String mode, List<String> txOptions) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getNodeAdd(seqNo, mode, txOptions);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleNodeAdd(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(mode, (String) response.get("MODE"));
        assertEquals(txOptions, (List<String>) response.get("TX_OPTIONS"));
    }

    /**
     * Performs an in/out test of the NODE_ADD_STATUS command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param status {@link String}
     * @param newNodeId {@link Integer}
     * @param nodeInfoLength {@link Integer}
     * @param capability {@link Integer}
     * @param listening {@link Boolean}
     * @param security {@link Integer}
     * @param opt {@link Boolean}
     * @param basicDeviceClass {@link Integer}
     * @param genericDeviceClass {@link Integer}
     * @param specificDeviceClass {@link Integer}
     * @param commandClass {@link byte[]}
     */
    public static void testNodeAddStatusLoopback(Integer seqNo, String status, Integer newNodeId, Integer nodeInfoLength,
            Integer capability, Boolean listening, Integer security, Boolean opt, Integer basicDeviceClass,
            Integer genericDeviceClass, Integer specificDeviceClass, byte[] commandClass) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getNodeAddStatus(seqNo, status, newNodeId,
                nodeInfoLength, capability, listening, security, opt, basicDeviceClass, genericDeviceClass,
                specificDeviceClass, commandClass);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleNodeAddStatus(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(status, (String) response.get("STATUS"));
        assertEquals(newNodeId, (Integer) response.get("NEW_NODE_ID"));
        assertEquals(nodeInfoLength, (Integer) response.get("NODE_INFO_LENGTH"));
        assertEquals(capability, (Integer) response.get("CAPABILITY"));
        assertEquals(listening, (Boolean) response.get("LISTENING"));
        assertEquals(security, (Integer) response.get("SECURITY"));
        assertEquals(opt, (Boolean) response.get("OPT"));
        assertEquals(basicDeviceClass, (Integer) response.get("BASIC_DEVICE_CLASS"));
        assertEquals(genericDeviceClass, (Integer) response.get("GENERIC_DEVICE_CLASS"));
        assertEquals(specificDeviceClass, (Integer) response.get("SPECIFIC_DEVICE_CLASS"));
        assertEquals(commandClass, (byte[]) response.get("COMMAND_CLASS"));
    }

    /**
     * Performs an in/out test of the NODE_REMOVE command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param mode {@link String}
     */
    public static void testNodeRemoveLoopback(Integer seqNo, String mode) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getNodeRemove(seqNo, mode);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleNodeRemove(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(mode, (String) response.get("MODE"));
    }

    /**
     * Performs an in/out test of the NODE_REMOVE_STATUS command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param status {@link String}
     * @param nodeid {@link Integer}
     */
    public static void testNodeRemoveStatusLoopback(Integer seqNo, String status, Integer nodeid) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getNodeRemoveStatus(seqNo, status, nodeid);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleNodeRemoveStatus(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(status, (String) response.get("STATUS"));
        assertEquals(nodeid, (Integer) response.get("NODEID"));
    }

    /**
     * Performs an in/out test of the FAILED_NODE_REMOVE command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param nodeId {@link Integer}
     */
    public static void testFailedNodeRemoveLoopback(Integer seqNo, Integer nodeId) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getFailedNodeRemove(seqNo, nodeId);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleFailedNodeRemove(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(nodeId, (Integer) response.get("NODE_ID"));
    }

    /**
     * Performs an in/out test of the FAILED_NODE_REMOVE_STATUS command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param status {@link String}
     * @param nodeId {@link Integer}
     */
    public static void testFailedNodeRemoveStatusLoopback(Integer seqNo, String status, Integer nodeId) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getFailedNodeRemoveStatus(seqNo, status, nodeId);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleFailedNodeRemoveStatus(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(status, (String) response.get("STATUS"));
        assertEquals(nodeId, (Integer) response.get("NODE_ID"));
    }

    /**
     * Performs an in/out test of the FAILED_NODE_REPLACE command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param nodeId {@link Integer}
     * @param txOptions {@link List<String>}
     * @param mode {@link Integer}
     */
    public static void testFailedNodeReplaceLoopback(Integer seqNo, Integer nodeId, List<String> txOptions, Integer mode) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getFailedNodeReplace(seqNo, nodeId, txOptions,
                mode);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleFailedNodeReplace(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(nodeId, (Integer) response.get("NODE_ID"));
        assertEquals(txOptions, (List<String>) response.get("TX_OPTIONS"));
        assertEquals(mode, (Integer) response.get("MODE"));
    }

    /**
     * Performs an in/out test of the FAILED_NODE_REPLACE_STATUS command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param status {@link String}
     * @param nodeId {@link Integer}
     */
    public static void testFailedNodeReplaceStatusLoopback(Integer seqNo, String status, Integer nodeId) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getFailedNodeReplaceStatus(seqNo, status, nodeId);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleFailedNodeReplaceStatus(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(status, (String) response.get("STATUS"));
        assertEquals(nodeId, (Integer) response.get("NODE_ID"));
    }

    /**
     * Performs an in/out test of the NODE_NEIGHBOR_UPDATE_REQUEST command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param nodeId {@link Integer}
     */
    public static void testNodeNeighborUpdateRequestLoopback(Integer seqNo, Integer nodeId) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getNodeNeighborUpdateRequest(seqNo, nodeId);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleNodeNeighborUpdateRequest(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(nodeId, (Integer) response.get("NODE_ID"));
    }

    /**
     * Performs an in/out test of the NODE_NEIGHBOR_UPDATE_STATUS command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param status {@link String}
     */
    public static void testNodeNeighborUpdateStatusLoopback(Integer seqNo, String status) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getNodeNeighborUpdateStatus(seqNo, status);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleNodeNeighborUpdateStatus(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(status, (String) response.get("STATUS"));
    }

    /**
     * Performs an in/out test of the RETURN_ROUTE_ASSIGN command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param sourceNodeId {@link Integer}
     * @param destinationNodeId {@link Integer}
     */
    public static void testReturnRouteAssignLoopback(Integer seqNo, Integer sourceNodeId, Integer destinationNodeId) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getReturnRouteAssign(seqNo, sourceNodeId,
                destinationNodeId);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleReturnRouteAssign(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(sourceNodeId, (Integer) response.get("SOURCE_NODE_ID"));
        assertEquals(destinationNodeId, (Integer) response.get("DESTINATION_NODE_ID"));
    }

    /**
     * Performs an in/out test of the RETURN_ROUTE_ASSIGN_COMPLETE command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param status {@link String}
     */
    public static void testReturnRouteAssignCompleteLoopback(Integer seqNo, String status) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getReturnRouteAssignComplete(seqNo, status);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleReturnRouteAssignComplete(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(status, (String) response.get("STATUS"));
    }

    /**
     * Performs an in/out test of the RETURN_ROUTE_DELETE command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param nodeId {@link Integer}
     */
    public static void testReturnRouteDeleteLoopback(Integer seqNo, Integer nodeId) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getReturnRouteDelete(seqNo, nodeId);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleReturnRouteDelete(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(nodeId, (Integer) response.get("NODE_ID"));
    }

    /**
     * Performs an in/out test of the RETURN_ROUTE_DELETE_COMPLETE command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param seqNo {@link Integer}
     * @param status {@link String}
     */
    public static void testReturnRouteDeleteCompleteLoopback(Integer seqNo, String status) {
        byte[] testPayload = CommandClassNetworkManagementInclusionV1.getReturnRouteDeleteComplete(seqNo, status);

        Map<String, Object> response = CommandClassNetworkManagementInclusionV1.handleReturnRouteDeleteComplete(testPayload);
        assertEquals(seqNo, (Integer) response.get("SEQ_NO"));
        assertEquals(status, (String) response.get("STATUS"));
    }

}
