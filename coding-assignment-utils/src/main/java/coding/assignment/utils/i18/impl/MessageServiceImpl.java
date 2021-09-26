package coding.assignment.utils.i18.impl;

import coding.assignment.utils.i18.api.MessageService;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class MessageServiceImpl implements MessageService {
    private MessageSource messageSource;

    public MessageServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String propertyName, String[] placeholders, Locale locale) {
        return messageSource.getMessage(propertyName, placeholders, locale);
    }

    public String getMessage(String propertyName, Locale locale) {
        return messageSource.getMessage(propertyName, new String[] {}, locale);
    }
}
