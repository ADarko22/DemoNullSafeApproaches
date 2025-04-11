package edu.adarko22;

import edu.adarko22.api.HelloApi;
import edu.adarko22.model.MessageResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class HelloApiController implements HelloApi {

    @Override
    public ResponseEntity<MessageResponse> getHello(String message) {
        MessageResponse response = new MessageResponse(null);
        return ResponseEntity.ok(response);
    }
}
