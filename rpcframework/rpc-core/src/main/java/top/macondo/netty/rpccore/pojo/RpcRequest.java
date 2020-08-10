package top.macondo.netty.rpccore.pojo;

import lombok.Data;

@Data
public class RpcRequest {

    private String requestId;
    private String className;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] parameters;

    // getter/setter...
}