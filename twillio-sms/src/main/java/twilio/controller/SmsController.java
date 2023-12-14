package twilio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import twilio.payload.SmsRequest;
import twilio.service.TwilioSmsService;

@RestController
public class SmsController {
    private final TwilioSmsService smsService;

    @Autowired
    public SmsController(TwilioSmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send-sms")
    public void sendSms(@RequestBody SmsRequest request) {
        smsService.sendSms(request.getToPhoneNumber(), request.getMessage());
    }
}
