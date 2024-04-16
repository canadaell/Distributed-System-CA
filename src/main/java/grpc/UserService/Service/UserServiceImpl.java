package grpc.UserService.Service;

import io.grpc.stub.StreamObserver;
import grpc.UserService.LoginRequest;
import grpc.UserService.LoginResponse;
import grpc.UserService.RegisterRequest;
import grpc.UserService.RegisterResponse;
import grpc.UserService.UserServiceGrpc.UserServiceImplBase;
public class UserServiceImpl extends UserServiceImplBase{

    @Override
    public void register(RegisterRequest request, StreamObserver<RegisterResponse> responseObserver) {

        boolean success = true;
        String message = "Registration successful.";

        RegisterResponse response = RegisterResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {

        boolean success = true;
        String message = "Login successful.";
        String token = "abcdefg12345";

        LoginResponse response = LoginResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .setToken(token)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
