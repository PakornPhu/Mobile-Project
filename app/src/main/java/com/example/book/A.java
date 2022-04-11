package com.example.book;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class A extends Contract {
    public static final String BINARY = "Bin file was not provided";

    public static final String FUNC_BOOKBILL = "bookBill";

    public static final String FUNC_BOOKMAPPING = "bookMapping";

    public static final String FUNC_RETRIEVEPREORDER = "retrievePreOrder";

    @Deprecated
    protected A(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected A(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected A(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected A(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> bookBill(String _name, String _bookName, String _email, String _addresspm, String _phone, String _price, String _date) {
        final Function function = new Function(
                FUNC_BOOKBILL, 
                Arrays.<Type>asList(new Utf8String(_name),
                new Utf8String(_bookName),
                new Utf8String(_email),
                new Utf8String(_addresspm),
                new Utf8String(_phone),
                new Utf8String(_price),
                new Utf8String(_date)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple7<String, String, String, String, String, String, String>> bookMapping(BigInteger param0) {
        final Function function = new Function(FUNC_BOOKMAPPING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple7<String, String, String, String, String, String, String>>(function,
                new Callable<Tuple7<String, String, String, String, String, String, String>>() {
                    @Override
                    public Tuple7<String, String, String, String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<String, String, String, String, String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple7<List<String>, List<String>, List<String>, List<String>, List<String>, List<String>, List<String>>> retrievePreOrder() {
        final Function function = new Function(FUNC_RETRIEVEPREORDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Utf8String>>() {}, new TypeReference<DynamicArray<Utf8String>>() {}, new TypeReference<DynamicArray<Utf8String>>() {}, new TypeReference<DynamicArray<Utf8String>>() {}, new TypeReference<DynamicArray<Utf8String>>() {}, new TypeReference<DynamicArray<Utf8String>>() {}, new TypeReference<DynamicArray<Utf8String>>() {}));
        return new RemoteFunctionCall<Tuple7<List<String>, List<String>, List<String>, List<String>, List<String>, List<String>, List<String>>>(function,
                new Callable<Tuple7<List<String>, List<String>, List<String>, List<String>, List<String>, List<String>, List<String>>>() {
                    @Override
                    public Tuple7<List<String>, List<String>, List<String>, List<String>, List<String>, List<String>, List<String>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<List<String>, List<String>, List<String>, List<String>, List<String>, List<String>, List<String>>(
                                convertToNative((List<Utf8String>) results.get(0).getValue()), 
                                convertToNative((List<Utf8String>) results.get(1).getValue()), 
                                convertToNative((List<Utf8String>) results.get(2).getValue()), 
                                convertToNative((List<Utf8String>) results.get(3).getValue()), 
                                convertToNative((List<Utf8String>) results.get(4).getValue()), 
                                convertToNative((List<Utf8String>) results.get(5).getValue()), 
                                convertToNative((List<Utf8String>) results.get(6).getValue()));
                    }
                });
    }

    @Deprecated
    public static A load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new A(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static A load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new A(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static A load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new A(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static A load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new A(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
