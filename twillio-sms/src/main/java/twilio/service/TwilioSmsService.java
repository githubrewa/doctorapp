package twilio.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twilio.config.TwilioConfig;


@Service
public class TwilioSmsService {
    private final TwilioConfig twilioConfig;

    @Autowired
    public TwilioSmsService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;

        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
    }

    public void sendSms(String toPhoneNumber, String message) {
        Message.creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(twilioConfig.getPhoneNumber()), message).create();
    }
}
