package com.example;

import com.example.hello.GreeterGrpc;
import com.example.hello.Hello;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

/**
 * Date 18/08/18
 * Time 12:11 AM
 *
 * @author yogin
 */
@Service
public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase implements GrpcService {

    @Override
    public void sayHello(Hello.HelloRequest req, StreamObserver<Hello.HelloReply> responseObserver) {
        Hello.HelloReply reply = Hello.HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
