package com.example.restServer.soapClient;

import com.example.serverone.*;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import static com.example.restServer.constants.Constants.USERS_SOAP_URI;


public class UserClient extends WebServiceGatewaySupport {
    public GetUserResponse getUserResponse(int userId) {
        GetUserRequest request = new GetUserRequest();
        request.setId(userId);
        GetUserResponse response = (GetUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(USERS_SOAP_URI, request);
        return response;
    }

    public AddUserResponse addUserResponse(int userId, String userName, String userDevice) {
        AddUserRequest request = new AddUserRequest();
        request.setId(userId);
        request.setName(userName);
        request.setDevice(userDevice);
        AddUserResponse response = (AddUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(USERS_SOAP_URI, request);
        return response;
    }

    public DeleteUserResponse deleteUserResponse(int userId) {
        DeleteUserRequest request = new DeleteUserRequest();
        request.setId(userId);
        DeleteUserResponse response = (DeleteUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(USERS_SOAP_URI, request);
        return response;
    }

    public UpdateUserResponse updateUserResponse(int userId, String userName, String userDevice) {
        UpdateUserRequest request = new UpdateUserRequest();
        request.setId(userId);
        request.setName(userName);
        request.setDevice(userDevice);
        UpdateUserResponse response = (UpdateUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(USERS_SOAP_URI, request);
        return response;
    }
}
