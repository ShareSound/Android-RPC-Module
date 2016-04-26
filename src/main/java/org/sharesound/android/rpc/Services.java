package org.sharesound.android.rpc;

import org.apache.thrift.TException;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.sharesound.android.rpc.account.AccountService;

public class Services {

    public static void closeTransport(TServiceClient client){
        try{
            if(client.getInputProtocol().getTransport().isOpen()){
                client.getInputProtocol().getTransport().close();
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public static AccountService.Client getAccountService(String address, int port) throws TException{
        TTransport transport = new TSocket(address, port);
        transport.open();

        TProtocol protocol = new TBinaryProtocol(transport);

        return new AccountService.Client(protocol);
    }
}
